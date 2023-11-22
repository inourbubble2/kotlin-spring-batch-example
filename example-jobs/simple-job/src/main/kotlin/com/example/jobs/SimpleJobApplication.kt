package com.example.jobs

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SimpleJobApplication

fun main(args: Array<String>) {
    runApplication<SimpleJobApplication>(*args)
}
