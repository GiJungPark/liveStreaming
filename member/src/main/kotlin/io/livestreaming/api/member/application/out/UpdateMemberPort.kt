package io.livestreaming.api.member.application.out

import io.livestreaming.api.common.domain.MemberId
import io.livestreaming.api.member.domain.MemberProfile

interface UpdateMemberPort {
    fun updateProfile(memberId: MemberId, memberProfile: MemberProfile): MemberId
}