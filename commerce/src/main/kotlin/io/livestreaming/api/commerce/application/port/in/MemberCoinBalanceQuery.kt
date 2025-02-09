package io.livestreaming.api.commerce.application.port.`in`

import io.livestreaming.api.common.domain.MemberId

data class MemberCoinBalanceQuery(
    val memberId: MemberId
) {
    companion object {
        fun of(memberId: String) = MemberCoinBalanceQuery(MemberId.of(memberId))
    }
}
