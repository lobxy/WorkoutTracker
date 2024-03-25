package com.lovish.workouttracker.common

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class WorkoutTrackerApp : Application() {

    override fun onCreate() {
        super.onCreate()

    }

}