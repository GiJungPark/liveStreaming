package io.livestreaming.api.member.application.service

import io.livestreaming.api.common.domain.MemberId
import io.livestreaming.api.member.application.port.`in`.UpdateMemberPasswordCommand
import io.livestreaming.api.member.application.port.`in`.UpdateMemberProfileCommand
import io.livestreaming.api.member.application.port.`in`.UpdateMemberUseCase
import io.livestreaming.api.member.application.port.out.GetMemberPort
import io.livestreaming.api.member.application.port.out.UpdateMemberPort
import org.springframework.stereotype.Service

@Service
class UpdateMemberService(
    private val getMemberPort: GetMemberPort,
    private val updateMemberPort: UpdateMemberPort,
) : UpdateMemberUseCase {
    override fun updatePassword(command: UpdateMemberPasswordCommand): MemberId {
        TODO("Not yet implemented")
    }

    override fun updateProfile(command: UpdateMemberProfileCommand): MemberId {
        // member 불러오기
        val memberProfile = getMemberPort.getMemberProfileById(command.id)

        // 프로필 수정
        memberProfile.updateMemberProfile(
            nickname = command.nickname,
            profileImage = command.profile,
            introduction = command.introduction
        )

        // member 업데이트
        return updateMemberPort.updateProfile(
            memberId = command.id,
            memberProfile = memberProfile
        )
    }

}