package io.livestreaming.api.commerce.application.port.`in`

import io.livestreaming.api.commerce.domain.DonationCoinHistory
import io.livestreaming.api.commerce.domain.ExchangeCoinHistory
import io.livestreaming.api.commerce.domain.PurchaseCoinHistory
import org.springframework.data.domain.Page

interface CoinHistoryQuery {
    fun getPurchaseHistory(query: PurchaseCoinHistoryQuery): Page<PurchaseCoinHistory>

    fun getDonationHistoryByMemberId(query: MemberDonationHistoryQuery): Page<DonationCoinHistory>
    fun getDonationHistoryByChannelId(query: ChannelDonationHistoryQuery): Page<DonationCoinHistory>

    fun getExchangeHistory(query: ChannelExchangeHistoryQuery): Page<ExchangeCoinHistory>
}