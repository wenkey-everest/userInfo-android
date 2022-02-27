package com.everest.userinfo.validation

import android.util.Patterns
import android.widget.Toast
import com.everest.userinfo.HomeActivity
import com.everest.userinfo.databinding.ActivityHomeBinding

class TextFieldValidation {

    fun validateUserName(binding: ActivityHomeBinding, homeActivity: HomeActivity) : Boolean{
        if(binding.userName.editText?.text.toString().trim().isEmpty()){
            binding.userName.error="user name is required"
            Toast.makeText(homeActivity,binding.userName.error, Toast.LENGTH_SHORT).show()
            return false
        }
        binding.userName.isErrorEnabled = false
        return true
    }

    fun validateEmail(binding: ActivityHomeBinding, homeActivity: HomeActivity) : Boolean{

        if(binding.email.editText?.text.toString().isEmpty()){
            binding.email.error="email is required"
            Toast.makeText(homeActivity,binding.email.error, Toast.LENGTH_SHORT).show()
            return false
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(binding.email.editText?.text.toString()).matches()){
            binding.email.error="email should contains @ and .com or .co.in "
            Toast.makeText(homeActivity,binding.email.error, Toast.LENGTH_SHORT).show()
            return false
        }
        binding.email.isErrorEnabled = false
        return true
    }

    fun validatePhoneNumber(binding: ActivityHomeBinding, homeActivity: HomeActivity) : Boolean{
            if(binding.phoneNumber.editText?.text.toString().length!=10){
                binding.phoneNumber.error= "Phone number should be length 10"
                Toast.makeText(homeActivity,binding.phoneNumber.error, Toast.LENGTH_SHORT).show()
                return false
            }
        if(binding.phoneNumber.editText?.text.toString().isEmpty()){
            binding.phoneNumber.error="Phone number should not be empty"
            Toast.makeText(homeActivity,binding.phoneNumber.error, Toast.LENGTH_SHORT).show()
            return false
        }

        binding.phoneNumber.isErrorEnabled=false
        return true
    }

    fun validatePinCode(binding: ActivityHomeBinding, homeActivity: HomeActivity) : Boolean{
        if(binding.pinCode.editText?.text.toString().length!=6){
            binding.pinCode.error="Pincode should be only length 6"
            Toast.makeText(homeActivity,binding.pinCode.error, Toast.LENGTH_SHORT).show()
            return false
        }
        if(binding.pinCode.editText?.text.toString().isEmpty()){
            binding.pinCode.error="Phone number should not be empty"
            Toast.makeText(homeActivity,binding.pinCode.error, Toast.LENGTH_SHORT).show()
            return false
        }
        binding.pinCode.isErrorEnabled=false
        return true
    }

    fun validateAddress(binding: ActivityHomeBinding, homeActivity: HomeActivity) : Boolean{
        if(binding.address.editText?.text.toString().isEmpty()){
            binding.address.error="Address should not be empty"
            Toast.makeText(homeActivity,binding.address.error, Toast.LENGTH_SHORT).show()
            return false
        }
        binding.address.isErrorEnabled=false
        return true
    }


}