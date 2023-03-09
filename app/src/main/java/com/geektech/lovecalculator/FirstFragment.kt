package com.geektech.lovecalculator

import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContentProviderCompat
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.geektech.lovecalculator.databinding.FirstFragmentBinding
import com.geektech.lovecalculator.remote.LoveModel
import com.geektech.lovecalculator.viewmodel.LoveViewModel
import com.geektech.lovecalculator.repository.Repository
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class FirstFragment : Fragment() {

    private lateinit var binding: FirstFragmentBinding
    private val viewModel: LoveViewModel by viewModels()

    @Inject
     lateinit var pref: SharedPreferences


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FirstFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun isUserSeen(): Boolean{
        return pref.getBoolean(PREF_SEEN_KEY,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initeClicker()
        if (!isUserSeen()) {
            findNavController().navigate(R.id.OnBoardingFragment)
        }
        binding.btnHistory.setOnClickListener {
            findNavController().navigate(R.id.historyFragment)
        }
    }

    private fun initeClicker() {
        with(binding) {
            btnSend.setOnClickListener {
                viewModel.getLiveLove(
                    fisrtname = etFirstName.text.toString(),
                    secondName = etSecondName.text.toString()
                )
                    .observe(viewLifecycleOwner, Observer {
                        App.appDatabase.loveDao().insert(it)
                        findNavController().navigate(R.id.secondFragment, bundleOf(LOVE_DATA to it))
                    })
            }
        }
    }

    companion object{
        const val PREF_SEEN_KEY ="Seen.key"
        const val LOVE_DATA = "Love.data"
    }

}