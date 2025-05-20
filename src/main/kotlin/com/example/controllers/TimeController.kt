package com.example.controllers

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Controller("/time")
class TimeController {
    @Get(produces = [MediaType.TEXT_PLAIN])
    fun index(): String {
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
        val current = LocalDateTime.now().format(formatter)
        return current.toString()
    }
}