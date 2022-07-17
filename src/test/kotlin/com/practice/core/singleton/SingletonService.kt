package com.practice.core.singleton

class SingletonService private constructor() {
    companion object {
        private val instance: SingletonService = SingletonService()

        fun getInstance(): SingletonService {
            return instance
        }
    }

    fun logic() {
        println("싱글톤 객체 로직 호출")
    }
}