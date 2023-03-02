package com.geektech.lovecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.geektech.lovecalculator.databinding.ActivityMainBinding
import com.geektech.lovecalculator.viewmodel.LoveViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        if (savedInstanceState==null){
//            supportFragmentManager.beginTransaction().add(R.id.fragment_container, FirstFragment()).commit()
//        }
    }
}