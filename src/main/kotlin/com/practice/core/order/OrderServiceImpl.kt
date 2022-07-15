package com.practice.core.order

import com.practice.core.discount.DiscountPolicy
import com.practice.core.discount.FixDiscountPolicy
import com.practice.core.member.MemberRepository
import com.practice.core.member.MemoryMemberRepository

class OrderServiceImpl(
    private val memberRepository: MemberRepository,
    private val discountPolicy: DiscountPolicy
): OrderService {

    override fun createOrder(
        memberId: Long,
        itemName: String,
        itemPrice: Int
    ): Order {
        println(memberRepository)
        val member = memberRepository.findById(memberId)
        val discountPrice = discountPolicy.discount(member, itemPrice)

        return Order(memberId, itemName, itemPrice, discountPrice)
    }
}