package io.livestreaming.api.commerce.application.port.`in`

import io.livestreaming.api.commerce.domain.CoinBalance
import io.livestreaming.api.commerce.domain.PurchaseCoinHistory
import org.springframework.data.domain.Page

interface PurchaseCoinUseCase {
    fun purchase(command: PurchaseCoinCommand)
    fun readHistory(command: PurchaseCoinHistoryCommand): Page<PurchaseCoinHistory>
    fun getMemberRemainingCoin(command: MemberRemainingCoinCommand): CoinBalance
}