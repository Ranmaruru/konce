package com.konce.model

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "Category")
class CategoryEntity (
    @Id val id: UUID = UUID.randomUUID(),
    val name: String,
    val type: Boolean,
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user.uuid")
    val userId: UUID
)
