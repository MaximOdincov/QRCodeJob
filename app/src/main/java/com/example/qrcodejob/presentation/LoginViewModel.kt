package com.example.qrcodejob.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.qrcodejob.data.LoginRepositoryImpl
import com.example.qrcodejob.domain.entities.Role
import com.example.qrcodejob.domain.repositories.LoginUserRepository
import com.example.qrcodejob.domain.useCases.LoginUserUseCase

class LoginViewModel: ViewModel() {
    private val repository = LoginRepositoryImpl()
    private val loginUserUseCase = LoginUserUseCase(repository)

    private var _role = MutableLiveData<Role?>()
    val role: LiveData<Role?>
        get() {
            return _role
        }

    fun login(login: String, password: String){
        _role.value = loginUserUseCase.login(login, password)
    }

    fun clearRole(){
        _role.value = null
    }
}