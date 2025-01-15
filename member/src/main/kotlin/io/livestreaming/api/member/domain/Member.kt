package io.livestreaming.api.member.domain

class Member private constructor(
    val id: MemberId? = null,
    email: Email,
    password: Password,
    profile: MemberProfile,
) {
    private var _email: Email = email
    private val email: Email
        get() = _email

    private var _password: Password = password
    private val password: Password
        get() = _password

    private var _profile: MemberProfile = profile
    private val profile: MemberProfile
        get() = _profile

    companion object {
        fun of(
            id: MemberId,
            email: Email,
            password: Password,
            nickname: Nickname,
            profileImage: Image,
            introduction: Introduction,
        ): Member {
            return Member(
                id = id,
                email = email,
                password = password,
                profile = MemberProfile.of(
                    nickname = nickname,
                    profileImage = profileImage,
                    introduction = introduction
                )
            )
        }

    }


    fun changeEmail(email: Email) {
        this._email = email
    }

    fun changePassword(password: Password) {
        this._password = password
    }

    fun changeProfile(profile: MemberProfile) {
        this._profile = profile
    }

}
