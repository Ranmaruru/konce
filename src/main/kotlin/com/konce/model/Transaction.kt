package com.konce.model

import jakarta.persistence.*
import java.util.*

@Entity
class Transaction (
    @Id @GeneratedValue var id: UUID? = null,
    var amount: Double,
    var description: String,
    var date: Date,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category.id")
    var category: Category,
)