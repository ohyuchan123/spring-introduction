package first.spring.hellospring.service;

import first.spring.hellospring.domain.Member;
import first.spring.hellospring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemoryMemberRepository memoryMemberRepository = new MemoryMemberRepository();

    /*
    * 회원 가입*/
    public long join(Member member){
        //같은 이름이 중복 회원X

        validateDuplicateMember(member); //중복 회원 검증


        memoryMemberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memoryMemberRepository.findByname(member.getName())
                .ifPresent(member1 -> {
                    try {
                        throw new IllegalAccessException("이미 존재하는 회원 입니다");
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                });
    }

    /*
    * 전체 회원 조회*/
    public List<Member> findMebers(){
        return MemoryMemberRepository.findAll();
    }
    public Optional<Member> findOne(long memberId){
        return memoryMemberRepository.findById(memberId);
    }
}
