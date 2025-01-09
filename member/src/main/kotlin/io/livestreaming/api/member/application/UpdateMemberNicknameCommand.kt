package io.livestreaming.api.member.application

import io.livestreaming.api.member.domain.MemberId
import io.livestreaming.api.member.domain.Nickname

data class UpdateMemberNicknameCommand(
    val id: MemberId,
    val nickname: Nickname,
) {
    companion object {
        fun of(id: String, nickname: String): UpdateMemberNicknameCommand {
            return UpdateMemberNicknameCommand(
                id = MemberId.of(id),
                nickname = Nickname.of(nickname)
            )
        }
    }
}
