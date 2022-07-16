package com.practice.core.beanfind

import com.practice.core.member.MemberRepository
import com.practice.core.member.MemoryMemberRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.beans.factory.NoUniqueBeanDefinitionException
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

class ApplicationContextSameBeanFindTest {
    val ac = AnnotationConfigApplicationContext(SameBeanConfig::class.java)

    @Configuration
    class SameBeanConfig {
        @Bean
        fun memberRepository1(): MemberRepository =
            MemoryMemberRepository()

        @Bean
        fun memberRepository2(): MemberRepository =
            MemoryMemberRepository()
    }

    @Test
    fun `타입으로 조회 시 같은 타입이 둘 이상 있으면 중복 에러가 발생한다`() {
        assertThrows<NoUniqueBeanDefinitionException> {
            ac.getBean(MemberRepository::class.java)
        }
    }

    @Test
    fun `타입으로 조회 시 같은 타입이 둘 이상 있으면 빈 이름을 지정하면 된다`() {
        val memberRepository = ac.getBean("memberRepository1", MemberRepository::class)
        assertThat(memberRepository).isInstanceOf(MemberRepository::class.java)
    }

    @Test
    fun `특정 타입 모두 조회`() {
        val beansOfType: Map<String, MemberRepository> = ac.getBeansOfType(MemberRepository::class.java)
        for ((key, value) in beansOfType) {
            println("key=$key value=$value")
        }
        println("beansOfType=$beansOfType")
        assertThat(beansOfType.size).isEqualTo(2)
    }




}