package com.everest.userinfo.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.everest.userinfo.R
import com.everest.userinfo.databinding.EditformFragmentBinding
import com.everest.userinfo.models.User
import com.everest.userinfo.models.UserViewModal
import com.everest.userinfo.validation.TextFieldValidation

class EditFormFragment :Fragment() {

    private lateinit var binding: EditformFragmentBinding

    private lateinit var viewModal :UserViewModal

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = EditformFragmentBinding.inflate(inflater, container, false)
        viewModal = ViewModelProvider(requireActivity())[UserViewModal::class.java]

        viewModal.user.observe(viewLifecycleOwner, Observer { user->
            binding.userName.editText?.setText(user.userName)
            binding.email.editText?.setText(user.email)
            binding.phoneNumber.editText?.setText(user.phoneNumber)
            binding.pinCode.editText?.setText(user.pinCode)
            binding.address.editText?.setText(user.address)
        })

        binding.validateButton.setOnClickListener {
            if(isValidate()) {
                viewModal.setUser(
                    User(
                        binding.userName.editText?.text.toString(),
                        binding.email.editText?.text.toString(),
                        binding.phoneNumber.editText?.text.toString(),
                        binding.pinCode.editText?.text.toString(),
                        binding.address.editText?.text.toString()
                    )
                )
                findNavController().navigate(R.id.action_editFormFragment_to_summeryCardFragment)
            }
        }

        return binding.root
    }

    private fun isValidate(): Boolean {
        val textFieldValidation = TextFieldValidation(requireActivity())

        return textFieldValidation.validateUserName(binding.userName.editText?.text.toString()) &&
                textFieldValidation.validateEmail(binding.email.editText?.text.toString())
                && textFieldValidation.validatePhoneNumber(binding.phoneNumber.editText?.text.toString())
                && textFieldValidation.validatePinCode(binding.pinCode.editText?.text.toString())
                && textFieldValidation.validateAddress(binding.address.editText?.text.toString())
    }

}