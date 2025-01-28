package io.livestreaming.api.commerce.application.port.out

import io.livestreaming.api.commerce.domain.Money
import io.livestreaming.api.common.domain.MemberId
import java.math.BigInteger

interface PurchaseCoinPort {
    fun purchase(memberId: MemberId, quantity: BigInteger, price: Money)
}