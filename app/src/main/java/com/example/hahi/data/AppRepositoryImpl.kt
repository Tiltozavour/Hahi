package com.example.hahi.data

import com.example.hahi.domain.AppRepository
import com.example.hahi.domain.CountOfHahi
import com.example.hahi.domain.usecases.GetCountOfHahi

object AppRepositoryImpl:AppRepository {


    private var count:Int = 0

    override fun getCountOfHahi(): CountOfHahi {
        return CountOfHahi(count)
    }

    override fun addCountInBaseUseCase(countOfHahi: CountOfHahi) {
       count = countOfHahi.count
        count++
    }
}