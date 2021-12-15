package com.example.gadsag19educationquiz.ui.dashboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.example.gadsag19educationquiz.R
import com.example.gadsag19educationquiz.databinding.FragmentSubjectBinding

class SubjectFragment : Fragment() {
    private var _binding: FragmentSubjectBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSubjectBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.scienceParent.setOnClickListener {
            findNavController().navigate(R.id.quizFragment)
        }

        binding.philosophySubjectParent.setOnClickListener {
            findNavController().navigate(R.id.philosophyFragment)
        }

        binding.comptSubjectParent.setOnClickListener {
            findNavController().navigate(R.id.computerFragment)
        }
    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity).supportActionBar!!.title = "Subjects"
    }

    override fun onStop() {
        super.onStop()
        (activity as AppCompatActivity).supportActionBar!!.title = ""

    }
}