package io.livestreaming.api.member.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class NicknameTest {

    @Test
    fun `닉네임을 생성한다`() {
        // Given
        val validNickname = "nickname"

        // When
        val nickname = Nickname.of(validNickname)

        // Then
        assertThat(nickname).isNotNull
        assertThat(nickname.value).isEqualTo(validNickname)

    }

    @Test
    fun `닉네임을 생성할 때, 값이 비어있으면 안된다`() {
        // Given
        val blankNickname = "    "

        // When & Then
        assertThatThrownBy { Nickname.of(blankNickname) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("닉네임이 비어있습니다.")
    }

}