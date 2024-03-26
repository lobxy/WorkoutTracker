package com.lovish.workouttracker.features.exercise.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lovish.workouttracker.common.Constants.LOG_CONSTANT
import com.lovish.workouttracker.features.exercise.domain.repository.ExerciseRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ThingsViewModel @Inject constructor(private val repositoryImpl: ExerciseRepository) : ViewModel() {

    fun doStuff() {
        repositoryImpl.insertExercise().onEach {
            Log.e(LOG_CONSTANT + "thingsvm", "Key returned : $it")
        }.launchIn(viewModelScope)
    }

}