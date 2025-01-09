package io.livestreaming.api.member.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class PasswordTest {

    @Test
    fun `패스워드를 생성한다`() {
        // Given
        val validPassword = "password"

        // When
        val password = Password.of(validPassword)

        // Then
        assertThat(password).isNotNull
        assertThat(password.value).isEqualTo(validPassword)
    }

    @Test
    fun `패스워드를 생성할 때, 값이 비어있으면 안된다`() {
        // Given
        val blankPassword = "  "

        // When & Then
        assertThatThrownBy { Password.of(blankPassword) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("패스워드가 비어있습니다.")
    }
}