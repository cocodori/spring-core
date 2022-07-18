package com.practice.core.lifecycle

import org.junit.jupiter.api.Test
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

class BeanLifeCycleTest {

    @Configuration
    class LifeCycleConfig {
        @Bean(initMethod = "init", destroyMethod = "close")
        fun networkClient(): NetworkClient =
            NetworkClient("http://hello-spring.dev")
    }

    @Test
    fun lifeCycleTest() {
        val ac: ConfigurableApplicationContext =
            AnnotationConfigApplicationContext(LifeCycleConfig::class.java)

        val networkClient = ac.getBean(NetworkClient::class.java)

        ac.close()
    }
}