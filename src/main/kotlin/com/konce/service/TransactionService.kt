package com.konce.service

import com.konce.model.Category
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

    fun save(category: Category, description: String, amount: Double, date: Date): Transaction {
        return transactionRepository.save(
            Transaction(
                category = category,
                description = description,
                amount = amount,
                date = date
            )
        )
    }

    fun deleteOne(id: UUID) {
        transactionRepository.deleteById(id)
    }
}