package com.example.ehealthapp.repository

import com.example.ehealthapp.dao.HealthDao
import com.example.ehealthapp.model.Health
import kotlinx.coroutines.flow.Flow

class HealthRepository(private val healthDao: HealthDao) {
    val allHealth: Flow<List<Health>> = healthDao.getAllHealth()

    suspend fun insertHealth(health: Health){
        healthDao.insertHealth(health)
    }
    suspend fun deleteHealth(health: Health){
        healthDao.deleteHealth(health)
    }
    suspend fun updateHealth(health: Health){
        healthDao.updateHealth(health)
    }
}