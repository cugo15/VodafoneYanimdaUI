package com.cumhurcugogunay.vodafoneyanimda.data.entity

import java.io.Serializable

data class Tarifelerim(var id : Int,
                       var tarifeAd : String,
                       var kalanGb : Double,
                       var toplamGb : Int,
                       var sonTarih : String,
                       var sinirsiz : Boolean) : Serializable {
}