package io.livestreaming.api.member.application.service

import io.livestreaming.api.common.domain.MemberId
import io.livestreaming.api.member.application.port.`in`.UpdateMemberPasswordCommand
import io.livestreaming.api.member.application.port.`in`.UpdateMemberProfileCommand
import io.livestreaming.api.member.application.port.`in`.UpdateMemberUseCase
import io.livestreaming.api.member.application.port.out.*
import org.springframework.stereotype.Service

@Service
class UpdateMemberService(
    private val getMemberAccountPort: GetMemberAccountPort,
    private val getMemberProfilePort: GetMemberProfilePort,
    private val updateMemberAccountPort: UpdateMemberAccountPort,
    private val updateMemberProfilePort: UpdateMemberProfilePort,
) : UpdateMemberUseCase {
    override fun updatePassword(command: UpdateMemberPasswordCommand): MemberId {
        val memberAccount = getMemberAccountPort.getMemberAccountById(command.id)

        memberAccount.changePassword(command.password)

        updateMemberAccountPort.updatePassword(id = command.id, memberAccount = memberAccount)

        return command.id
    }

    override fun updateProfile(command: UpdateMemberProfileCommand): MemberId {
        val memberProfile = getMemberProfilePort.getMemberProfileById(command.id)

        memberProfile.updateMemberProfile(
            nickname = command.nickname,
            profileImage = command.profile,
            introduction = command.introduction
        )

        updateMemberProfilePort.updateProfile(id = command.id, memberProfile = memberProfile)

        return command.id
    }

}