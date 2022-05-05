package spring.introductionspring.service;

import spring.introductionspring.domain.Member;
import spring.introductionspring.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

//@Service
public class MemberService {
    private final MemberRepository memberRepository;

//    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    //회원 가입
    public Long join(Member member){

        Long start = System.currentTimeMillis();
        try{
            //같은 이름이 있는 중복 회원X
            validataDuplicateMember(member); // 중복 회원 검증
            memberRepository.save(member);
            return member.getId();
        }finally {
            Long finish = System.currentTimeMillis();
            Long timeMs = finish-start;
            System.out.println("join = "+timeMs + "ms");
        }
    }

    private void validataDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m->{
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    //전체 회원 조회
    public List<Member> findMembers(){
        Long start = System.currentTimeMillis();
        try{
            return memberRepository.findAll();
        }finally {
            Long finish = System.currentTimeMillis();
            Long timeMs = finish-start;
            System.out.println("findMembers ="+timeMs+"ms");
        }

    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}