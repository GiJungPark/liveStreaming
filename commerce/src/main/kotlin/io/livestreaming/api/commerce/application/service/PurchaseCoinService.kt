package io.livestreaming.api.commerce.application.service

import io.livestreaming.api.commerce.application.port.`in`.PurchaseCoinCommand
import io.livestreaming.api.commerce.application.port.`in`.PurchaseCoinUseCase
import io.livestreaming.api.commerce.application.port.out.CreateCoinHistoryPort
import io.livestreaming.api.commerce.application.port.out.GetCoinBalancePort
import io.livestreaming.api.commerce.application.port.out.UpdateCoinBalancePort
import io.livestreaming.api.commerce.domain.Money
import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.math.BigInteger
import java.math.RoundingMode

@Service
class PurchaseCoinService(
    private val getCoinBalancePort: GetCoinBalancePort,
    private val updateCoinBalancePort: UpdateCoinBalancePort,
    private val createCoinHistoryPort: CreateCoinHistoryPort,
) : PurchaseCoinUseCase {
    override fun purchase(command: PurchaseCoinCommand) {
        val memberCoinBalance = getCoinBalancePort.getMemberBalanceByMemberId(command.memberId)
        val remaining = memberCoinBalance.quantity

        memberCoinBalance.add(command.quantity)

        updateCoinBalancePort.updateMemberCoinBalance(command.memberId, memberCoinBalance)

        createCoinHistoryPort.createPurchaseHistory(
            memberId = command.memberId,
            remaining = remaining,
            quantity = command.quantity,
            price = calculateCoinPrice(command.quantity)
        )
    }

    private fun calculateCoinPrice(amount: BigInteger): Money {
        val calculatedPrice = amount.toBigDecimal().multiply(BigDecimal("1.1"))

        return Money.of(
            calculatedPrice.setScale(0, RoundingMode.FLOOR).toBigInteger()
                .divide(BigInteger.TEN)
                .multiply(BigInteger.TEN)
        )
    }
}