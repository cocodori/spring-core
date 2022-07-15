package com.practice.core.order

import com.practice.core.AppConfig
import com.practice.core.member.Grade
import com.practice.core.member.Member
import com.practice.core.member.MemberService
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class OrderServiceTest {

    lateinit var memberService: MemberService
    lateinit var orderService: OrderService

    @BeforeEach
    fun setup() {
        val appConfig = AppConfig()
        memberService = appConfig.memberService()
        orderService = appConfig.orderService()
    }

    @Test
    fun createOrderTest() {
        //given
        val member = Member(1, "name", Grade.BASIC)
        memberService.join(member)

        //when
        val order = orderService.createOrder(
            memberId = 1,
            itemName = "itemName",
            itemPrice = 10000
        )

        //then
        assertThat(order.itemName).isEqualTo("itemName")
        assertThat(order.memberId).isEqualTo(member.id)
        assertThat(order.itemPrice).isEqualTo(10000)
        assertThat(order.discountPrice).isEqualTo(0)
    }
}