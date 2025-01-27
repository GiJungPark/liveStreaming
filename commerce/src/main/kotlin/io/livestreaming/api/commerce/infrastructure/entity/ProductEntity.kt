package io.livestreaming.api.commerce.infrastructure.entity

import io.livestreaming.api.commerce.domain.Product
import jakarta.persistence.*
import java.math.BigInteger
import java.time.LocalDateTime

@Entity
@Table(name = "product")
class ProductEntity private constructor(
    name: String,
    price: BigInteger,
){
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    val id: Long? = null

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_code_id", referencedColumnName = "id")
    val code: ProductCodeEntity = ProductCodeEntity()

    @Column(name = "name", nullable = false)
    val name: String = name

    @Column(name = "price", nullable = false)
    val price: BigInteger = price

    @Column(name = "created_at", nullable = false)
    val createdAt: LocalDateTime = LocalDateTime.now()

    companion object {
        fun withoutId(product: Product): ProductEntity {
            return ProductEntity(name = product.name,  price = product.price)
        }
    }

    constructor() : this("", BigInteger.ZERO)
}

