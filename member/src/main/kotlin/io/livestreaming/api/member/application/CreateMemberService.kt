package io.livestreaming.api.member.application

import io.livestreaming.api.common.domain.Image
import io.livestreaming.api.common.domain.MemberId
import io.livestreaming.api.member.domain.*
import io.livestreaming.api.member.util.id.IdGenerator
import org.springframework.stereotype.Service

@Service
class CreateMemberService(
    private val memberIdGenerator: IdGenerator<MemberId>,
) : CreateMemberUseCase {
    override fun create(command: CreateMemberCommand): MemberId {
        val memberId = memberIdGenerator.generate()

        val member = Member.of(
            id = memberId,
            email = command.email,
            password = command.password,
            nickname = command.nickname,
            profileImage = Image.profileImageOf("https://www.example.com/image.jpg"),
            introduction = Introduction.of("자기소개")
        )

        // Member 저장

        return member.id ?: throw IllegalStateException("[서버 내부 오류] 회원 생성에 실패하였습니다.")
    }
}