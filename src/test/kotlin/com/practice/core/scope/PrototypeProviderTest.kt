package com.practice.core.scope

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.ObjectProvider
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.AnnotationConfigApplicationContext

class PrototypeProviderTest {

    @Test
    fun providerTest() {
        val ac = AnnotationConfigApplicationContext(
            ClientBean::class.java,
            SingletonWithProtoTypeTest1.PrototypeBean::class.java
        )

        val clientBean1 = ac.getBean(ClientBean::class.java)
        val clientBean2 = ac.getBean(ClientBean::class.java)

        val count1 = clientBean1.logic()
        assertThat(count1)

        val count2 = clientBean2.logic()
        assertThat(count2)
    }

    class ClientBean {
        @Autowired
        lateinit var prototypeBeanProvider: ObjectProvider<SingletonWithProtoTypeTest1.PrototypeBean>

        fun logic(): Int {
            val prototypeBean = prototypeBeanProvider.getObject()
            prototypeBean.addCount()

            return prototypeBean.count
        }
    }
}