package com.practice.core.beanfind

import com.practice.core.discount.DiscountPolicy
import com.practice.core.discount.FixDiscountPolicy
import com.practice.core.discount.RateDiscountPolicy
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.beans.factory.NoUniqueBeanDefinitionException
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

class ApplicationContextExtendsFindTest {
    val ac = AnnotationConfigApplicationContext(TestConfig::class.java)

    @Configuration
    class TestConfig {
        @Bean
        fun rateDiscountPolicy() =
            RateDiscountPolicy()

        @Bean
        fun fixDiscountPolicy() =
            FixDiscountPolicy()
    }

    @Test
    fun `부모타입으로 조회 시, 자식이 둘 이상 있으면 중복 오류가 발생한다`() {
        assertThrows<NoUniqueBeanDefinitionException> {
            ac.getBean(DiscountPolicy::class.java)
        }
    }

    @Test
    fun `부모 타입으로 조회 시, 자식이 둘 이상 있으면, 빈 이름을 지정해야 한다`() {
        val rateDiscountPolicy = ac.getBean("rateDiscountPolicy", DiscountPolicy::class.java)

        assertThat(rateDiscountPolicy).isInstanceOf(DiscountPolicy::class.java)
    }

    @Test
    fun `부모 타입으로 모두 조회하기`() {
        val beansOfType = ac.getBeansOfType(DiscountPolicy::class.java)
        assertThat(beansOfType.size).isEqualTo(2)

        for ((key, value) in beansOfType) {
            println("key=$key, value=$value")
        }
    }

    @Test
    fun `부모 타입으로 모두 조회 - Object`() {
        val beansOfType = ac.getBeansOfType(Any::class.java)
        for((key, value) in beansOfType) {
            println("key=$key, value=$value")
        }
    }
}
