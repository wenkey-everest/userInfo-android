package com.everest.userinfo

import SUMMERY_CARD
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.everest.userinfo.databinding.ActivityHomeBinding
import com.everest.userinfo.models.User
import com.everest.userinfo.validation.TextFieldValidation
import SUMMERY_CARD_VISIBILITY
import USER
import USER_FORM
import USER_FORM_VISIBILITY
import android.widget.EditText

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.validateButton.setOnClickListener {
            if (isValidate()) {
                summeryCard()
            }
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(USER_FORM_VISIBILITY, binding.editForm.visibility)
        outState.putInt(SUMMERY_CARD_VISIBILITY, binding.summeryCard.visibility)

        val editTextParcelable = User(
            binding.nameId.text.toString(),
            binding.emailId.text.toString(), binding.phoneNumberId.text.toString(),
            binding.pinCodeId.text.toString(), binding.addressId.text.toString()
        )
        val textViewParcelable = User(
            binding.userName.editText?.text.toString(),
            binding.email.editText?.text.toString(), binding.phoneNumber.editText?.text.toString(),
            binding.pinCode.editText?.text.toString(), binding.address.editText?.text.toString()
        )

        outState.putParcelable(USER_FORM, editTextParcelable)
        outState.putParcelable(SUMMERY_CARD, textViewParcelable)

        super.onSaveInstanceState(outState)

    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        binding.editForm.visibility = savedInstanceState.getInt(USER_FORM_VISIBILITY, View.GONE)
        binding.summeryCard.visibility =
            savedInstanceState.getInt(SUMMERY_CARD_VISIBILITY, View.VISIBLE)

        val summeryCardDetails = savedInstanceState.getParcelable<User>(SUMMERY_CARD)
        val formInputs = savedInstanceState.getParcelable<User>(USER_FORM)

        binding.userName.editText?.setText(summeryCardDetails?.userName)
        binding.email.editText?.setText(summeryCardDetails?.email)
        binding.phoneNumber.editText?.setText(summeryCardDetails?.phoneNumber)
        binding.pinCode.editText?.setText(summeryCardDetails?.pinCode)
        binding.address.editText?.setText(summeryCardDetails?.address)

        binding.nameId.text = formInputs?.userName
        binding.emailId.text = formInputs?.email
        binding.phoneNumberId.text = formInputs?.phoneNumber
        binding.pinCodeId.text = formInputs?.pinCode
        binding.addressId.text = formInputs?.address

        onClickConformButton()

        onClickCancelButton()

        super.onRestoreInstanceState(savedInstanceState)


    }

    private fun isValidate(): Boolean {
        val textFieldValidation = TextFieldValidation(this)

        return textFieldValidation.validateUserName(binding.userName.editText?.text.toString()) &&
                textFieldValidation.validateEmail(binding.email.editText?.text.toString())
                && textFieldValidation.validatePhoneNumber(binding.phoneNumber.editText?.text.toString())
                && textFieldValidation.validatePinCode(binding.pinCode.editText?.text.toString())
                && textFieldValidation.validateAddress(binding.address.editText?.text.toString())
    }


    private fun summeryCard() {
        binding.editForm.visibility = View.GONE
        binding.summeryCard.visibility = View.VISIBLE
        binding.nameId.text = binding.userName.editText?.text.toString()
        binding.emailId.text = binding.email.editText?.text.toString()
        binding.phoneNumberId.text = binding.phoneNumber.editText?.text.toString()
        binding.pinCodeId.text = binding.pinCode.editText?.text.toString()
        binding.addressId.text = binding.address.editText?.text.toString()

        onClickConformButton()

        onClickCancelButton()

    }

    private fun onClickConformButton() {
        binding.confirmButton.setOnClickListener {
            val intent = Intent(this, ContactActivity::class.java)

            val user = User(
                binding.nameId.text.toString(),
                binding.emailId.text.toString(), binding.phoneNumberId.text.toString(),
                binding.pinCodeId.text.toString(), binding.addressId.text.toString()
            )
            intent.putExtra(USER, user)
            startActivity(intent)
        }
    }

    private fun onClickCancelButton() {
        binding.cancelButton.setOnClickListener {
            binding.summeryCard.visibility = View.GONE
            binding.editForm.visibility = View.VISIBLE
        }
    }

}
