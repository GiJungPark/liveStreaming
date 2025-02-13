package io.livestreaming.api.member

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["io.livestreaming.api.member", "io.livestreaming.api.common"])
class MemberApplication

fun main(args: Array<String>) {
    runApplication<MemberApplication>(*args)
}
