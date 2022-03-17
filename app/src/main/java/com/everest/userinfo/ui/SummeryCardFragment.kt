package com.everest.userinfo.ui

import USER
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.everest.userinfo.ContactActivity
import com.everest.userinfo.R
import com.everest.userinfo.databinding.SummeryCardFragmentBinding
import com.everest.userinfo.models.User
import com.everest.userinfo.models.UserViewModal

class SummeryCardFragment : Fragment() {

    private lateinit var binding: SummeryCardFragmentBinding

    private lateinit var viewModal: UserViewModal

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = SummeryCardFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModal=ViewModelProvider(requireActivity())[UserViewModal::class.java]
        viewModal.user.observe(viewLifecycleOwner, Observer {
            binding.nameId.text = viewModal.user.value?.userName.toString()
            binding.emailId.text = viewModal.user.value?.email.toString()
            binding.phoneNumberId.text = viewModal.user.value?.phoneNumber.toString()
            binding.pinCodeId.text = viewModal.user.value?.pinCode.toString()
            binding.addressId.text = viewModal.user.value?.address.toString()
        })

        onClickConformButton()

        onClickCancelButton()

    }
    private fun onClickConformButton() {
        binding.confirmButton.setOnClickListener {
            val intent = Intent(requireContext(), ContactActivity::class.java)

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
           findNavController().navigate(R.id.action_summeryCardFragment_to_editFormFragment)
        }
    }


}