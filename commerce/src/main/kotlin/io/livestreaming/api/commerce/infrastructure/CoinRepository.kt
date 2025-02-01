package io.livestreaming.api.commerce.infrastructure

import io.livestreaming.api.commerce.application.port.out.DonationCoinPort
import io.livestreaming.api.commerce.application.port.out.PurchaseCoinPort
import io.livestreaming.api.commerce.application.port.out.ReadCoinPort
import io.livestreaming.api.commerce.domain.ChannelId
import io.livestreaming.api.commerce.domain.Money
import io.livestreaming.api.commerce.domain.PurchaseCoinHistory
import io.livestreaming.api.commerce.infrastructure.entity.DonationCoinHistoryEntity
import io.livestreaming.api.commerce.infrastructure.entity.PurchaseCoinHistoryEntity
import io.livestreaming.api.common.domain.MemberId
import jakarta.transaction.Transactional
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Repository
import java.math.BigInteger
import java.time.LocalDateTime
import java.time.Year
import kotlin.jvm.optionals.getOrNull

@Repository
class CoinRepository(
    private val coinJpaRepository: CoinJpaRepository,
    private val channelCoinJpaRepository: ChannelCoinBalanceJpaRepository,
    private val purchaseCoinHistoryRepository: PurchaseCoinHistoryJpaRepository,
    private val donationCoinHistoryRepository: DonationCoinHistoryJpaRepository,
) : PurchaseCoinPort, DonationCoinPort, ReadCoinPort {

    @Transactional
    override fun purchase(memberId: MemberId, quantity: BigInteger, price: Money) {
        val coinBalanceEntity = coinJpaRepository.findById(memberId.value).orElseThrow()

        val purchaseCoinHistoryEntity = PurchaseCoinHistoryEntity.of(
            memberId = memberId,
            quantity = quantity,
            remaining = coinBalanceEntity.amount,
            price = price,
        )
        purchaseCoinHistoryRepository.save(purchaseCoinHistoryEntity)

        coinBalanceEntity.add(quantity)
        coinJpaRepository.save(coinBalanceEntity)
    }

    override fun getPurchaseHistory(memberId: MemberId, size: Int, page: Int, searchYear: Year): Page<PurchaseCoinHistory> {
        val startDate = LocalDateTime.of(searchYear.value, 1, 1, 0, 0)
        val endDate = LocalDateTime.of(searchYear.value + 1, 1, 1, 0, 0)
        val pageable = PageRequest.of(page, size)

        return purchaseCoinHistoryRepository.findByMemberIdAndPurchaseAtBetween(
            memberId = memberId.value,
            start = startDate,
            end = endDate.minusNanos(1),
            pageable = pageable
        ).map { it.toDomain() }
    }

    @Transactional
    override fun donation(memberId: MemberId, channelId: ChannelId, quantity: BigInteger) {
        val memberCoinBalanceEntity = coinJpaRepository.findById(memberId.value).orElseThrow()
        val channelCoinBalanceEntity = channelCoinJpaRepository.findById(channelId.value).orElseThrow()

        memberCoinBalanceEntity.minus(quantity)
        coinJpaRepository.save(memberCoinBalanceEntity)

        channelCoinBalanceEntity.add(quantity)
        channelCoinJpaRepository.save(channelCoinBalanceEntity)

        val donationCoinHistoryEntity = DonationCoinHistoryEntity.of(
            memberId = memberId,
            channelId = channelId,
            quantity = quantity
        )

        donationCoinHistoryRepository.save(donationCoinHistoryEntity)

    }

    override fun getRemainingByMemberId(memberId: MemberId): BigInteger {
        val coinBalanceEntity = coinJpaRepository.findById(memberId.value)

        return coinBalanceEntity.getOrNull()?.amount ?: BigInteger.ZERO
    }
}