package io.livestreaming.api.member.application.port.out

import io.livestreaming.api.common.domain.MemberId
import io.livestreaming.api.member.domain.*

interface GetMemberAccountPort {
    fun getMemberAccountById(id: MemberId): MemberAccount
    fun doesntExistEmail(email: Email): Boolean
}