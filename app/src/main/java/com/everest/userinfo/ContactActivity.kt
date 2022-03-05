package com.everest.userinfo

import USER
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.everest.userinfo.databinding.ActivityContactBinding
import com.everest.userinfo.models.User

class ContactActivity : AppCompatActivity() {

    private lateinit var binding: ActivityContactBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val user = intent.getParcelableExtra<User>(USER)

        val userParagraph = String.format(
            resources.getString(R.string.user_paragraph),
            user?.userName, user?.address, user?.pinCode, user?.phoneNumber, user?.email
        )

        binding.paragraph.text = userParagraph

    }
}