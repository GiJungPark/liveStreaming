package io.livestreaming.api.member.application.port.out

import io.livestreaming.api.common.domain.Image
import io.livestreaming.api.common.domain.MemberId
import io.livestreaming.api.member.domain.Introduction
import io.livestreaming.api.member.domain.Nickname

interface CreateMemberProfilePort {
    fun createMemberProfile(id: MemberId, nickname: Nickname, profileImage: Image, introduction: Introduction)
}