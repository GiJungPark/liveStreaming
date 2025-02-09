package io.livestreaming.api.commerce

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(
    scanBasePackages = ["io.livestreaming.api.commerce", "io.livestreaming.api.common"]
)
class CommerceApplication {
}

fun main(args: Array<String>) {
    runApplication<CommerceApplication>(*args)
}
