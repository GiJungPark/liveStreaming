package io.livestreaming.api.commerce.application.port.`in`

import io.livestreaming.api.commerce.domain.ChannelId

data class CreateChannelCoinBalanceCommand(
    val channelId: ChannelId,
) {
    companion object {
        fun of(channelId: String) = CreateChannelCoinBalanceCommand(ChannelId.of(channelId))
    }
}
