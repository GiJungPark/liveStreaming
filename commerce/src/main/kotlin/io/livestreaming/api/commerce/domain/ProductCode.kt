package io.livestreaming.api.commerce.domain

class ProductCode private constructor(
    val code: String,
    val description: String,
) {
    init {
        isCodeValid(code)
        isDescriptionValid(description)
    }

    companion object {
        fun of(code: String, description: String): ProductCode {
            return ProductCode(code, description)
        }
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
        require(code.isNotBlank()) { "코드가 비어있습니다." }
    }

    private fun isCodeLengthValid(code: String) {
        require(code.length <= 10) { "코드의 최대 길이는 10글자 입니다." }
    }

    private fun isCodeFormatValid(code: String) {
        require(code.matches(Regex("[A-Z]+\\d+"))) { "코드는 영어로 시작하고, 숫자로 끝나야 합니다." }
    }

    private fun isDescriptionNotBlank(description: String) {
        require(description.isNotBlank()) { "코드 설명이 비어있습니다." }
    }

    private fun isDescriptionLengthValid(description: String) {
        require(description.length <= 60) { "코드 설명의 최대 길이는 60글자 입니다." }
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