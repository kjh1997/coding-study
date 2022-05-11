package com.kjh.hellospring.service;

import com.kjh.hellospring.domain.Member;
import com.kjh.hellospring.repository.MemoryMemberRepository;

import java.util.Optional;

public class MemberService {
    public double a;
    private final MemoryMemberRepository memberRepository = new MemoryMemberRepository();

    public Long join(Member member){
        Optional<Member> result =  memberRepository.findByName(member.getName());
        result.ifPresent(m -> {
            throw new IllegalAccessException("존재하는 회원입니다.");
        });
        return member.getId();
    }
}
