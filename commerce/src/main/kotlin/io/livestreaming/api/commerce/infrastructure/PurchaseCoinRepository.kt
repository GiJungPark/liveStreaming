package io.livestreaming.api.commerce.infrastructure

import io.livestreaming.api.commerce.application.PurchaseCoinPort
import io.livestreaming.api.commerce.domain.Coin
import io.livestreaming.api.commerce.infrastructure.entity.PurchaseCoinEntity
import io.livestreaming.api.common.domain.MemberId
import org.springframework.stereotype.Repository

@Repository
class PurchaseCoinRepository(
    private val jpaRepository: PurchaseCoinJpaRepository,
) : PurchaseCoinPort {
    override fun purchaseCoin(memberId: MemberId, purchaseCoin: Coin) {
        val entity = PurchaseCoinEntity(
            memberId = memberId.value,
            purchaseCoin = purchaseCoin.amount.toLong(),
            // TODO 변경해야하는 부분
            remainingCoin = Coin.ZERO.amount.toLong(),
        )

        jpaRepository.save(entity)
    }

}