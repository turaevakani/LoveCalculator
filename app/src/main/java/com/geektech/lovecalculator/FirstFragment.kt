package com.geektech.lovecalculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.geektech.lovecalculator.databinding.FirstFragmentBinding
import com.geektech.lovecalculator.viewmodel.LoveViewModel
import com.geektech.lovecalculator.repository.Repository


class FirstFragment : Fragment() {

    private lateinit var binding: FirstFragmentBinding
    private val viewModel: LoveViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FirstFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initeClicker()
    }

    private fun initeClicker() {
        with(binding) {
            btnSend.setOnClickListener {
                viewModel.getLiveLove(
                    fisrtname = etFirstName.text.toString(),
                    secondName = etSecondName.text.toString()
                )
                    .observe(viewLifecycleOwner, Observer {
                        findNavController().navigate(R.id.secondFragment, bundleOf("names" to it))
                    })
            }
        }
    }

}