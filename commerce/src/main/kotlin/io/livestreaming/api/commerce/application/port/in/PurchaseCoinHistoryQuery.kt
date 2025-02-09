package io.livestreaming.api.commerce.application.port.`in`

import io.livestreaming.api.common.domain.MemberId

data class PurchaseCoinHistoryQuery(
    val memberId: MemberId,
    val page: Int,
    val size: Int,
) {
    companion object {
        fun of(memberId: String, page: Int, size: Int): PurchaseCoinHistoryQuery {
            return PurchaseCoinHistoryQuery(
                memberId = MemberId.of(memberId),
                page = page,
                size = size
            )
        }
    }
}
