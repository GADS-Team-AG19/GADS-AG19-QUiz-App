package com.example.gadsag19educationquiz.ui.dashboard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.gadsag19educationquiz.R
import com.example.gadsag19educationquiz.databinding.QuizRvItemBinding
import com.example.gadsag19educationquiz.model.Subjects

class HomeRvAdapter(var subjects: Subjects): ListAdapter<Subjects, HomeRvAdapter.ViewHolder>(DiffCallback) {

    class ViewHolder( val binding: QuizRvItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(subjects: Subjects) {
            binding.imageView.setImageResource(subjects.image)
            binding.subjectsTv.text = subjects.subject
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            QuizRvItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
        holder.binding.apply {
            subjectParent.setOnClickListener {
                it.findNavController().navigate(R.id.quizFragment)
            }
        }
    }

}

object DiffCallback : DiffUtil.ItemCallback<Subjects>() {
    override fun areItemsTheSame(oldItem: Subjects, newItem: Subjects): Boolean {
        return oldItem.image == newItem.image
    }

    override fun areContentsTheSame(oldItem: Subjects, newItem: Subjects): Boolean {
        return oldItem == newItem
    }
}
