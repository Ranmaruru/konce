package com.konce.dto

data class UserCreateRequest(
    val username: String,
    val password: String,
    val email: String,
)

data class UserUpdateRequest(
    val username: String,
    val password: String,
    val email: String,
)