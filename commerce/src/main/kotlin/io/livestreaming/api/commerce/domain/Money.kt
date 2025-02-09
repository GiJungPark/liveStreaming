package io.livestreaming.api.commerce.domain

import java.math.BigInteger

class Money private constructor(
    val amount: BigInteger,
) {
    companion object {
        val ZERO: Money = of(BigInteger.ZERO)

        fun of(amount: BigInteger): Money {
            return Money(amount)
        }

        fun add(a: Money, b: Money): Money {
            return Money(a.amount.add(b.amount))
        }

        fun sub(a: Money, b: Money): Money {
            return Money(a.amount.subtract(b.amount))
        }
    }

    fun negate(): Money {
        return Money(this.amount.negate())
    }

    fun isPositive(): Boolean {
        return this.amount > BigInteger.ZERO
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Money

        return amount == other.amount
    }

    override fun hashCode(): Int {
        return amount.hashCode()
    }

    override fun toString(): String {
        return "[Money] amount: $amount"
    }

}