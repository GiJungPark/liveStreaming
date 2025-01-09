package io.livestreaming.api.member.presentation.web.request

data class LoginRequest(
    val email: String,
    val password: String,
)
