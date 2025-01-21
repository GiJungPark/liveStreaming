package io.livestreaming.api.commerce.application

interface PurchaseCoinUseCase {
    fun purchaseCoin(command: PurchaseCoinCommand)
}