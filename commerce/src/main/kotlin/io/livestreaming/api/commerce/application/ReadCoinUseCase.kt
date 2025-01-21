package io.livestreaming.api.commerce.application

import io.livestreaming.api.commerce.domain.Coin
import io.livestreaming.api.commerce.domain.CoinPurchaseHistory

interface ReadCoinUseCase {
    fun readCoinPurchaseHistory(command: ReadCoinPurchaseHistoryCommand): List<CoinPurchaseHistory>
}