package com.geektech.lovecalculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.geektech.lovecalculator.databinding.SecondFragmentBinding

@Suppress("DEPRECATION")
class SecondFragment: Fragment() {

    private lateinit var binding: SecondFragmentBinding

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
        val name =arguments?.getSerializable(FirstFragment.NAME) as LoveModel
        with(binding){
            tvFirstName.text = name.firstName
            tvSecondName.text = name.secondName
            tvPercentage.text = name.percentage +"%"
            tvResult.text = name.result
            btnTry.setOnClickListener {
                findNavController().navigateUp()
            }

        }
    }

}