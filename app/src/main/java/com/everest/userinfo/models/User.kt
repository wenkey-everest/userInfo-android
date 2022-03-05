package com.everest.userinfo.models

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parceler
import kotlinx.parcelize.Parcelize

@Parcelize
class User( var userName:String,  var email : String,
         var phoneNumber : String,  var pinCode : String,
         var address : String) : Parcelable {



}