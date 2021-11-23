package com.carlos.paquetes.app

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PaquetesAppApplication

fun main(args: Array<String>) {
	runApplication<PaquetesAppApplication>(*args)
}
