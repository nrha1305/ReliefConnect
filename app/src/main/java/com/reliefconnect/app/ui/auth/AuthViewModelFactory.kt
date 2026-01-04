package com.reliefconnect.app.ui.auth

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.reliefconnect.app.data.DataStoreManager

class AuthViewModelFactory(
    private val context: Context
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return AuthViewModel(
            DataStoreManager(context)
        ) as T
    }
}
