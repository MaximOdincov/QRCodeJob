package com.example.qrcodejob.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.qrcodejob.R
import com.example.qrcodejob.databinding.FragmentTeacherBinding
import com.journeyapps.barcodescanner.BarcodeView
import com.journeyapps.barcodescanner.DecoratedBarcodeView

class TeacherFragment : Fragment(R.layout.fragment_teacher) {
    private val binding by viewBinding(FragmentTeacherBinding::bind)
    private val viewModel: TeacherViewModel by viewModels()
    private lateinit var scanner: DecoratedBarcodeView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.scannedStudentId.observe(viewLifecycleOwner){
            Toast.makeText(requireContext() , it, Toast.LENGTH_LONG).show()
        }
        scanner = binding.barcodeScanner
        scanner.decodeContinuous { result ->
            viewModel.scan(result.text)
        }
    }

    override fun onResume() {
        super.onResume()
        scanner.resume()
    }

    override fun onPause() {
        super.onPause()
        scanner.pause()
    }
}