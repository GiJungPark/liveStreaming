package io.livestreaming.api.commerce.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import kotlin.test.Test
import kotlin.test.assertFailsWith

class ProductCodeTest : BehaviorSpec({

    Given("Code가 COIN001이고, 설명이 '후원하는데에 사용하는 가상 화폐'인 경우") {
        val code = "COIN001"
        val description = "후원하는데에 사용하는 가상 화폐"

        When("ProductCode 객체를 생성할 때") {
            val productCode = ProductCode.of(code, description)

            Then("정상적으로 생성된다.") {
                productCode.code shouldBe code
                productCode.description shouldBe description
            }
        }
    }

    Given("Code가 비어있는 경우") {
        val code = ""
        val description = "후원하는데 사용하는 가상 화폐"

        When("ProductCode 객체를 생성할 때") {
            Then("생성에 실패한다.") {
                val exception = assertFailsWith<IllegalArgumentException> {
                    ProductCode.of(code, description)
                }
                exception.message shouldBe "코드가 비어있습니다."
            }
        }
    }

    Given("Code가 영어로 시작하고 숫자로 끝나지 않는 경우") {
        val code = "001COIN"
        val description = "후원하는데 사용하는 가상 화폐"

        When("ProductCode 객체를 생성할 때") {
            Then("생성에 실패한다.") {
                val exception = assertFailsWith<IllegalArgumentException> {
                    ProductCode.of(code, description)
                }
                exception.message shouldBe "코드는 영어로 시작하고, 숫자로 끝나야 합니다."
            }
        }
    }

    Given("Code가 10글자를 넘어가는 경우") {
        val code = "COINCODE001"
        val description = "후원하는데 사용하는 가상 화폐"

        When("ProductCode 객체를 생성할 때") {
            Then("생성에 실패한다.") {
                val exception = assertFailsWith<IllegalArgumentException> {
                    ProductCode.of(code, description)
                }
                exception.message shouldBe "코드의 최대 길이는 10글자 입니다."
            }
        }
    }

    Given("설명이 비어있는 경우") {
        val code = "COIN001"
        val description = ""

        When("ProductCode 객체를 생성할 때") {
            Then("생성에 실패한다.") {
                val exception = assertFailsWith<IllegalArgumentException> {
                    ProductCode.of(code, description)
                }
                exception.message shouldBe "코드 설명이 비어있습니다."
            }
        }
    }

    Given("설명이 60글자를 넘어가는 경우") {
        val code = "COIN001"
        val description = buildString { repeat(61) { append("a") } }

        When("ProductCode 객체를 생성할 때") {
            Then("생성에 실패한다.") {
                val exception = assertFailsWith<IllegalArgumentException> {
                    ProductCode.of(code, description)
                }
                exception.message shouldBe "코드 설명의 최대 길이는 60글자 입니다."
            }
        }
    }
})