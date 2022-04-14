package first.spring.hellospring.service;

import first.spring.hellospring.domain.Member;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService=new MemberService();

    @Test
    void join() {
        //given 무언가가 주어졌을 떄
        Member member = new Member();
        member.setName("hello");

        //when 이걸 실행 했을 때
        long saveId = memberService.join(member);
        //then 결과가 이게 나와야 한다
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    void findMebers() {
    }

    @Test
    void findOne() {
    }
}