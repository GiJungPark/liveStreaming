package io.livestreaming.api.commerce.application.port.`in`

interface DonationCoinUseCase {
    fun donation(command: DonationCoinCommand)
}