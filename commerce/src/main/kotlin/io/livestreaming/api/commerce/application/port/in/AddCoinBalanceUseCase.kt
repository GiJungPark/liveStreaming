package io.livestreaming.api.commerce.application.port.`in`

interface AddCoinBalanceUseCase {
    fun addMemberCoinBalance(command: AddMemberCoinBalanceCommand)
    fun addChannelCoinBalance(command: AddChannelCoinBalanceCommand)
}