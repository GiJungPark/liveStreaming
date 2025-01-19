package io.livestreaming.api.member.application

import io.livestreaming.api.common.domain.Image
import io.livestreaming.api.common.domain.MemberId
import io.livestreaming.api.member.domain.Introduction
import io.livestreaming.api.member.domain.Nickname

data class UpdateMemberProfileCommand(
    val id: MemberId,
    val nickname: Nickname,
    val profile: Image,
    val introduction: Introduction,
) {
    companion object {
        fun of(id: String, nickname: String, profile: String, introduction: String): UpdateMemberProfileCommand {
            return UpdateMemberProfileCommand(
                id = MemberId.of(id),
                nickname = Nickname.of(nickname),
                profile = Image.profileImageOf(profile),
                introduction = Introduction.of(introduction),
            )
        }
    }
}