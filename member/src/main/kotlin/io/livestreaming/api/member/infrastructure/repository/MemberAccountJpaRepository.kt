package io.livestreaming.api.member.infrastructure.repository

import io.livestreaming.api.member.infrastructure.repository.entity.MemberAccountEntity
import org.springframework.data.jpa.repository.JpaRepository

interface MemberAccountJpaRepository: JpaRepository<MemberAccountEntity, String> {
    fun existsByEmail(email: String): Boolean
}