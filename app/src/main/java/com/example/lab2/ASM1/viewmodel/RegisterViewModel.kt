package com.example.lab2.ASM1.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lab2.ASM1.model.RegisterRequest
import com.example.lab2.ASM1.network.RetrofitClient
import kotlinx.coroutines.launch

class RegisterViewModel : ViewModel() {
    var registrationSuccess = mutableStateOf(false)
        private set

    var registrationMessage = mutableStateOf("")
        private set

    fun registerUser(email: String, password: String, fullname: String) {
        viewModelScope.launch {
            try {
                val request = RegisterRequest(email, password, fullname)
                val response = RetrofitClient.apiService.registerUser(request)
                registrationSuccess.value = true
                registrationMessage.value = response.message
                Log.d("RegisterViewModel", "Registration successful: ${response.message}")
            } catch (e: Exception) {
                registrationSuccess.value = false
                registrationMessage.value = "Failed to register: ${e.message}"
                Log.e("RegisterViewModel", "Failed to register: ${e.message}", e)
            }
        }
    }
}
