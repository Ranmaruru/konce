package com.konce.repository

import com.konce.model.Transaction
import org.springframework.data.repository.CrudRepository
import java.util.*

interface TransactionRepository : CrudRepository<Transaction, UUID>