package com.simplestacktodolist.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity
data class Todo(
    @PrimaryKey(autoGenerate = true) val id: Int = 0, val description: String = "", val date: Long = 0L
) : Parcelable
