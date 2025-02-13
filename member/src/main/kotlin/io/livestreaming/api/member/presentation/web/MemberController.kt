package io.livestreaming.api.member.presentation.web

import io.livestreaming.api.member.application.port.`in`.*
import io.livestreaming.api.member.presentation.web.request.*
import io.livestreaming.api.member.presentation.web.response.AvailabilityResponse
import org.springframework.web.bind.annotation.*

@RestController
class MemberController(
    private val createMemberUseCase: CreateMemberUseCase,
    private val readMemberUseCase: ReadMemberUseCase,
    private val updateMemberUseCase: UpdateMemberUseCase,
) {
    @PostMapping("/member")
    fun createMember(@RequestBody request: CreateMemberRequest) {
        val command = CreateMemberCommand.of(
            email = request.email,
            password = request.password,
            nickname = request.nickname
        )

        createMemberUseCase.create(command)
    }

    @GetMapping("/member/check-email")
    fun checkEmail(@RequestParam email: String): AvailabilityResponse {
        val command = CheckEmailCommand.of(email)

        val result = readMemberUseCase.isAvailableEmail(command)

        return AvailabilityResponse(result)
    }

    @GetMapping("/member/check-nickname")
    fun checkNickname(@RequestParam nickname: String): AvailabilityResponse {
        val command = CheckNicknameCommand.of(nickname)

        val result = readMemberUseCase.isAvailableNickname(command)

        return AvailabilityResponse(result)
    }

    @PutMapping("/member/password")
    fun updatePassword(@RequestBody request: UpdateMemberPasswordRequest) {
        val command = UpdateMemberPasswordCommand.of(
            id = request.memberId,
            password = request.password
        )

        updateMemberUseCase.updatePassword(command)
    }

    @PutMapping("/member/profile")
    fun updateProfile(@RequestBody request: UpdateMemberProfileRequest) {
        val command = UpdateMemberProfileCommand.of(
            id = request.memberId,
            nickname = request.nickname,
            profile = request.profileImageUrl,
            introduction = request.introduction,
        )

        updateMemberUseCase.updateProfile(command)
    }
}