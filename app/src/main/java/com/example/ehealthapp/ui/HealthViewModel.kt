package com.example.ehealthapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.ehealthapp.model.Health
import com.example.ehealthapp.repository.HealthRepository
import kotlinx.coroutines.launch

class HealthViewModel (private val repository: HealthRepository): ViewModel() {
    val allHealth: LiveData<List<Health>> = repository.allHealth.asLiveData()

    fun insert(health: Health) = viewModelScope.launch {
        repository.insertHealth(health)
    }

    fun delete(health: Health) = viewModelScope.launch {
        repository.deleteHealth(health)
    }

    fun update(health: Health) = viewModelScope.launch {
        repository.updateHealth(health)
    }
}

class HealthViewModelFactory(private val repository: HealthRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom((HealthViewModel::class.java))){
            return HealthViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}