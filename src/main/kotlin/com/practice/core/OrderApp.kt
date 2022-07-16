package com.practice.core

import com.practice.core.member.*
import com.practice.core.order.OrderService
import com.practice.core.order.OrderServiceImpl
import org.springframework.context.annotation.AnnotationConfigApplicationContext

fun main() {

    val context = AnnotationConfigApplicationContext(AppConfig::class.java)

    val memberService: MemberService = context.getBean("memberService", MemberService::class.java)
    val orderService: OrderService = context.getBean("orderService", OrderService::class.java)

    val memberId = 1L
    val member = Member(memberId, "memberA", Grade.VIP)
    memberService.join(member)

    val order = orderService.createOrder(memberId, "itemA", 10000)

    println(order)
}