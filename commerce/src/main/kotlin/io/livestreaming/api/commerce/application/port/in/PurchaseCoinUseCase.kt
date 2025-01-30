package io.livestreaming.api.commerce.application.port.`in`

interface PurchaseCoinUseCase {
    fun purchase(command: PurchaseCoinCommand)
    fun readHistory(command: PurchaseCoinHistoryCommand): List<String>
}