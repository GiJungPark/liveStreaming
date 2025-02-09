package io.livestreaming.api.commerce.presentation.web.response

import io.livestreaming.api.commerce.domain.DonationCoinHistory
import java.math.BigInteger
import java.time.LocalDateTime

data class MemberDonationHistoryResponse(
    val donationDate: LocalDateTime,
    val quantity: BigInteger,
    val message: String,
    val receiverId: String,
) {
    companion object {
        fun of(donationCoinHistory: DonationCoinHistory): MemberDonationHistoryResponse {
            return MemberDonationHistoryResponse(
                donationDate = donationCoinHistory.donationDate,
                quantity = donationCoinHistory.quantity,
                message = donationCoinHistory.message,
                receiverId = donationCoinHistory.receiverId.value
            )
        }
    }
}
