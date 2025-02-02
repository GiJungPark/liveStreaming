package io.livestreaming.api.commerce.presentation.web.response

import io.livestreaming.api.commerce.domain.PurchaseCoinHistory
import java.math.BigInteger
import java.time.LocalDateTime

data class PurchaseCoinHistoryResponse(
    val purchaseDate: LocalDateTime,
    val quantity: BigInteger,
    val remaining: BigInteger,
    val price: BigInteger
) {
    companion object {
        fun of(purchaseCoinHistory: PurchaseCoinHistory): PurchaseCoinHistoryResponse {
            return PurchaseCoinHistoryResponse(
                purchaseDate = purchaseCoinHistory.purchaseDate,
                quantity = purchaseCoinHistory.quantity,
                remaining = purchaseCoinHistory.remaining,
                price = purchaseCoinHistory.price.amount
            )
        }
    }
}
