package com.example.socialcompose.ui.utils

import android.text.TextUtils
import android.util.Patterns
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue


class Validation {
    fun isValidEmail(target: String): Boolean {

        return target.trim().isNotBlank() && Patterns.EMAIL_ADDRESS.matcher(target).matches()
    }


    fun validatePassword(input: String) = when {
        input.isBlank() -> {
            "Password is required field"
        }
        input.length < 6 -> {
            "Length of the password should be greater than 7"
        }
        input.length > 15 -> {
            "Length of the password should be less than 15"
        }
        else -> {
            "Valid"
        }
    }
}


