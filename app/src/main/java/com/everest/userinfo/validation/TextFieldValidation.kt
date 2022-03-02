package com.everest.userinfo.validation

import android.util.Patterns
import android.widget.Toast
import com.everest.userinfo.HomeActivity
import com.everest.userinfo.databinding.ActivityHomeBinding
import com.google.android.material.textfield.TextInputLayout

class TextFieldValidation constructor(private var homeActivity: HomeActivity ) {

    fun validateUserName(userName: TextInputLayout): Boolean{
        if(userName.editText?.text.toString().trim().isEmpty()){
            userName.error="user name is required"
            Toast.makeText(homeActivity,userName.error, Toast.LENGTH_SHORT).show()
            return false
        }
        userName.isErrorEnabled = false
        return true
    }

    fun validateEmail(email: TextInputLayout) : Boolean{

        if(email.editText?.text.toString().isEmpty()){
            email.error="email is required"
            Toast.makeText(homeActivity,email.error, Toast.LENGTH_SHORT).show()
            return false
        }
        if(!email.editText?.text.toString().trim().matches(Regex("^[A-za-z0-9_.-]+@[a-z]+\\.+(com|co.in)"))){
            email.error="email should contains @ and .com or .co.in "
            Toast.makeText(homeActivity,email.error, Toast.LENGTH_SHORT).show()
            return false
        }
        email.isErrorEnabled = false
        return true
    }

    fun validatePhoneNumber(phoneNumber : TextInputLayout) : Boolean{
            if(phoneNumber.editText?.text.toString().length!=10){
                phoneNumber.error= "Phone number should be length 10"
                Toast.makeText(homeActivity,phoneNumber.error, Toast.LENGTH_SHORT).show()
                return false
            }

        if(phoneNumber.editText?.text.toString().isEmpty()){
            phoneNumber.error="Phone number should not be empty"
            Toast.makeText(homeActivity,phoneNumber.error, Toast.LENGTH_SHORT).show()
            return false
        }

        phoneNumber.isErrorEnabled=false
        return true
    }

    fun validatePinCode(pinCode: TextInputLayout) : Boolean{
        if(pinCode.editText?.text.toString().length!=6){
            pinCode.error="Pincode should be only length 6"
            Toast.makeText(homeActivity,pinCode.error, Toast.LENGTH_SHORT).show()
            return false
        }
        if(pinCode.editText?.text.toString().isEmpty()){
            pinCode.error="Phone number should not be empty"
            Toast.makeText(homeActivity,pinCode.error, Toast.LENGTH_SHORT).show()
            return false
        }
        pinCode.isErrorEnabled=false
        return true
    }

    fun validateAddress(address : TextInputLayout) : Boolean{
        if(address.editText?.text.toString().isEmpty()){
            address.error="Address should not be empty"
            Toast.makeText(homeActivity,address.error, Toast.LENGTH_SHORT).show()
            return false
        }
        address.isErrorEnabled=false
        return true
    }


}