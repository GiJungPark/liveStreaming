package io.livestreaming.api.commerce.infrastructure

import io.livestreaming.api.commerce.application.port.out.PurchaseCoinPort
import io.livestreaming.api.commerce.application.port.out.ReadCoinPort
import io.livestreaming.api.commerce.domain.Money
import io.livestreaming.api.commerce.infrastructure.entity.PurchaseCoinHistoryEntity
import io.livestreaming.api.common.domain.MemberId
import jakarta.transaction.Transactional
import org.springframework.stereotype.Repository
import java.math.BigInteger
import kotlin.jvm.optionals.getOrNull

@Repository
class CoinRepository(
    private val coinJpaRepository: CoinJpaRepository,
    private val purchaseCoinHistoryRepository: PurchaseCoinHistoryJpaRepository
) : PurchaseCoinPort, ReadCoinPort {
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

    override fun getRemainingByMemberId(memberId: MemberId): BigInteger {
        val coinBalanceEntity = coinJpaRepository.findById(memberId.value)

        return coinBalanceEntity.getOrNull()?.amount ?: BigInteger.ZERO
    }
}