package com.example.demo.clients.time

import com.example.demo.dto.Time
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class TimeServiceImpl(val timeCliente: TimeClient): TimeService {

    @Value(value = "#\${my.key}")
    var key: String = "";

    override fun getTime(cityName: String): Time {
        return timeCliente.getTime(key, cityName);
    }
}