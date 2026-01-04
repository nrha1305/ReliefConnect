package com.reliefconnect.app.ui.auth

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.reliefconnect.app.data.DataStoreManager
import kotlinx.coroutines.launch

class AuthViewModel (
    private val dataStoreManager: DataStoreManager
) : ViewModel() {

    var isLoggedIn = mutableStateOf(false)
        private set

    init {
        viewModelScope.launch {
            dataStoreManager.isLoggedIn.collect {
                isLoggedIn.value = it
            }
        }
    }

    fun login() {
        viewModelScope.launch {
            dataStoreManager.saveLoginState(true)
        }
    }

    fun logout() {
        viewModelScope.launch {
            dataStoreManager.saveLoginState(false)
        }
    }
}
