package io.livestreaming.api.commerce.application.port.`in`

import io.livestreaming.api.commerce.domain.ChannelId
import java.math.BigInteger

data class ExchangeDonationCoinCommand(
    val channelId: ChannelId,
    val quantity: BigInteger,
) {
    companion object {
        fun of(channelId: String, quantity: BigInteger) = ExchangeDonationCoinCommand(ChannelId.of(channelId), quantity)
    }
}
