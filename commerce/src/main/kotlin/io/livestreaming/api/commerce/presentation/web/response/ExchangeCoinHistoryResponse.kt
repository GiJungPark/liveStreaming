package io.livestreaming.api.commerce.presentation.web.response

import io.livestreaming.api.commerce.domain.ExchangeCoinHistory
import java.math.BigInteger
import java.time.LocalDateTime

data class ExchangeCoinHistoryResponse(
    val exchangeDate: LocalDateTime,
    val quantity: BigInteger,
    val remaining: BigInteger,
    val price: BigInteger
) {
    companion object {
        fun of(exchangeCoinHistory: ExchangeCoinHistory): ExchangeCoinHistoryResponse {
            return ExchangeCoinHistoryResponse(
                exchangeDate = exchangeCoinHistory.exchangeDate,
                quantity = exchangeCoinHistory.quantity,
                remaining = exchangeCoinHistory.remaining,
                price = exchangeCoinHistory.price.amount
            )
        }
    }
}
