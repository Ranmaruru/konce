package com.konce.service

import com.konce.model.User
import com.konce.repository.UserRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService(
    private val userRepository: UserRepository
) {
    fun all(): List<User> {
        return userRepository.findAll().toList()
    }

    fun one(id: UUID): User? {
        return userRepository.findByIdOrNull(id)
    }

    fun save(user: User): User {
        return userRepository.save(user)
    }

    fun deleteOne(id: UUID) {
        userRepository.deleteById(id)
    }
}