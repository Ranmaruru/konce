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
    fun all(): List<User> {
        return userService.all()
    }

    @GetMapping("/{id}")
    fun one(@PathVariable id: UUID): User {
        return userService.one(id) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)
    }

    @PostMapping("/")
    fun newOne(@RequestBody user: UserCreateRequest): User {
        return userService.save(
            User(
                username = user.username,
                password = user.password,
                email = user.email
            )
        )
    }

    @PutMapping("/{id}")
    fun updateOne(@PathVariable id: UUID, @RequestBody user: UserUpdateRequest): User {
        val found = userService.one(id) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)

        found.username = user.username
        found.password = user.password
        found.email = user.email

        return userService.save(found)
    }

    @DeleteMapping("/{id}")
    fun deleteOne(@PathVariable id: UUID) {
        userService.deleteOne(id)
    }
}