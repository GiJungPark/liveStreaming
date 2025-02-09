package io.livestreaming.api.commerce.presentation.web.response

import io.livestreaming.api.commerce.domain.DonationCoinHistory
import io.livestreaming.api.commerce.domain.ExchangeCoinHistory
import io.livestreaming.api.commerce.domain.PurchaseCoinHistory
import org.springframework.data.domain.Page

data class PaginationResponse<T>(
    val data: List<T>,
    val page: Int,
    val size: Int,
    val totalPages: Int,
    val totalElements: Int,
) {
    companion object {
        fun ofChannelDonationHistory(page: Page<DonationCoinHistory>): PaginationResponse<ChannelDonationHistoryResponse> {
            val data = page.content.map { ChannelDonationHistoryResponse.of(it) }

            return PaginationResponse(
                data = data,
                page = page.number + 1,
                size = page.size,
                totalPages = page.totalPages,
                totalElements = page.totalElements.toInt()
            )
        }

        fun ofMemberDonationHistory(page: Page<DonationCoinHistory>): PaginationResponse<MemberDonationHistoryResponse> {
            val data = page.content.map { MemberDonationHistoryResponse.of(it) }

            return PaginationResponse(
                data = data,
                page = page.number + 1,
                size = page.size,
                totalPages = page.totalPages,
                totalElements = page.totalElements.toInt()
            )
        }

        fun ofPurchaseCoinHistory(page: Page<PurchaseCoinHistory>): PaginationResponse<PurchaseCoinHistoryResponse> {
            val data = page.content.map { PurchaseCoinHistoryResponse.of(it) }

            return PaginationResponse(
                data = data,
                page = page.number + 1,
                size = page.size,
                totalPages = page.totalPages,
                totalElements = page.totalElements.toInt()
            )
        }

        fun ofExchangeCoinHistory(page: Page<ExchangeCoinHistory>): PaginationResponse<ExchangeCoinHistoryResponse> {
            val data = page.content.map { ExchangeCoinHistoryResponse.of(it) }

            return PaginationResponse(
                data = data,
                page = page.number + 1,
                size = page.size,
                totalPages = page.totalPages,
                totalElements = page.totalElements.toInt()
            )
        }
    }
}