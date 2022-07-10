package com.practice.core.discount

import com.practice.core.member.Grade
import com.practice.core.member.Member

class FixDiscountPolicy: DiscountPolicy {
    private val discountFixAmount = 1000 //원

    //vip면 1000원 할인 아니면 할인 없음
    override fun discount(member: Member, price: Int): Int {
        return if (member.grade == Grade.VIP) {
            discountFixAmount
        } else {
            0
        }
    }
}