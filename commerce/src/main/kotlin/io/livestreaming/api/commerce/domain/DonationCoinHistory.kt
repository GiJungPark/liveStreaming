package io.livestreaming.api.commerce.domain

import java.math.BigInteger
import java.time.LocalDateTime

class DonationCoinHistory private constructor(
    val donationDate: LocalDateTime,
    val quantity: BigInteger,
    val message: String,
    val channelId: ChannelId
) {
    companion object {
        fun of(
            donationDate: LocalDateTime,
            quantity: BigInteger,
            message: String,
            channelId: String
        ): DonationCoinHistory {
            return DonationCoinHistory(
                donationDate = donationDate,
                quantity = quantity,
                message = message,
                channelId = ChannelId.of(channelId)
            )
        }
    }
}