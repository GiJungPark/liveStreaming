package io.livestreaming.api.member.application.port.`in`

import io.livestreaming.api.common.domain.MemberId

interface UpdateMemberUseCase {
    fun updatePassword(command: UpdateMemberPasswordCommand): MemberId
    fun updateProfile(command: UpdateMemberProfileCommand): MemberId
}