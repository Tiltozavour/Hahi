package com.example.hahi.domain

import com.example.hahi.domain.usecases.GetCountOfHahi

interface AppRepository {

    fun  getCountOfHahi(): CountOfHahi

    fun addCountInBaseUseCase(countOfHahi: CountOfHahi)


}