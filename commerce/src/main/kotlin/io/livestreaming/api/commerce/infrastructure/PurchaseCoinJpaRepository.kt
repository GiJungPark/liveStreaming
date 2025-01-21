package io.livestreaming.api.commerce.infrastructure

import io.livestreaming.api.commerce.infrastructure.entity.PurchaseCoinEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface PurchaseCoinJpaRepository : JpaRepository<PurchaseCoinEntity, Long> {
    fun findByMemberId(memberId: String, pageable: Pageable): Page<PurchaseCoinEntity>
}