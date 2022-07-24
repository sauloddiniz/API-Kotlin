package com.example.demo.clients.time

import com.example.demo.dto.Time

interface TimeService {
    fun getTime(cityName: String): Time;
}