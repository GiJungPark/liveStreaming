package io.livestreaming.api.commerce.infrastructure.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.math.BigInteger

@Entity
@Table(name = "available_balance")
class CoinBalanceEntity private constructor(
    @Id
    val memberId: String,

    var amount: BigInteger,
) {
    protected constructor() : this("", BigInteger.ZERO)

    fun add(amount: BigInteger) {
        this.amount += amount
    }

    fun minus(amount: BigInteger) {
        if (this.amount < amount) {
            throw IllegalArgumentException("코인이 부족합니다.")
        }

        this.amount -= amount
    }

}