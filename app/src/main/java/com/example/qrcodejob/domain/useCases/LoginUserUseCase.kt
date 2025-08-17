package com.example.qrcodejob.domain.useCases

import com.example.qrcodejob.domain.entities.Role
import com.example.qrcodejob.domain.repositories.LoginUserRepository

class LoginUserUseCase(private val repository: LoginUserRepository) {
    fun login(login: String, password: String): Role {
        return repository.loginUser(login, password)
    }
}