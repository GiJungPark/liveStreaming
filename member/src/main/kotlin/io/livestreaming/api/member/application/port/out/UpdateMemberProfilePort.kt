package io.livestreaming.api.member.application.port.out

import io.livestreaming.api.common.domain.MemberId
import io.livestreaming.api.member.domain.MemberProfile

interface UpdateMemberProfilePort {
    fun updateProfile(id: MemberId, memberProfile: MemberProfile)
}