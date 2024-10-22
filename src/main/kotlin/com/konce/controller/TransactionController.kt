package com.konce.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

val mockDb = arrayListOf<String>()

@RestController
@RequestMapping("/api/transactions")
class TransactionController {
    @GetMapping("/")
    fun all() {
    }
}