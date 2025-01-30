package io.livestreaming.api.commerce.application.service

import io.livestreaming.api.commerce.application.port.`in`.DonationCoinCommand
import io.livestreaming.api.commerce.application.port.`in`.DonationCoinUseCase
import io.livestreaming.api.commerce.application.port.`in`.PurchaseCoinCommand
import io.livestreaming.api.commerce.application.port.`in`.PurchaseCoinUseCase
import io.livestreaming.api.commerce.application.port.out.DonationCoinPort
import io.livestreaming.api.commerce.application.port.out.PurchaseCoinPort
import io.livestreaming.api.commerce.domain.Money
import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.math.BigInteger
import java.math.RoundingMode

@Service
class CoinService(
    private val purchaseCoinPort: PurchaseCoinPort,
    private val donationCoinPort: DonationCoinPort
) : PurchaseCoinUseCase, DonationCoinUseCase {
    override fun purchase(command: PurchaseCoinCommand) {
        val price = Money.of(calculateCoinPrice(command.quantity))

        purchaseCoinPort.purchase(command.memberId, command.quantity, price)
    }

    override fun donation(command: DonationCoinCommand) {
        donationCoinPort.donation(
            memberId = command.memberId,
            channelId = command.channelId,
            quantity = command.quantity
        )
    }

    private fun calculateCoinPrice(amount: BigInteger): BigInteger {
        val calculatedPrice = amount.toBigDecimal().multiply(BigDecimal("1.1"))

        return calculatedPrice.setScale(0, RoundingMode.FLOOR).toBigInteger()
            .divide(BigInteger.TEN)
            .multiply(BigInteger.TEN)
    }

}