package io.livestreaming.api.commerce.presentation.web

import io.livestreaming.api.commerce.application.PurchaseCoinCommand
import io.livestreaming.api.commerce.application.PurchaseCoinUseCase
import io.livestreaming.api.commerce.presentation.web.request.PurchaseCoinRequest
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController("/commerce")
class CoinController(
    private val purchaseCoinUseCase: PurchaseCoinUseCase,
) {
    @PostMapping("/purchase/coin")
    fun purchaseCoin(@RequestBody request: PurchaseCoinRequest) {
        val command = PurchaseCoinCommand.of(memberId = request.memberId, amount = request.coinAmount.toBigInteger())

        purchaseCoinUseCase.purchaseCoin(command)

    }

}