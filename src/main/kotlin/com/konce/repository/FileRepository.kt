package com.konce.repository

import com.konce.model.File
import org.springframework.data.repository.CrudRepository
import java.util.*

interface FileRepository : CrudRepository<File, UUID>