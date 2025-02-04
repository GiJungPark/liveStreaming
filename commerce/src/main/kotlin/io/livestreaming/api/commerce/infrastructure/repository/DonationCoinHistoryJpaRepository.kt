package io.livestreaming.api.commerce.infrastructure.repository

import io.livestreaming.api.commerce.infrastructure.repository.entity.DonationCoinHistoryEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface DonationCoinHistoryJpaRepository : JpaRepository<DonationCoinHistoryEntity, Long> {
    fun findByMemberId(memberId: String, pageable: Pageable): Page<DonationCoinHistoryEntity>
    fun findByChannelId(channelId: String, pageable: Pageable): Page<DonationCoinHistoryEntity>
}