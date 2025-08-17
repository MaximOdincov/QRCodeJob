package com.example.qrcodejob.domain.repositories

import com.example.qrcodejob.domain.entities.Role

interface LoginUserRepository {
    fun loginUser(login: String, password: String): Role
}