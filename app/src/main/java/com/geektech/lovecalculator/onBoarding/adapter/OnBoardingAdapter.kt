package com.geektech.lovecalculator.onBoarding.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.geektech.lovecalculator.OnBoard
import com.geektech.lovecalculator.databinding.ItemOnboardingBinding
import com.geektech.lovecalculator.R

class OnBoardingAdapter(private val onClick:()->Unit):
    RecyclerView.Adapter<OnBoardingAdapter.OnBoardingViewHolder>(){

    private val data = arrayListOf(
        OnBoard("GET A LONG","Spare time with the person who need you", R.raw.lottie_1),
        OnBoard("OOH BREAK UP?","Don't worry we have got you covered, someone might be waiting for you",R.raw.lottie_2),
        OnBoard("CHERISH LOVE","Your wait for being able to cherish love has now ended",R.raw.lottie_3),
        OnBoard("REAL LOVE","Find out the compatibility of names",R.raw.lottie_4)
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        return OnBoardingViewHolder(ItemOnboardingBinding.inflate(LayoutInflater.from(parent.context),parent, false))
    }

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.bind(data[position])

    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class OnBoardingViewHolder(private val binding: ItemOnboardingBinding):ViewHolder(binding.root){
        fun bind(onBoard: OnBoard) {
            binding.tvTitle.text=onBoard.title
            binding.tvDesc.text=onBoard.desc
            onBoard.image?.let{binding.animationView.setAnimation(it)}
            binding.btnStart.isVisible = adapterPosition==data.lastIndex
            binding.btnStart.setOnClickListener {
                onClick()
            }
        }

    }
}