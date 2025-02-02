package io.livestreaming.api.commerce.presentation.web

import io.livestreaming.api.commerce.application.port.`in`.*
import io.livestreaming.api.commerce.domain.DonationCoinHistory
import io.livestreaming.api.commerce.domain.PurchaseCoinHistory
import io.livestreaming.api.commerce.presentation.web.request.DonationCoinRequest
import io.livestreaming.api.commerce.presentation.web.request.PurchaseCoinRequest
import io.livestreaming.api.commerce.presentation.web.response.ChannelDonationHistoryResponse
import io.livestreaming.api.commerce.presentation.web.response.PaginationResponse
import org.springframework.data.domain.Page
import org.springframework.web.bind.annotation.*

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
    ): Page<PurchaseCoinHistory> {
        val command = PurchaseCoinHistoryCommand.of(
            memberId = memberId,
            page = page,
            size = size,
            searchYear = searchYear,
        )

        return purchaseCoinUseCase.readHistory(command)
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

    @GetMapping("/commerce/coin/donation/history")
    fun getDonationCoinHistory(
        @RequestParam("memberId") memberId: String,
        @RequestParam("page") page: Int,
        @RequestParam("size") size: Int,
        @RequestParam("searchYear") searchYear: String,
    ): Page<DonationCoinHistory> {
        val command = MemberDonationHistoryCommand.of(
            memberId = memberId,
            page = page,
            size = size,
            searchYear = searchYear,
        )

        return donationCoinUseCase.getDonationHistoryByMemberId(command)
    }

    @GetMapping("/commerce/channels/{channelId}/donations")
    fun getDonationCoinHistory(
        @PathVariable("channelId") channelId: String,
        @RequestParam("page") page: Int,
        @RequestParam("size") size: Int,
    ): PaginationResponse<ChannelDonationHistoryResponse> {
        val command = ChannelDonationHistoryCommand.of(
            channelId = channelId,
            page = page,
            size = size
        )
        val result = donationCoinUseCase.getDonationHistoryByChannelId(command)

        return PaginationResponse.ofChannelDonationHistory(result)
    }
}