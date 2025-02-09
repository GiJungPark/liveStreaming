package io.livestreaming.api.commerce.application.port.out

import io.livestreaming.api.commerce.domain.ChannelId
import io.livestreaming.api.commerce.domain.Money
import io.livestreaming.api.common.domain.MemberId
import java.math.BigInteger

interface CreateCoinHistoryPort {
    fun createPurchaseHistory(memberId: MemberId, quantity: BigInteger, remaining: BigInteger, price: Money)
    fun createDonationHistory(memberId: MemberId, channelId: ChannelId, quantity: BigInteger)
    fun createExchangeHistory(channelId: ChannelId, quantity: BigInteger, price: Money, remaining: BigInteger)
}