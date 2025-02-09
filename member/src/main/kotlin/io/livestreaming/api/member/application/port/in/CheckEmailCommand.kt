package io.livestreaming.api.member.application.port.`in`

import io.livestreaming.api.member.domain.Email

data class CheckEmailCommand(
    val email: Email,
) {
    companion object {
        fun of(email: String): CheckEmailCommand {
            return CheckEmailCommand(Email.of(email))
        }
    }
}
