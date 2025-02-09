package io.livestreaming.api.commerce.presentation.web.request

import java.math.BigInteger

data class DonationCoinRequest(
    val memberId: String,
    val channelId: String,
    val quantity: BigInteger,
)
