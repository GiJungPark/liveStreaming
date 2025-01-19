package io.livestreaming.api.common.domain

class MemberId private constructor(val value: String) {

    companion object {
        fun of(value: String): MemberId {
            return MemberId(value)
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as MemberId

        return value == other.value
    }

    override fun hashCode(): Int {
        return value.hashCode()
    }

    override fun toString(): String {
        return "[MemberId] value: $value"
    }

}