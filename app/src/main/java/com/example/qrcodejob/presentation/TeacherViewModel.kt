package com.example.qrcodejob.presentation

import android.graphics.Bitmap
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.qrcodejob.data.QrCodeRepositoryImpl
import com.example.qrcodejob.domain.useCases.ScanQrCodeUseCase

class TeacherViewModel: ViewModel() {
    private val repository = QrCodeRepositoryImpl()
    private val scanQrCodeUseCase = ScanQrCodeUseCase(repository)

    private val _scannedStudentId = MutableLiveData<String>()
    val scannedStudentId: LiveData<String>
        get(){return _scannedStudentId}

    fun scan(string: String){
        scanQrCodeUseCase.scanQrCode(string)?.let {_scannedStudentId.value = it}
    }
}