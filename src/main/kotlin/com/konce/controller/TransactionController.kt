package com.konce.controller

import com.konce.dto.TransactionCreateRequest
import com.konce.dto.TransactionUpdateRequest
import com.konce.model.Transaction
import com.konce.service.CategoryService
import com.konce.service.TransactionService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import java.util.*

@RestController
@RequestMapping("/api/transactions")
class TransactionController(
    private val transactionService: TransactionService,
    private val categoryService: CategoryService,
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
        val foundCategory = categoryService.one(transaction.categoryId) ?: throw ResponseStatusException(
            HttpStatus.NOT_FOUND
        )

        return transactionService.save(foundCategory, transaction.description, transaction.amount, transaction.date)
    }

    @PutMapping("/{id}")
    fun updateOne(@PathVariable id: UUID, @RequestBody transaction: TransactionUpdateRequest): Transaction {
        val found = transactionService.one(id) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)

        val foundCategory = categoryService.one(transaction.categoryId) ?: throw ResponseStatusException(
            HttpStatus.NOT_FOUND
        )

        return transactionService.save(foundCategory, transaction.description, transaction.amount, transaction.date)
    }

    @DeleteMapping("/{id}")
    fun deleteOne(@PathVariable id: UUID) {
        transactionService.deleteOne(id)
    }
}