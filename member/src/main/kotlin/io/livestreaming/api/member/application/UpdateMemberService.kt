package io.livestreaming.api.member.application

import io.livestreaming.api.member.domain.MemberId
import org.springframework.stereotype.Service

@Service
class UpdateMemberService : UpdateMemberUseCase {
    override fun updatePassword(command: UpdateMemberPasswordCommand): MemberId {
        TODO("Not yet implemented")
    }

    override fun updateNickname(command: UpdateMemberNicknameCommand): MemberId {
        TODO("Not yet implemented")
    }

}