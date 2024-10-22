package com.konce.dto

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import java.time.Instant
import java.util.*

data class TransactionCreateRequest(
    val amount: Double,

    @field:NotBlank()
    val description: String,

    @field:NotNull
    val date: Date = Date.from(Instant.now()),

    @field:NotNull
    val categoryId: UUID
)

data class TransactionUpdateRequest(
    val amount: Double,

    @field:NotBlank
    val description: String,

    @field:NotNull
    val date: Date = Date.from(Instant.now()),

    @field:NotNull
    val categoryId: UUID
)