package io.livestreaming.api.member.application

import io.livestreaming.api.member.domain.Email
import io.livestreaming.api.member.domain.Password

data class ReadMemberByCredentialsCommand(
    val email: Email,
    val password: Password
) {
    companion object {
        fun of(email: String, password: String): ReadMemberByCredentialsCommand {
            return ReadMemberByCredentialsCommand(
                email = Email.of(email),
                password = Password.of(password)
            )
        }
    }
}
