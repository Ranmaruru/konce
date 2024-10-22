package com.konce.model

import jakarta.persistence.*
import java.util.*

@Entity
@Table(
    uniqueConstraints = [
        UniqueConstraint(
            columnNames = ["users_id", "name"],
            name = "uk_unique_uid_category_name"
        )
    ]
)
class Category(
    @Id
    @GeneratedValue
    var id: UUID? = null,

    var name: String,
    var type: Boolean,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users.id")
    var user: User
)
