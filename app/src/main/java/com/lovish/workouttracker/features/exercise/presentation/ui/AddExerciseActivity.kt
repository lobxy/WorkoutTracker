package com.lovish.workouttracker.features.exercise.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lovish.workouttracker.ui.theme.WorkoutTrackerTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlin.String as String1

@AndroidEntryPoint
class AddExerciseActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WorkoutTrackerTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Box {
                        Greeting()
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting() {

    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp), horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color.Black)
            .padding(16.dp)
    ) {
        EditTextWithTitle(title = "Name of Exercise")

        EditTextWithTitle(title = "Description of the Exercise")

        Button(onClick = {}, modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Text(text = "Save", color = Color.White, fontSize = 14.sp)
        }
    }

}

@Composable
fun EditTextWithTitle(title: String1?) {

    val titleTextField = remember {
        mutableStateOf("")
    }

    Column {
        Text(
            text = title ?: "", color = Color.White, fontSize = 14.sp, modifier = Modifier.padding(bottom = 4.dp)
        )

        TextField(modifier = Modifier.fillMaxWidth(), value = titleTextField.value, singleLine = true, onValueChange = { text ->
            titleTextField.value = text
        })
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WorkoutTrackerTheme {
        Greeting()
    }
}