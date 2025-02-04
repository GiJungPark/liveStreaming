package io.livestreaming.api.commerce.application.port.out

import io.livestreaming.api.commerce.domain.ChannelId
import io.livestreaming.api.commerce.domain.CoinBalance
import io.livestreaming.api.common.domain.MemberId

interface UpdateCoinBalancePort {
    fun updateMemberCoinBalance(memberId: MemberId, coinBalance: CoinBalance)
    fun updateChannelCoinBalance(channelId: ChannelId, coinBalance: CoinBalance)
}