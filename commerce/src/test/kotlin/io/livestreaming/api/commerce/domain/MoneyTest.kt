package io.livestreaming.api.commerce.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import java.math.BigInteger

class MoneyTest : BehaviorSpec({

    Given("금액이 0원인 경우") {
        When("상수 'ZERO'를 호출하면") {
            val money = Money.ZERO

            Then("0원인 Money 객체가 생성된다.") {
                money.amount shouldBe BigInteger.ZERO
            }
        }
    }

    Given("금액이 1000원인 경우") {
        val amount = 1000.toBigInteger()

        When("Money 객체를 생성할 때") {
            val money = Money.of(amount)

            Then("정상적으로 생성된다.") {
                money.amount shouldBe amount
            }
        }
    }

    Given("금액 1,000원과 2,000원이 주어진 경우") {
        val amount1 = Money.of(1000.toBigInteger())
        val amount2 = Money.of(2000.toBigInteger())

        When("두 금액을 더하는 add 메서드를 호출하면") {
            val money = Money.add(amount1, amount2)

            Then("합계 금액인 3,000원이 반환된다.") {
                money.amount shouldBe 3000.toBigInteger()
            }
        }

        When("두 금액을 빼는 sub 메서드를 호출하면") {
            val money = Money.sub(amount1, amount2)

            Then("결과 금액으로 -1,000원이 반환된다.") {
                money.amount shouldBe (-1000).toBigInteger()
            }
        }
    }

    Given("금액이 1,000원인 Money 객체가 주어진 경우") {
        val money = Money.of(1000.toBigInteger())

        When("negate 메서드를 호출하면") {
            val negatedMoney = money.negate()

            Then("금액이 -1,000원이 된다.") {
                negatedMoney.amount shouldBe (-1000).toBigInteger()
            }
        }

        When("isPositive 메서드를 호출하면") {
            val result = money.isPositive()

            Then("true를 반환한다.") {
                result shouldBe true
            }
        }
    }

    Given("금액이 -1,000원인 Money 객체가 주어진 경우") {
        val money = Money.of((-1000).toBigInteger())

        When("negate 메서드를 호출하면") {
            val negatedMoney = money.negate()

            Then("금액이 1,000원이 된다.") {
                negatedMoney.amount shouldBe 1000.toBigInteger()
            }
        }

        When("isPositive 메서드를 호출하면") {
            val result = money.isPositive()

            Then("false를 반환한다.") {
                result shouldBe false
            }
        }
    }

    Given("금액이 0원인 Money 객체가 주어진 경우") {
        val money = Money.of(BigInteger.ZERO)

        When("negate 메서드를 호출하면") {
            val negatedMoney = money.negate()

            Then("동일한 금액 0원을 반환한다.") {
                negatedMoney.amount shouldBe 0.toBigInteger()
            }
        }

        When("isPositive 메서드를 호출하면") {
            val result = money.isPositive()

            Then("false를 반환한다.") {
                result shouldBe false
            }
        }
    }

})