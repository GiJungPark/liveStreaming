package io.livestreaming.api.commerce.domain

class ChannelId private constructor(val value: String) {
    companion object {
        fun of(value: String): ChannelId {
            return ChannelId(value)
        }
    }

}