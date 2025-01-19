package io.livestreaming.api.member.util.uuid

interface UuidProvider {
    fun generate(): String
}