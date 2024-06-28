package com.example.hahi.domain.usecases

import com.example.hahi.domain.AppRepository
import com.example.hahi.domain.CountOfHahi

class GetCountOfHahi(private val repository: AppRepository) {

    fun  getCountOfHahi(): CountOfHahi {
        return  repository.getCountOfHahi()
    }

}