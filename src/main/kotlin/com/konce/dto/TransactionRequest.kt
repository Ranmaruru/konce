package com.konce.dto

import java.util.*

data class TransactionCreateRequest(
    val amount: Double,
    val description: String,
    val date: Date,
    val categoryId: UUID
)

data class TransactionUpdateRequest(
    val amount: Double,
    val description: String,
    val date: Date,
    val categoryId: UUID
)