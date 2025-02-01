package io.livestreaming.api.commerce.infrastructure

import io.livestreaming.api.commerce.infrastructure.entity.PurchaseCoinHistoryEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import java.time.LocalDateTime

interface PurchaseCoinHistoryJpaRepository : JpaRepository<PurchaseCoinHistoryEntity, Long> {
    fun findByMemberIdAndPurchaseAtBetween(
        memberId: String,
        start: LocalDateTime,
        end: LocalDateTime,
        pageable: Pageable
    ): Page<PurchaseCoinHistoryEntity>
}