package io.livestreaming.api.commerce.application.port.out

import io.livestreaming.api.commerce.domain.ChannelId
import io.livestreaming.api.commerce.domain.DonationCoinHistory
import io.livestreaming.api.common.domain.MemberId
import org.springframework.data.domain.Page
import java.math.BigInteger
import java.time.Year

interface DonationCoinPort {
    fun donation(memberId: MemberId, channelId: ChannelId, quantity: BigInteger)
    fun getDonationHistoryByMemberId(memberId: MemberId, page: Int, size: Int, searchYear: Year): Page<DonationCoinHistory>
    fun getDonationHistoryByChannelId(channelId: ChannelId, page: Int, size: Int): Page<DonationCoinHistory>
}