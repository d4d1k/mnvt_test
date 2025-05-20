package com.example.controllers

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller("/")
class IndexController {
    @Get(produces = [MediaType.TEXT_PLAIN])
    fun index(): String {
        return "Hello)"
    }
}