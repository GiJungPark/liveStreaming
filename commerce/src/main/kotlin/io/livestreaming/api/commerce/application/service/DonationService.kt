package io.livestreaming.api.commerce.application.service

import io.livestreaming.api.commerce.application.port.`in`.DonationCoinCommand
import io.livestreaming.api.commerce.application.port.`in`.DonationUseCase
import io.livestreaming.api.commerce.application.port.out.CreateCoinHistoryPort
import io.livestreaming.api.commerce.application.port.out.GetCoinBalancePort
import io.livestreaming.api.commerce.application.port.out.UpdateCoinBalancePort
import org.redisson.api.RedissonClient
import org.springframework.stereotype.Service
import java.util.concurrent.TimeUnit

@Service
class DonationService(
    private val redissonClient: RedissonClient,
    private val createCoinHistoryPort: CreateCoinHistoryPort,
    private val getCoinBalancePort: GetCoinBalancePort,
    private val updateCoinBalancePort: UpdateCoinBalancePort,
) : DonationUseCase {
    override fun donation(command: DonationCoinCommand) {
        val lock = redissonClient.getLock(command.channelId.value);

        try {
            val available = lock.tryLock(10, 1, TimeUnit.SECONDS)

            if (!available) {
                println("lock 획득 실패")
                return
            }

            val memberCoinBalance = getCoinBalancePort.getCoinBalanceByMemberId(command.memberId)
            val channelCoinBalance = getCoinBalancePort.getChannelBalanceByChannelId(command.channelId)

            memberCoinBalance.sub(command.quantity)
            channelCoinBalance.add(command.quantity)

            createCoinHistoryPort.createDonationHistory(
                memberId = command.memberId,
                channelId = command.channelId,
                quantity = command.quantity
            )

            updateCoinBalancePort.updateMemberCoinBalance(command.memberId, memberCoinBalance)
            updateCoinBalancePort.updateChannelCoinBalance(command.channelId, memberCoinBalance)

        } finally {
            lock.unlock()
        }
    }
}