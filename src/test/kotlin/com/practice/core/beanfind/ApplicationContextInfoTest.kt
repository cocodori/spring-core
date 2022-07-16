package com.practice.core.beanfind

import com.practice.core.AppConfig
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.config.BeanDefinition
import org.springframework.context.annotation.AnnotationConfigApplicationContext

class ApplicationContextInfoTest {

    val ac = AnnotationConfigApplicationContext(AppConfig::class.java)

    @Test
    fun `모든 빈 출력하기`() {
        val beanDefinitionNames = ac.beanDefinitionNames

        for (beanDefinitionName in beanDefinitionNames) {
            val bean = ac.getBean(beanDefinitionName)
            println("name=$beanDefinitionName, object=$bean")
        }
    }

    @Test
    fun `애플리케이션 빈 출력하기`() {
        val beanDefinitionNames = ac.beanDefinitionNames
        for (beanDefinitionName in beanDefinitionNames) {
            val beanDefinition = ac.getBeanDefinition(beanDefinitionName)

            //Role ROLE_APPLICATION: 직접 등록한 애플리케이션 빈
            //Role ROLE_INFRASTRUCTURE: 스프링이 내부에서 사용하는 빈
            if (beanDefinition.role == BeanDefinition.ROLE_APPLICATION) {
                val bean = ac.getBean(beanDefinitionName)
                println("name=$beanDefinitionName, object=$bean")
            }
        }
    }
}