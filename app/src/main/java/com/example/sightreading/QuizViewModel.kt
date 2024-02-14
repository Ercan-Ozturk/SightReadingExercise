package com.example.sightreading

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

class QuizViewModel: ViewModel() {

    var currentNote by mutableStateOf(Notes.C)
        private set
    var isAnswerCorrect by mutableStateOf(-1)
        private set
    fun changeNote(){
        isAnswerCorrect = 1
        var nextNote = Notes.values().random()
        while (nextNote == currentNote){
            nextNote = Notes.values().random()
        }
        currentNote = nextNote
    }
    fun answerIsWrong(){
        isAnswerCorrect = 0
    }
}