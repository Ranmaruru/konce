package com.konce.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.*

@Entity
@Table(name = "users")
class User(
    @Id @GeneratedValue val id: UUID,
    val username: String,
    val password: String,
    val email: String
)