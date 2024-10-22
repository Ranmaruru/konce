package com.konce.dto

import java.util.*

data class CategoryCreateRequest(
    val name: String,
    val type: Boolean,
    val userId: UUID,
)

data class CategoryUpdateRequest(
    val name: String,
    val type: Boolean,
    val userId: UUID,
)