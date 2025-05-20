package com.example

import io.micronaut.http.HttpRequest
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@MicronautTest
class TimeControllerTest(@Client("/") val client: HttpClient) {
    @Test
    fun testGetTime() {
        val request: HttpRequest<Any> = HttpRequest.GET<Any>("/time")
        val body = client.toBlocking().retrieve(request)
        assertNotNull(body, "Body in time is null")
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
        val current = LocalDateTime.now().format(formatter).toString()
        assertEquals(body, current, "Current time doesn't match")
    }
}