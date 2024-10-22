package com.konce.model

import jakarta.persistence.*
import java.util.*

@Entity
@Table
class File(
    @Id @GeneratedValue var id: UUID? = null,
    var url: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "transaction.id")
    var transaction: Transaction
)