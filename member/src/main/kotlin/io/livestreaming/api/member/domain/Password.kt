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

    // TODO: 패스워드 규칙 체크하는 로직 추후 보강
    private fun validate(value: String) {
        require(value.isNotBlank()) { "이메일이 비어있습니다." }
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