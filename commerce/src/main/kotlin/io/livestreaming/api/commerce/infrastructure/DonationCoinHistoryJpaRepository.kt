package io.livestreaming.api.commerce.infrastructure

import io.livestreaming.api.commerce.infrastructure.entity.DonationCoinHistoryEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import java.time.LocalDateTime

interface DonationCoinHistoryJpaRepository: JpaRepository<DonationCoinHistoryEntity, Long> {
    fun findByMemberIdAndDonationAtBetween(
        memberId: String,
        start: LocalDateTime,
        end: LocalDateTime,
        pageable: Pageable
    ): Page<DonationCoinHistoryEntity>

    fun findByChannelId(channelId: String, pageable: Pageable): Page<DonationCoinHistoryEntity>
}