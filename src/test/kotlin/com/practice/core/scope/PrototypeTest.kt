package com.practice.core.scope

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Scope
import javax.annotation.PostConstruct
import javax.annotation.PreDestroy

class PrototypeTest {

    @Test
    fun prototypeBeanFind() {
        val ac = AnnotationConfigApplicationContext(PrototypeBean::class.java)

        val prototypeBean1 = ac.getBean(PrototypeBean::class.java)
        val prototypeBean2 = ac.getBean(PrototypeBean::class.java)

        println("prototypeBean1=$prototypeBean1")
        println("prototypeBean2=$prototypeBean2")

        assertThat(prototypeBean1).isNotSameAs(prototypeBean2)
    }


    @Scope("prototype")
    class PrototypeBean {
        @PostConstruct
        fun init() {
            println("PrototypeBean.init")
        }

        @PreDestroy
        fun destroy() {
            println("PrototypeBean.destroy")
        }

    }
}