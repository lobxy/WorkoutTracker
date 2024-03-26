package com.lovish.workouttracker.di

import android.content.Context
import androidx.room.Room
import com.lovish.workouttracker.common.Constants
import com.lovish.workouttracker.db.WorkoutTrackerDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class CoreModule {

    @Provides
    @Singleton
    fun providesAppDatabase(@ApplicationContext context: Context): WorkoutTrackerDB {
        return Room.databaseBuilder(
            context, WorkoutTrackerDB::class.java, Constants.APP_DATABASE_NAME
        ).fallbackToDestructiveMigration().build()
    }

}