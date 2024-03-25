package com.lovish.workouttracker.features.exercise.data

import androidx.room.Dao
import androidx.room.Upsert

@Dao
interface ExerciseDAO {

    @Upsert
    fun upsertExercise()

}