package io.livestreaming.api.member.application

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
            nickname = command.nickname
        )

        // Member 저장

        return member.id ?: throw IllegalStateException("[서버 내부 오류] 회원 생성에 실패하였습니다.")
    }
}