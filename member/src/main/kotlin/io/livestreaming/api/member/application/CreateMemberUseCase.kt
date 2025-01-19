package io.livestreaming.api.member.application

import io.livestreaming.api.common.domain.MemberId

interface CreateMemberUseCase {
    fun create(command: CreateMemberCommand): MemberId
}