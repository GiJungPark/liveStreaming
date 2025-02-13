package io.livestreaming.api.member.infrastructure.repository

import io.livestreaming.api.common.domain.Image
import io.livestreaming.api.common.domain.MemberId
import io.livestreaming.api.member.application.port.out.CreateMemberProfilePort
import io.livestreaming.api.member.application.port.out.GetMemberProfilePort
import io.livestreaming.api.member.application.port.out.UpdateMemberProfilePort
import io.livestreaming.api.member.domain.Introduction
import io.livestreaming.api.member.domain.MemberProfile
import io.livestreaming.api.member.domain.Nickname
import io.livestreaming.api.member.infrastructure.repository.entity.MemberProfileEntity
import org.springframework.stereotype.Repository

@Repository
class MemberProfileRepository(
    private val memberProfileJpaRepository: MemberProfileJpaRepository
) : CreateMemberProfilePort, GetMemberProfilePort, UpdateMemberProfilePort {

    override fun createMemberProfile(id: MemberId, nickname: Nickname, profileImage: Image, inroduction: Introduction) {
        val memberProfileEntity = MemberProfileEntity.of(
            id = id,
            profileImage = profileImage,
            nickname = nickname,
            introduction = inroduction
        )

        memberProfileJpaRepository.save(memberProfileEntity)
    }

    override fun getMemberProfileById(id: MemberId): MemberProfile {
        val memberProfileEntity = memberProfileJpaRepository.findById(id.value)

        if (memberProfileEntity.isPresent) {
            return memberProfileEntity.get().toDomain()
        }

        throw IllegalStateException("사용자를 찾을 수 없습니다.")
    }

    override fun doesntExistNickname(nickname: Nickname): Boolean {
        return !existNickname(nickname)
    }

    override fun updateProfile(id: MemberId, memberProfile: MemberProfile) {
        val memberProfileEntity = MemberProfileEntity.of(
            id = id,
            nickname = memberProfile.nickname,
            profileImage = memberProfile.profileImage,
            introduction = memberProfile.introduction
        )

        memberProfileJpaRepository.save(memberProfileEntity)
    }

    private fun existNickname(nickname: Nickname): Boolean {
        return memberProfileJpaRepository.existsByNickname(nickname.value)
    }

}