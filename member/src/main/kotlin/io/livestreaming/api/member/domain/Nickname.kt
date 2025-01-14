package io.livestreaming.api.member.domain

class Nickname private constructor(val value: String) {

    init {
        validate(value)
    }

    companion object {
        fun of(nickname: String): Nickname {
            return Nickname(nickname)
        }
    }

    private fun validate(value: String) {
        require(value.isNotBlank()) { "닉네임이 비어있습니다." }
        require(isNotValidateLength()) { "닉네임 글자수는 30을 초과할 수 없습니다. "}
    }

    private fun isNotValidateLength(): Boolean {
        return value.length > 30
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Nickname

        return value == other.value
    }

    override fun hashCode(): Int {
        return value.hashCode()
    }

    override fun toString(): String {
        return "[Nickname] value: $value"
    }

}