package com.practice.core

import com.practice.core.member.Grade
import com.practice.core.member.Member
import com.practice.core.member.MemberService
import com.practice.core.member.MemberServiceImpl
import org.apache.catalina.core.ApplicationContext
import org.springframework.context.annotation.AnnotationConfigApplicationContext

fun main() {

    val context = AnnotationConfigApplicationContext(AppConfig::class.java)

    val memberService: MemberService = context.getBean("memberService", MemberService::class.java)

    val member = Member(
        id = 1,
        name = "memberA",
        grade = Grade.VIP
    )
    memberService.join(member)


    val findMember = memberService.findMember(1L)
    println("new member=${member.name}")
    println("find member=${findMember?.name}")
}