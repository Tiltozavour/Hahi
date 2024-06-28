package com.example.hahi.domain.usecases

import com.example.hahi.domain.AppRepository
import com.example.hahi.domain.CountOfHahi

class AddCountInBaseUseCase(private val repository: AppRepository) {

    fun addCountInBaseUseCase(countOfHahi: CountOfHahi){
        repository.addCountInBaseUseCase(countOfHahi)
    }

}