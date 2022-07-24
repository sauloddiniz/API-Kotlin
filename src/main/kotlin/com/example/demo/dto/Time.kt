package com.example.demo.dto

import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming

@Suppress("DEPRECATION")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
data class Time(
    val by: String = "",
    val validKey: String = "",
    var results: Result? = null,
    val executionTime: Double = 0.0,
    val fromCache: Boolean = false
)