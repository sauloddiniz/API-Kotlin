package com.example.demo.dto

class LocationJoinTime(
    val cep: Int = 0,
    val bairro: String = "",
    val localidade: String = "",
    val uf: String = "",
    val ddd: String = "",
    val description: String = "",
    val city: String = "",
    val humidity: Int = 0,
    val wind_speedy: String = "",
    val cityName: String = "",
    val populacao: String = "",
    val forecast: List<Forecast> = ArrayList()
);