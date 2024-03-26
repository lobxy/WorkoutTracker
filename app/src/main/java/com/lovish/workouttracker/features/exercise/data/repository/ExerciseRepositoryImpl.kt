package com.lovish.workouttracker.features.exercise.data.repository

import com.lovish.workouttracker.common.Resource
import com.lovish.workouttracker.features.exercise.data.ExerciseDAO
import com.lovish.workouttracker.features.exercise.data.entity.ExerciseEntity
import com.lovish.workouttracker.features.exercise.domain.repository.ExerciseRepository
import com.lovish.workouttracker.features.exercise.domain.use_case.GetExercisesErrors
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ExerciseRepositoryImpl @Inject constructor(private val dao: ExerciseDAO) : ExerciseRepository {

    override fun getExerciseById(id: Int): Flow<Resource<List<ExerciseEntity>>> = flow {
        emit(Resource.Loading())
        val value = dao.getExerciseById(id)
        if (value.isEmpty()) {
            emit(Resource.Error(GetExercisesErrors.EMPTY.ordinal))
        } else {
            emit(Resource.Success(value))
        }
    }

    override fun getAllExercises(): Flow<Resource<List<ExerciseEntity>>> = flow {
        emit(Resource.Loading())
        val value = dao.getAllExercises()
        if (value.isEmpty()) {
            emit(Resource.Error())
        } else {
            emit(Resource.Success(value))
        }
    }

    override fun insertExercise(exerciseEntity: ExerciseEntity): Flow<Long> = flow {
        val value = dao.upsertExercise(exerciseEntity)
        emit(value)
    }

    override fun updateExercise(exerciseEntity: ExerciseEntity): Flow<Long> = flow {
        val value = dao.upsertExercise(exerciseEntity)
        emit(value)
    }

    override fun deleteExercise(id: Int): Flow<Unit> = flow {
        val value = dao.deleteExercise(id)
        emit(value)
    }

}