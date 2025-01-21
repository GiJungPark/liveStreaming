package io.livestreaming.api.commerce.application

import io.livestreaming.api.common.domain.MemberId

data class ReadCoinPurchaseHistoryCommand(
    val memberId: MemberId,
    val page: Int,
    val size: Int,
) {
    companion object {
        fun of(memberId: String, page: Int, size: Int) = ReadCoinPurchaseHistoryCommand(MemberId.of(memberId), page, size)
    }
}
