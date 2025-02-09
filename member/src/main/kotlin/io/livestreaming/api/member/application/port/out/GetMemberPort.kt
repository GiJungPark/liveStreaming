package io.livestreaming.api.member.application.port.out

import io.livestreaming.api.common.domain.MemberId
import io.livestreaming.api.member.domain.*

interface GetMemberPort {
    fun getMemberById(id: MemberId): Member
    fun getMemberProfileById(id: MemberId): MemberProfile

    fun doesntExistEmail(email: Email): Boolean
    fun doesntExistNickname(nickname: Nickname): Boolean
}