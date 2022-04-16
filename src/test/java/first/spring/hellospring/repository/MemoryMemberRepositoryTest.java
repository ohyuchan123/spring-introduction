package first.spring.hellospring.repository;

import first.spring.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository=new MemoryMemberRepository();

    //메서드가 실행이 끝날때마다 실행(저장된 것을 지움)
    @AfterEach
    public void afterEach()
    {
        repository.clearStore();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result =repository.findById(member.getId()).get();
//        System.out.println("result = "+(result==member));
        Assertions.assertEquals(member,result);
//          Assertions.assertEquals(member,null); 오류
        assertThat(member).isEqualTo(result);
    }
    @Test
    public void FindByname()
    {
        Member member1=new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2=new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByname("spring1").get();
//        Member result = repository.findByname("spring2").get(); 오류

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll()
    {
        Member member1=new Member();

        member1.setName("spring1");
        repository.save(member1);

        Member member2=new Member();

        member2.setName("spring2");
        repository.save(member2);

        List<Member> result= MemberRepository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }
}
