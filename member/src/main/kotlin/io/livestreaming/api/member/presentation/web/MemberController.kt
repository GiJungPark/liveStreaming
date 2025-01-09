package io.livestreaming.api.member.presentation.web

import io.livestreaming.api.member.application.CreateMemberCommand
import io.livestreaming.api.member.application.CreateMemberUseCase
import io.livestreaming.api.member.presentation.web.request.CreateMemberRequest
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController("/members")
class MemberController(
    private val createMemberUseCase: CreateMemberUseCase,
) {
    @PostMapping
    fun createMember(
        @RequestBody request: CreateMemberRequest,
    ) {
        val command = CreateMemberCommand.of(
            email = request.email,
            password = request.password,
            nickname = request.nickname
        )

        createMemberUseCase.create(command)
    }

}