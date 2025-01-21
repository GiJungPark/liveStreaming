package io.livestreaming.api.commerce.presentation.web.response

import io.livestreaming.api.commerce.domain.CoinPurchaseHistory
import java.time.LocalDateTime

data class CoinPurchaseHistoryResponse(
    val purchaseAt: LocalDateTime,
    val remainingCoin: String,
    val purchaseCoin: String,
) {
    companion object {
        fun of(coinPurchaseHistory: CoinPurchaseHistory): CoinPurchaseHistoryResponse {
            return CoinPurchaseHistoryResponse(
                purchaseAt = coinPurchaseHistory.purchaseAt,
                remainingCoin = coinPurchaseHistory.purchaseCoin.amount.toString(),
                purchaseCoin = coinPurchaseHistory.purchaseCoin.amount.toString()
            )
        }
    }
}