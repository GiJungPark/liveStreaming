package io.livestreaming.api.member.application.port.out

import io.livestreaming.api.common.domain.MemberId
import io.livestreaming.api.member.domain.MemberAccount

interface UpdateMemberAccountPort {
    fun updatePassword(id: MemberId, memberAccount: MemberAccount)
}