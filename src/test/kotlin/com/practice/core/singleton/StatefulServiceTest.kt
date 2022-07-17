package com.practice.core.singleton

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Bean

class StatefulServiceTest {

    class TestConfig {
        @Bean
        fun statefulService(): StatefulService {
            return StatefulService()
        }
    }

    @Test
    fun statefulServiceSingleton() {
        val ac = AnnotationConfigApplicationContext(TestConfig::class.java)
        val statefulService1 = ac.getBean("statefulService", StatefulService::class.java)
        val statefulService2 = ac.getBean("statefulService", StatefulService::class.java)

        //ThreadA: A사용자 10000원 주문
        statefulService1.order("userA", 10000)

        //ThreadB: B사용자 20000원 주문
        statefulService1.order("userB", 20000)

        //ThreadA 사용자 A 주문 금액 조회
        val price = statefulService1.price
        //ThreadA: 사용자 A는 1000원을 기대했지만, 20000원 출력
        println("price=$price")

        assertThat(price).isEqualTo(20000)
    }
}