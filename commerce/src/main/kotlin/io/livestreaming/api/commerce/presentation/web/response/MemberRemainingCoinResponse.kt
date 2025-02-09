package io.livestreaming.api.commerce.presentation.web.response

import io.livestreaming.api.commerce.domain.CoinBalance
import java.math.BigInteger

data class MemberRemainingCoinResponse(
    val remaining: BigInteger,
) {
    companion object {
        fun of(coinBalance: CoinBalance): MemberRemainingCoinResponse {
            return MemberRemainingCoinResponse(coinBalance.quantity)
        }
    }
}
