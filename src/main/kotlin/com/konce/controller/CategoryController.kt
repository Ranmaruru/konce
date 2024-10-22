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
    fun all(): List<Category> {
        return categoryService.all()
    }

    @GetMapping("/{id}")
    fun one(@PathVariable id: UUID): Category {
        return categoryService.one(id) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)
    }

    @PostMapping("/")
    fun newOne(@RequestBody category: CategoryCreateRequest): Category {
        val foundUser = userService.one(category.userId) ?: throw ResponseStatusException(
            HttpStatus.NOT_FOUND
        )

        return categoryService.save(
            Category(
                name = category.name,
                type = category.type,
                user = foundUser
            )
        )
    }

    @PutMapping("/{id}")
    fun updateOne(@PathVariable id: UUID, @RequestBody category: CategoryUpdateRequest): Category {
        val found = categoryService.one(id) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)

        val foundUser = userService.one(category.userId) ?: throw ResponseStatusException(
            HttpStatus.NOT_FOUND
        )

        found.user = foundUser
        found.name = category.name
        found.type = category.type

        return categoryService.save(found)
    }

    @DeleteMapping("/{id}")
    fun deleteOne(@PathVariable id: UUID) {
        categoryService.deleteOne(id)
    }
}