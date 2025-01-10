package io.livestreaming.api.member.domain

class URL private constructor(val value: String) {

    init {
        validate(value)
    }

    companion object {
        private val urlRegex = Regex("^(http|https)://[\\w\\-]+(\\.[\\w\\-]+)+[/#?]?.*$")

        fun of(value: String): URL {
            return URL(value.trim())
        }
    }

    fun isImageUrl(): Boolean {
        val imageExtensions = setOf("jpg", "jpeg", "png", "gif", "webp")
        return imageExtensions.any { value.endsWith(it, ignoreCase = true) }
    }

    private fun validate(value: String) {
        require(urlRegex.matches(value)) { "URL 형식이 잘못되었습니다." }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as URL

        return value == other.value
    }

    override fun hashCode(): Int {
        return value.hashCode()
    }

    override fun toString(): String {
        return "[URL] value: $value"
    }

}