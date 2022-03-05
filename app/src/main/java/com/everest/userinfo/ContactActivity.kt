package com.everest.userinfo

import addressCd
import android.annotation.SuppressLint
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.everest.userinfo.databinding.ActivityContactBinding
import emailCd
import phone_number_Cd
import pin_codeCd
import userNameCd

class ContactActivity : AppCompatActivity() {

    private lateinit var binding: ActivityContactBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val userName = intent.getStringExtra(userNameCd)
        val email = intent.getStringExtra(emailCd)
        val phoneNumber = intent.getStringExtra(phone_number_Cd)
        val pinCode = intent.getStringExtra(pin_codeCd)
        val address = intent.getStringExtra(addressCd)

       val userParagraph = String.format(resources.getString(R.string.user_paragraph), userName, address, pinCode, phoneNumber, email)

        binding.paragraph.text = userParagraph

    }
}