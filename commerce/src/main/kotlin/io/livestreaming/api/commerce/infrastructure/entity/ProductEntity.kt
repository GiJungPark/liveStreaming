package io.livestreaming.api.commerce.infrastructure.entity

import jakarta.persistence.*
import java.math.BigInteger
import java.time.LocalDateTime

@Table(name = "product")
@Entity
class ProductEntity private constructor(
    name: String,
    price: BigInteger,
){
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column(name = "name", nullable = false)
    var name: String = name

    @Column(name = "price", nullable = false)
    var price: BigInteger = price

    @Column(name = "created_at", nullable = false)
    var createdAt: LocalDateTime = LocalDateTime.now()

    constructor() : this("", BigInteger.ZERO)
}

