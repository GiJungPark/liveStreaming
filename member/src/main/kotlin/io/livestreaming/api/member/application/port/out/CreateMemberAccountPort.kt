package io.livestreaming.api.member.application.port.out

import io.livestreaming.api.common.domain.MemberId
import io.livestreaming.api.member.domain.Email
import io.livestreaming.api.member.domain.Password

interface CreateMemberAccountPort {
    fun createMemberAccount(id: MemberId, email: Email, password: Password)
}