package io.livestreaming.api.commerce.domain

import io.livestreaming.api.common.domain.MemberId
import java.math.BigInteger
import java.time.LocalDateTime

class DonationCoinHistory private constructor(
    val donationDate: LocalDateTime,
    val quantity: BigInteger,
    val message: String,
    val senderId: MemberId,
    val receiverId: ChannelId
) {
    companion object {
        fun of(
            donationDate: LocalDateTime,
            quantity: BigInteger,
            message: String,
            senderId: String,
            receiverId: String
        ): DonationCoinHistory {
            return DonationCoinHistory(
                donationDate = donationDate,
                quantity = quantity,
                message = message,
                senderId = MemberId.of(senderId),
                receiverId = ChannelId.of(receiverId)
            )
        }
    }
}