package com.geektech.lovecalculator.repository

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.MutableLiveData
import com.geektech.lovecalculator.R
import com.geektech.lovecalculator.SecondFragment
import com.geektech.lovecalculator.remote.LoveModel
import com.geektech.lovecalculator.remote.LoveService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {

    fun getLove(fisrtname:String, secondName:String): MutableLiveData<LoveModel>{

        val liveLoveData = MutableLiveData<LoveModel>()
        LoveService().api.calculatePercentage(fisrtname,secondName).enqueue(object: Callback<LoveModel>{
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