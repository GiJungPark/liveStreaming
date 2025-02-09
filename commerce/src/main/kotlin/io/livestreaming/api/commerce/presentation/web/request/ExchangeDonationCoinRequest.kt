package io.livestreaming.api.commerce.presentation.web.request

import java.math.BigInteger

data class ExchangeDonationCoinRequest(
    val quantity: BigInteger
) {
    // 단일 필드인 경우, 기본 생성자 생성 전략을 선택하지 못하는 오류가 있음
    // https://github.com/FasterXML/jackson-databind/issues/3085
    constructor(): this(BigInteger.ZERO)
}
