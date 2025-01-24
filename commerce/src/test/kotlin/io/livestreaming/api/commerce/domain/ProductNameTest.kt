package io.livestreaming.api.commerce.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import kotlin.test.assertFailsWith

class ProductNameTest : BehaviorSpec({

    Given("상품 이름이 '코인'인 경우") {
        val name = "코인"

        When("Product 객체를 생성할 때") {
            val productName = ProductName.of(name)

            Then("정상적으로 생성된다.") {
                productName.value shouldBe name
            }
        }
    }

    Given("상품 이름이 비어있는 경우") {
        val name = ""

        When("ProductName 객체를 생성할 때") {
            Then("생성에 실패한다.") {
                val exception = assertFailsWith<IllegalArgumentException> {
                    ProductName.of(name)
                }
                exception.message shouldBe "상품 이름이 비어있습니다."
            }
        }
    }

    Given("상품 이름이 30글자를 초과하는 경우") {
        val name = buildString { repeat(31) { append("a") } }

        When("ProductName 객체를 생성할 때") {
            Then("생성에 실패한다.") {
                val exception = assertFailsWith<IllegalArgumentException> {
                    ProductName.of(name)
                }
                exception.message shouldBe "상품 이름은 최대 30글자 입니다."
            }
        }
    }

    Given("상품 이름에 한글 또는 영문이 들어가지 않는 경우") {
        val name = "[1234]!@#"

        When("ProductName 객체를 생성할 때") {
            Then("생성에 실패한다.") {
                val exception = assertFailsWith<IllegalArgumentException> {
                    ProductName.of(name)
                }
                exception.message shouldBe "상품 이름은 한글 또는 영문이 들어가 있어야 합니다."
            }
        }
    }

})