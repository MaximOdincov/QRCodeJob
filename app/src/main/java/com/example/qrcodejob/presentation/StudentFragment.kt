package com.example.qrcodejob.presentation

import android.graphics.Bitmap
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.qrcodejob.R
import com.example.qrcodejob.databinding.FragmentStudentBinding
import dev.androidbroadcast.vbpd.viewBinding

class StudentFragment : Fragment(R.layout.fragment_student) {

    private val viewModel: StudentFragmentViewModel by viewModels()
    private val binding by viewBinding(FragmentStudentBinding::bind)
    private lateinit var bitmap: Bitmap

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.qrCodeBitmap.observe(viewLifecycleOwner){
            bitmap = it
            binding.qrCodeImage.setImageBitmap(bitmap)
        }
        viewModel.generateQrCode("I'm student", 1080)
    }

}