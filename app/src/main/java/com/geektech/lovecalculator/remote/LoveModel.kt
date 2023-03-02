package com.geektech.lovecalculator.remote

import com.google.gson.annotations.SerializedName
import java.io.Serializable

//{
//    "fname": "Akylai",
//    "sname": "Aktan",
//    "percentage": "55",
//    "result": "All the best!"
//}
data class LoveModel(
    @SerializedName("fname")
    var firstName: String,
    @SerializedName("sname")
    var secondName: String,
    var percentage: String,
    var result: String
) : Serializable
