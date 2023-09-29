package com.cumhurcugogunay.vodafoneyanimda.data.entity

import java.io.Serializable

data class Stories(var id : Int,
                   var name : String,
                   var img : String,
                   var star : Boolean,
                   var yellowStar : Boolean) : Serializable {
}