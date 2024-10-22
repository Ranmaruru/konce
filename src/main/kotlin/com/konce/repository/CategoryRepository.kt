package com.konce.repository

import com.konce.model.Category
import org.springframework.data.repository.CrudRepository
import java.util.*

interface CategoryRepository : CrudRepository<Category, UUID>