package io.livestreaming.api.commerce.application.port.`in`

import io.livestreaming.api.commerce.domain.CoinBalance

interface CoinBalanceQuery {
    fun getMemberCoinBalance(query: MemberCoinBalanceQuery): CoinBalance
}