package com.kjh.hellospring.service;

import com.kjh.hellospring.domain.Member;
import com.kjh.hellospring.repository.MemoryMemberRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public class MemberService {
    public double a;
    private final MemoryMemberRepository memberRepository = new MemoryMemberRepository();

    public Long join(Member member){
        validateDuplicateMember(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName()).
                ifPresent(m -> {
            throw new IllegalStateException("존재하는 회원입니다.");
        });
    }

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
