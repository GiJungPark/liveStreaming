package io.livestreaming.api.member.util.uuid

import org.springframework.stereotype.Component
import java.util.*

@Component
class DefaultUuidProvider : UuidProvider {
    override fun generate(): String {
        return UUID.randomUUID().toString()
    }
}