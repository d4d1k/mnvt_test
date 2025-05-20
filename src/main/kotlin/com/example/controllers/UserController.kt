package com.example.controllers

import com.example.service.User
import com.example.service.UserRepository
import io.micronaut.data.model.Pageable
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.scheduling.TaskExecutors
import io.micronaut.scheduling.annotation.ExecuteOn
import jakarta.validation.Valid
import java.util.Optional

@ExecuteOn(TaskExecutors.BLOCKING)
@Controller("/users")
open class UserController (private val userRepository: UserRepository) {

    @Get("/{id}")
    fun show(id: Long): Optional<User> {
        return userRepository.findById(id)
    }

    @Get("/list")
    open fun list(@Valid pageable: Pageable): List<User> = userRepository.findAll(pageable).content
}