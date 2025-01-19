package io.livestreaming.api.member

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["io.livestreaming.api.common"])
class UserApplication

fun main(args: Array<String>) {
    runApplication<UserApplication>(*args)
}
