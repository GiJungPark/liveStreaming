package io.livestreaming.api.commerce.domain

class ProductCode private constructor(
    val code: String,
    val description: String,
) {
    companion object {
        private const val PRODUCT_CODE_MAX_LENGTH = 10
        private const val PRODUCT_CODE_DESCRIPTION_MAX_LENGTH = 60
        private const val CODE_EMPTY_CHECK_MESSAGE = "코드가 비어있습니다."
        private const val CODE_EXCEED_MAX_LENGTH_MESSAGE = "코드의 최대 길이는 10글자 입니다."
        private const val CODE_START_ENGLISH_END_NUMBER_MESSAGE = "코드는 영어로 시작하고, 숫자로 끝나야 합니다."
        private const val DESCRIPTION_EMPTY_CHECK_MESSAGE = "코드 설명이 비어있습니다."
        private const val DESCRIPTION_EXCEED_MAX_LENGTH_MESSAGE = "코드 설명의 최대 길이는 60글자 입니다."

        private val START_ENGLISH_END_NUMBER_REGEX = Regex("[A-Z]+\\d+")

        fun of(code: String, description: String): ProductCode {
            return ProductCode(code, description)
        }
    }

    init {
        isCodeValid(code)
        isDescriptionValid(description)
    }

    private fun isCodeValid(code: String) {
        isCodeNotBlank(code)
        isCodeLengthValid(code)
        isCodeFormatValid(code)
    }

    private fun isDescriptionValid(description: String) {
        isDescriptionNotBlank(description)
        isDescriptionLengthValid(description)
    }

    private fun isCodeNotBlank(code: String) {
        require(code.isNotBlank()) { CODE_EMPTY_CHECK_MESSAGE }
    }

    private fun isCodeLengthValid(code: String) {
        require(code.length <= PRODUCT_CODE_MAX_LENGTH) { CODE_EXCEED_MAX_LENGTH_MESSAGE }
    }

    private fun isCodeFormatValid(code: String) {
        require(START_ENGLISH_END_NUMBER_REGEX.matches(code)) { CODE_START_ENGLISH_END_NUMBER_MESSAGE }
    }

    private fun isDescriptionNotBlank(description: String) {
        require(description.isNotBlank()) { DESCRIPTION_EMPTY_CHECK_MESSAGE }
    }

    private fun isDescriptionLengthValid(description: String) {
        require(description.length <= PRODUCT_CODE_DESCRIPTION_MAX_LENGTH) { DESCRIPTION_EXCEED_MAX_LENGTH_MESSAGE }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ProductCode

        if (code != other.code) return false
        if (description != other.description) return false

        return true
    }

    override fun hashCode(): Int {
        var result = code.hashCode()
        result = 31 * result + description.hashCode()
        return result
    }

    override fun toString(): String {
        return "[ProductCode] code: $code, description: $description"
    }

}