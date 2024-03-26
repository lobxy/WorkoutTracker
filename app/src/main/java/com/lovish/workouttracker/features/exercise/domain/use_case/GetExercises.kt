package com.lovish.workouttracker.features.exercise.domain.use_case

import com.lovish.workouttracker.common.Resource
import com.lovish.workouttracker.features.exercise.data.entity.ExerciseEntity
import com.lovish.workouttracker.features.exercise.domain.repository.ExerciseRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetExercises @Inject constructor(private val repository: ExerciseRepository) {

    operator fun invoke(id: Int): Flow<Resource<List<ExerciseEntity>>> {
        return if (id == -1) {
            repository.getAllExercises()
        } else {
            repository.getExerciseById(id)
        }
    }

}