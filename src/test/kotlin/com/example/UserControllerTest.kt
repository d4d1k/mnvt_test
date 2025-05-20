package com.example

import com.example.service.User
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import com.example.service.UserRepository
import jakarta.inject.Inject

@MicronautTest
class UserControllerTest() {
    @Inject
    lateinit var userRepository: UserRepository

    @Test
    fun testListUsers() {
        val users = listOf<User>(
            User(id=1, name="Vadim"),
            User(id=2, name="Artem"),
            User(id=3, name="Kamil")
        )
        userRepository.saveAll(users)

        val returnedUsers = userRepository.findAll()
        assertEquals(users[0], returnedUsers[0])
    }
}