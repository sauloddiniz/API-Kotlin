package com.example.demo.dto

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming

@Suppress("DEPRECATION")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
data class Result(
    val temp: Int = 0,
    val date: String = "",
    val time: String = "",
    val conditionCode: String = "",
    val description: String = "",
    val currently: String = "",
    val cid: String = "",
    val city: String = "",
    val imgId: String = "",
    val humidity: Int = 0,
    val wind_speedy: String = "",
    val sunrise: String = "",
    val sunset: String = "",
    val conditionSlug: String = "",
    val cityName: String = "",
    val forecast: List<Forecast> = ArrayList()

)