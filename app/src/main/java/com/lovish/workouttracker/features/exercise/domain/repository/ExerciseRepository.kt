package com.lovish.workouttracker.features.exercise.domain.repository

import com.lovish.workouttracker.features.exercise.data.ExerciseDAO
import javax.inject.Inject

class ExerciseRepositoryImpl @Inject constructor(private val dao: ExerciseDAO) {

    fun upsertThings() {
        dao.upsertExercise()
    }

}