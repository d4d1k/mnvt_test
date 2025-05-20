package com.example

import io.micronaut.http.HttpRequest
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test

@MicronautTest
class IndexControllerTest(@Client("/") val client: HttpClient) {
    @Test
    fun testIndex() {
        val request: HttpRequest<Any> = HttpRequest.GET("/")
        val body = client.toBlocking().retrieve(request)
        assertNotNull(body, "Body in index is null")
        assertEquals(body, "Hello)", "Message on index doesn't equals to expected")
    }
}