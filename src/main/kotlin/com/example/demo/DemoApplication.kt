package com.example.demo

import feign.Logger
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.Bean

@SpringBootApplication
@EnableFeignClients
class DemoApplication

fun main(args: Array<String>) {
    runApplication<DemoApplication>(*args)
}
