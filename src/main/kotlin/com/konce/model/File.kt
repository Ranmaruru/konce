package com.konce.model

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToOne
import java.util.UUID

@Entity
class File (
    @Id val id: UUID = UUID.randomUUID(),
    val url: String,
    @OneToOne
    @JoinColumn(name = "transaction.id")
    val transaction_id: UUID
)