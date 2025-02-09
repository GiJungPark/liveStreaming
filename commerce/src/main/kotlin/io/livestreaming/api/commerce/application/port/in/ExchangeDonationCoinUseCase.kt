package io.livestreaming.api.commerce.application.port.`in`

interface ExchangeDonationCoinUseCase {
    fun exchange(command: ExchangeDonationCoinCommand)
}