package com.konce

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KonceApplication

fun main(vararg args: String) {
	runApplication<KonceApplication>(*args)
}
