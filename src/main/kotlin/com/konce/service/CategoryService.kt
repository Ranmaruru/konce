package com.konce.service

import com.konce.model.Category
import com.konce.model.User
import com.konce.repository.CategoryRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.*

@Service
class CategoryService(
    private val categoryRepository: CategoryRepository
) {

    fun all(): List<Category> {
        return categoryRepository.findAll().toList()
    }

    fun one(categoryId: UUID): Category? {
        return categoryRepository.findByIdOrNull(categoryId)
    }

    fun save(name: String, user: User, type: Boolean): Category {
        return categoryRepository.save(
            Category(
                name = name,
                type = type,
                user = user
            )
        )
    }

    fun deleteOne(id: UUID) {
        categoryRepository.deleteById(id)
    }
}