package com.lovish.workouttracker.features.exercise.domain.repository

import com.lovish.workouttracker.common.Resource
import com.lovish.workouttracker.features.exercise.data.entity.ExerciseEntity
import com.lovish.workouttracker.features.exercise.domain.model.Exercise
import kotlinx.coroutines.flow.Flow

interface ExerciseRepository {

    fun getExerciseById(id: Int): Flow<Resource<List<Exercise>>>

    fun getAllExercises(): Flow<Resource<List<Exercise>>>

    fun insertExercise(exerciseEntity: ExerciseEntity): Flow<Long>

    fun updateExercise(exerciseEntity: ExerciseEntity): Flow<Long>

    fun deleteExercise(id: Int): Flow<Unit>
}