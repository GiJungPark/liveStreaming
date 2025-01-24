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
        isNameValid(value)
    }

    private fun isNameValid(name: String) {
        isNotEmpty(name)
        isWithinMaxLength(name)
        containsKoreanOrEnglish(name)
    }

    private fun isNotEmpty(value: String) {
        require(value.isNotBlank()) { EMPTY_CHECK_MESSAGE }
    }

    private fun isWithinMaxLength(value: String) {
        require(value.length <= PRODUCT_NAME_MAX_LENGTH) { EXCEED_MAX_LENGTH_MESSAGE }
    }

    private fun containsKoreanOrEnglish(value: String) {
        require(KOREAN_OR_ENGLISH_REGEX.matches(value)) { NOT_CONTAINS_KOREAN_OR_ENGLISH_MESSAGE }
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