package com.example.qrcodejob.presentation

import android.graphics.Bitmap
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.qrcodejob.data.QrCodeRepositoryImpl
import com.example.qrcodejob.domain.repositories.QrCodeRepository
import com.example.qrcodejob.domain.useCases.GenerateQrCodeUseCase

class StudentFragmentViewModel: ViewModel() {
    private val repository = QrCodeRepositoryImpl()
    private val generateQrCodeUseCase = GenerateQrCodeUseCase(repository)

    private val _qrCodeBitmap = MutableLiveData<Bitmap>()
    val qrCodeBitmap: LiveData<Bitmap>
        get() {
            return _qrCodeBitmap
        }

    fun generateQrCode(content: String, sizePx: Int){
        _qrCodeBitmap.value = generateQrCodeUseCase(content, sizePx)
    }
}