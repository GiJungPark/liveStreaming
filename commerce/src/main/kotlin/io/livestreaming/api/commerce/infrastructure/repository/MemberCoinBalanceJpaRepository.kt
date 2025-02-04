package io.livestreaming.api.commerce.infrastructure.repository

import io.livestreaming.api.commerce.infrastructure.repository.entity.MemberCoinBalanceEntity
import org.springframework.data.jpa.repository.JpaRepository

interface MemberCoinBalanceJpaRepository : JpaRepository<MemberCoinBalanceEntity, String> {
}