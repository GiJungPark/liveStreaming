package io.livestreaming.api.commerce.presentation.web.response

import io.livestreaming.api.commerce.domain.CoinBalance
import java.math.BigInteger

data class ChannelRemainingCoinResponse(
    val remaining: BigInteger,
) {
    companion object {
        fun of(remaining: CoinBalance) = ChannelRemainingCoinResponse(remaining.quantity)
    }
}
