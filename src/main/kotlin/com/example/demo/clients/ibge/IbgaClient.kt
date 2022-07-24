package com.example.demo.clients.ibge

import com.example.demo.dto.Aggregate
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping

@FeignClient(
    name = "ibge-client",
    url = "https://servicodados.ibge.gov.br/api/v3/agregados/6579/periodos/2021/variaveis/9324?localidades=N6[3119401]")
interface IbgaClient {

    @GetMapping()
    fun getPopulacaoIbge(): List<Aggregate>;

}
