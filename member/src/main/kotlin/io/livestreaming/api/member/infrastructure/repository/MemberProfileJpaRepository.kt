package io.livestreaming.api.member.infrastructure.repository

import io.livestreaming.api.member.infrastructure.repository.entity.MemberProfileEntity
import org.springframework.data.jpa.repository.JpaRepository

interface MemberProfileJpaRepository: JpaRepository<MemberProfileEntity, String> {
    fun existsByNickname(nickname: String): Boolean
}