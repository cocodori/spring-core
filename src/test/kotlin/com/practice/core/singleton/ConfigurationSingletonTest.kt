package com.practice.core.singleton

import com.practice.core.AppConfig
import com.practice.core.member.MemberRepository
import com.practice.core.member.MemberServiceImpl
import com.practice.core.order.OrderServiceImpl
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.context.annotation.AnnotationConfigApplicationContext

class ConfigurationSingletonTest {

    @Test
    fun configurationTest() {
        val ac = AnnotationConfigApplicationContext(AppConfig::class.java)

        val memberServiceImpl = ac.getBean("memberService", MemberServiceImpl::class.java)
        val orderServiceImpl = ac.getBean("orderService", OrderServiceImpl::class.java)
        val memberRepository = ac.getBean("memberRepository", MemberRepository::class.java)

        println("memberServiceImpl=${memberServiceImpl.getMemberRepository()}")
        println("orderServiceImpl=${orderServiceImpl.getMemberRepository()}")
        println("memberRepository=$memberRepository")

        assertThat(memberServiceImpl.getMemberRepository()).isSameAs(memberRepository)
        assertThat(orderServiceImpl.getMemberRepository()).isSameAs(memberRepository)
    }
}