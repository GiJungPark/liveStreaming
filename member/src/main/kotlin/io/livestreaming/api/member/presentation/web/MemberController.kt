package io.livestreaming.api.member.presentation.web

import io.livestreaming.api.member.application.*
import io.livestreaming.api.member.presentation.web.request.*
import org.springframework.web.bind.annotation.*

@RestController("/member")
class MemberController(
    private val createMemberUseCase: CreateMemberUseCase,
    private val readMemberUseCase: ReadMemberUseCase,
    private val updateMemberUseCase: UpdateMemberUseCase,
) {
    @PostMapping
    fun createMember(@RequestBody request: CreateMemberRequest) {
        val command = CreateMemberCommand.of(
            email = request.email,
            password = request.password,
            nickname = request.nickname
        )

        createMemberUseCase.create(command)
    }

    @PutMapping("/password")
    fun updatePassword(
        @RequestBody request: UpdateMemberPasswordRequest,
    ) {
        val command = UpdateMemberPasswordCommand.of(
            id = request.memberId,
            password = request.password
        )

        updateMemberUseCase.updatePassword(command)
    }

    @PutMapping("/{profile")
    fun updateProfile(
        @RequestBody request: UpdateMemberProfileRequest,
    ) {
        val command = UpdateMemberProfileCommand.of(
            id = request.memberId,
            nickname = request.nickname,
            profile = request.profileImageUrl,
            introduction = request.introduction,
        )

        updateMemberUseCase.updateProfile(command)
    }
}