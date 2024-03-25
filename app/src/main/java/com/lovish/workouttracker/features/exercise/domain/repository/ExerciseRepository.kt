package com.lovish.workouttracker.features.exercise.domain.repository

import com.lovish.workouttracker.features.exercise.data.ExerciseDAO
import com.lovish.workouttracker.features.exercise.data.entity.ExerciseEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ExerciseRepositoryImpl @Inject constructor(private val dao: ExerciseDAO) {

    fun upsertThings(): Flow<Int> = flow {
        dao.upsertExercise(ExerciseEntity(name = "Hello"))
    }

}