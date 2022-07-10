package com.practice.core.order

interface OrderService {
    fun createOrder(
        memberId: Long,
        itemName: String,
        itemPrice: Int
    ): Order
}