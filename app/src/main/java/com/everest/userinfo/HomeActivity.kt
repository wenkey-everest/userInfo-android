package com.everest.userinfo

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.everest.userinfo.databinding.ActivityHomeBinding
import com.everest.userinfo.validation.TextFieldValidation

class HomeActivity : AppCompatActivity() {

    private lateinit var binding : ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.validateButton.setOnClickListener {
            if(isValidate()) {
               onClick()

            }
        }

    }

    private fun isValidate(): Boolean {
       return TextFieldValidation().validateUserName(binding, this) &&
                TextFieldValidation().validateEmail(binding, this)
                && TextFieldValidation().validatePhoneNumber(binding, this)
               && TextFieldValidation().validatePinCode(binding, this)
               && TextFieldValidation().validateAddress(binding, this)
    }


    private fun onClick(){
        binding.editForm.visibility = View.GONE
        binding.summeryCard.visibility = View.VISIBLE
        binding.nameId.text = binding.userName.editText?.text.toString()
        binding.emailId.text = binding.email.editText?.text.toString()
        binding.phoneNumberId.text = binding.phoneNumber.editText?.text.toString()
        binding.pinCodeId.text = binding.pinCode.editText?.text.toString()
        binding.addressId.text = binding.address.editText?.text.toString()

        binding.confirmButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        binding.cancelButton.setOnClickListener {
            binding.summeryCard.visibility = View.GONE
            binding.editForm.visibility = View.VISIBLE
        }
    }


}