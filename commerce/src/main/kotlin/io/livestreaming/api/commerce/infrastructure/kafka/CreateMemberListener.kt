package io.livestreaming.api.commerce.infrastructure.kafka

import io.livestreaming.api.commerce.application.port.`in`.AddChannelCoinBalanceCommand
import io.livestreaming.api.commerce.application.port.`in`.AddCoinBalanceUseCase
import io.livestreaming.api.commerce.application.port.`in`.AddMemberCoinBalanceCommand
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class CreateMemberListener(
    private val addCoinBalanceUseCase: AddCoinBalanceUseCase
) {
    @KafkaListener(topics = ["create-member"], groupId = "commerce-service")
    @Transactional
    fun listener(data: String) {
        val addMemberBalanceCommand = AddMemberCoinBalanceCommand.of(
            memberId = data
        )
        addCoinBalanceUseCase.addMemberCoinBalance(addMemberBalanceCommand)

        val addChannelBalanceCommand = AddChannelCoinBalanceCommand.of(
            channelId = data
        )
        addCoinBalanceUseCase.addChannelCoinBalance(addChannelBalanceCommand)
    }
}
