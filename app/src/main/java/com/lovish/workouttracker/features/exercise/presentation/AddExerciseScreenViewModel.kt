package com.lovish.workouttracker.features.exercise.presentation

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lovish.workouttracker.R
import com.lovish.workouttracker.common.Constants
import com.lovish.workouttracker.common.Resource
import com.lovish.workouttracker.features.exercise.domain.use_case.AddExercise
import com.lovish.workouttracker.features.exercise.domain.use_case.AddExercisesErrors
import com.lovish.workouttracker.features.exercise.domain.use_case.GetExercises
import com.lovish.workouttracker.features.exercise.domain.use_case.GetExercisesErrors
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class AddExerciseScreenViewModel @Inject constructor(
    private val getExercisesUseCase: GetExercises,
    private val addExerciseUseCase: AddExercise
) : ViewModel() {

    @ApplicationContext
    lateinit var context: Context

    fun insertExercise() {
        addExerciseUseCase.invoke().onEach {
            when (it) {
                is Resource.Error -> {
                    handleErrorCodesAndShowMessage(it.errorCode)
                }

                is Resource.Loading -> TODO()
                is Resource.Success -> TODO()
            }
        }.launchIn(viewModelScope)
    }

    fun getExercises() {
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

            AddExercisesErrors.TITLE_EMPTY.ordinal -> {
                Log.e(Constants.LOG_CONSTANT + "error", context.getString(R.string.exercise_error_title_missing))
                Toast.makeText(context, context.getString(R.string.exercise_error_title_missing), Toast.LENGTH_SHORT).show()
            }

            AddExercisesErrors.DESCRIPTION_EMPTY.ordinal -> {
                Log.e(Constants.LOG_CONSTANT + "error", context.getString(R.string.exercise_error_description_missing))
            }
        }
    }

}