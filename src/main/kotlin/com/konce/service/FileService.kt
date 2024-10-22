package com.konce.service

import com.konce.repository.FileRepository
import org.springframework.stereotype.Service

@Service
class FileService(
    private val fileRepository: FileRepository
)