package com.konce.model

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "users")
class User(
    @Id
    @GeneratedValue
    var id: UUID? = null,

    var username: String,
    var password: String,

    @Column(unique = true)
    var email: String
)