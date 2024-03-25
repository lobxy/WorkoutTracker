package com.lovish.workouttracker.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.lovish.workouttracker.features.exercise.data.ExerciseDAO
import com.lovish.workouttracker.features.exercise.data.entity.ExerciseEntity

@Database([ExerciseEntity::class], version = 1, exportSchema = false)
abstract class WorkoutTrackerDB : RoomDatabase() {

    abstract fun exerciseDAO(): ExerciseDAO

}