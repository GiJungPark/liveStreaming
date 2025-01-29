package io.livestreaming.api.commerce.application.port.`in`

import io.livestreaming.api.commerce.domain.ChannelId
import io.livestreaming.api.common.domain.MemberId
import java.math.BigInteger

data class DonationCoinCommand(
    val memberId: MemberId,
    val channelId: ChannelId,
    val quantity: BigInteger,
) {
    companion object {
        fun of(memberId: String, channelId: String, quantity: BigInteger): DonationCoinCommand {
            return DonationCoinCommand(
                memberId = MemberId.of(memberId),
                channelId = ChannelId.of(channelId),
                quantity = quantity,
            )
        }
    }
}