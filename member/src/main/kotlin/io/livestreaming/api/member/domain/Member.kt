package io.livestreaming.api.member.domain

class Member private constructor(
    val id: MemberId? = null,
    account: MemberAccount,
    profile: MemberProfile,
) {
    private var _account: MemberAccount = account
    private val account: MemberAccount
        get() = _account

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
                account = MemberAccount.of(
                    email = email,
                    password = password,
                ),
                profile = MemberProfile.of(
                    nickname = nickname,
                    profileImage = profileImage,
                    introduction = introduction
                )
            )
        }

    }

    fun changeAccount(account: MemberAccount) {
        this._account = account
    }

    fun changeProfile(profile: MemberProfile) {
        this._profile = profile
    }

}
