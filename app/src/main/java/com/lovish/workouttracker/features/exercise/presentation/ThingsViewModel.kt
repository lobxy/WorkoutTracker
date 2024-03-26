package com.lovish.workouttracker.features.exercise.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lovish.workouttracker.common.Constants
import com.lovish.workouttracker.common.Resource
import com.lovish.workouttracker.features.exercise.domain.use_case.GetExercises
import com.lovish.workouttracker.features.exercise.domain.use_case.GetExercisesErrors
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ThingsViewModel @Inject constructor(private val getExercisesUseCase: GetExercises) : ViewModel() {

    fun doStuff() {
        getExercisesUseCase.invoke(3).onEach {
            when (it) {
                is Resource.Error -> {
                    handleErrorCodesAndShowMessage(it.errorCode)
                }

                is Resource.Loading -> {
                    Log.e(Constants.LOG_CONSTANT + "doStuff", "Loading")
                }

                is Resource.Success -> {
                    Log.e(Constants.LOG_CONSTANT + "doStuff", "Success" + it.data?.toString())
                }
            }
        }.launchIn(viewModelScope)

    }

    private fun handleErrorCodesAndShowMessage(errorCode: Int?) {
        if (errorCode == null) return

        when (errorCode) {
            GetExercisesErrors.EMPTY.ordinal -> {
                Log.e(Constants.LOG_CONSTANT + "error", "No data exists")
            }
        }
    }


}