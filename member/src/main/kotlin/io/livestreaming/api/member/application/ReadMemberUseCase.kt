package io.livestreaming.api.member.application

import io.livestreaming.api.member.domain.Member

interface ReadMemberUseCase {
    fun read(command: ReadMemberByIdCommand): Member
    fun read(command: ReadMemberByCredentialsCommand): Member
}