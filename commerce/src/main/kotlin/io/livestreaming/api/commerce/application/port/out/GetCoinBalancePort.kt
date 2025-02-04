package io.livestreaming.api.commerce.application.port.out

import io.livestreaming.api.commerce.domain.ChannelId
import io.livestreaming.api.commerce.domain.CoinBalance
import io.livestreaming.api.common.domain.MemberId

interface GetCoinBalancePort {
    fun getCoinBalanceByMemberId(memberId: MemberId): CoinBalance
    fun getChannelBalanceByChannelId(channelId: ChannelId): CoinBalance
}