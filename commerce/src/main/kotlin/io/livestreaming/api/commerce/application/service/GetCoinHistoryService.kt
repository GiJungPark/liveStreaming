package io.livestreaming.api.commerce.application.service

import io.livestreaming.api.commerce.application.port.`in`.*
import io.livestreaming.api.commerce.application.port.out.GetCoinHistoryPort
import io.livestreaming.api.commerce.domain.DonationCoinHistory
import io.livestreaming.api.commerce.domain.ExchangeCoinHistory
import io.livestreaming.api.commerce.domain.PurchaseCoinHistory
import org.springframework.data.domain.Page
import org.springframework.stereotype.Service

@Service
class GetCoinHistoryService(
    private val getCoinHistoryPort: GetCoinHistoryPort
) : CoinHistoryQuery {
    override fun getPurchaseHistory(query: PurchaseCoinHistoryQuery): Page<PurchaseCoinHistory> {
        return getCoinHistoryPort.getPurchaseHistoryByMemberId(
            memberId = query.memberId,
            size = query.size,
            page = query.page
        )
    }

    override fun getDonationHistoryByMemberId(query: MemberDonationHistoryQuery): Page<DonationCoinHistory> {
        return getCoinHistoryPort.getDonationHistoryByMemberId(
            memberId = query.memberId,
            size = query.size,
            page = query.page
        )
    }

    override fun getDonationHistoryByChannelId(query: ChannelDonationHistoryQuery): Page<DonationCoinHistory> {
        return getCoinHistoryPort.getDonationHistoryByChannelId(
            channelId = query.channelId,
            size = query.size,
            page = query.page
        )
    }

    override fun getExchangeHistory(query: ChannelExchangeHistoryQuery): Page<ExchangeCoinHistory> {
        return getCoinHistoryPort.getExchangeHistoryByChannelId(
            channelId = query.channelId,
            size = query.size,
            page = query.page
        )
    }

}