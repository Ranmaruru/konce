package com.konce.model

import jakarta.persistence.*
import java.util.*

@Entity
class Transaction (
    @Id @GeneratedValue val id: UUID,
    val amount: Double,
    val description: String,
    val date: Date,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category.id")
    val category: Category,
)