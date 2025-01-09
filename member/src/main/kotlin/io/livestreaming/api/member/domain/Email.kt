package io.livestreaming.api.member.domain

class Email private constructor(val value: String) {

    init {
        validate(value)
    }

    companion object {
        private val EMAIL_REGEX = Regex("[0-9a-zA-Z]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$")

        fun of(value: String): Email {
            return Email(value)
        }
    }

    // TODO: 이메일 규칙 체크하는 로직 추후 보강
    private fun validate(value: String) {
        require (value.isNotBlank()) { "이메일 값은 필수입니다." }
        require(EMAIL_REGEX.matches(value)) { "유효하지 않은 이메일 형식입니다." }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Email

        return value == other.value
    }

    override fun hashCode(): Int {
        return value.hashCode()
    }

    override fun toString(): String {
        return "[Email] value: $value"
    }

}