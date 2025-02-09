package io.livestreaming.api.commerce.application.port.`in`

import io.livestreaming.api.common.domain.MemberId
import java.math.BigInteger

data class PurchaseCoinCommand(
    val memberId: MemberId,
    val quantity: BigInteger,
) {
    companion object {
        fun of(memberId: String, quantity: BigInteger): PurchaseCoinCommand {
            return PurchaseCoinCommand(MemberId.of(memberId), quantity)
        }
    }
}