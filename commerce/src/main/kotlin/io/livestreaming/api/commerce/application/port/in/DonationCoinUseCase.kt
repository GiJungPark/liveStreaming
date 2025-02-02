package io.livestreaming.api.commerce.application.port.`in`

import io.livestreaming.api.commerce.domain.DonationCoinHistory
import org.springframework.data.domain.Page

interface DonationCoinUseCase {
    fun donation(command: DonationCoinCommand)
    fun getDonationHistoryByMemberId(command: MemberDonationHistoryCommand): Page<DonationCoinHistory>
    fun getDonationHistoryByChannelId(command: ChannelDonationHistoryCommand): Page<DonationCoinHistory>
}