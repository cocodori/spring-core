package com.practice.core

import com.practice.core.member.Grade
import com.practice.core.member.Member
import com.practice.core.member.MemberService
import com.practice.core.member.MemberServiceImpl

fun main() {
    val memberService: MemberService = MemberServiceImpl()
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