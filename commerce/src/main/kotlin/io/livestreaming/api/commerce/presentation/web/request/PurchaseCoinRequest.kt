package io.livestreaming.api.commerce.presentation.web.request

data class PurchaseCoinRequest(
    val memberId: String,
    val coinAmount: String,
)