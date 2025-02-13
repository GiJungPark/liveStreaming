package io.livestreaming.api.member.application.service

import io.livestreaming.api.member.application.port.`in`.CheckEmailCommand
import io.livestreaming.api.member.application.port.`in`.CheckNicknameCommand
import io.livestreaming.api.member.application.port.`in`.ReadMemberUseCase
import io.livestreaming.api.member.application.port.out.GetMemberAccountPort
import io.livestreaming.api.member.application.port.out.GetMemberPort
import io.livestreaming.api.member.application.port.out.GetMemberProfilePort
import org.springframework.stereotype.Service

@Service
class ReadMemberService(
    private val getMemberAccountPort: GetMemberAccountPort,
    private val getMemberProfilePort: GetMemberProfilePort,
) : ReadMemberUseCase {
    override fun isAvailableEmail(command: CheckEmailCommand): Boolean {
        return getMemberAccountPort.doesntExistEmail(command.email)
    }

    override fun isAvailableNickname(command: CheckNicknameCommand): Boolean {
        return getMemberProfilePort.doesntExistNickname(command.nickname)
    }

}