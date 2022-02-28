package com.everest.userinfo

import addressCd
import android.annotation.SuppressLint
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

        binding.paragraph.text= "Hi "+userName+", How are you? Are you staying at "+address+"-"+pinCode+" \n" +
                "code. I am not able to contact you on "+phoneNumber+". Can I \n" +
                "email you the details at "+email+""


    }
}