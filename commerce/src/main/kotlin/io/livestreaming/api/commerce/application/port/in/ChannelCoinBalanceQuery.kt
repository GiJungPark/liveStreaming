package io.livestreaming.api.commerce.application.port.`in`

import io.livestreaming.api.commerce.domain.ChannelId

data class ChannelCoinBalanceQuery(
    val channelId: ChannelId,
) {
    companion object {
        fun of(channelId: String) = ChannelCoinBalanceQuery(ChannelId.of(channelId))
    }
}