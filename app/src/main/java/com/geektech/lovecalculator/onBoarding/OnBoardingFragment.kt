package com.geektech.lovecalculator.onBoarding

import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.geektech.lovecalculator.FirstFragment.Companion.PREF_SEEN_KEY
import com.geektech.lovecalculator.databinding.FragmentOnBoardingBinding
import com.geektech.lovecalculator.onBoarding.adapter.OnBoardingAdapter
import javax.inject.Inject


class OnBoardingFragment : Fragment() {

    private lateinit var binding: FragmentOnBoardingBinding

    @Inject
    lateinit var pref: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =FragmentOnBoardingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter=OnBoardingAdapter {
            pref.edit().putBoolean(PREF_SEEN_KEY, true).apply()
            findNavController().navigateUp()
        }
        binding.viewpager.adapter =adapter
        binding.indicator.setViewPager(binding.viewpager)
        adapter.registerAdapterDataObserver(binding.indicator.adapterDataObserver)
    }


}