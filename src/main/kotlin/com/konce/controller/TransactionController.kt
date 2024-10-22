package com.konce.controller

import com.konce.dto.TransactionCreateRequest
import com.konce.dto.TransactionUpdateRequest
import com.konce.model.Transaction
import com.konce.repository.CategoryRepository
import com.konce.repository.TransactionRepository
import com.konce.service.TransactionService
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import java.util.*

@RestController
@RequestMapping("/api/transactions")
class TransactionController(
    private val transactionService: TransactionService,
    private val categoryRepository: CategoryRepository, private val transactionRepository: TransactionRepository
) {
    @GetMapping("/")
    fun all(): List<Transaction> {
        return transactionService.all()
    }

    @GetMapping("/{id}")
    fun one(@PathVariable id: UUID): Transaction {
        return transactionService.one(id) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)
    }

    @PostMapping("/")
    fun newOne(@RequestBody transaction: TransactionCreateRequest): Transaction {
        val foundCategory = categoryRepository.findByIdOrNull(transaction.categoryId) ?: throw ResponseStatusException(
            HttpStatus.NOT_FOUND
        )

        return transactionService.save(
            Transaction(
                category = foundCategory,
                description = transaction.description,
                amount = transaction.amount,
                date = transaction.date
            )
        )
    }

    @PutMapping("/{id}")
    fun updateOne(@PathVariable id: UUID, @RequestBody transaction: TransactionUpdateRequest): Transaction {
        val found = transactionService.one(id) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)

        val foundCategory = categoryRepository.findByIdOrNull(transaction.categoryId) ?: throw ResponseStatusException(
            HttpStatus.NOT_FOUND
        )

        found.category = foundCategory
        found.date = transaction.date
        found.amount = transaction.amount
        found.description = transaction.description

        return transactionService.save(found)
    }

    @DeleteMapping("/{id}")
    fun deleteOne(@PathVariable id: UUID) {
        transactionService.deleteOne(id)
    }
}