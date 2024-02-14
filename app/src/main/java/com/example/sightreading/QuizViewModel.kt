package com.example.sightreading

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class QuizViewModel: ViewModel() {

    var currentNote by mutableStateOf(Notes.C)
        private set
    fun changeNote(){
        currentNote = Notes.values().random()
    }
}