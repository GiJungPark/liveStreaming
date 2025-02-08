package io.livestreaming.api.commerce.infrastructure.lock

import io.livestreaming.api.commerce.application.port.out.CoinBalanceLockPort
import org.redisson.api.RedissonClient
import org.springframework.stereotype.Component
import java.util.concurrent.TimeUnit

@Component
class RedissonLockManager(
    private val redissonClient: RedissonClient,
) : CoinBalanceLockPort {
    override fun <T> executeWithLock(lockKey: String, waitTime: Long, leaseTime: Long, unit: TimeUnit, action: () -> T): T? {
        val lock = redissonClient.getLock(lockKey)
        val available = lock.tryLock(waitTime, leaseTime, unit)

        return if (available) {
            try {
                action()
            } finally {
                lock.unlock()
            }
        } else {
            println("Lock 획득 실패: $lockKey")
            null
        }
    }
}