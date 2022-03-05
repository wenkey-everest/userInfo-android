package com.everest.userinfo.validation

import android.content.Context
import android.content.ContextWrapper
import android.widget.Toast
import com.everest.userinfo.R

class TextFieldValidation(homeActivity: Context?) : ContextWrapper(homeActivity) {

    fun validateUserName(userName: String): Boolean {
        if (userName.trim().isEmpty()) {
            toastMessage(getString(R.string.user_name_validation_test))
            return false
        }
        return true
    }

    fun validateEmail(email: String): Boolean {

        if (email.trim().isEmpty()) {
            toastMessage(getString(R.string.email_field_validate))
            return false
        }
        if (!email.trim()
                .matches(Regex("^[A-za-z0-9_.-]+@[a-z]+\\.+(com|co.in)"))
        ) {
            toastMessage(getString(R.string.email_should_be_end_with))
            return false
        }
        return true
    }

    fun validatePhoneNumber(phoneNumber: String): Boolean {
        if (phoneNumber.trim().length != 10) {
            toastMessage(getString(R.string.password_contains_10_digits))
            return false
        }

        if (phoneNumber.trim().isEmpty()) {
            toastMessage(getString(R.string.password_should_not_empty))
            return false
        }

        return true
    }

    fun validatePinCode(pinCode: String): Boolean {
        if (pinCode.trim().length != 6) {
            toastMessage(getString(R.string.pincode_should_be_6))
            return false
        }
        if (pinCode.trim().isEmpty()) {
            toastMessage(getString(R.string.pin_code_should_not_be_empty))
            return false
        }
        return true
    }

    fun validateAddress(address: String): Boolean {
        if (address.isEmpty()) {
            toastMessage(getString(R.string.address_should_not_be_empty))
            return false
        }
        return true
    }

    private fun toastMessage(string: String) {
        Toast.makeText(
            this,
            string,
            Toast.LENGTH_SHORT
        ).show()
    }
}