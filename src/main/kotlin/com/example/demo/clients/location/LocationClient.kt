package com.example.demo.clients.location

import com.example.demo.entity.Location
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import javax.websocket.server.PathParam

@FeignClient(
    name = "client-location",
    url = "http://viacep.com.br/ws/")
interface LocationClient {

    @GetMapping("/{cep}/json")
    fun getLocation(@PathVariable cep: Int): Location?;
}