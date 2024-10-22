package com.konce.dto

import jakarta.validation.constraints.NotBlank
import java.util.*

data class CategoryCreateRequest(
    @field:NotBlank
    val name: String,

    val type: Boolean,

    val userId: UUID,
)

data class CategoryUpdateRequest(
    @field:NotBlank
    val name: String,

    val type: Boolean,

    val userId: UUID,
)