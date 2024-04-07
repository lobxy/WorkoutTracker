package com.lovish.workouttracker.features.exercise.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.lovish.workouttracker.features.exercise.domain.model.Exercise

@Entity
data class ExerciseEntity(
    @PrimaryKey(autoGenerate = true) val primaryKey: Int = 0, @ColumnInfo val title: String? = null, @ColumnInfo val description: String? = null
) {
    fun toExercise(): Exercise {
        return Exercise(title = title, description = description)
    }

}