package com.konce.controller

import com.konce.dto.CategoryCreateRequest
import com.konce.dto.CategoryUpdateRequest
import com.konce.model.Category
import com.konce.service.CategoryService
import com.konce.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import java.util.*

@RestController
@RequestMapping("/api/categories")
class CategoryController(
    private val categoryService: CategoryService,
    private val userService: UserService
) {
    @GetMapping("/")
    fun getAllUsers(): List<Category> {
        return categoryService.all()
    }

    @GetMapping("/{id}")
    fun getSingleUser(@PathVariable id: UUID): Category {
        return categoryService.one(id) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)
    }

    @PostMapping("/")
    fun createUser(@RequestBody category: CategoryCreateRequest): Category {
        val foundUser = userService.one(category.userId) ?: throw ResponseStatusException(
            HttpStatus.NOT_FOUND
        )

        return categoryService.save(category.name, foundUser, category.type)
    }

    @PutMapping("/{id}")
    fun updateSingleUser(@PathVariable id: UUID, @RequestBody category: CategoryUpdateRequest): Category {
        val found = categoryService.one(id) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)

        val foundUser = userService.one(category.userId) ?: throw ResponseStatusException(
            HttpStatus.NOT_FOUND
        )

        return categoryService.save(category.name, foundUser, category.type)
    }

    @DeleteMapping("/{id}")
    fun deleteOne(@PathVariable id: UUID) {
        categoryService.deleteOne(id)
    }
}