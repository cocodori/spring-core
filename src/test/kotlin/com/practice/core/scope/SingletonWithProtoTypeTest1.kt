package com.practice.core.scope

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Scope
import javax.annotation.PostConstruct
import javax.annotation.PreDestroy

class SingletonWithProtoTypeTest1 {

    @Test
    fun singletonClientUsePrototype() {
        val ac =
            AnnotationConfigApplicationContext(ClientBean::class.java, PrototypeBean::class.java)

        val clientBean1 = ac.getBean(ClientBean::class.java)
        val count1 = clientBean1.logic()
        assertThat(count1).isEqualTo(1)

        val clientBean2 = ac.getBean(ClientBean::class.java)
        val count2 = clientBean2.logic()

        assertThat(count2).isEqualTo(2)
    }

    @Test
    fun prototypeFind() {
        val ac = AnnotationConfigApplicationContext(PrototypeBean::class.java)
        val prototypeBean1 = ac.getBean(PrototypeBean::class.java)
        prototypeBean1.addCount()

        val prototypeBean2 = ac.getBean(PrototypeBean::class.java)
        prototypeBean2.addCount()

        assertThat(prototypeBean2.count).isEqualTo(1)
    }

    class ClientBean(
        @Autowired
        private val prototypeBean: PrototypeBean
    ) {
        fun logic(): Int {
            prototypeBean.addCount()
            return prototypeBean.count
        }
    }

    @Scope("prototype")
    class PrototypeBean {
        var count = 0

        fun addCount() {
            this.count++
        }

        @PostConstruct
        fun init() {
            println("PrototypeBean.init $this")
        }

        @PreDestroy
        fun destroy() {
            println("PrototypeBean.destroy")
        }
    }
}