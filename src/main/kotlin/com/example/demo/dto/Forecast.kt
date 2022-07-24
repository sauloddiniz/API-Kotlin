package com.example.demo.dto

import java.time.LocalDate

class Forecast(
    val date: String = "",
    val weekday: String= "",
    val max: Int = 0,
    val min: Int =0,
    val description: String = "",
    val condition: String = ""
)