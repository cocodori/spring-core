package com.practice.core.discount

import com.practice.core.member.Grade
import com.practice.core.member.Member
import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Component

@Primary
@Component
class RateDiscountPolicy: DiscountPolicy {

    private val discountPercent = 10

    override fun discount(member: Member, price: Int): Int {
        return if (member.grade == Grade.VIP)
            price * discountPercent / 100
        else 0
    }
}