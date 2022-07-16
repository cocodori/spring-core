package com.practice.core

import com.practice.core.member.MemberService
import com.practice.core.member.MemberServiceImpl
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.beans.factory.NoSuchBeanDefinitionException
import org.springframework.context.annotation.AnnotationConfigApplicationContext

class ApplicationContextBasicFindTest {
    val ac = AnnotationConfigApplicationContext(AppConfig::class.java)

    @Test
    fun `빈 이름으로 조회`() {
        val memberService = ac.getBean("memberService", MemberService::class.java)
        assertThat(memberService).isInstanceOf(MemberServiceImpl::class.java)
    }

    @Test
    fun `이름없이 타입만으로 조회`() {
        val memberService = ac.getBean(MemberService::class.java)
        assertThat(memberService).isInstanceOf(MemberServiceImpl::class.java)
    }

    @Test
    fun `구체타입으로 조회`() {
        val memberService = ac.getBean("memberService", MemberServiceImpl::class.java)
        assertThat(memberService).isInstanceOf(MemberServiceImpl::class.java)
    }

    @Test
    fun `빈 이름으로 조회X`() {
        assertThrows<NoSuchBeanDefinitionException> {
            ac.getBean("xxxx", MemberService::class.java)
        }
    }
}