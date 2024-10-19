package com.konce.model

import jakarta.persistence.*
import java.util.*

@Entity
class Category (
    @Id val id: UUID = UUID.randomUUID(),
    val name: String,
    val type: Boolean,
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user.uuid")
    val user_id: UUID
)
