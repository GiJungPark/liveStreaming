package io.livestreaming.api.member.application

import io.livestreaming.api.member.domain.MemberId

data class ReadMemberByIdCommand(
    val id: MemberId,
) {
    companion object {
        fun of(id: String): ReadMemberByIdCommand {
            return ReadMemberByIdCommand(id = MemberId.of(id))
        }
    }
}