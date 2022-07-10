package com.practice.core

import com.practice.core.member.*
import com.practice.core.order.OrderService
import com.practice.core.order.OrderServiceImpl

fun main() {
    val memberRepository: MemberRepository = MemoryMemberRepository()
    val memberService: MemberService = MemberServiceImpl(memberRepository = memberRepository)
    val orderService: OrderService = OrderServiceImpl(memberRepository = memberRepository)

    val memberId = 1L
    val member = Member(memberId, "memberA", Grade.VIP)
    memberService.join(member)

    val order = orderService.createOrder(memberId, "itemA", 10000)

    println(order)
}