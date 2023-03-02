package com.geektech.lovecalculator.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.geektech.lovecalculator.remote.LoveModel
import com.geektech.lovecalculator.repository.Repository

class LoveViewModel: ViewModel() {

    private val repository = Repository()

    fun getLiveLove(fisrtname:String, secondName:String):LiveData<LoveModel>{
        return repository.getLove(fisrtname, secondName)
    }
}