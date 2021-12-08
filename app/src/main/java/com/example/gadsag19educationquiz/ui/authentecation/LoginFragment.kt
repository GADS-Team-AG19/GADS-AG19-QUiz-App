package com.example.gadsag19educationquiz.ui.authentecation

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import com.example.gadsag19educationquiz.DashboardActivity
import com.example.gadsag19educationquiz.R
import com.example.gadsag19educationquiz.databinding.FragmentLoginBinding
import com.example.gadsag19educationquiz.databinding.FragmentSignUpBinding
import com.google.firebase.auth.FirebaseAuth

class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding: FragmentLoginBinding get() = _binding!!
    lateinit var auth: FirebaseAuth
    lateinit var email: EditText
    lateinit var password: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        email = binding.loginFragmentEmailAddressEditText
        password = binding.loginFragmentPasswordEditText

        auth = FirebaseAuth.getInstance()
        binding.loginButton.setOnClickListener {
            if (email.text.toString().isNotEmpty() && password.text.toString().isNotEmpty()) {
                login()
            }else {
                Toast.makeText(requireContext(), "Fields cannot be empty", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
        }
    }

    override fun onResume() {
        super.onResume()
        validateSignUpFieldsOnTextChange()
    }

    /*Method to Validate input Field onText Change*/
    private fun validateSignUpFieldsOnTextChange(): Boolean {
        var isValidated = true

        email.doOnTextChanged { _, _, _, _ ->
            when {
                email.text.toString().trim().isEmpty() -> {
                    binding.loginFragmentEmailAddressTextInputLayout.error =
                        getString(R.string.enter_email_address)
                    isValidated = false
                }
                password.text.toString().trim().isEmpty()-> {
                    binding.loginFragmentPasswordTextInputLayout.error =
                        getString(R.string.enter_password)
                    isValidated = false
                }
                else -> {
                    binding.loginFragmentEmailAddressTextInputLayout.error = null
                    isValidated = true
                }
            }
        }
        return isValidated
    }

    private fun login() {
        val email = binding.loginFragmentEmailAddressEditText.text.toString()
        val password = binding.loginFragmentPasswordEditText.text.toString()

        binding.progressBar.visibility = View.VISIBLE

        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                binding.progressBar.visibility = View.GONE
                val intent = Intent(requireContext(), DashboardActivity::class.java)
                startActivity(intent)
            }
        }.addOnFailureListener { exception ->
            binding.progressBar.visibility = View.GONE
            Toast.makeText(requireContext(), exception.localizedMessage, Toast.LENGTH_SHORT).show()
        }
    }
}