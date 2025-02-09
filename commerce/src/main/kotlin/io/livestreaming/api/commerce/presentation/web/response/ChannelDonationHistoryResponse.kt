package io.livestreaming.api.commerce.presentation.web.response

import io.livestreaming.api.commerce.domain.DonationCoinHistory
import java.math.BigInteger
import java.time.LocalDateTime

data class ChannelDonationHistoryResponse(
    val donationDate: LocalDateTime,
    val quantity: BigInteger,
    val message: String,
    val senderId: String,
) {
    companion object {
        fun of(donationCoinHistory: DonationCoinHistory): ChannelDonationHistoryResponse {
            return ChannelDonationHistoryResponse(
                donationDate = donationCoinHistory.donationDate,
                quantity = donationCoinHistory.quantity,
                message = donationCoinHistory.message,
                senderId = donationCoinHistory.senderId.value
            )
        }
    }
}
