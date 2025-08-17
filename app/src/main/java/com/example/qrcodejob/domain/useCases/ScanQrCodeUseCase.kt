package com.example.qrcodejob.domain.useCases

import android.graphics.Bitmap
import com.example.qrcodejob.domain.repositories.QrCodeRepository

class ScanQrCodeUseCase(private val repository: QrCodeRepository) {
    fun scanQrCode(string: String): String?{
        return repository.scanQrCode(string)
    }
}