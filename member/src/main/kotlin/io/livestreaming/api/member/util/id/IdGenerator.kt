package io.livestreaming.api.member.util.id

interface IdGenerator<T> {
    fun generate(): T
}