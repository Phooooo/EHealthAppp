package com.example.ehealthapp.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "health_table")
data class Health  (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val address: String,
    val phonenumber: String,
    val latitude: Double?,
    val longitude: Double?
) : Parcelable