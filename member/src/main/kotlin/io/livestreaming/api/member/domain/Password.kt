package io.livestreaming.api.member.domain

class Password private constructor(val value: String) {

    init {
        validate(value)
    }

    companion object {
        fun of(value: String): Password {
            return Password(value)
        }
    }

    private fun validate(value: String) {
        require(value.isNotBlank()) { "패스워드가 비어있습니다." }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Password

        return value == other.value
    }

    override fun hashCode(): Int {
        return value.hashCode()
    }

    override fun toString(): String {
        return "[Password] value: $value"
    }

}