package io.livestreaming.api.commerce.application

import io.livestreaming.api.commerce.domain.CoinPurchaseHistory
import io.livestreaming.api.common.domain.MemberId

interface ReadCoinPurchaseHistoryPort {
    fun readCoinPurchaseHistory(memberId: MemberId, page: Int, size: Int) : List<CoinPurchaseHistory>
}