package io.livestreaming.api.commerce.infrastructure.entity

import io.livestreaming.api.commerce.domain.ChannelId
import io.livestreaming.api.commerce.domain.DonationCoinHistory
import io.livestreaming.api.common.domain.MemberId
import jakarta.persistence.*
import java.math.BigInteger
import java.time.LocalDateTime

@Entity
@Table(name = "donation_history")
class DonationCoinHistoryEntity private constructor(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val memberId: String,

    val channelId: String,

    val quantity: BigInteger,

    val message: String,

    val type: String,

    val donationAt: LocalDateTime = LocalDateTime.now(),
) {
    constructor() : this(memberId = "", channelId = "", quantity = BigInteger.ZERO, message = "", type = "")

    companion object {
        fun of(memberId: MemberId, channelId: ChannelId, quantity: BigInteger): DonationCoinHistoryEntity {
            return DonationCoinHistoryEntity(
                memberId = memberId.value,
                channelId = channelId.value,
                quantity = quantity,
                message = "임시 메세지",
                type = "메세지 도네이션"
            )
        }
    }

    fun toDomain():DonationCoinHistory {
        return DonationCoinHistory.of(
            donationDate = donationAt,
            quantity = quantity,
            message = message,
            channelId = channelId,
        )
    }
}