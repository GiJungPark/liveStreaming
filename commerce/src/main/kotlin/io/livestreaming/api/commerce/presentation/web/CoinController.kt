package io.livestreaming.api.commerce.presentation.web

import io.livestreaming.api.commerce.application.PurchaseCoinCommand
import io.livestreaming.api.commerce.application.PurchaseCoinUseCase
import io.livestreaming.api.commerce.application.ReadCoinPurchaseHistoryCommand
import io.livestreaming.api.commerce.application.ReadCoinUseCase
import io.livestreaming.api.commerce.domain.CoinPurchaseHistory
import io.livestreaming.api.commerce.presentation.web.request.PaginationRequest
import io.livestreaming.api.commerce.presentation.web.request.PurchaseCoinRequest
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController("/commerce")
class CoinController(
    private val purchaseCoinUseCase: PurchaseCoinUseCase,
    private val readCoinUseCase: ReadCoinUseCase,
) {
    @PostMapping("/purchase/coin")
    fun purchaseCoin(@RequestBody request: PurchaseCoinRequest) {
        val command = PurchaseCoinCommand.of(memberId = request.memberId, amount = request.coinAmount.toBigInteger())

        purchaseCoinUseCase.purchaseCoin(command)

    }

    @GetMapping("/purchase/coin")
    fun getCoinPurchaseHistory(
        @RequestParam(name = "memberId") memberId: String,
        @ModelAttribute paginationRequest: PaginationRequest,
    ): List<CoinPurchaseHistory> {
        val command = ReadCoinPurchaseHistoryCommand.of(
            memberId = memberId,
            page = paginationRequest.page,
            size = paginationRequest.size
        )

        return readCoinUseCase.readCoinPurchaseHistory(command)
    }

}