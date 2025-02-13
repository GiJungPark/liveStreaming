package io.livestreaming.api.member.infrastructure.repository

import io.livestreaming.api.common.domain.MemberId
import io.livestreaming.api.member.application.port.out.CreateMemberAccountPort
import io.livestreaming.api.member.application.port.out.GetMemberAccountPort
import io.livestreaming.api.member.application.port.out.UpdateMemberAccountPort
import io.livestreaming.api.member.domain.Email
import io.livestreaming.api.member.domain.MemberAccount
import io.livestreaming.api.member.domain.Password
import io.livestreaming.api.member.infrastructure.repository.entity.MemberAccountEntity
import org.springframework.stereotype.Repository

@Repository
class MemberAccountRepository(
    private val memberAccountJpaRepository: MemberAccountJpaRepository,
) : CreateMemberAccountPort, GetMemberAccountPort, UpdateMemberAccountPort {

    override fun createMemberAccount(id: MemberId, email: Email, password: Password) {
        val memberAccountEntity = MemberAccountEntity.of(
            id = id,
            email = email,
            password = password
        )

        memberAccountJpaRepository.save(memberAccountEntity)
    }

    override fun getMemberAccountById(id: MemberId): MemberAccount {
        val memberAccountEntity = memberAccountJpaRepository.findById(id.value)

        if (memberAccountEntity.isPresent) {
            return memberAccountEntity.get().toDomain()
        }

        throw IllegalStateException("사용자를 찾을 수 없습니다.")
    }

    override fun doesntExistEmail(email: Email): Boolean {
        return !existEmail(email)
    }

    override fun updatePassword(id: MemberId, memberAccount: MemberAccount) {
        val memberAccountEntity = MemberAccountEntity.of(
            id = id,
            email = memberAccount.email,
            password = memberAccount.password
        )

        memberAccountJpaRepository.save(memberAccountEntity)
    }

    private fun existEmail(email: Email): Boolean {
        return memberAccountJpaRepository.existsByEmail(email.value)
    }

}