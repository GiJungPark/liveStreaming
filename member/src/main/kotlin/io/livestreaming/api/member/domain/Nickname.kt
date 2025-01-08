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

    // TODO: 닉네임 규칙 체크하는 로직 추후 보강
    private fun validate(value: String) {
        require(value.isNotBlank()) { "닉네임이 비어있습니다." }
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