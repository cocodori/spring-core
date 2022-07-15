package com.practice.core

import com.practice.core.member.*
import com.practice.core.order.OrderService
import com.practice.core.order.OrderServiceImpl

fun main() {
    val appConfig = AppConfig()
    val memberService: MemberService = appConfig.memberService()
    val orderService: OrderService = appConfig.orderService()

    val memberId = 1L
    val member = Member(memberId, "memberA", Grade.VIP)
    memberService.join(member)

    val order = orderService.createOrder(memberId, "itemA", 10000)

    println(order)
}