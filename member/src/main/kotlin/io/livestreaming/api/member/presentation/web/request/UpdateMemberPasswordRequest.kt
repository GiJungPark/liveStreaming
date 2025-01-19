package io.livestreaming.api.member.presentation.web.request

data class UpdateMemberPasswordRequest(
    val memberId: String,
    val password: String,
)
