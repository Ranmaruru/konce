package com.konce.controller

import com.konce.dto.UserCreateRequest
import com.konce.dto.UserUpdateRequest
import com.konce.model.User
import com.konce.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import java.util.*


@RestController
@RequestMapping("/api/users")
class UserController(
    private val userService: UserService
) {
    @GetMapping("/")
    fun getAllUsers(): List<User> {
        return userService.all()
    }

    @GetMapping("/{id}")
    fun getSingleUser(@PathVariable id: UUID): User {
        return userService.one(id) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)
    }

    @PostMapping("/")
    fun createUser(@RequestBody user: UserCreateRequest): User {
        return userService.save(user.username, user.password, user.email)
    }

    @PutMapping("/{id}")
    fun updateSingleUser(@PathVariable id: UUID, @RequestBody user: UserUpdateRequest): User {
        val found = userService.one(id) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)
        return userService.save(user.username, user.password, user.email)
    }

    @DeleteMapping("/{id}")
    fun deleteOne(@PathVariable id: UUID) {
        userService.deleteOne(id)
    }
}