package io.livestreaming.api.commerce.application.port.out

import io.livestreaming.api.commerce.domain.CoinBalance
import io.livestreaming.api.commerce.domain.Money
import io.livestreaming.api.commerce.domain.PurchaseCoinHistory
import io.livestreaming.api.common.domain.MemberId
import org.springframework.data.domain.Page
import java.math.BigInteger

interface PurchaseCoinPort {
    fun purchase(memberId: MemberId, quantity: BigInteger, price: Money)
    fun getPurchaseHistory(memberId: MemberId, size: Int, page: Int): Page<PurchaseCoinHistory>
    fun getMemberRemainingCoin(memberId: MemberId): CoinBalance
}