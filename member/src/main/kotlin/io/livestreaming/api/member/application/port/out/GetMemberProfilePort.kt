package io.livestreaming.api.member.application.port.out

import io.livestreaming.api.common.domain.MemberId
import io.livestreaming.api.member.domain.MemberProfile
import io.livestreaming.api.member.domain.Nickname

interface GetMemberProfilePort {
    fun getMemberProfileById(id: MemberId): MemberProfile
    fun doesntExistNickname(nickname: Nickname): Boolean

}