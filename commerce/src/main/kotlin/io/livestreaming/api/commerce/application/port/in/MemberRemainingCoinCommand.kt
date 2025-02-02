package io.livestreaming.api.commerce.application.port.`in`

import io.livestreaming.api.common.domain.MemberId

data class MemberRemainingCoinCommand(
    val memberId: MemberId
) {
    companion object {
        fun of(memberId: String) = MemberRemainingCoinCommand(MemberId.of(memberId))
    }
}
