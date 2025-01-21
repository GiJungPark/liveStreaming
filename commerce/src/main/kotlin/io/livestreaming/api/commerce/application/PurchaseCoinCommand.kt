package io.livestreaming.api.commerce.application

import io.livestreaming.api.commerce.domain.Coin
import io.livestreaming.api.common.domain.MemberId
import java.math.BigInteger

data class PurchaseCoinCommand(
    val memberId: MemberId,
    val coin: Coin,
) {
    companion object {
        fun of(memberId: String, amount: BigInteger) = PurchaseCoinCommand(MemberId.of(memberId), Coin.of(amount))
    }
}
