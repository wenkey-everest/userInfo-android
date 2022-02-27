package com.everest.userinfo

import android.os.Bundle
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
                Toast.makeText(this, "All fields are validated", Toast.LENGTH_LONG)
                    .show()
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

}