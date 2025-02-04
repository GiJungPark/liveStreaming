package io.livestreaming.api.commerce.application.port.out

import io.livestreaming.api.commerce.domain.ChannelId
import io.livestreaming.api.common.domain.MemberId

interface CreateCoinBalancePort {
    fun createMemberBalance(memberId: MemberId)
    fun createChannelBalance(channelId: ChannelId)
}