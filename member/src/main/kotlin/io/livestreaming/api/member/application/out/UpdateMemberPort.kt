package io.livestreaming.api.member.application.out

import io.livestreaming.api.member.domain.MemberId
import io.livestreaming.api.member.domain.MemberProfile

interface UpdateMemberPort {
    fun updateProfile(memberProfile: MemberProfile): MemberId
}