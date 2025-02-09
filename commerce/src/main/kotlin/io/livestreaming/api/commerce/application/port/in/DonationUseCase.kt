package io.livestreaming.api.commerce.application.port.`in`

interface DonationUseCase {
    fun donation(command: DonationCoinCommand)
}