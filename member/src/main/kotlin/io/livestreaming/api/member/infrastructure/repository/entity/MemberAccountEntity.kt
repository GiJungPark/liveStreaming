package io.livestreaming.api.member.infrastructure.repository.entity

import io.livestreaming.api.common.domain.MemberId
import io.livestreaming.api.member.domain.Email
import io.livestreaming.api.member.domain.MemberAccount
import io.livestreaming.api.member.domain.Password
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "member_account")
class MemberAccountEntity private constructor(
    @Id @Column(name = "member_id", nullable = false)
    val id: String,

    @Column(name = "email", unique = true, nullable = false)
    val email: String,

    @Column(name = "password", nullable = false)
    val password: String
) {
    protected constructor() : this("", "", "")

    companion object {
        fun of(id: MemberId, email: Email, password: Password): MemberAccountEntity {
            return MemberAccountEntity(
                id = id.value,
                email = email.value,
                password = password.value
            )
        }
    }

    fun toDomain(): MemberAccount {
        return MemberAccount.of(
            email = email,
            password = password
        )
    }
}