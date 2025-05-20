package com.example
import io.micronaut.runtime.EmbeddedApplication
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import jakarta.inject.Inject

@MicronautTest
class ApplicationRunTest {

    @Inject
    lateinit var application: EmbeddedApplication<*>

    @Test
    fun testApplicationRun() {
        Assertions.assertTrue(application.isRunning)
    }

}
