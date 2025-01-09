package io.livestreaming.api.member.application

import io.livestreaming.api.member.domain.*
import org.springframework.stereotype.Service

@Service
class ReadMemberService : ReadMemberUseCase {
    override fun read(command: ReadMemberByIdCommand): Member {
        return Member.of(
            id = command.id,
            email = Email.of("이메일"),
            password = Password.of("비밀번호"),
            nickname = Nickname.of("닉네임")
        )
    }

    override fun read(command: ReadMemberByCredentialsCommand): Member {
        return Member.of(
            id = MemberId.of("임시"),
            email = command.email,
            password = command.password,
            nickname = Nickname.of("닉네임")
        );
    }
}