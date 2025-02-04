package io.livestreaming.api.commerce.application.port.out

import io.livestreaming.api.commerce.domain.ChannelId
import io.livestreaming.api.common.domain.MemberId

interface AddCoinBalancePort {
    fun addMemberBalance(memberId: MemberId)
    fun addChannelBalance(channelId: ChannelId)
}