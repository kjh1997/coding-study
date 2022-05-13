package com.kjh.hellospring.service;

import com.kjh.hellospring.domain.Member;
import com.kjh.hellospring.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

// 서비스에 등록함.

public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    public Long join(Member member){
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m ->{
                    // Null 가능성 있으면 요즘은 Optional 사용한다.
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });

    }
    public List<Member> findMembers() {

        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
