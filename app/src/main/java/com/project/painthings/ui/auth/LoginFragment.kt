package com.project.painthings.ui.auth

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.project.painthings.R
import com.project.painthings.databinding.FragmentLoginBinding
import com.project.painthings.ui.main.BottomMainActivity

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setListeners()
    }

    private fun setListeners() {
        binding.apply {
            btnLogin.setOnClickListener {
                val iMain = Intent(requireContext(), BottomMainActivity::class.java)
                startActivity(iMain)
            }

            btnToRegister.setOnClickListener {
                parentFragmentManager.beginTransaction().apply {
                    replace(
                        R.id.auth_container,
                        RegisterFragment(),
                        RegisterFragment::class.java.simpleName
                    )
                        .commit()
                }
            }
        }
    }
}