package io.livestreaming.api.commerce.infrastructure.repository

import io.livestreaming.api.commerce.application.port.out.CreateCoinHistoryPort
import io.livestreaming.api.commerce.application.port.out.GetCoinHistoryPort
import io.livestreaming.api.commerce.domain.ChannelId
import io.livestreaming.api.commerce.domain.DonationCoinHistory
import io.livestreaming.api.commerce.domain.Money
import io.livestreaming.api.commerce.domain.PurchaseCoinHistory
import io.livestreaming.api.commerce.infrastructure.repository.entity.DonationCoinHistoryEntity
import io.livestreaming.api.commerce.infrastructure.repository.entity.PurchaseCoinHistoryEntity
import io.livestreaming.api.common.domain.MemberId
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Repository
import java.math.BigInteger

@Repository
class CoinHistoryRepository(
    private val purchaseCoinHistoryRepository: PurchaseCoinHistoryJpaRepository,
    private val donationCoinHistoryRepository: DonationCoinHistoryJpaRepository,
) : CreateCoinHistoryPort, GetCoinHistoryPort {

    override fun createPurchaseHistory(memberId: MemberId, quantity: BigInteger, remaining: BigInteger, price: Money) {
        val purchaseCoinHistoryEntity = PurchaseCoinHistoryEntity.of(
            memberId = memberId,
            quantity = quantity,
            remaining = remaining,
            price = price,
        )

        purchaseCoinHistoryRepository.save(purchaseCoinHistoryEntity)
    }

    override fun createDonationHistory(memberId: MemberId, channelId: ChannelId, quantity: BigInteger) {
        val donationCoinHistoryEntity = DonationCoinHistoryEntity.of(
            memberId = memberId,
            channelId = channelId,
            quantity = quantity,
        )

        donationCoinHistoryRepository.save(donationCoinHistoryEntity)
    }

    override fun getPurchaseHistoryByMemberId(memberId: MemberId, size: Int, page: Int): Page<PurchaseCoinHistory> {
        val pageable = PageRequest.of(page - 1, size)

        return purchaseCoinHistoryRepository.findByMemberId(
            memberId = memberId.value,
            pageable = pageable
        ).map { it.toDomain() }
    }

    override fun getDonationHistoryByMemberId(memberId: MemberId, size: Int, page: Int): Page<DonationCoinHistory> {
        val pageable = PageRequest.of(page - 1, size)

        return donationCoinHistoryRepository.findByMemberId(
            memberId = memberId.value,
            pageable = pageable
        ).map { it.toDomain() }
    }

    override fun getDonationHistoryByChannelId(channelId: ChannelId, size: Int, page: Int): Page<DonationCoinHistory> {
        val pageable = PageRequest.of(page - 1, size)

        return donationCoinHistoryRepository.findByChannelId(
            channelId = channelId.value,
            pageable = pageable
        ).map { it.toDomain() }
    }

}