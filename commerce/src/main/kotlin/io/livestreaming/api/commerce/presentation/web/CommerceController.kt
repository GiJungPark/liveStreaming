package io.livestreaming.api.commerce.presentation.web

import io.livestreaming.api.commerce.application.port.`in`.*
import io.livestreaming.api.commerce.presentation.web.request.DonationCoinRequest
import io.livestreaming.api.commerce.presentation.web.request.PurchaseCoinRequest
import io.livestreaming.api.commerce.presentation.web.response.*
import org.springframework.web.bind.annotation.*

@RestController
class CommerceController(
    private val purchaseCoinUseCase: PurchaseCoinUseCase,
    private val coinHistoryQuery: CoinHistoryQuery,
    private val coinBalanceQuery: CoinBalanceQuery,
    private val donationUseCase: DonationUseCase,
) {
    @PostMapping("/coin/members/{memberId}")
    fun purchaseCoin(@RequestBody request: PurchaseCoinRequest) {
        val command = PurchaseCoinCommand.of(
            memberId = request.memberId,
            quantity = request.quantity,
        )

        purchaseCoinUseCase.purchase(command)
    }

    @GetMapping("/coin/members/{memberId}")
    fun getPurchaseCoinHistory(
        @PathVariable("memberId") memberId: String,
        @RequestParam("page") page: Int,
        @RequestParam("size") size: Int,
    ): PaginationResponse<PurchaseCoinHistoryResponse> {
        val query = PurchaseCoinHistoryQuery.of(
            memberId = memberId,
            page = page,
            size = size
        )
        val result = coinHistoryQuery.getPurchaseHistory(query)

        return PaginationResponse.ofPurchaseCoinHistory(result)
    }

    @GetMapping("/coin/members/{memberId}/remaining")
    fun getCoinRemaining(@PathVariable("memberId") memberId: String): MemberRemainingCoinResponse {
        val query = MemberCoinBalanceQuery.of(
            memberId = memberId
        )
        val result = coinBalanceQuery.getMemberCoinBalance(query)

        return MemberRemainingCoinResponse.of(result)
    }

    @PostMapping("/coin/members/{memberId}/donations")
    fun donationCoin(@RequestBody request: DonationCoinRequest) {
        val command = DonationCoinCommand.of(
            memberId = request.memberId,
            channelId = request.channelId,
            quantity = request.quantity
        )

        donationUseCase.donation(command)
    }

    @GetMapping("/coin/members/{memberId}/donations")
    fun getDonationCoinHistoryByMember(
        @PathVariable("memberId") memberId: String,
        @RequestParam("page") page: Int,
        @RequestParam("size") size: Int,
    ): PaginationResponse<MemberDonationHistoryResponse> {
        val query = MemberDonationHistoryQuery.of(
            memberId = memberId,
            page = page,
            size = size,
        )
        val result = coinHistoryQuery.getDonationHistoryByMemberId(query)

        return PaginationResponse.ofMemberDonationHistory(result)
    }

    @GetMapping("/coin/channels/{channelId}/donations")
    fun getDonationCoinHistoryByChannel(
        @PathVariable("channelId") channelId: String,
        @RequestParam("page") page: Int,
        @RequestParam("size") size: Int,
    ): PaginationResponse<ChannelDonationHistoryResponse> {
        val query = ChannelDonationHistoryQuery.of(
            channelId = channelId,
            page = page,
            size = size
        )
        val result = coinHistoryQuery.getDonationHistoryByChannelId(query)

        return PaginationResponse.ofChannelDonationHistory(result)
    }
}