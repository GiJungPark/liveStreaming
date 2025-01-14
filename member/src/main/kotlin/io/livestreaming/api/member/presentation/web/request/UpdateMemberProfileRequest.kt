package io.livestreaming.api.member.presentation.web.request

data class UpdateMemberProfileRequest(
    val memberId: String,
    val nickname: String,
    val profileImageUrl: String?,
    val introduction: String?,
)
