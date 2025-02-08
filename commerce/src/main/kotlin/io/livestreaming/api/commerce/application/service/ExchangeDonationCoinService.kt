package io.livestreaming.api.commerce.application.service

import io.livestreaming.api.commerce.application.port.`in`.ExchangeDonationCoinCommand
import io.livestreaming.api.commerce.application.port.`in`.ExchangeDonationCoinUseCase
import io.livestreaming.api.commerce.application.port.out.CoinBalanceLockPort
import io.livestreaming.api.commerce.application.port.out.CreateCoinHistoryPort
import io.livestreaming.api.commerce.application.port.out.GetCoinBalancePort
import io.livestreaming.api.commerce.application.port.out.UpdateCoinBalancePort
import io.livestreaming.api.commerce.domain.Money
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.math.BigDecimal
import java.math.BigInteger
import java.math.RoundingMode

@Service
class ExchangeDonationCoinService(
    private val coinHistoryPort: CreateCoinHistoryPort,
    private val updateCoinBalancePort: UpdateCoinBalancePort,
    private val getCoinBalancePort: GetCoinBalancePort,
    private val lockPort: CoinBalanceLockPort
) : ExchangeDonationCoinUseCase {

    @Transactional
    override fun exchange(command: ExchangeDonationCoinCommand) {
        val lockKey = command.channelId.value

        lockPort.executeWithLock(lockKey) {
            val channelCoinBalance = getCoinBalancePort.getChannelBalanceByChannelId(command.channelId)

            channelCoinBalance.sub(command.quantity)

            updateCoinBalancePort.updateChannelCoinBalance(channelId = command.channelId, coinBalance = channelCoinBalance)

            coinHistoryPort.createExchangeHistory(
                channelId = command.channelId,
                quantity = command.quantity,
                price = calculateCoinPrice(command.quantity),
                remaining = channelCoinBalance.quantity
            )
        }
    }

    private fun calculateCoinPrice(amount: BigInteger): Money {
        val calculatedPrice = amount.toBigDecimal().multiply(BigDecimal("0.7"))

        return Money.of(
            calculatedPrice.setScale(0, RoundingMode.FLOOR).toBigInteger()
                .divide(BigInteger.TEN)
                .multiply(BigInteger.TEN)
        )
    }
}