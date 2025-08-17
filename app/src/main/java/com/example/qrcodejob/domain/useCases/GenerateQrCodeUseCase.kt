package com.example.qrcodejob.domain.useCases

import android.graphics.Bitmap
import com.example.qrcodejob.domain.repositories.QrCodeRepository

class GenerateQrCodeUseCase(private val repository: QrCodeRepository) {
    operator fun invoke(content: String, sizePx: Int): Bitmap{
        return repository.generateQrCode(content, sizePx)
    }
}