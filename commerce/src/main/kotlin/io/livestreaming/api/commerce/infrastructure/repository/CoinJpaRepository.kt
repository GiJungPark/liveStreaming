package io.livestreaming.api.commerce.infrastructure.repository

import io.livestreaming.api.commerce.infrastructure.repository.entity.CoinBalanceEntity
import org.springframework.data.jpa.repository.JpaRepository

interface CoinJpaRepository : JpaRepository<CoinBalanceEntity, String> {
}