package first.spring.introductionspring;

import first.spring.introductionspring.repository.MemberRepository;
import first.spring.introductionspring.repository.MemoryMemberRepository;
import first.spring.introductionspring.service.MemberService;
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
