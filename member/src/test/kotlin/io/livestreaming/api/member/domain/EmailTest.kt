package io.livestreaming.api.member.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class EmailTest {

    @Test
    fun `이메일을 생성한다`() {
        // Given
        val validEmail = "test@example.com"

        // When
        val email = Email.of(validEmail)

        // Then
        assertThat(email).isNotNull
        assertThat(email.value).isEqualTo(validEmail)
    }

    @Test
    fun `이메일을 생성할 때, 이메일 형식과 일치해야한다`() {
        // Given
        val invalidEmail = "invalid-email"

        // When & Then
        assertThatThrownBy { Email.of(invalidEmail) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("유효하지 않은 이메일 형식입니다.")
    }

    @Test
    fun `이메일을 생성할 때, 값이 비어있으면 안된다`() {
        // Given
        val blankEmail = "  "

        // When & Then
        assertThatThrownBy { Email.of(blankEmail) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("이메일 값은 필수입니다.")
    }

}