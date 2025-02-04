package io.livestreaming.api.commerce.infrastructure.repository

import io.livestreaming.api.commerce.infrastructure.repository.entity.ChannelCoinBalanceEntity
import org.springframework.data.jpa.repository.JpaRepository


interface ChannelCoinBalanceJpaRepository : JpaRepository<ChannelCoinBalanceEntity, String> {
}