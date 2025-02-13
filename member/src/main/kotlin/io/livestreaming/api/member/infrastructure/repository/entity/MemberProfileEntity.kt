package io.livestreaming.api.member.infrastructure.repository.entity

import io.livestreaming.api.common.domain.Image
import io.livestreaming.api.common.domain.MemberId
import io.livestreaming.api.member.domain.Introduction
import io.livestreaming.api.member.domain.MemberProfile
import io.livestreaming.api.member.domain.Nickname
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "member_profile")
class MemberProfileEntity private constructor(
    @Id @Column(name = "member_id", nullable = false)
    val id: String,

    @Column(name = "nickname", nullable = false)
    val nickname: String,

    @Column(name = "profileImage", nullable = false)
    val profileImage: String,

    @Column(name = "introduction", nullable = false)
    val introduction: String
) {
    protected constructor() : this("", "","", "")

    companion object {
        fun of(id: MemberId, nickname: Nickname, profileImage: Image, introduction: Introduction): MemberProfileEntity {
            return MemberProfileEntity(
                id = id.value,
                nickname = nickname.value,
                profileImage = profileImage.url.value,
                introduction = introduction.value
            )
        }
    }

    fun toDomain(): MemberProfile {
        return MemberProfile.of(
            nickname = Nickname.of(nickname),
            profileImage = Image.profileImageOf(profileImage),
            introduction = Introduction.of(introduction)
        )
    }
}