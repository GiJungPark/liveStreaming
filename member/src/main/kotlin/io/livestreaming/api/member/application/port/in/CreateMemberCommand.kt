package io.livestreaming.api.member.application.port.`in`

import io.livestreaming.api.member.domain.Email
import io.livestreaming.api.member.domain.Nickname
import io.livestreaming.api.member.domain.Password

data class CreateMemberCommand(
    val email: Email,
    val password: Password,
    val nickname: Nickname,
) {
    companion object {
        fun of(email: String, password: String, nickname: String): CreateMemberCommand {
            return CreateMemberCommand(
                email = Email.of(email),
                password = Password.of(password),
                nickname = Nickname.of(nickname),
            )
        }
    }
}
