package io.livestreaming.api.commerce.presentation.web.request

import java.math.BigInteger

data class PurchaseCoinRequest(
    val memberId: String,
    val quantity: BigInteger,
)
