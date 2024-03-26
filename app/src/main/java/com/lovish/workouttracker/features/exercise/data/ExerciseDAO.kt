package com.lovish.workouttracker.features.exercise.data

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.lovish.workouttracker.features.exercise.data.entity.ExerciseEntity

@Dao
interface ExerciseDAO {

    @Query("SELECT * FROM ExerciseEntity")
    suspend fun getAllExercises(): List<ExerciseEntity>

    @Query("SELECT * FROM ExerciseEntity WHERE primaryKey =:id")
    suspend fun getExerciseById(id: Int): List<ExerciseEntity>

    @Upsert
    suspend fun upsertExercise(exerciseEntity: ExerciseEntity): Long

    @Query("DELETE FROM ExerciseEntity where primaryKey =:id")
    suspend fun deleteExercise(id: Int)

}