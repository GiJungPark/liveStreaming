package io.livestreaming.api.commerce.application.port.`in`

import io.livestreaming.api.commerce.domain.ChannelId

data class AddChannelCoinBalanceCommand(
    val channelId: ChannelId,
) {
    companion object {
        fun of(channelId: String) = AddChannelCoinBalanceCommand(ChannelId.of(channelId))
    }
}
