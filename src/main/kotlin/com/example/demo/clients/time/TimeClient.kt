package com.example.demo.clients.time

import com.example.demo.dto.Time
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(
    name = "time-client",
    url = "https://api.hgbrasil.com/weather?key=24c54e08"
)
interface TimeClient {

    @GetMapping()
    fun getTime(
        @RequestParam(value = "key") key: String,
        @RequestParam(value = "city_name") cityName: String
    ): Time;

}
