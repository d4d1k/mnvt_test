package com.example

import io.micronaut.runtime.Micronaut.run

fun main(args: Array<String>) {
	println(">>>Working dir: " + System.getProperty("user.dir"))
	run(*args)
}