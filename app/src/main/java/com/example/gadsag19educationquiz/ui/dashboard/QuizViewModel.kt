package com.example.gadsag19educationquiz.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gadsag19educationquiz.util.Constants

class QuizViewModel: ViewModel() {

    private var _score = MutableLiveData<Int>(0)
    val score: LiveData<Int> get() = _score

    private val _currentQuesCount = MutableLiveData<Int>(0)
    val currentWordCount: LiveData<Int> get() = _currentQuesCount


    fun increaseScore() {
        _score.value = _score.value?.plus(Constants.SCORE_INCREASE)
    }

    fun reInitializeData() {
        _score.value = 0
        _currentQuesCount.value = 0
    }

}