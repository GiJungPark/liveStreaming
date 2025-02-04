package io.livestreaming.api.commerce.application.port.`in`

import io.livestreaming.api.commerce.domain.ChannelId

data class ChannelDonationHistoryQuery(
    val channelId: ChannelId,
    val page: Int,
    val size: Int,
) {
    companion object {
        fun of(channelId: String, page: Int, size: Int) = ChannelDonationHistoryQuery(
            channelId = ChannelId.of(channelId),
            page = page,
            size = size
        )
    }
}
