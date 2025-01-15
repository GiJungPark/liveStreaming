package io.livestreaming.api.member.application.out

import io.livestreaming.api.member.domain.Member
import io.livestreaming.api.member.domain.MemberId
import io.livestreaming.api.member.domain.MemberProfile

interface GetMemberPort {
    fun getMemberById(id: MemberId): Member
    fun getMemberProfileById(id: MemberId): MemberProfile
}