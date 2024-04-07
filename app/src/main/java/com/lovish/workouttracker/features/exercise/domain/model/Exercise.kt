package com.lovish.workouttracker.features.exercise.domain.model

import com.lovish.workouttracker.features.exercise.data.entity.ExerciseEntity

data class Exercise(
    val title: String? = null,
    val description: String? = null
) {
    fun toExerciseEntity(): ExerciseEntity {
        return ExerciseEntity()
    }
}
