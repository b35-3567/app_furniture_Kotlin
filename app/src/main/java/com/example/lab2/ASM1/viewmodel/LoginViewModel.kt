package com.example.lab2.ASM1.viewmodel



import android.content.Context
import android.content.SharedPreferences
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lab2.ASM1.model.LoginRequest
import com.example.lab2.ASM1.network.RetrofitClient
import kotlinx.coroutines.launch

class LoginViewModel(private val context: Context) : ViewModel() {
    var loginSuccess = mutableStateOf(false)
    var loginMessage = mutableStateOf("")

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("MyAppPrefs", Context.MODE_PRIVATE)

    fun loginUser(email: String, password: String) {
        viewModelScope.launch {
            try {
                val request = LoginRequest(email, password)
                val response = RetrofitClient.apiService.loginUser(request)
                loginMessage.value = response.message
                loginSuccess.value = response.message == "Logged in successfully"

                if (loginSuccess.value) {
                    saveLoginState(email)
                }
            } catch (e: Exception) {
                loginMessage.value = "Failed to login: ${e.message}"
                loginSuccess.value = false
            }
        }
    }

    private fun saveLoginState(email: String) {
        val editor = sharedPreferences.edit()
        editor.putBoolean("loggedIn", true)
        editor.putString("email", email)
        editor.apply()
    }
}
