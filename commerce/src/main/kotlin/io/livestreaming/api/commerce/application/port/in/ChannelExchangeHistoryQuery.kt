package io.livestreaming.api.commerce.application.port.`in`

import io.livestreaming.api.commerce.domain.ChannelId

data class ChannelExchangeHistoryQuery(
    val channelId: ChannelId,
    val size: Int,
    val page: Int,
) {
    companion object {
        fun of(channelId: String, page: Int, size: Int): ChannelExchangeHistoryQuery {
            return ChannelExchangeHistoryQuery(channelId = ChannelId.of(channelId), page = page, size = size)
        }
    }
}
