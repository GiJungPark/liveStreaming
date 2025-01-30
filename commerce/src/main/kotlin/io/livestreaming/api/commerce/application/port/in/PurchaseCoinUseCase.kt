package io.livestreaming.api.commerce.application.port.`in`

import io.livestreaming.api.commerce.domain.PurchaseCoinHistory

interface PurchaseCoinUseCase {
    fun purchase(command: PurchaseCoinCommand)
    fun readHistory(command: PurchaseCoinHistoryCommand): List<PurchaseCoinHistory>
}