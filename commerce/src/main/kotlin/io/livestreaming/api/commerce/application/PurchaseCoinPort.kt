package io.livestreaming.api.commerce.application

import io.livestreaming.api.commerce.domain.Coin
import io.livestreaming.api.common.domain.MemberId

interface PurchaseCoinPort {
    fun purchaseCoin(memberId: MemberId, purchaseCoin: Coin)
}