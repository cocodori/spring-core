package com.practice.core.member

class MemberServiceImpl(
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