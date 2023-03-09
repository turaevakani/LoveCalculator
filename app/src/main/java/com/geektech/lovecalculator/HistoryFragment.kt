package com.geektech.lovecalculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.geektech.lovecalculator.databinding.FirstFragmentBinding
import com.geektech.lovecalculator.databinding.FragmentHistoryBinding
import com.geektech.lovecalculator.viewmodel.LoveViewModel

class HistoryFragment : Fragment() {

    private lateinit var binding: FragmentHistoryBinding
    private val viewModel: LoveViewModel by viewModels()

    override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
): View? {
        binding =FragmentHistoryBinding.inflate(inflater, container, false)
        return binding.root
}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val list = App.appDatabase.loveDao().getAll()
        var data = ""

        list.forEach{
            data += "${it.firstName}\n ${it.secondName}\n ${it.percentage}\n ${it.result}\n"
        }
        binding.tvResult.text = data
    }



}