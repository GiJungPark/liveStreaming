package io.livestreaming.api.commerce.infrastructure

import io.livestreaming.api.commerce.infrastructure.entity.PurchaseCoinHistoryEntity
import org.springframework.data.jpa.repository.JpaRepository

interface PurchaseCoinHistoryJpaRepository : JpaRepository<PurchaseCoinHistoryEntity, Long> {
}