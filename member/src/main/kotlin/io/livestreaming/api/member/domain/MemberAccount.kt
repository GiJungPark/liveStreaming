package io.livestreaming.api.member.domain

class MemberAccount private constructor(
    email: Email,
    password: Password,
) {
    private var _email: Email = email
    val email: Email
        get() = _email

    private var _password: Password = password
    val password: Password
        get() = _password

    companion object {
        fun of(email: Email, password: Password): MemberAccount {
            return MemberAccount(email = email, password = password)
        }

        fun of(email: String, password: String): MemberAccount {
            return MemberAccount(email = Email.of(email), password = Password.of(password))
        }
    }

    fun changeEmail(email: Email) {
        this._email = email
    }

    fun changePassword(password: Password) {
        this._password = password
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as MemberAccount

        if (_email != other._email) return false
        if (_password != other._password) return false

        return true
    }

    override fun hashCode(): Int {
        var result = _email.hashCode()
        result = 31 * result + _password.hashCode()
        return result
    }

    override fun toString(): String {
        return "[MemberAccount] email:$_email, password:$_password"
    }


}