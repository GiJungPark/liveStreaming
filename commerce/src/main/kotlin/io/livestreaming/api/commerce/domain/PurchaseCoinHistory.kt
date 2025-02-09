package io.livestreaming.api.commerce.domain

import java.math.BigInteger
import java.time.LocalDateTime

class PurchaseCoinHistory private constructor(
    val purchaseDate: LocalDateTime,
    val quantity: BigInteger,
    val remaining: BigInteger,
    val price: Money,
) {
    companion object {
        fun of(
            purchaseDate: LocalDateTime,
            quantity: BigInteger,
            remaining: BigInteger,
            price: BigInteger
        ): PurchaseCoinHistory {
            return PurchaseCoinHistory(
                purchaseDate = purchaseDate,
                quantity = quantity,
                remaining = remaining,
                price = Money.of(price)
            )
        }
    }
}