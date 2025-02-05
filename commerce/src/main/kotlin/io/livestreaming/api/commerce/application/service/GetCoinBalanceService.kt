package io.livestreaming.api.commerce.application.service

import io.livestreaming.api.commerce.application.port.`in`.ChannelCoinBalanceQuery
import io.livestreaming.api.commerce.application.port.`in`.CoinBalanceQuery
import io.livestreaming.api.commerce.application.port.`in`.MemberCoinBalanceQuery
import io.livestreaming.api.commerce.application.port.out.GetCoinBalancePort
import io.livestreaming.api.commerce.domain.CoinBalance
import org.springframework.stereotype.Service

@Service
class GetCoinBalanceService(
    private val getCoinBalancePort: GetCoinBalancePort,
) : CoinBalanceQuery {
    override fun getMemberCoinBalance(query: MemberCoinBalanceQuery): CoinBalance {
        return getCoinBalancePort.getMemberBalanceByMemberId(query.memberId)
    }

    override fun getChannelCoinBalance(query: ChannelCoinBalanceQuery): CoinBalance {
        return getCoinBalancePort.getChannelBalanceByChannelId(query.channelId)
    }

}