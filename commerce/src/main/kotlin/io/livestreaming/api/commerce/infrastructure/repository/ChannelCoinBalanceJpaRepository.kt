package io.livestreaming.api.commerce.infrastructure.repository

import io.livestreaming.api.commerce.infrastructure.repository.entity.ChannelBalanceEntity
import org.springframework.data.jpa.repository.JpaRepository


interface ChannelCoinBalanceJpaRepository : JpaRepository<ChannelBalanceEntity, String> {
}