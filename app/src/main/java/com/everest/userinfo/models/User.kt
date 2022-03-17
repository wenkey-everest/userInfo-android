package com.everest.userinfo.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User( var userName:String,  var email : String,
         var phoneNumber : String,  var pinCode : String,
         var address : String) : Parcelable {


}