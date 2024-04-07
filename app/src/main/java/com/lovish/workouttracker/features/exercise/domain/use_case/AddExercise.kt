package com.lovish.workouttracker.features.exercise.domain.use_case

import com.lovish.workouttracker.common.Resource
import com.lovish.workouttracker.features.exercise.data.entity.ExerciseEntity
import com.lovish.workouttracker.features.exercise.domain.repository.ExerciseRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AddExercise @Inject constructor(private val repository: ExerciseRepository) {

    fun invoke(exerciseEntity: ExerciseEntity): Flow<Resource<Long>> = flow {

        if (exerciseEntity.title.isNullOrBlank()) {
            emit(Resource.Error(AddExercisesErrors.TITLE_EMPTY.ordinal))
            return@flow
        }

        if (exerciseEntity.description.isNullOrBlank()) {
            emit(Resource.Error(AddExercisesErrors.DESCRIPTION_EMPTY.ordinal))
            return@flow
        }

        repository.insertExercise(exerciseEntity)
    }

}
