package io.livestreaming.api.commerce.application.port.`in`

import io.livestreaming.api.commerce.domain.DonationCoinHistory
import org.springframework.data.domain.Page

interface DonationCoinUseCase {
    fun donation(command: DonationCoinCommand)
    fun readHistory(command: DonationCoinHistoryCommand): Page<DonationCoinHistory>
}