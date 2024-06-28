package com.example.hahi.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.hahi.data.AppRepositoryImpl
import com.example.hahi.domain.CountOfHahi
import com.example.hahi.domain.usecases.AddCountInBaseUseCase
import com.example.hahi.domain.usecases.GetCountOfHahi

class AppViewModel:ViewModel() {

    private val repository = AppRepositoryImpl

    private val getCountOfHahi = GetCountOfHahi(repository)
    private val addCountOfHahi = AddCountInBaseUseCase(repository)

    private val _score = MutableLiveData<CountOfHahi>()
    val score:LiveData<CountOfHahi>
        get() = _score

   fun addCountOfhahi(score:Int) {
        addCountOfHahi.addCountInBaseUseCase(CountOfHahi(score))
    }

    fun getCountOfHahi() {
        _score.value = getCountOfHahi.getCountOfHahi()
    }


}