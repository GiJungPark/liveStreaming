package io.livestreaming.api.commerce.infrastructure

import io.livestreaming.api.commerce.infrastructure.entity.PurchaseCoinEntity
import org.springframework.data.jpa.repository.JpaRepository

interface PurchaseCoinJpaRepository : JpaRepository<PurchaseCoinEntity, Long> {
}