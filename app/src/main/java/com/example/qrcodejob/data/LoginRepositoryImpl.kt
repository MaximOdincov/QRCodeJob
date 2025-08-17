package com.example.qrcodejob.data

import com.example.qrcodejob.domain.entities.Role
import com.example.qrcodejob.domain.repositories.LoginUserRepository

class LoginRepositoryImpl: LoginUserRepository {
    override fun loginUser(login: String, password: String): Role {
        if(password == "1"){
            return Role.TEACHER
        }
        return Role.STUDENT
    }
}