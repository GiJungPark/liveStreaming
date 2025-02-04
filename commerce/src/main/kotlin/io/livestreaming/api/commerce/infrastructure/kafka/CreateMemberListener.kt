package io.livestreaming.api.commerce.infrastructure.kafka

import io.livestreaming.api.commerce.application.port.`in`.CreateChannelCoinBalanceCommand
import io.livestreaming.api.commerce.application.port.`in`.CreateCoinBalanceUseCase
import io.livestreaming.api.commerce.application.port.`in`.CreateMemberCoinBalanceCommand
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class CreateMemberListener(
    private val createCoinBalanceUseCase: CreateCoinBalanceUseCase
) {
    @KafkaListener(topics = ["create-member"], groupId = "commerce-service")
    @Transactional
    fun listener(data: String) {
        val addMemberBalanceCommand = CreateMemberCoinBalanceCommand.of(
            memberId = data
        )
        createCoinBalanceUseCase.createMemberCoinBalance(addMemberBalanceCommand)

        val addChannelBalanceCommand = CreateChannelCoinBalanceCommand.of(
            channelId = data
        )
        createCoinBalanceUseCase.createChannelCoinBalance(addChannelBalanceCommand)
    }
}
