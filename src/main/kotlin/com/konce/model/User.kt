package com.konce.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.*

@Entity
@Table(name = "users")
class User(
    @Id @GeneratedValue var id: UUID? = null,
    var username: String,
    var password: String,
    var email: String
)