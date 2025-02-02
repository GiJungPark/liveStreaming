package io.livestreaming.api.commerce.infrastructure

import io.livestreaming.api.commerce.application.port.out.DonationCoinPort
import io.livestreaming.api.commerce.application.port.out.PurchaseCoinPort
import io.livestreaming.api.commerce.domain.*
import io.livestreaming.api.commerce.infrastructure.entity.DonationCoinHistoryEntity
import io.livestreaming.api.commerce.infrastructure.entity.PurchaseCoinHistoryEntity
import io.livestreaming.api.common.domain.MemberId
import jakarta.transaction.Transactional
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Repository
import java.math.BigInteger

@Repository
class CoinRepository(
    private val coinJpaRepository: CoinJpaRepository,
    private val channelCoinJpaRepository: ChannelCoinBalanceJpaRepository,
    private val purchaseCoinHistoryRepository: PurchaseCoinHistoryJpaRepository,
    private val donationCoinHistoryRepository: DonationCoinHistoryJpaRepository,
) : PurchaseCoinPort, DonationCoinPort {

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

    override fun getPurchaseHistory(
        memberId: MemberId,
        size: Int,
        page: Int
    ): Page<PurchaseCoinHistory> {
        val pageable = PageRequest.of(page, size)

        return purchaseCoinHistoryRepository.findByMemberId(
            memberId = memberId.value,
            pageable = pageable
        ).map { it.toDomain() }
    }

    override fun getMemberRemainingCoin(memberId: MemberId): CoinBalance {
        val memberCoinBalanceEntity = coinJpaRepository.findById(memberId.value)
        if(memberCoinBalanceEntity.isPresent) {
            return CoinBalance.of(memberCoinBalanceEntity.get().amount)
        }

        return CoinBalance.ZERO()
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

    override fun getDonationHistoryByMemberId(
        memberId: MemberId,
        page: Int,
        size: Int
    ): Page<DonationCoinHistory> {
        val pageable = PageRequest.of(page, size)

        return donationCoinHistoryRepository.findByMemberId(
            memberId = memberId.value,
            pageable = pageable
        ).map { it.toDomain() }
    }

    override fun getDonationHistoryByChannelId(channelId: ChannelId, page: Int, size: Int): Page<DonationCoinHistory> {
        val pageable = PageRequest.of(page, size)

        return donationCoinHistoryRepository.findByChannelId(
            channelId = channelId.value,
            pageable = pageable
        ).map { it.toDomain() }
    }
}