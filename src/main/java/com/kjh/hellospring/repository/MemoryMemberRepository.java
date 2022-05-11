package com.kjh.hellospring.repository;

import com.kjh.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberResitory {
    private static Map<Long, Member> store = new HashMap<>();  // 실무에서는 동시성문제로 concurrent hash를 사용한다함
    private static long sequence = 0L; // 이것도 마찬가지로 위와 같은 문제로 atomlong같은걸 쓴다함

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));

    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }

}
