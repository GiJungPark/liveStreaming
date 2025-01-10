package io.livestreaming.api.member.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class URLTest {

    @ParameterizedTest(name = "{index}: URL 생성 테스트 [{0}]")
    @CsvSource(
        "https://www.example.com",
        "https://example.me",
        "http://www.example.io",
        "http://example.kr",
    )
    fun `URL을 생성한다`(validUrl: String) {
        // When
        val url = URL.of(validUrl)

        // Then
        assertThat(url).isNotNull
        assertThat(url.value).isEqualTo(validUrl)
    }

    @ParameterizedTest(name = "{index}: inValid URL 생성 테스트 [{0}]")
    @CsvSource(
        "htt://www.example.com",
        "http://",
        "invalid",
    )
    fun `URL을 생성할 때, URL 형식과 일치해야한다`(inValidUrl: String) {
        // When & Then
        assertThatThrownBy { URL.of(inValidUrl) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("URL 형식이 잘못되었습니다.")

    }

    @ParameterizedTest(name = "{index}: valid Image URL 생성 테스트 [{0}]")
    @CsvSource(
        "https://www.example.com/example.jpg",
        "https://www.example.com/example.gif",
        "https://www.example.com/example.webp",
        "https://www.example.com/example.png",
        "https://www.example.com/example.jpeg",
    )
    fun `이미지 URL인지 알 수 있다 성공 케이스`(validImageUrl: String) {
        // When
        val url = URL.of(validImageUrl)

        // Then
        assertThat(url.isImageUrl()).isTrue
    }

    @ParameterizedTest(name = "{index}: inValid Image URL 생성 테스트 [{0}]")
    @CsvSource(
        "https://www.example.com/",
        "https://www.example.com/example.mp4",
        "https://www.example.com/image"
    )
    fun `이미지 URL인지 알 수 있다 실패 케이스`(invalidImageUrl: String) {
        // When
        val url = URL.of(invalidImageUrl)

        // Then
        assertThat(url.isImageUrl()).isFalse
    }

}