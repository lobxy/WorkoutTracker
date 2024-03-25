package com.lovish.workouttracker.features.exercise.data

import androidx.room.Dao
import androidx.room.Upsert
import com.lovish.workouttracker.features.exercise.data.entity.ExerciseEntity

@Dao
interface ExerciseDAO {

    @Upsert
    suspend fun upsertExercise(exerciseEntity: ExerciseEntity)

}