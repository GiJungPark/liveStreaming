package io.livestreaming.api.commerce.infrastructure

import org.springframework.stereotype.Repository

@Repository
class ProductRepository(
    private val jpaRepository: ProductJpaRepository
) {

}