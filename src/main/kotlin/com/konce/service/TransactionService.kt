package com.konce.service

import com.konce.model.Transaction
import com.konce.repository.TransactionRepository
import org.springframework.stereotype.Service
import org.springframework.data.redis.core.RedisTemplate
import java.util.UUID

@Service
class TransactionService(
    private val transactionRepository: TransactionRepository,
    private val redisTemplate: RedisTemplate<String, String>
) {

//    fun getTransactionsByUser(userId: UUID): List<Transaction> {
//        val cacheKey = "transactions:$userId"
//        val cachedTransactions = redisTemplate.opsForValue().get(cacheKey)
//    }

}