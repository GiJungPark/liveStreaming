package io.livestreaming.api.member.application.service

import io.livestreaming.api.common.domain.Image
import io.livestreaming.api.common.domain.MemberId
import io.livestreaming.api.member.application.port.`in`.CreateMemberCommand
import io.livestreaming.api.member.application.port.`in`.CreateMemberUseCase
import io.livestreaming.api.member.application.port.out.CreateMemberAccountPort
import io.livestreaming.api.member.application.port.out.CreateMemberProfilePort
import io.livestreaming.api.member.domain.*
import io.livestreaming.api.member.util.id.IdGenerator
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CreateMemberService(
    private val memberIdGenerator: IdGenerator<MemberId>,
    private val createMemberAccountPort: CreateMemberAccountPort,
    private val createMemberProfilePort: CreateMemberProfilePort,
) : CreateMemberUseCase {

    @Transactional
    override fun create(command: CreateMemberCommand): MemberId {
        val memberId = memberIdGenerator.generate()
        val defaultProfileImage = Image.profileImageOf("https://www.example.com/image.jpg")
        val defaultIntroduction = Introduction.of("자기소개")

        createMemberAccountPort.createMemberAccount(
            id = memberId,
            email = command.email,
            password = command.password
        )

        createMemberProfilePort.createMemberProfile(
            id = memberId,
            nickname = command.nickname,
            profileImage = defaultProfileImage,
            introduction = defaultIntroduction
        )

        return memberId
    }
}