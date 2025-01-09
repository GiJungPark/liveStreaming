package io.livestreaming.api.member.presentation.web

import io.livestreaming.api.member.application.*
import io.livestreaming.api.member.presentation.web.request.CreateMemberRequest
import io.livestreaming.api.member.presentation.web.request.LoginRequest
import org.springframework.web.bind.annotation.*

@RestController("/members")
class MemberController(
    private val createMemberUseCase: CreateMemberUseCase,
    private val readMemberUseCase: ReadMemberUseCase
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
}