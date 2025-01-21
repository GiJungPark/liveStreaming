package io.livestreaming.api.commerce.domain

import io.livestreaming.api.common.domain.MemberId
import java.time.LocalDateTime

class CoinPurchaseHistory private constructor(
    val memberId: MemberId,
    val purchaseAt: LocalDateTime,
    val remainingCoin: Coin,
    val purchaseCoin: Coin,
) {
    companion object {
        fun of(
            memberId: String,
            purchaseAt: LocalDateTime,
            remainingCoin: Long,
            purchaseCoin: Long
        ): CoinPurchaseHistory {
            return CoinPurchaseHistory(
                memberId = MemberId.of(memberId),
                purchaseAt = purchaseAt,
                remainingCoin = Coin.of(remainingCoin.toBigInteger()),
                purchaseCoin = Coin.of(purchaseCoin.toBigInteger())
            )
        }
    }
}