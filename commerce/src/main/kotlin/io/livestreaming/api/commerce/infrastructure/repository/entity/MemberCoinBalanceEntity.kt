package io.livestreaming.api.commerce.infrastructure.repository.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.math.BigInteger

@Entity
@Table(name = "member_coin_balance")
class MemberCoinBalanceEntity private constructor(
    @Id @Column(name = "member_id", nullable = false)
    val memberId: String,

    @Column(name = "amount", nullable = false)
    var amount: BigInteger,
) {
    protected constructor() : this("", BigInteger.ZERO)

    companion object {
        fun of(memberId: String, amount: BigInteger) = MemberCoinBalanceEntity(memberId, amount)
    }

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