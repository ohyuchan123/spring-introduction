package first.spring.hellospring.service;

import first.spring.hellospring.domain.Member;
import first.spring.hellospring.repository.MemberRepository;
import first.spring.hellospring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemoryMemberRepository memberRepository;

    public MemberService(MemoryMemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /*
    * 회원 가입*/
    public long join(Member member){
        //같은 이름이 중복 회원X

        validateDuplicateMember(member); //중복 회원 검증


        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByname(member.getName())
                .ifPresent(member1 -> {
                    try {
                        throw new IllegalAccessException("이미 존재하는 회원 입니다123");
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                });
    }

    /*
    * 전체 회원 조회*/
    public List<Member> findMebers(){
        return MemberRepository.findAll();
    }
    public Optional<Member> findOne(long memberId){
        return memberRepository.findById(memberId);
    }
}
