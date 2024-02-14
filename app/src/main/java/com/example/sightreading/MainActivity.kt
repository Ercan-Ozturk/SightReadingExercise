package com.example.sightreading

import android.content.Context
import android.os.Bundle
import android.text.Layout
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box


import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.sightreading.ui.theme.SightReadingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SightReadingTheme {
                
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {

                    val mutableNote = remember { mutableStateOf(Notes.C) }
                    Column(verticalArrangement = Arrangement.Center,modifier = Modifier.fillMaxSize()) {

                        SightReadingApp()
                    }
                }
            }
        }
    }
}
enum class Notes(val offset: Dp) {
    C(15.dp),
    D(0.dp),
    E(-15.dp),
    F(-30.dp),
    G(60.dp),
    A(45.dp),
    B(30.dp);
}
@Composable
fun SightMaker(viewModel: QuizViewModel, note: Notes) {



    Box(contentAlignment = Alignment.Center, modifier = Modifier) {

        Column(modifier = Modifier
            .padding(30.dp)
            .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(30.dp))
            Divider(color = Color.Black, thickness = 1.dp)
            Spacer(modifier = Modifier.height(30.dp))
            Divider(color = Color.Black, thickness = 1.dp)
            Spacer(modifier = Modifier.height(30.dp))
            Divider(color = Color.Black, thickness = 1.dp)
            Spacer(modifier = Modifier.height(30.dp))
            Divider(color = Color.Black, thickness = 1.dp)
            Spacer(modifier = Modifier.height(30.dp))
            Divider(color = Color.Black, thickness = 1.dp)
            Spacer(modifier = Modifier.height(30.dp))
        }
        Icon(
            painter = painterResource(R.drawable.wholenote),
            contentDescription = "Music",
            Modifier
                .size(30.dp)
                .align(Alignment.Center)
                .offset(y = viewModel.currentNote.offset)
        )
        Icon(
            painter = painterResource(R.drawable.fclef),
            contentDescription = "Bass Clef",
            Modifier
                .size(100.dp)
                .align(Alignment.CenterStart)
                .offset(x = 30.dp, y = -12.dp)

        )
    }
}

@Composable
fun QuizButtons(viewModel: QuizViewModel){
    val context  = LocalContext.current
    Column {
        Row (horizontalArrangement = Arrangement.SpaceEvenly, verticalAlignment = Alignment.CenterVertically ,modifier = Modifier.fillMaxWidth()){


            Button(onClick = {
                NoteChecker(viewModel, context, Notes.C)

            }) {
                Text(text = "C")
            }
            Button(onClick = {
                NoteChecker(viewModel, context, Notes.D)

            }) {
                Text(text = "D")
            }
            Button(onClick = {
                NoteChecker(viewModel, context, Notes.E)

            }) {
                Text(text = "E")
            }
            Button(onClick = {
                NoteChecker(viewModel, context, Notes.F)

            }) {
                Text(text = "F")
            }
        }
        Row (horizontalArrangement = Arrangement.SpaceEvenly, verticalAlignment = Alignment.CenterVertically ,modifier = Modifier.fillMaxWidth()){
            Spacer(modifier = Modifier.width(10.dp))
            Button(onClick = {
                NoteChecker(viewModel, context,Notes.G)

            }) {
                Text(text = "G")
            }
            Button(onClick = {
                NoteChecker(viewModel, context,Notes.A)

            }) {
                Text(text = "A")
            }
            Button(onClick = {
                NoteChecker(viewModel, context, Notes.B)

            }) {
                Text(text = "B")
            }
            Spacer(modifier = Modifier.width(10.dp))
        }
    }

}



private fun NoteChecker(viewModel:QuizViewModel, context: Context, buttonNote: Notes) {
    if (buttonNote == viewModel.currentNote) {
        ChangeNote(viewModel, context)

    } else {
        WrongNote(context)
    }
}

fun WrongNote(context: Context) {
    val text = "Wrong Note!"
    val duration = Toast.LENGTH_SHORT
    val toast = Toast.makeText(context, text, duration)
    toast.show()
}

fun ChangeNote(viewModel: QuizViewModel, context: Context) {

    val text = "Correct Note!"
    val duration = Toast.LENGTH_SHORT
    val toast = Toast.makeText(context, text, duration)
    toast.show()

    viewModel.changeNote()




}

@Composable
fun SightReadingApp(){
    val mutableNote = remember { mutableStateOf(Notes.C) }
    val viewModel = viewModel<QuizViewModel>()

    Column(verticalArrangement = Arrangement.Center,modifier = Modifier.fillMaxSize()) {

        SightMaker(viewModel, mutableNote.value)
        QuizButtons(viewModel)
    }

}
/*
@Preview(showBackground = true, device = "id:pixel_5")
@Composable
fun SightMakerPreview() {
    SightReadingTheme {
        SightMaker(note = Notes.C)
    }
}
@Preview(showBackground = true, device = "id:pixel_7_pro")
@Composable
fun QuizButtonsPreview(){
    SightReadingTheme {
        QuizButtons(currentNote = Notes.C)
    }

}*/
@Preview(showBackground = true, device = "id:pixel_7_pro")
@Composable
fun SightReadingAppPreview(){
    SightReadingTheme {
        SightReadingApp()
    }

}

