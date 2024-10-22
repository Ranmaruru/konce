package com.konce.service

import com.konce.model.Transaction
import com.konce.repository.TransactionRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.*

@Service
class TransactionService(
    private val transactionRepository: TransactionRepository
) {
    fun all(): List<Transaction> {
        return transactionRepository.findAll().toList()
    }

    fun one(id: UUID): Transaction? {
        return transactionRepository.findByIdOrNull(id)
    }

    fun save(transaction: Transaction): Transaction {
        return transactionRepository.save(transaction)
    }

    fun deleteOne(id: UUID) {
        transactionRepository.deleteById(id)
    }
}