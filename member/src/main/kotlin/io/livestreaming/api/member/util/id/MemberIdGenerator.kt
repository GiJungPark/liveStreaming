package io.livestreaming.api.member.util.id

import io.livestreaming.api.common.domain.MemberId
import io.livestreaming.api.member.util.uuid.UuidProvider
import org.springframework.stereotype.Component

@Component
class MemberIdGenerator(
    private val uuidProvider: UuidProvider,
) : IdGenerator<MemberId> {
    override fun generate(): MemberId {
        return MemberId.of(uuidProvider.generate())
    }
}