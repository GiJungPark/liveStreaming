package io.livestreaming.api.commerce.infrastructure

import io.livestreaming.api.commerce.application.PurchaseCoinPort
import io.livestreaming.api.commerce.application.ReadCoinPurchaseHistoryPort
import io.livestreaming.api.commerce.domain.Coin
import io.livestreaming.api.commerce.domain.CoinPurchaseHistory
import io.livestreaming.api.commerce.infrastructure.entity.PurchaseCoinEntity
import io.livestreaming.api.common.domain.MemberId
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Repository

@Repository
class PurchaseCoinRepository(
    private val jpaRepository: PurchaseCoinJpaRepository,
) : PurchaseCoinPort, ReadCoinPurchaseHistoryPort {
    override fun purchaseCoin(memberId: MemberId, purchaseCoin: Coin) {
        val entity = PurchaseCoinEntity(
            memberId = memberId.value,
            purchaseCoin = purchaseCoin.amount.toLong(),
            // TODO 변경해야하는 부분
            remainingCoin = Coin.ZERO.amount.toLong(),
        )

        jpaRepository.save(entity)
    }

    override fun readCoinPurchaseHistory(memberId: MemberId, page: Int, size: Int): List<CoinPurchaseHistory> {
        val pageable = pageRequest(page, size)
        val coinPurchasePage = jpaRepository.findByMemberId(memberId = memberId.value, pageable = pageable)

        return coinPurchasePage.map { it.toCoinPurchaseHistory() }.toList()
    }

    private fun pageRequest(page: Int, size: Int): PageRequest {
        return PageRequest.of(
            page - 1, size, Sort.by(
                Sort.Order.desc("purchaseAt")
            )
        )
    }

}