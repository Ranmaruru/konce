package com.konce.service

import com.konce.repository.TransactionRepository
import org.springframework.stereotype.Service

@Service
class TransactionService(
    private val transactionRepository: TransactionRepository
)