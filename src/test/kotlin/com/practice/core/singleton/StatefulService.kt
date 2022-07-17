package com.practice.core.singleton

class StatefulService {

    var price: Int = 0
        private set

    fun order(name: String, price: Int) {
        println("name=$name, price=$price")
        this.price = price
    }
}