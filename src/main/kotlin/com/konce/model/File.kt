package com.konce.model

import jakarta.persistence.*
import java.util.*

@Entity
@Table
class File(
    @Id @GeneratedValue val id: UUID,
    val url: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "transaction.id")
    val transaction: Transaction
)