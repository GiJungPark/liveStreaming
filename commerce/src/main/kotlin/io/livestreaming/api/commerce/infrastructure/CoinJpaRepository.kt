package io.livestreaming.api.commerce.infrastructure

import io.livestreaming.api.commerce.infrastructure.entity.CoinBalanceEntity
import org.springframework.data.jpa.repository.JpaRepository

interface CoinJpaRepository : JpaRepository<CoinBalanceEntity, String> {
}