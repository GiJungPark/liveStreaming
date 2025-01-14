package io.livestreaming.api.member.application

import io.livestreaming.api.member.domain.MemberId

interface UpdateMemberUseCase {
    fun updatePassword(command: UpdateMemberPasswordCommand): MemberId
    fun updateProfile(command: UpdateMemberProfileCommand): MemberId
}