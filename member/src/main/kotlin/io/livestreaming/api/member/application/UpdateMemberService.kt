package io.livestreaming.api.member.application

import io.livestreaming.api.member.application.out.GetMemberPort
import io.livestreaming.api.member.application.out.UpdateMemberPort
import io.livestreaming.api.member.domain.MemberId
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
        return updateMemberPort.updateProfile(memberProfile)
    }

}