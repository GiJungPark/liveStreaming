package io.livestreaming.api.member.application

import io.livestreaming.api.common.domain.MemberId
import io.livestreaming.api.member.domain.Password

data class UpdateMemberPasswordCommand(
    val id: MemberId,
    val password: Password,
) {
    companion object {
        fun of(id: String, password: String): UpdateMemberPasswordCommand {
            return UpdateMemberPasswordCommand(
                id = MemberId.of(id),
                password = Password.of(password)
            )
        }
    }
}
