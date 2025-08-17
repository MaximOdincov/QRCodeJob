package com.example.qrcodejob.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.qrcodejob.R
import com.example.qrcodejob.databinding.FragmentLoginBinding
import com.example.qrcodejob.domain.entities.Role

class LoginFragment : Fragment(R.layout.fragment_login) {
    private val binding by viewBinding(FragmentLoginBinding::bind)
    private val viewModel: LoginViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonLogin.setOnClickListener {
            viewModel.login(binding.login.text.toString(), binding.password.text.toString())
        }
        viewModel.role.observe(viewLifecycleOwner){
            it?.let{
                when(it){
                    Role.STUDENT -> launchScreen(StudentFragment())
                    Role.TEACHER -> launchScreen(TeacherFragment())
                }
            }
        }
    }

    private fun launchScreen(newFragment: Fragment){
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, newFragment)
            .addToBackStack(null)
            .commit()

        viewModel.clearRole()
    }

}