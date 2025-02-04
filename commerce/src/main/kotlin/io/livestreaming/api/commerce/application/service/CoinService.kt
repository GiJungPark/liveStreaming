package io.livestreaming.api.commerce.application.service

import io.livestreaming.api.commerce.application.port.`in`.*
import io.livestreaming.api.commerce.application.port.out.AddCoinBalancePort
import io.livestreaming.api.commerce.application.port.out.DonationCoinPort
import io.livestreaming.api.commerce.application.port.out.PurchaseCoinPort
import io.livestreaming.api.commerce.domain.CoinBalance
import io.livestreaming.api.commerce.domain.DonationCoinHistory
import io.livestreaming.api.commerce.domain.PurchaseCoinHistory
import io.livestreaming.api.commerce.domain.Money
import org.redisson.api.RedissonClient
import org.springframework.data.domain.Page
import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.math.BigInteger
import java.math.RoundingMode
import java.util.concurrent.TimeUnit

@Service
class CoinService(
    private val purchaseCoinPort: PurchaseCoinPort,
    private val donationCoinPort: DonationCoinPort,
    private val redissonClient: RedissonClient,
    private val addCoinBalancePort: AddCoinBalancePort
) : PurchaseCoinUseCase, DonationCoinUseCase, AddCoinBalanceUseCase {
    override fun purchase(command: PurchaseCoinCommand) {
        val price = Money.of(calculateCoinPrice(command.quantity))

        purchaseCoinPort.purchase(command.memberId, command.quantity, price)
    }

    override fun readHistory(command: PurchaseCoinHistoryCommand): Page<PurchaseCoinHistory> {
        return purchaseCoinPort.getPurchaseHistory(
            memberId = command.memberId,
            page = command.page - 1,
            size = command.size
        )
    }

    override fun getMemberRemainingCoin(command: MemberRemainingCoinCommand): CoinBalance {
        return purchaseCoinPort.getMemberRemainingCoin(command.memberId)
    }

    override fun donation(command: DonationCoinCommand) {
        val lock = redissonClient.getLock(command.channelId.value);

        try {
            val available = lock.tryLock(10, 1, TimeUnit.SECONDS)

            if (!available) {
                println("lock 획득 실패")
                return
            }

            donationCoinPort.donation(
                memberId = command.memberId,
                channelId = command.channelId,
                quantity = command.quantity
            )

        } finally {
            lock.unlock()
        }
    }

    override fun getDonationHistoryByMemberId(command: MemberDonationHistoryCommand): Page<DonationCoinHistory> {
        return donationCoinPort.getDonationHistoryByMemberId(
            memberId = command.memberId,
            page = command.page - 1,
            size = command.size,
        )
    }

    override fun getDonationHistoryByChannelId(command: ChannelDonationHistoryCommand): Page<DonationCoinHistory> {
        return donationCoinPort.getDonationHistoryByChannelId(
            channelId = command.channelId,
            page = command.page - 1,
            size = command.size,
        )
    }

    private fun calculateCoinPrice(amount: BigInteger): BigInteger {
        val calculatedPrice = amount.toBigDecimal().multiply(BigDecimal("1.1"))

        return calculatedPrice.setScale(0, RoundingMode.FLOOR).toBigInteger()
            .divide(BigInteger.TEN)
            .multiply(BigInteger.TEN)
    }

    override fun addMemberCoinBalance(command: AddMemberCoinBalanceCommand) {
        addCoinBalancePort.addMemberBalance(command.memberId)
    }

    override fun addChannelCoinBalance(command: AddChannelCoinBalanceCommand) {
        addCoinBalancePort.addChannelBalance(command.channelId)
    }

}