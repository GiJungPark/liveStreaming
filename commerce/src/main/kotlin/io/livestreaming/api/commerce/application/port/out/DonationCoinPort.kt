package io.livestreaming.api.commerce.application.port.out

import io.livestreaming.api.commerce.domain.ChannelId
import io.livestreaming.api.commerce.domain.DonationCoinHistory
import io.livestreaming.api.common.domain.MemberId
import org.springframework.data.domain.Page
import java.math.BigInteger

interface DonationCoinPort {
    fun donation(memberId: MemberId, channelId: ChannelId, quantity: BigInteger)
    fun getDonationHistoryByMemberId(memberId: MemberId, page: Int, size: Int): Page<DonationCoinHistory>
    fun getDonationHistoryByChannelId(channelId: ChannelId, page: Int, size: Int): Page<DonationCoinHistory>
}