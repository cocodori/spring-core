package com.practice.core.discount

import com.practice.core.member.Member

interface DiscountPolicy {
    fun discount(member: Member, price: Int): Int
}