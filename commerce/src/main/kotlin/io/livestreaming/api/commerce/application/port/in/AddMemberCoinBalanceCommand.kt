package io.livestreaming.api.commerce.application.port.`in`

import io.livestreaming.api.common.domain.MemberId

data class AddMemberCoinBalanceCommand(
    val memberId: MemberId
) {
    companion object {
        fun of(memberId: String) = AddMemberCoinBalanceCommand(MemberId.of(memberId))
    }
}
