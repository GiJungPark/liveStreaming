package io.livestreaming.api.commerce.application.port.out

import io.livestreaming.api.commerce.domain.ChannelId
import io.livestreaming.api.common.domain.MemberId
import java.math.BigInteger

interface DonationCoinPort {
    fun donation(memberId: MemberId, channelId: ChannelId, quantity: BigInteger)
}