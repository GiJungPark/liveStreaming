package io.livestreaming.api.commerce.application

import io.livestreaming.api.commerce.domain.CoinPurchaseHistory
import org.springframework.stereotype.Service

@Service
class ReadCoinService(
    private val readCoinPurchaseHistoryPort: ReadCoinPurchaseHistoryPort
) : ReadCoinUseCase {
    override fun readCoinPurchaseHistory(command: ReadCoinPurchaseHistoryCommand): List<CoinPurchaseHistory> {
        return readCoinPurchaseHistoryPort.readCoinPurchaseHistory(
            memberId = command.memberId,
            page = command.page,
            size = command.size
        )
    }
}