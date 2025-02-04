package io.livestreaming.api.commerce.application.port.out

import io.livestreaming.api.commerce.domain.ChannelId
import io.livestreaming.api.commerce.domain.DonationCoinHistory
import io.livestreaming.api.commerce.domain.PurchaseCoinHistory
import io.livestreaming.api.common.domain.MemberId
import org.springframework.data.domain.Page

interface GetCoinHistoryPort {
    fun getPurchaseHistoryByMemberId(memberId: MemberId, size: Int, page: Int): Page<PurchaseCoinHistory>
    fun getDonationHistoryByMemberId(memberId: MemberId, size: Int, page: Int): Page<DonationCoinHistory>
    fun getDonationHistoryByChannelId(channelId: ChannelId, size: Int, page: Int): Page<DonationCoinHistory>
}