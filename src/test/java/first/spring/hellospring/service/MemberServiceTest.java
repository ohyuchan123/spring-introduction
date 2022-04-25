package first.spring.hellospring.service;

import first.spring.hellospring.domain.Member;
import first.spring.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach(){
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    //코드가 돌아갈 때마다 DB의 값을 다 날려줌
    @AfterEach
    public void afterEach(){
        memberRepository.clearStore();
    }


    // Test는 한글로 바꾸어 됨
    @Test
    void 회원가입(){
        //given (무언가 주어짐)
        Member member = new Member();
        member.setName("spring");
        //when (이 프로그램을 시행 했을 때)
        Long saveId = memberService.join(member);

        //then (결과가 이것이 나와야 됨)
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외(){
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");
        //when
        memberService.join(member1);

        IllegalStateException e = assertThrows(IllegalStateException.class,()->memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

//        assertThrows(NullPointerException.class,()->memberService.join(member2));

//        try {
//            memberService.join(member2);
//            fail();
//        }catch (IllegalStateException e){
//            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//        }
        //then

    }

    @Test
    void findMembers(){
        //given

        //when

        //then
        
    }
    
    @Test
    void findOne(){

    }
}