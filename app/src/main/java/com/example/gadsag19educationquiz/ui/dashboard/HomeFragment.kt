package com.example.gadsag19educationquiz.ui.dashboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.example.gadsag19educationquiz.R
import com.example.gadsag19educationquiz.databinding.FragmentHomeBinding
import com.example.gadsag19educationquiz.model.Subjects

class HomeFragment : Fragment() {
    lateinit var homeAdapter: HomeRvAdapter
    private lateinit var subjectRecyclerView: RecyclerView
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val subjectList = listOf(
            Subjects(R.drawable.ic_subject, "History"),
            Subjects(R.drawable.ic_subject, "Maths"),
            Subjects(R.drawable.ic_subject, "Philosophy"),
            Subjects(R.drawable.ic_subject, "Computer Studies")
        )

        subjectRecyclerView = binding.subjectsRv
        homeAdapter = HomeRvAdapter()
        subjectRecyclerView.adapter = homeAdapter
        homeAdapter.submitList(subjectList)
    }


}