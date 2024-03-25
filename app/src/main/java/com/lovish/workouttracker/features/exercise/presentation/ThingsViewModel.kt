package com.lovish.workouttracker.features.exercise.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lovish.workouttracker.features.exercise.domain.repository.ExerciseRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import javax.inject.Inject

@HiltViewModel
class ThingsViewModel @Inject constructor(private val repositoryImpl: ExerciseRepositoryImpl) : ViewModel() {

    fun doStuff() {
        repositoryImpl.upsertThings().launchIn(viewModelScope)
    }

}