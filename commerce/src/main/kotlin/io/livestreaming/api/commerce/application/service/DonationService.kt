package io.livestreaming.api.commerce.application.service

import io.livestreaming.api.commerce.application.port.`in`.DonationCoinCommand
import io.livestreaming.api.commerce.application.port.`in`.DonationUseCase
import io.livestreaming.api.commerce.application.port.out.CoinBalanceLockPort
import io.livestreaming.api.commerce.application.port.out.CreateCoinHistoryPort
import io.livestreaming.api.commerce.application.port.out.GetCoinBalancePort
import io.livestreaming.api.commerce.application.port.out.UpdateCoinBalancePort
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.concurrent.TimeUnit

@Service
class DonationService(
    private val createCoinHistoryPort: CreateCoinHistoryPort,
    private val getCoinBalancePort: GetCoinBalancePort,
    private val updateCoinBalancePort: UpdateCoinBalancePort,
    private val lockPort: CoinBalanceLockPort
) : DonationUseCase {

    @Transactional
    override fun donation(command: DonationCoinCommand) {
        val lockKey = command.channelId.value

        lockPort.executeWithLock(lockKey) {
            val memberCoinBalance = getCoinBalancePort.getMemberBalanceByMemberId(command.memberId)
            val channelCoinBalance = getCoinBalancePort.getChannelBalanceByChannelId(command.channelId)

            memberCoinBalance.sub(command.quantity)
            channelCoinBalance.add(command.quantity)

            updateCoinBalancePort.updateMemberCoinBalance(command.memberId, memberCoinBalance)
            updateCoinBalancePort.updateChannelCoinBalance(command.channelId, memberCoinBalance)

            createCoinHistoryPort.createDonationHistory(
                memberId = command.memberId,
                channelId = command.channelId,
                quantity = command.quantity
            )
        }

    }
}