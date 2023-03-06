package com.geektech.lovecalculator.repository

import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.geektech.lovecalculator.remote.LoveApi
import com.geektech.lovecalculator.remote.LoveModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor(val api:LoveApi){

    fun getLove(fisrtname:String, secondName:String): MutableLiveData<LoveModel>{

        val liveLoveData = MutableLiveData<LoveModel>()
        api.calculatePercentage(fisrtname,secondName).enqueue(object: Callback<LoveModel>{
            override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                if (response.isSuccessful){
                    liveLoveData.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                Log.e("kani", "onFailure: ${t.message}", )
            }

        })
        return liveLoveData
    }
}