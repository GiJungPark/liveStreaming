package io.livestreaming.api.commerce.application.port.`in`

interface CreateCoinBalanceUseCase {
    fun createMemberCoinBalance(command: CreateMemberCoinBalanceCommand)
    fun createChannelCoinBalance(command: CreateChannelCoinBalanceCommand)
}