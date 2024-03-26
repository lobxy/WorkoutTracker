package com.lovish.workouttracker.features.exercise.di

import com.lovish.workouttracker.db.WorkoutTrackerDB
import com.lovish.workouttracker.features.exercise.data.ExerciseDAO
import com.lovish.workouttracker.features.exercise.data.repository.ExerciseRepositoryImpl
import com.lovish.workouttracker.features.exercise.domain.repository.ExerciseRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class ExerciseModule {

    @Provides
    fun providesExerciseDAO(appDatabase: WorkoutTrackerDB): ExerciseDAO {
        return appDatabase.exerciseDAO()
    }

    @Provides
    fun providesMainRepository(exerciseDAO: ExerciseDAO): ExerciseRepository {
        return ExerciseRepositoryImpl(exerciseDAO)
    }

}