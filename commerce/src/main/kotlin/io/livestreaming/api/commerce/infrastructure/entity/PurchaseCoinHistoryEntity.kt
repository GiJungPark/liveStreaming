package io.livestreaming.api.commerce.infrastructure.entity

import io.livestreaming.api.commerce.domain.Money
import io.livestreaming.api.commerce.domain.PurchaseCoinHistory
import io.livestreaming.api.common.domain.MemberId
import jakarta.persistence.*
import java.math.BigInteger
import java.time.LocalDateTime

@Entity
@Table(name = "purchase_coin_history")
class PurchaseCoinHistoryEntity private constructor(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val memberId: String,

    val quantity: BigInteger,

    val remaining: BigInteger,

    val price: BigInteger,

    val purchaseAt: LocalDateTime = LocalDateTime.now(),
) {
    protected constructor() : this(
        memberId = "",
        quantity = BigInteger.ZERO,
        remaining = BigInteger.ZERO,
        price = BigInteger.ZERO
    )

    companion object {
        fun of(
            memberId: MemberId,
            quantity: BigInteger,
            remaining: BigInteger,
            price: Money
        ): PurchaseCoinHistoryEntity {
            return PurchaseCoinHistoryEntity(
                memberId = memberId.value,
                quantity = quantity,
                remaining = remaining,
                price = price.amount,
            )
        }

    }

    fun toDomain(): PurchaseCoinHistory {
        return PurchaseCoinHistory.of(
            purchaseDate = purchaseAt,
            quantity = quantity,
            remaining = remaining,
            price = price,
        )
    }
}