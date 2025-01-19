package io.livestreaming.api.member.presentation.web.request

data class CreateMemberRequest(
    val email: String,
    val password: String,
    val nickname: String,
    val profileImageUrl: String?,
    val introduction: String?,
)
