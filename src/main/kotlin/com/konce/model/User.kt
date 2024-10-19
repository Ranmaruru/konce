package com.konce.model

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.UUID

@Entity
data class User (
    @Id val id: UUID = UUID.randomUUID(),
    val username: String,
    val email: String,
    val password: String
)