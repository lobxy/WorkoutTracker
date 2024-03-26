package com.lovish.workouttracker.features.exercise.data.repository

import com.lovish.workouttracker.features.exercise.data.ExerciseDAO
import com.lovish.workouttracker.features.exercise.data.entity.ExerciseEntity
import com.lovish.workouttracker.features.exercise.domain.repository.ExerciseRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ExerciseRepositoryImpl @Inject constructor(private val dao: ExerciseDAO) : ExerciseRepository {

    override fun getExerciseById(id: Int): Flow<List<ExerciseEntity>> = flow {
        val value = dao.getExerciseById(id)
        emit(value)
    }

    override fun getAllExercises(): Flow<List<ExerciseEntity>> = flow {
        val value = dao.getAllExercises()
        emit(value)
    }

    override fun insertExercise(): Flow<Long> = flow {
        val value = dao.upsertExercise(ExerciseEntity(name = "Hello"))
        emit(value)
    }

    override fun updateExercise(): Flow<Long> = flow {
        val value = dao.upsertExercise(ExerciseEntity(name = "Hello"))
        emit(value)
    }

    override fun deleteExercise(id: Int): Flow<Long> = flow {
        val value = dao.deleteExercise(id)
        emit(value)
    }

}