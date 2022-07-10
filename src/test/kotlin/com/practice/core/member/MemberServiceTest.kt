package com.practice.core.member

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class MemberServiceTest {

    val memberService: MemberService = MemberServiceImpl()

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