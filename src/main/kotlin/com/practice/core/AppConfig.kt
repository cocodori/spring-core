package com.practice.core

import com.practice.core.discount.FixDiscountPolicy
import com.practice.core.member.MemberRepository
import com.practice.core.member.MemberService
import com.practice.core.member.MemberServiceImpl
import com.practice.core.member.MemoryMemberRepository
import com.practice.core.order.OrderService
import com.practice.core.order.OrderServiceImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AppConfig {

    @Bean
    fun memberService(): MemberService =
        MemberServiceImpl(memberRepository())

    @Bean
    fun orderService(): OrderService =
        OrderServiceImpl(
            memberRepository = memberRepository(),
            discountPolicy = discountPolicy()
        )

    @Bean
    fun discountPolicy() = FixDiscountPolicy()

    @Bean
    fun memberRepository(): MemberRepository = MemoryMemberRepository()

}