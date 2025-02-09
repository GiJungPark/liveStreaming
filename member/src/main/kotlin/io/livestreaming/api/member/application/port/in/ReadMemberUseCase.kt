package io.livestreaming.api.member.application.port.`in`

interface ReadMemberUseCase {
    fun isAvailableEmail(command: CheckEmailCommand): Boolean
    fun isAvailableNickname(command: CheckNicknameCommand): Boolean
}