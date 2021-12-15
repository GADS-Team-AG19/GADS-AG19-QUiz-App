package com.example.gadsag19educationquiz.ui.dashboard

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.gadsag19educationquiz.R
import com.example.gadsag19educationquiz.databinding.FragmentComputerBinding
import com.example.gadsag19educationquiz.model.Question
import com.example.gadsag19educationquiz.util.QuestionList.computer_questions
import com.example.gadsag19educationquiz.util.QuestionList.science_questions
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class ComputerFragment : Fragment() {
    private val args: QuizFragmentArgs by navArgs()
    private lateinit var binding: FragmentComputerBinding
    private val quizViewModel: QuizViewModel by viewModels()


    lateinit var currentQuestion: Question
    lateinit var answers: MutableList<String>
    private var questionIndex = 0
    private var score = 0
    private val numQuestions = Math.min((computer_questions.size + 1), 9)


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_computer, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        randomizeQuestions()
        binding.game = this
        binding.nextButton.setOnClickListener { view: View ->
            val checkedId = binding.questionRadioGroup.checkedRadioButtonId
            if (-1 != checkedId) {
                var answerIndex = 0
                when (checkedId) {
                    R.id.optionB -> answerIndex = 1
                    R.id.optionC -> answerIndex = 2
                    R.id.optionD -> answerIndex = 3
                }

                if (answers[answerIndex] == currentQuestion.answers[0]) {
                    score +=20
                    questionIndex++
                    binding.questionRadioGroup.clearCheck()
                    // Advance to the next question
                    if (questionIndex < numQuestions) {
                        currentQuestion = computer_questions[questionIndex]
                        setQuestion()
                        binding.invalidateAll()
                    } else {
                        showFinalScoreDialog()
                    }
                } else {
                    Toast.makeText(requireContext(), "Wrong Answer, Try again", Toast.LENGTH_SHORT).show()

                }
            }
        }
    }

    private fun showFinalScoreDialog() {
        MaterialAlertDialogBuilder(requireContext())
            .setTitle(getString(R.string.congratulations))
            .setMessage(getString((R.string.you_scored), score))
            .setCancelable(false)
            .setNegativeButton(getString(R.string.exit)) { _, _ ->
                exitGame()
            }
            .setPositiveButton(getString(R.string.play_again)) { _, _ ->
                restartGame()
            }
            .show()
    }


    private fun exitGame() {
        findNavController().popBackStack()
    }

    private fun restartGame() {
        findNavController().popBackStack()
    }
    private fun randomizeQuestions() {
        science_questions.shuffle()
        questionIndex = 0
        score = 0
        setQuestion()
    }

    private fun setQuestion() {
        currentQuestion = computer_questions[questionIndex]
        answers = currentQuestion.answers.toMutableList()
        answers.shuffle()
        binding.wordCount.text = getString(R.string.title_question, questionIndex + 1, numQuestions)
        binding.score.text = getString(R.string.score, score + 0)
    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity).supportActionBar!!.title = "Computer Quiz"
    }

    override fun onStop() {
        super.onStop()
        (activity as AppCompatActivity).supportActionBar!!.title = "Subjects"

    }

}