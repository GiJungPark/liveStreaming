package io.livestreaming.api.commerce.application.service

import io.livestreaming.api.commerce.application.port.`in`.ChannelDonationHistoryQuery
import io.livestreaming.api.commerce.application.port.`in`.CoinHistoryQuery
import io.livestreaming.api.commerce.application.port.`in`.MemberDonationHistoryQuery
import io.livestreaming.api.commerce.application.port.`in`.PurchaseCoinHistoryQuery
import io.livestreaming.api.commerce.application.port.out.GetCoinHistoryPort
import io.livestreaming.api.commerce.domain.DonationCoinHistory
import io.livestreaming.api.commerce.domain.PurchaseCoinHistory
import org.springframework.data.domain.Page
import org.springframework.stereotype.Service

@Service
class GetCoinHistoryService(
    private val getCoinHistoryPort: GetCoinHistoryPort
) : CoinHistoryQuery {
    override fun getPurchaseHistory(command: PurchaseCoinHistoryQuery): Page<PurchaseCoinHistory> {
        return getCoinHistoryPort.getPurchaseHistoryByMemberId(
            memberId = command.memberId,
            size = command.size,
            page = command.page
        )
    }

    override fun getDonationHistoryByMemberId(command: MemberDonationHistoryQuery): Page<DonationCoinHistory> {
        return getCoinHistoryPort.getDonationHistoryByMemberId(
            memberId = command.memberId,
            size = command.size,
            page = command.page
        )
    }

    override fun getDonationHistoryByChannelId(command: ChannelDonationHistoryQuery): Page<DonationCoinHistory> {
        return getCoinHistoryPort.getDonationHistoryByChannelId(
            channelId = command.channelId,
            size = command.size,
            page = command.page
        )
    }

}