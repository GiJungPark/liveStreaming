package io.livestreaming.api.member.domain

import io.livestreaming.api.common.domain.Image

class MemberProfile private constructor(
    nickname: Nickname,
    profileImage: Image,
    introduction: Introduction,
) {

    private var _nickname: Nickname = nickname
    val nickname: Nickname
        get() = _nickname

    private var _profileImage: Image = profileImage
    val profileImage: Image
        get() = _profileImage

    private var _introduction: Introduction = introduction
    val introduction: Introduction
        get() = _introduction

    companion object {
        fun of(nickname: Nickname, profileImage: Image, introduction: Introduction): MemberProfile {
            return MemberProfile(
                nickname = nickname,
                profileImage = profileImage,
                introduction = introduction
            )
        }
    }

    fun updateMemberProfile(nickname: Nickname, profileImage: Image, introduction: Introduction) {
        changeNickname(nickname)
        changeProfileImage(profileImage)
        changeIntroduction(introduction)
    }

    private fun changeNickname(nickname: Nickname) {
        this._nickname = nickname
    }

    private fun changeProfileImage(profileImage: Image) {
        this._profileImage = profileImage
    }

    private fun changeIntroduction(introduction: Introduction) {
        this._introduction = introduction
    }
}