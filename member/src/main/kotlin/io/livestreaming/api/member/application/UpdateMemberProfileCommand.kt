package io.livestreaming.api.member.application

import io.livestreaming.api.member.domain.Image
import io.livestreaming.api.member.domain.MemberId
import io.livestreaming.api.member.domain.Nickname

data class UpdateMemberProfileCommand(
    val id: MemberId,
    val nickname: Nickname,
    val profile: Image,
) {
    companion object {
        fun of(id: String, nickname: String, profile: String): UpdateMemberProfileCommand {
            return UpdateMemberProfileCommand(
                id = MemberId.of(id),
                nickname = Nickname.of(nickname),
                profile = Image.profileImageOf(nickname)
            )
        }
    }
}