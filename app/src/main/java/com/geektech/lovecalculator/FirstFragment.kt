package com.geektech.lovecalculator

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.geektech.lovecalculator.databinding.FirstFragmentBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class FirstFragment: Fragment() {
    private lateinit var binding: FirstFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FirstFragmentBinding.inflate(inflater, container, false)
        return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initeClicker()
    }

    private fun initeClicker() {
        with(binding){
            btnSend.setOnClickListener {
                LoveService().api.calculatePercentage(
                    firstName = etFirstName.text.toString(),
                    secondName = etSecondName.text.toString()
                ).enqueue(object : Callback<LoveModel> {
                    override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                        if (response.isSuccessful){
                            Log.e("kani", "onResponse: ${response.body()}", )
                            findNavController().navigate(R.id.secondFragment,
                                bundleOf(NAME to response.body()))
                        }
                    }

                    override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                        Log.e("kani", "onFailure: ${t.message}", )
                    }

                })
            }
        }
    }

    companion object{
        const val NAME = "NAME"
    }

}