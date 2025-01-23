package io.livestreaming.api.commerce.domain

class ProductName private constructor(val value: String) {

    companion object {
        private const val PRODUCT_NAME_MAX_LENGTH = 30
        private const val EMPTY_CHECK_MESSAGE = "상품 이름이 비어있습니다."
        private const val EXCEED_MAX_LENGTH_MESSAGE = "상품 이름은 최대 30글자 입니다."
        private const val NOT_CONTAINS_KOREAN_OR_ENGLISH_MESSAGE = "상품 이름은 한글 또는 영문이 들어가 있어야 합니다."

        private val KOREAN_OR_ENGLISH_REGEX = Regex(".*[a-zA-Z\uAC00-\uD7A3].*")

        fun of(value: String): ProductName {
            return ProductName(value)
        }
    }

    init {
        require(isNotEmpty(value)) { EMPTY_CHECK_MESSAGE }
        require(isWithinMaxLength(value)) { EXCEED_MAX_LENGTH_MESSAGE }
        require(containsKoreanOrEnglish(value)) { NOT_CONTAINS_KOREAN_OR_ENGLISH_MESSAGE }
    }

    private fun isNotEmpty(value: String): Boolean {
        return value.isNotBlank()
    }

    private fun isWithinMaxLength(value: String): Boolean {
        return value.length <= PRODUCT_NAME_MAX_LENGTH
    }

    private fun containsKoreanOrEnglish(value: String): Boolean {
        return KOREAN_OR_ENGLISH_REGEX.matches(value)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ProductName

        return value == other.value
    }

    override fun hashCode(): Int {
        return value.hashCode()
    }

    override fun toString(): String {
        return "[ProductName] value: $value"
    }
}