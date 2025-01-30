package io.livestreaming.api.commerce.presentation.web

import io.livestreaming.api.commerce.application.port.`in`.*
import io.livestreaming.api.commerce.presentation.web.request.DonationCoinRequest
import io.livestreaming.api.commerce.presentation.web.request.PurchaseCoinRequest
import org.springframework.web.bind.annotation.*
import java.time.Year

@RestController
class CommerceController(
    private val purchaseCoinUseCase: PurchaseCoinUseCase,
    private val donationCoinUseCase: DonationCoinUseCase,
) {
    @PostMapping("/commerce/coin/purchase")
    fun purchaseCoin(@RequestBody request: PurchaseCoinRequest) {
        val command = PurchaseCoinCommand.of(
            memberId = request.memberId,
            quantity = request.quantity,
        )

        purchaseCoinUseCase.purchase(command)
    }

    @GetMapping("/commerce/coin/purchase/history")
    fun getPurchaseCoinHistory(
        @RequestParam("memberId") memberId: String,
        @RequestParam("page") page: Int,
        @RequestParam("size") size: Int,
        @RequestParam("searchYear") searchYear: String,
    ) {
        val command = PurchaseCoinHistoryCommand.of(
            memberId = memberId,
            page = page,
            size = size,
            searchYear = searchYear,
        )

        purchaseCoinUseCase.readHistory(command)
    }

    @PostMapping("/commerce/coin/donation")
    fun donationCoin(@RequestBody request: DonationCoinRequest) {
        val command = DonationCoinCommand.of(
            memberId = request.memberId,
            channelId = request.channelId,
            quantity = request.quantity
        )

        donationCoinUseCase.donation(command)
    }


}