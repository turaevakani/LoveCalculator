package com.geektech.lovecalculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.geektech.lovecalculator.FirstFragment.Companion.LOVE_DATA
import com.geektech.lovecalculator.databinding.SecondFragmentBinding
import com.geektech.lovecalculator.remote.LoveModel
import com.geektech.lovecalculator.viewmodel.LoveViewModel


class SecondFragment: Fragment() {

    private lateinit var binding: SecondFragmentBinding
    private val viewModel: LoveViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SecondFragmentBinding.inflate(inflater, container, false)
        return  binding.root
    }
    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val inputData =arguments?.getSerializable(LOVE_DATA) as LoveModel
        with(binding){
            tvFirstName.text = inputData.firstName
            tvSecondName.text = inputData.secondName
            tvPercentage.text = inputData.percentage +"%"
            tvResult.text = inputData.result
            btnTry.setOnClickListener{
                findNavController().navigateUp()
            }
            btnHistory.setOnClickListener {
                findNavController().navigate(R.id.historyFragment)
            }

        }

    }

}