package io.livestreaming.api.commerce.application.port.out

import java.util.concurrent.TimeUnit

interface CoinBalanceLockPort {
    fun <T> executeWithLock(lockKey: String, waitTime: Long = 10, leaseTime: Long = 1, unit: TimeUnit = TimeUnit.SECONDS, action: () -> T): T?
}