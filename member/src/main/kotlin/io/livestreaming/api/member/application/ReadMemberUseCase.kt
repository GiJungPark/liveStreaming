package io.livestreaming.api.member.application

interface ReadMemberUseCase {
    fun isAvailableEmail(command: CheckEmailCommand): Boolean
    fun isAvailableNickname(command: CheckNicknameCommand): Boolean
}