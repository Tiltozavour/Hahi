package com.example.hahi.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.hahi.databinding.FragmentHahiBinding


class HahiFragment : Fragment() {


    private var _binding: FragmentHahiBinding?=null
    private val binding: FragmentHahiBinding
        get() = _binding ?: throw RuntimeException("FragmentHahiBinding is null")


    private val viewModel by lazy {
        ViewModelProvider(this)[AppViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHahiBinding.inflate(inflater, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
            initViewModel()
        binding.ivFox.setOnClickListener {
            initViewModel()
            foxLeftOrRight(it)
        }

    }
    private fun foxLeftOrRight(foxImage:View){
        if (foxImage.scaleX == valueScaleForImageLeft){
            foxImage.scaleX = valueScaleForImageRight }
        else { foxImage.scaleX = valueScaleForImageLeft }
        }

    private fun initViewModel(){
        viewModel.getCountOfHahi()
        viewModel.score.observe(viewLifecycleOwner){
            binding.tvCount.text = it.count.toString()
            viewModel.addCountOfhahi(it.count)
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object{
        private const val valueScaleForImageRight = -1.0F
        private const val valueScaleForImageLeft = 1.0F
    }

    /*


        private fun AddEasterEgg() {
        when (countOfHahi) {
            150 -> binding.tvEgg.text = "Ты тут ищешь пасхалку или что?"
            151 -> binding.tvEgg.text = ""
            250 -> binding.tvEgg.text = "Какой ты дурдак, чес_слово"
            251 -> binding.tvEgg.text = ""
            300 -> binding.tvEgg.text = "ХА!Ну ты понял..."
            301 -> binding.tvEgg.text = ""


        }
    } */




}