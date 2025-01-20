package io.livestreaming.api.commerce.domain

import java.math.BigDecimal
import java.math.BigInteger
import java.math.RoundingMode

class Coin private constructor(
    val amount: BigInteger,
) {
    companion object {
        private val DEFAULT_FEE_RATE = BigDecimal("1.1")

        val ZERO: Coin = of(BigInteger.ZERO)

        fun of(amount: BigInteger): Coin {
            return Coin(amount)
        }

        fun add(a: Coin, b: Coin): Coin {
            return Coin(a.amount.add(b.amount))
        }

        fun sub(a: Coin, b: Coin): Coin {
            return Coin(a.amount.subtract(b.amount))
        }

        fun fromPrice(price: BigInteger, feeRate: BigDecimal = DEFAULT_FEE_RATE): Coin {
            val amount = BigDecimal(price)
                .divide(feeRate, 0, RoundingMode.DOWN)
                .toBigInteger()
            return Coin(amount)
        }
    }

    fun negate(): Coin {
        return Coin(this.amount.negate())
    }

    fun isPositive(): Boolean {
        return this.amount > BigInteger.ZERO
    }

    fun toPrice(feeRate: BigDecimal = DEFAULT_FEE_RATE): BigInteger {
        return this.amount.toBigDecimal()
            .multiply(feeRate)
            .setScale(0, RoundingMode.DOWN)
            .toBigInteger()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Coin

        return amount == other.amount
    }

    override fun hashCode(): Int {
        return amount.hashCode()
    }

    override fun toString(): String {
        return "Coin(amount=$amount)"
    }

}