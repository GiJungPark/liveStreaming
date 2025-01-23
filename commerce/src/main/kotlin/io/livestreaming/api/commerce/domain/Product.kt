package io.livestreaming.api.commerce.domain

import java.math.BigInteger

class Product private constructor(
    val name: ProductName,
    val price: Money,
) {
    companion object {
        fun of(name: String, price: BigInteger) = Product(ProductName.of(name), Money.of(price))
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Product

        if (name != other.name) return false
        if (price != other.price) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + price.hashCode()
        return result
    }

    override fun toString(): String {
        return "[Product] name: $name, price: $price"
    }

}