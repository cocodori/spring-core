package com.practice.core.member

import org.springframework.stereotype.Component

@Component
class MemoryMemberRepository: MemberRepository {

    private val store: HashMap<Long, Member> = HashMap()

    override fun save(member: Member) {
        store[member.id] = member
    }

    override fun findById(memberId: Long): Member {
        return store[memberId] ?: throw RuntimeException("memberId=${memberId}")
    }
}