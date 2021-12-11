package com.example.gadsag19educationquiz.ui.dashboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.fragment.navArgs
import com.example.gadsag19educationquiz.R
import com.example.gadsag19educationquiz.databinding.FragmentHomeBinding
import com.example.gadsag19educationquiz.databinding.FragmentQuizBinding
import com.example.gadsag19educationquiz.databinding.QuizRvItemBinding
import com.example.gadsag19educationquiz.model.Subjects

class QuizFragment : Fragment() {
    private val args: QuizFragmentArgs by navArgs()
    private lateinit var toolbar: Toolbar
    private var _binding: FragmentQuizBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentQuizBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity).supportActionBar!!.hide()
    }

    override fun onStop() {
        super.onStop()
        (activity as AppCompatActivity).supportActionBar!!.show()

    }
}