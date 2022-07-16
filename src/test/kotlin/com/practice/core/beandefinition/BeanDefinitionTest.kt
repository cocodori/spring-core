package com.practice.core.beandefinition

import com.practice.core.AppConfig
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.config.BeanDefinition
import org.springframework.context.annotation.AnnotationConfigApplicationContext

class BeanDefinitionTest {
    val ac = AnnotationConfigApplicationContext(AppConfig::class.java)

    @Test
    fun `빈 설정 메타정보 확인`() {
        val beanDefinitionNames = ac.beanDefinitionNames
        for (beanDefinitionName in beanDefinitionNames) {
            val beanDefinition = ac.getBeanDefinition(beanDefinitionName)
            if (beanDefinition.role == BeanDefinition.ROLE_APPLICATION) {
                println("beanDefinitionName=$beanDefinitionName, beanDefinition=$beanDefinition")
            }
        }
    }
}