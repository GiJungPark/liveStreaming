package io.livestreaming.api.member.application

import io.livestreaming.api.member.domain.Nickname

data class CheckNicknameCommand(
    val nickname: Nickname,
) {
    companion object {
        fun of(nickname: String): CheckNicknameCommand {
            return CheckNicknameCommand(Nickname.of(nickname))
        }
    }
}
