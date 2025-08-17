package com.example.qrcodejob.domain.repositories

import android.graphics.Bitmap
import java.sql.Struct


interface QrCodeRepository {
    fun generateQrCode(content: String, sizePx: Int): Bitmap

    fun scanQrCode(qrCode: String): String?
}