package io.livestreaming.api.commerce.infrastructure.entity

import io.livestreaming.api.commerce.domain.CoinPurchaseHistory
import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import java.time.LocalDateTime

@Table(name = "purchase_coin_history")
@Entity
class PurchaseCoinEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column
    var memberId: String,

    @Column @CreationTimestamp
    var purchaseAt: LocalDateTime = LocalDateTime.now(),

    @Column
    var purchaseCoin: Long,

    @Column
    var remainingCoin: Long,
) {
    protected constructor() : this(null, "", LocalDateTime.now(), 0L, 0L)

    fun toCoinPurchaseHistory(): CoinPurchaseHistory {
        return CoinPurchaseHistory.of(
            memberId = memberId,
            purchaseAt = purchaseAt,
            purchaseCoin = purchaseCoin,
            remainingCoin = remainingCoin
        )
    }
}
