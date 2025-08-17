package com.example.qrcodejob.data

import android.graphics.Bitmap
import com.example.qrcodejob.domain.repositories.QrCodeRepository
import androidmads.library.qrgenearator.QRGContents
import androidmads.library.qrgenearator.QRGEncoder
import com.google.zxing.MultiFormatReader
import com.google.zxing.RGBLuminanceSource
import com.google.zxing.BinaryBitmap
import com.google.zxing.common.HybridBinarizer

class QrCodeRepositoryImpl: QrCodeRepository {
    override fun generateQrCode(content: String, sizePx: Int): Bitmap {
        val encoder = QRGEncoder(content, null, QRGContents.Type.TEXT, sizePx)
        return encoder.bitmap
    }

    override fun scanQrCode(qrCode: String): String? {
        return qrCode
    }
}