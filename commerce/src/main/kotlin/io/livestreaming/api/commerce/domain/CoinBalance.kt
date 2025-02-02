package io.livestreaming.api.commerce.domain

import java.math.BigInteger

class CoinBalance private constructor(val quantity: BigInteger) {

    init {
        ensureNonNegative(quantity)
    }

    companion object {
        fun ZERO(): CoinBalance {
            return CoinBalance(BigInteger.ZERO)
        }

        fun of(quantity: BigInteger): CoinBalance {
            return CoinBalance(quantity)
        }
    }

    private fun ensureNonNegative(quantity: BigInteger) {
        require(quantity.signum() >= 0) { "남은 코인은 0개보다 작을 수 없습니다." }
    }

}