package io.livestreaming.api.commerce.domain

import java.math.BigInteger
import java.time.LocalDateTime

class ExchangeCoinHistory private constructor(
    val exchangeDate: LocalDateTime,
    val quantity: BigInteger,
    val price: Money,
    val remaining: BigInteger,
) {
    companion object {
        fun of(
            exchangeDate: LocalDateTime,
            quantity: BigInteger,
            price: BigInteger,
            remaining: BigInteger
        ): ExchangeCoinHistory {
            return ExchangeCoinHistory(
                exchangeDate = exchangeDate,
                quantity = quantity,
                price = Money.of(price),
                remaining = remaining
            )
        }
    }
}