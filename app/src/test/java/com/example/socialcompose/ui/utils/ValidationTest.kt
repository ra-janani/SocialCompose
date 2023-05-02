package com.example.socialcompose.ui.utils

import org.junit.Assert.*

import org.junit.Test

class ValidationTest {




    @Test
    fun validatePassword_blank_expectedRequired() {
        val sut = Validation()
        val result = sut.validatePassword("  ")
        assertEquals("Password is required field", result)
    }


    @Test
    fun validatePassword_CorrectPass_expectedValid() {
        val sut = Validation()
        val result = sut.validatePassword("Pass123")
        assertEquals("Valid", result)
    }


   /* @Test
    fun validatePassword_2CharLong_expectedLengthErr() {
        val sut = Validation()
        val result = sut.validatePassword(" .")
        assertEquals("Length of the password should be greater than 6", result)
    }*/
}