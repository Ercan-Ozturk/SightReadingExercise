package com.ercanozturk.sightreading

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

class QuizViewModel: ViewModel() {

    var currentNote by mutableStateOf(Notes.C)
        private set
    var currentOctave by mutableStateOf(currentNote.offset)
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
        val rnds = (0..1).random()

        if(rnds == 1){
            currentOctave = currentNote.offset
        }else{
            currentOctave = currentNote.octaveOffset
        }

    }
    fun answerIsWrong(){
        isAnswerCorrect = 0
    }
}