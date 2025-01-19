package io.livestreaming.api.member.domain

class Introduction private constructor(val value: String) {

    init {
        validate(value)
    }

    companion object {
        fun of(value: String): Introduction {
            return Introduction(value = value)
        }
    }

    private fun validate(value: String) {
        require(value.length <= 60) { "자기소개는 60자를 초과할 수 없습니다." }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Introduction

        return value == other.value
    }

    override fun hashCode(): Int {
        return value.hashCode()
    }

    override fun toString(): String {
        return "[Introduction] value: $value"
    }


}