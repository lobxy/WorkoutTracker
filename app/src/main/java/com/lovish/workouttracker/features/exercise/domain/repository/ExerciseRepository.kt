package com.lovish.workouttracker.features.exercise.domain.repository

import com.lovish.workouttracker.common.Resource
import com.lovish.workouttracker.features.exercise.data.entity.ExerciseEntity
import kotlinx.coroutines.flow.Flow

interface ExerciseRepository {

    fun getExerciseById(id: Int): Flow<Resource<List<ExerciseEntity>>>

    fun getAllExercises(): Flow<Resource<List<ExerciseEntity>>>

    fun insertExercise(exerciseEntity: ExerciseEntity): Flow<Long>

    fun updateExercise(exerciseEntity: ExerciseEntity): Flow<Long>

    fun deleteExercise(id: Int): Flow<Unit>
}