package first.spring.hellospring.repository;

import first.spring.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

    static final Map<Long,Member> store=new HashMap<>();
    private static long sequence=0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(),member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByname(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    public void clearStore(){
        store.clear();

    }
}
