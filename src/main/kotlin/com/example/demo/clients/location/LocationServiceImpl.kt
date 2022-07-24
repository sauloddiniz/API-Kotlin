package com.example.demo.clients.location

import com.example.demo.entity.Location
import org.springframework.stereotype.Service

@Service
class LocationServiceImpl(var location: LocationClient) : LocationService {

    override fun getLocationFromClient(cep: Int): Location? {
        return location.getLocation(cep);
    }

}