package io.livestreaming.api.commerce.presentation.web

import io.livestreaming.api.commerce.application.port.`in`.PurchaseCoinCommand
import io.livestreaming.api.commerce.application.port.`in`.PurchaseCoinUseCase
import io.livestreaming.api.commerce.presentation.web.request.PurchaseCoinRequest
import org.springframework.web.bind.annotation.*

@RestController
class CommerceController(
    private val purchaseCoinUseCase: PurchaseCoinUseCase
) {
    @PostMapping("/commerce/coin/purchase")
    fun purchaseCoin(@RequestBody request: PurchaseCoinRequest) {
        val command = PurchaseCoinCommand.of(
            memberId = request.memberId,
            quantity = request.quantity,
        )

        purchaseCoinUseCase.purchase(command)
    }

}