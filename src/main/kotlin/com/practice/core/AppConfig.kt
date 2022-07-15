package com.practice.core

import com.practice.core.discount.FixDiscountPolicy
import com.practice.core.member.MemberRepository
import com.practice.core.member.MemberService
import com.practice.core.member.MemberServiceImpl
import com.practice.core.member.MemoryMemberRepository
import com.practice.core.order.OrderService
import com.practice.core.order.OrderServiceImpl

class AppConfig {

    private val memberRepository: MemberRepository = MemoryMemberRepository()

    fun memberService(): MemberService =
        MemberServiceImpl(memberRepository)

    fun orderService(): OrderService =
        OrderServiceImpl(
            memberRepository = memberRepository,
            discountPolicy = FixDiscountPolicy()
        )
}