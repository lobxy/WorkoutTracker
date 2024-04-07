package com.lovish.workouttracker.features.exercise.domain.use_case

import com.lovish.workouttracker.common.Resource
import com.lovish.workouttracker.features.exercise.domain.model.Exercise
import com.lovish.workouttracker.features.exercise.domain.repository.ExerciseRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetExercises @Inject constructor(private val repository: ExerciseRepository) {

    operator fun invoke(id: Int): Flow<Resource<List<Exercise>>> {
        return if (id == -1) {
            repository.getAllExercises()
        } else {
            repository.getExerciseById(id)
        }
    }

}