package com.konce.model

import jakarta.persistence.*
import java.util.*

@Entity
class Category(
    @Id @GeneratedValue var id: UUID,
    var name: String = "",
    var type: Boolean = true,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users.id")
    var user: User
)
