package io.livestreaming.api.commerce.infrastructure.repository

import io.livestreaming.api.commerce.infrastructure.repository.entity.ExchangeCoinHistoryEntity
import org.springframework.data.jpa.repository.JpaRepository

interface ExchangeCoinHistoryJpaRepository : JpaRepository<ExchangeCoinHistoryEntity, Long> {
}