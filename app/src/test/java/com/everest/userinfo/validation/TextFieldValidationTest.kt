package com.everest.userinfo.validation

import android.arch.core.executor.testing.InstantTaskExecutorRule
import android.os.Looper
import com.everest.userinfo.HomeActivity
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import io.mockk.mockkClass
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runner.manipulation.Ordering
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

@RunWith(JUnit4::class)
class TextFieldValidationTest {

    private lateinit var textFieldValidation : TextFieldValidation

    @Before
    fun setUp() {
        val context = mockkClass(HomeActivity::class)
        textFieldValidation = TextFieldValidation(context)
    }

    @Test
    fun emailShouldBeInCorrectFormat() {
        assertTrue(textFieldValidation.validateEmail("wenkey@gmail.com"))

    }

    @Test
    fun isValidPinCode() {
        assertTrue(textFieldValidation.validatePinCode("524132"))
    }

    @Test
    fun isValidPhone() {
        assertTrue(textFieldValidation.validatePhoneNumber("7330732647"))
    }

    @Test
    fun isValidUserName() {
        assertTrue(textFieldValidation.validateUserName("wenkey"))
    }

    @Test
    fun isValidAddress() {
        assertTrue(textFieldValidation.validateAddress("18-4622, something street"))
    }
}