package com.everest.userinfo

import address
import addressCd
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.everest.userinfo.databinding.ActivityHomeBinding
import com.everest.userinfo.validation.TextFieldValidation
import email
import emailCd
import phone_number
import phone_number_Cd
import pin_code
import pin_codeCd
import summery_card
import userName
import userNameCd
import user_form

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.validateButton.setOnClickListener {
            if (isValidate()) {
                showSummeryCardView()
            }
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(user_form, binding.editForm.visibility)
        outState.putInt(summery_card, binding.summeryCard.visibility)
        super.onSaveInstanceState(outState)

        outState.putString(userName, binding.nameId.text.toString())
        outState.putString(email, binding.emailId.text.toString())
        outState.putString(phone_number, binding.phoneNumberId.text.toString())
        outState.putString(pin_code, binding.pinCodeId.text.toString())
        outState.putString(address, binding.addressId.text.toString())

        outState.putCharSequence(userNameCd, binding.userName.editText?.text.toString())
        outState.putCharSequence(emailCd, binding.email.editText?.text.toString())
        outState.putCharSequence(phone_number_Cd, binding.phoneNumber.editText?.text.toString())
        outState.putCharSequence(pin_codeCd, binding.pinCode.editText?.text.toString())
        outState.putCharSequence(addressCd, binding.address.editText?.text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        binding.editForm.visibility = savedInstanceState.getInt(user_form, View.GONE)
        binding.summeryCard.visibility = savedInstanceState.getInt(summery_card, View.VISIBLE)

        super.onRestoreInstanceState(savedInstanceState)

        binding.userName.editText?.setText(savedInstanceState.getCharSequence(userNameCd))
        binding.email.editText?.setText(savedInstanceState.getCharSequence(emailCd))
        binding.phoneNumber.editText?.setText(savedInstanceState.getCharSequence(phone_number_Cd))
        binding.pinCode.editText?.setText(savedInstanceState.getCharSequence(pin_codeCd))
        binding.address.editText?.setText(savedInstanceState.getCharSequence(addressCd))

        binding.nameId.text = savedInstanceState.getString(userName)
        binding.emailId.text = savedInstanceState.getString(email)
        binding.phoneNumberId.text = savedInstanceState.getString(phone_number)
        binding.pinCodeId.text = savedInstanceState.getString(pin_code)
        binding.addressId.text = savedInstanceState.getString(address)

        conformButton()
        cancelButton()

    }


    private fun isValidate(): Boolean {
        val textFieldValidation = TextFieldValidation(binding, this)
        return textFieldValidation.validateUserName() &&
                textFieldValidation.validateEmail()
                && textFieldValidation.validatePhoneNumber()
                && textFieldValidation.validatePinCode()
                && textFieldValidation.validateAddress()
    }
    private fun showSummeryCardView() {
        binding.editForm.visibility = View.GONE
        binding.summeryCard.visibility = View.VISIBLE
        binding.nameId.text = binding.userName.editText?.text.toString()
        binding.emailId.text = binding.email.editText?.text.toString()
        binding.phoneNumberId.text = binding.phoneNumber.editText?.text.toString()
        binding.pinCodeId.text = binding.pinCode.editText?.text.toString()
        binding.addressId.text = binding.address.editText?.text.toString()

        conformButton()

        cancelButton()

    }

    private fun conformButton() {
        binding.confirmButton.setOnClickListener {
            val intent = Intent(this, ContactActivity::class.java)
            intent.putExtra(userNameCd, binding.nameId.text.toString())
            intent.putExtra(emailCd, binding.emailId.text.toString())
            intent.putExtra(phone_number_Cd, binding.phoneNumberId.text.toString())
            intent.putExtra(pin_codeCd,binding.pinCodeId.text.toString())
            intent.putExtra(addressCd, binding.addressId.text.toString())
            startActivity(intent)
        }
    }


    private fun cancelButton() {
        binding.cancelButton.setOnClickListener {
            binding.summeryCard.visibility = View.GONE
            binding.editForm.visibility = View.VISIBLE
        }
    }



}