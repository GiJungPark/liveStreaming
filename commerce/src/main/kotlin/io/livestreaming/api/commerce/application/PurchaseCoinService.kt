package io.livestreaming.api.commerce.application

import io.livestreaming.api.commerce.domain.Coin
import org.springframework.stereotype.Service

@Service
class PurchaseCoinService(
    private val purchaseCoinPort: PurchaseCoinPort
) : PurchaseCoinUseCase {
    override fun purchaseCoin(command: PurchaseCoinCommand) {
        purchaseCoinPort.purchaseCoin(
            memberId = command.memberId,
            purchaseCoin = command.coin,
        )

    }
}