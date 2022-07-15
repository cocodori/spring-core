package com.practice.core.member

import com.practice.core.AppConfig
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class MemberServiceTest {

    lateinit var memberService: MemberService

    @BeforeEach
    fun setup() {
        val appConfig = AppConfig()
        memberService = appConfig.memberService()
    }

    @Test
    fun join() {
        //given
        val member = Member(id = 1, name = "memberA", Grade.VIP)

        //when
        memberService.join(member)
        val findMember = memberService.findMember(memberId = member.id)

        //then
        assertThat(member).isEqualTo(findMember)
    }
}