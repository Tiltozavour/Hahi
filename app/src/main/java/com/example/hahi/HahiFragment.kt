package com.example.hahi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hahi.databinding.FragmentHahiBinding


class HahiFragment : Fragment() {


   private var countOfHahi:Int = 0


    private var _binding: FragmentHahiBinding?=null
    private val binding: FragmentHahiBinding
        get() = _binding ?: throw RuntimeException("FragmentHahiBinding is null")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
        binding.tvCount.text ="0"
        binding.ivFox.setOnClickListener {
            foxLeftOrRight(it)
            binding.tvCount.text = countOfHahi.toString()
            AddEasterEgg()
        }

    }
    private fun foxLeftOrRight(foxImage:View){
        if (foxImage.scaleX == valueScaleForImageLeft){
            foxImage.scaleX = valueScaleForImageRight
            countOfHahi++
        } else {foxImage.scaleX = valueScaleForImageLeft
            countOfHahi++
        }
    }

    private fun AddEasterEgg() {
        when (countOfHahi) {
            150 -> binding.tvEgg.text = "Ты тут ищешь пасхалку или что?"
            151 -> binding.tvEgg.text = ""
            250 -> binding.tvEgg.text = "Какой ты дурдак, чес_слово"
            251 -> binding.tvEgg.text = ""
            300 -> binding.tvEgg.text = "ХА!Ну ты понял..."
            301 -> binding.tvEgg.text = ""
        }
    }

  /*  override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_SAVE_SCORE,countOfHahi)
    }*/

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object{
        private const val valueScaleForImageRight = -1.0F
        private const val valueScaleForImageLeft = 1.0F
        //private const val KEY_SAVE_SCORE = "key_score"
    }

}