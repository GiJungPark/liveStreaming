package io.livestreaming.api.commerce.domain

import java.math.BigInteger

class CoinBalance private constructor(private var _quantity: BigInteger) {

    val quantity: BigInteger
        get() = _quantity

    init {
        ensureNonNegative(_quantity)
    }

    companion object {
        fun ZERO(): CoinBalance {
            return CoinBalance(BigInteger.ZERO)
        }

        fun of(quantity: BigInteger): CoinBalance {
            return CoinBalance(quantity)
        }
    }

    fun add(quantity: BigInteger) {
        require(quantity.signum() >= 0) { "추가할 코인은 0개보다 작을 수 없습니다." }
        _quantity = _quantity.add(quantity)
    }

    fun sub(quantity: BigInteger) {
        require(quantity.signum() >= 0) { "차감할 코인은 0개보다 작을 수 없습니다." }
        val newQuantity = _quantity.subtract(quantity)
        ensureNonNegative(newQuantity)
        _quantity = newQuantity
    }

    private fun ensureNonNegative(quantity: BigInteger) {
        require(quantity.signum() >= 0) { "남은 코인은 0개보다 작을 수 없습니다." }
    }

}