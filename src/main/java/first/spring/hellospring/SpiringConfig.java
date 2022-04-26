package first.spring.hellospring;

import first.spring.hellospring.domain.Member;
import first.spring.hellospring.repository.MemberRepository;
import first.spring.hellospring.repository.MemoryMemberRepository;
import first.spring.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpiringConfig {
    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
