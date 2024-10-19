package com.konce.model

import jakarta.persistence.*
import java.util.*

@Entity
class Transaction (
    @Id
    val id: UUID = UUID.randomUUID(),
    val amount: Double,
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category.id")
    val category_id: UUID,
    val description: String,
    val date: Date
)