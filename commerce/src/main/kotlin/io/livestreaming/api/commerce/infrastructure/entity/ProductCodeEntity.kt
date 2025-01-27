package io.livestreaming.api.commerce.infrastructure.entity

import io.livestreaming.api.commerce.domain.ProductCode
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "product_code")
class ProductCodeEntity private constructor(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    val id: Long? = null,

    @Column(name = "name", nullable = false, columnDefinition = "VARCHAR(10)")
    val code: String,

    @Column(name = "description", nullable = false, columnDefinition = "VARCHAR(60)")
    val description: String,

    @Column(name = "created_at", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    val createdAt: LocalDateTime = LocalDateTime.now(),
) {
    constructor() : this(null, "", "")

    companion object {
        fun from(productCode: ProductCode): ProductCodeEntity {
            return ProductCodeEntity(
                code = productCode.code,
                description = productCode.description,
            )
        }
    }
}