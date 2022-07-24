package com.example.demo.clients.location

import com.example.demo.entity.Location

interface LocationService {
    fun getLocationFromClient(cep: Int): Location?;
}