package io.livestreaming.api.member.domain

class Member private constructor(
    val id: MemberId? = null,
    email: Email,
    password: Password,
    nickname: Nickname,
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

    companion object {
        fun of(email: Email, password: Password, nickname: Nickname): Member {
            return Member(null, email, password, nickname)
        }

        fun of(id: MemberId, email: Email, password: Password, nickname: Nickname): Member {
            return Member(id, email, password, nickname)
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