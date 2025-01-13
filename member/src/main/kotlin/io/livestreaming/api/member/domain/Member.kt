package io.livestreaming.api.member.domain

class Member private constructor(
    val id: MemberId? = null,
    email: Email,
    password: Password,
    nickname: Nickname,
    profile: Image,
) {
    private var _email: Email = email
    private val email: Email
        get() = _email

    private var _password: Password = password
    private val password: Password
        get() = _password

    private var _nickname: Nickname = nickname
    val nickname: Nickname
        get() = _nickname

    private var _profile: Image = profile
    val profile: Image
        get() = _profile

    companion object {
        fun of(id: MemberId, email: Email, password: Password, nickname: Nickname, profile: Image?): Member {
            if (profile == null) {
                return Member(
                    id = id,
                    email = email,
                    password = password,
                    nickname = nickname,
                    profile = Image.profileImageOf("https://www.example.com/test.jpg")
                )
            }

            return Member(id, email, password, nickname, profile)
        }
    }

    fun changeEmail(email: Email) {
        this._email = email
    }

    fun changePassword(password: Password) {
        this._password = password
    }

    fun changeNickname(nickname: Nickname) {
        this._nickname = nickname
    }

}