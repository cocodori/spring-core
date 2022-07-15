package com.practice.core.discount

import com.practice.core.member.Grade
import com.practice.core.member.Member
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class RateDiscountPolicyTest {
    val discountPolicy = RateDiscountPolicy()

    @Test
    fun `VIP는 10% 할인이 적용되어야 한다`() {
        //given
        val member = Member(1L, "memberVIP", Grade.VIP)

        //when
        val discount = discountPolicy.discount(member, 10000)

        //then
        assertThat(discount).isEqualTo(1000)
    }

    @Test
    fun `VIP가 아니면 할인이 적용되지 않는다`() {
        //given
        val member = Member(1L, "memberBasic", Grade.BASIC)

        //when
        val discount = discountPolicy.discount(member, 10000)

        //then
        assertThat(discount).isEqualTo(0)
    }
}