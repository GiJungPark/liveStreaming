package io.livestreaming.api.member.application

import io.livestreaming.api.member.application.out.GetMemberPort
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