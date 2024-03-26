package com.lovish.workouttracker.features.exercise.domain.repository

import com.lovish.workouttracker.features.exercise.data.entity.ExerciseEntity
import kotlinx.coroutines.flow.Flow

interface ExerciseRepository {

    fun getExerciseById(id: Int): Flow<List<ExerciseEntity>>

    fun getAllExercises(): Flow<List<ExerciseEntity>>

    fun insertExercise(): Flow<Long>

    fun updateExercise(): Flow<Long>

    fun deleteExercise(id: Int): Flow<Long>
}