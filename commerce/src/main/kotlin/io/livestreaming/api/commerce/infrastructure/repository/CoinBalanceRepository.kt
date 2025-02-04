package io.livestreaming.api.commerce.infrastructure.repository

import io.livestreaming.api.commerce.application.port.out.*
import io.livestreaming.api.commerce.domain.*
import io.livestreaming.api.commerce.infrastructure.repository.entity.ChannelCoinBalanceEntity
import io.livestreaming.api.commerce.infrastructure.repository.entity.MemberCoinBalanceEntity
import io.livestreaming.api.commerce.infrastructure.repository.entity.DonationCoinHistoryEntity
import io.livestreaming.api.commerce.infrastructure.repository.entity.PurchaseCoinHistoryEntity
import io.livestreaming.api.common.domain.MemberId
import jakarta.transaction.Transactional
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Repository
import java.math.BigInteger

@Repository
class CoinBalanceRepository(
    private val memberCoinBalanceJpaRepository: MemberCoinBalanceJpaRepository,
    private val channelCoinBalanceJpaRepository: ChannelCoinBalanceJpaRepository,
) : CreateCoinBalancePort, GetCoinBalancePort, UpdateCoinBalancePort {

    override fun createMemberBalance(memberId: MemberId) {
        val memberCoinBalanceEntity = MemberCoinBalanceEntity.of(memberId.value, BigInteger.ZERO)

        memberCoinBalanceJpaRepository.save(memberCoinBalanceEntity)
    }

    override fun createChannelBalance(channelId: ChannelId) {
        val channelCoinBalanceEntity = ChannelCoinBalanceEntity.of(channelId.value, BigInteger.ZERO)

        channelCoinBalanceJpaRepository.save(channelCoinBalanceEntity)
    }

    override fun getCoinBalanceByMemberId(memberId: MemberId): CoinBalance {
        val memberCoinBalanceEntity = memberCoinBalanceJpaRepository.findById(memberId.value)

        if (memberCoinBalanceEntity.isPresent) {
            return CoinBalance.of(memberCoinBalanceEntity.get().amount)
        }

        throw IllegalArgumentException("해당하는 Member가 존재하지 않습니다.")
    }

    override fun getChannelBalanceByChannelId(channelId: ChannelId): CoinBalance {
        val channelCoinBalanceEntity = channelCoinBalanceJpaRepository.findById(channelId.value)

        if (channelCoinBalanceEntity.isPresent) {
            return CoinBalance.of(channelCoinBalanceEntity.get().amount)
        }

        throw IllegalArgumentException("해당하는 Channel이 존재하지 않습니다.")
    }

    override fun updateMemberCoinBalance(memberId: MemberId, coinBalance: CoinBalance) {
        val coinBalanceEntity = MemberCoinBalanceEntity.of(
            memberId = memberId.value,
            amount = coinBalance.quantity
        )

        memberCoinBalanceJpaRepository.save(coinBalanceEntity)
    }

    override fun updateChannelCoinBalance(channelId: ChannelId, coinBalance: CoinBalance) {
        val coinBalanceEntity = ChannelCoinBalanceEntity.of(
            channelId = channelId.value,
            amount = coinBalance.quantity
        )

        channelCoinBalanceJpaRepository.save(coinBalanceEntity)
    }
}