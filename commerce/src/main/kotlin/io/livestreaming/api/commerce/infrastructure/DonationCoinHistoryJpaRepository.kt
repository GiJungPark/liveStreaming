package io.livestreaming.api.commerce.infrastructure

import io.livestreaming.api.commerce.infrastructure.entity.DonationCoinHistoryEntity
import org.springframework.data.jpa.repository.JpaRepository

interface DonationCoinHistoryJpaRepository: JpaRepository<DonationCoinHistoryEntity, Long> {
}