package io.livestreaming.api.commerce.infrastructure.repository

import io.livestreaming.api.commerce.infrastructure.repository.entity.PurchaseCoinHistoryEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface PurchaseCoinHistoryJpaRepository : JpaRepository<PurchaseCoinHistoryEntity, Long> {
    fun findByMemberId(
        memberId: String,
        pageable: Pageable
    ): Page<PurchaseCoinHistoryEntity>
}