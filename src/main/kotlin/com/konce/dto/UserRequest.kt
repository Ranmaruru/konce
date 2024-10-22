package com.konce.dto

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

data class UserCreateRequest(
    @field:NotBlank
    val username: String,

    @field:NotBlank
    val password: String,

    @field:NotBlank
    val email: String,
)

data class UserUpdateRequest(
    @field:NotBlank
    val username: String,

    @field:NotBlank
    val password: String,

    @field:NotBlank
    val email: String,
)