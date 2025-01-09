package io.livestreaming.api.member.presentation.web

import io.livestreaming.api.member.application.*
import io.livestreaming.api.member.presentation.web.request.CreateMemberRequest
import io.livestreaming.api.member.presentation.web.request.LoginRequest
import io.livestreaming.api.member.presentation.web.request.UpdateMemberNicknameRequest
import io.livestreaming.api.member.presentation.web.request.UpdateMemberPasswordRequest
import org.springframework.web.bind.annotation.*

@RestController("/members")
class MemberController(
    private val createMemberUseCase: CreateMemberUseCase,
    private val readMemberUseCase: ReadMemberUseCase,
    private val updateMemberUseCase: UpdateMemberUseCase
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

    @GetMapping("/{id}")
    fun readMemberById(@PathVariable("id") id: String) {
        val command = ReadMemberByIdCommand.of(id)

        readMemberUseCase.read(command)
    }

    @PostMapping("/login")
    fun login(@RequestBody request: LoginRequest) {
        val command = ReadMemberByCredentialsCommand.of(
            email = request.email,
            password = request.password
        )

        readMemberUseCase.read(command)
    }

    @PatchMapping("/{id}/nickname")
    fun updateNickname(
        @PathVariable("id") id: String,
        @RequestBody request: UpdateMemberNicknameRequest,
    ) {
        val command = UpdateMemberNicknameCommand.of(
            id = id,
            nickname = request.nickname
        )

        updateMemberUseCase.updateNickname(command)
    }

    @PatchMapping("/{id}/password")
    fun updatePassword(
        @PathVariable("id") id: String,
        @RequestBody request: UpdateMemberPasswordRequest,
    ) {
        val command = UpdateMemberPasswordCommand.of(
            id = id,
            password = request.password
        )

        updateMemberUseCase.updatePassword(command)
    }

}