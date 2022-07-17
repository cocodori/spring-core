package com.practice.core.member

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class MemberServiceImpl @Autowired constructor(
    private val memberRepository: MemberRepository
): MemberService {
    override fun join(member: Member) {
        println(memberRepository)
        memberRepository.save(member)
    }

    override fun findMember(memberId: Long): Member {
        return memberRepository.findById(memberId)
    }

    //test
    fun getMemberRepository() = memberRepository
}