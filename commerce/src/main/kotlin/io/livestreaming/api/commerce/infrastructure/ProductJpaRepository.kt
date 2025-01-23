package io.livestreaming.api.commerce.infrastructure

import io.livestreaming.api.commerce.domain.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductJpaRepository : JpaRepository<Product, Long> {
}