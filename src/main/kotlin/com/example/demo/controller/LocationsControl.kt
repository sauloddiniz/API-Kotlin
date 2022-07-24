package com.example.demo.controller;

import com.example.demo.clients.ibge.IbgaServices
import com.example.demo.clients.location.LocationService
import com.example.demo.clients.time.TimeService
import com.example.demo.dto.Aggregate
import com.example.demo.dto.Forecast
import com.example.demo.dto.LocationJoinTime
import com.example.demo.dto.Time
import com.example.demo.entity.Location
import com.example.demo.repository.LocationRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI

@RestController
@RequestMapping("/locations")
class LocationsControl(
    private val repository: LocationRepository,
    private val csl: LocationService,
    private val cst: TimeService,
    private val csIbga: IbgaServices
) {

    @GetMapping
    fun getAllLocations(): ResponseEntity<List<Location>> {
        return ResponseEntity.ok(repository.findAll());
    }

    @PostMapping
    fun save(@RequestBody location: Location): ResponseEntity<Void> {
        repository.save(location);
        return ResponseEntity.created(URI.create(location.id.toString())).build()
    }

    @GetMapping("/{cep}")
    fun consumeCep(@PathVariable cep: Int): ResponseEntity<LocationJoinTime> {

        val location: Location? = csl.getLocationFromClient(cep);
        val address = "${location?.localidade},${location?.uf}";
        val time: Time = cst.getTime(address);
        val aggregate = csIbga.getPopulacao("","","");
        val lista: ArrayList<Forecast> = extractListForecast(time)
        val locationTime: LocationJoinTime = mountLocationTime(cep, location, time, lista, aggregate)

        return ResponseEntity.ok(locationTime);

    }

    private fun mountLocationTime(
        cep: Int,
        location: Location?,
        time: Time,
        lista: ArrayList<Forecast>,
        aggregate: Aggregate
    ): LocationJoinTime {
        val locationTime: LocationJoinTime = LocationJoinTime(
            cep = cep,
            bairro = location?.bairro ?: "",
            uf = location?.uf ?: "",
            localidade = location?.localidade ?: "",
            ddd = location?.ddd ?: "",
            description = time.results?.description ?: "",
            city = time.results?.city ?: "",
            humidity = time.results?.humidity ?: 0,
            wind_speedy = time.results?.wind_speedy ?: "",
            cityName = time.results?.cityName ?: "",
            populacao = "${aggregate.variavel}: ${aggregate.resultados[0].series[0].serie.doisMilVinteUm}",
            forecast = lista
        );
        return locationTime
    }

    private fun extractListForecast(time: Time): ArrayList<Forecast> {
        val lista: ArrayList<Forecast> = ArrayList();

        for (i in 0..5) {
            lista.add(time.results?.forecast?.get(i) ?: Forecast());
        }
        return lista
    }

}