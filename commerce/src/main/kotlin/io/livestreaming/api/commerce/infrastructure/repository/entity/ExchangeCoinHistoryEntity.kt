package io.livestreaming.api.commerce.infrastructure.repository.entity

import io.livestreaming.api.commerce.domain.ChannelId
import io.livestreaming.api.commerce.domain.CoinBalance
import io.livestreaming.api.commerce.domain.ExchangeCoinHistory
import io.livestreaming.api.commerce.domain.Money
import jakarta.persistence.*
import java.math.BigInteger
import java.time.LocalDateTime

@Entity
@Table(name = "exchange_coin_history")
class ExchangeCoinHistoryEntity private constructor(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val channelId: String,

    val quantity: BigInteger,

    val price: BigInteger,

    val remaining: BigInteger,

    val exchangeAt: LocalDateTime = LocalDateTime.now(),
) {
    protected constructor() : this(
        channelId = "",
        quantity = BigInteger.ZERO,
        price = BigInteger.ZERO,
        remaining = BigInteger.ZERO
    )

    companion object {
        fun of(
            channelId: ChannelId,
            quantity: BigInteger,
            price: Money,
            remaining: BigInteger
        ): ExchangeCoinHistoryEntity {
            return ExchangeCoinHistoryEntity(
                channelId = channelId.value,
                quantity = quantity,
                price = price.amount,
                remaining = remaining,
            )
        }
    }

    fun toDomain(): ExchangeCoinHistory {
        return ExchangeCoinHistory.of(
            exchangeDate = exchangeAt,
            quantity = quantity,
            price = price,
            remaining = remaining,
        )
    }

}