package io.livestreaming.api.commerce.application.service

import io.livestreaming.api.commerce.application.port.`in`.CreateChannelCoinBalanceCommand
import io.livestreaming.api.commerce.application.port.`in`.CreateCoinBalanceUseCase
import io.livestreaming.api.commerce.application.port.`in`.CreateMemberCoinBalanceCommand
import io.livestreaming.api.commerce.application.port.out.CreateCoinBalancePort
import org.springframework.stereotype.Service

@Service
class CreateCoinBalanceService(
    private val createCoinBalancePort: CreateCoinBalancePort
) : CreateCoinBalanceUseCase {
    override fun createMemberCoinBalance(command: CreateMemberCoinBalanceCommand) {
        createCoinBalancePort.createMemberBalance(command.memberId)
    }

    override fun createChannelCoinBalance(command: CreateChannelCoinBalanceCommand) {
        createCoinBalancePort.createChannelBalance(command.channelId)
    }
}