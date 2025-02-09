package io.livestreaming.api.member.application.service

import io.livestreaming.api.member.application.port.`in`.CheckEmailCommand
import io.livestreaming.api.member.application.port.`in`.CheckNicknameCommand
import io.livestreaming.api.member.application.port.`in`.ReadMemberUseCase
import io.livestreaming.api.member.application.port.out.GetMemberPort
import org.springframework.stereotype.Service

@Service
class ReadMemberService(
    private val getMemberPort: GetMemberPort
) : ReadMemberUseCase {
    override fun isAvailableEmail(command: CheckEmailCommand): Boolean {
        return getMemberPort.doesntExistEmail(command.email)
    }

    override fun isAvailableNickname(command: CheckNicknameCommand): Boolean {
        return getMemberPort.doesntExistNickname(command.nickname)
    }

}