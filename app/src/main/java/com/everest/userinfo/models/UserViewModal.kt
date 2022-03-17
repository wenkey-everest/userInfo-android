package com.everest.userinfo.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserViewModal : ViewModel() {

    private var _user = MutableLiveData<User>()

    val user :LiveData<User> = _user

    fun setUser(newUser : User){
        _user.value=newUser
    }

}