package io.livestreaming.api.commerce.application.port.`in`

import io.livestreaming.api.common.domain.MemberId

data class CreateMemberCoinBalanceCommand(
    val memberId: MemberId
) {
    companion object {
        fun of(memberId: String) = CreateMemberCoinBalanceCommand(MemberId.of(memberId))
    }
}
