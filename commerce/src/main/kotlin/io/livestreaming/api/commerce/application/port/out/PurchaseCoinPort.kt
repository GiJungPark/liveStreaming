package io.livestreaming.api.commerce.application.port.out

import io.livestreaming.api.commerce.domain.Money
import io.livestreaming.api.commerce.domain.PurchaseCoinHistory
import io.livestreaming.api.common.domain.MemberId
import java.math.BigInteger
import java.time.Year

interface PurchaseCoinPort {
    fun purchase(memberId: MemberId, quantity: BigInteger, price: Money)
    fun getHistory(memberId: MemberId, size: Int, page: Int, searchYear: Year): List<PurchaseCoinHistory>
}