package io.livestreaming.api.commerce.application.port.`in`

import io.livestreaming.api.common.domain.MemberId
import java.time.Year

data class DonationCoinHistoryCommand(
    val memberId: MemberId,
    val page: Int,
    val size: Int,
    val searchYear: Year,
) {
    companion object {
        fun of(memberId: String, page: Int, size: Int, searchYear: String) = DonationCoinHistoryCommand(
            memberId = MemberId.of(memberId),
            page = page,
            size = size,
            searchYear = Year.parse(searchYear)
        )
    }
}
