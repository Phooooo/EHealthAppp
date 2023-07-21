package com.example.ehealthapp.application

import android.app.Application
import com.example.ehealthapp.repository.HealthRepository

class HealthApp: Application() {
    val database by lazy {HealthDatabase.getDatabase(this) }
    val repository by lazy { HealthRepository(database.healthDao()) }
}