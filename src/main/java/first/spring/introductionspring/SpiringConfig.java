package first.spring.introductionspring;

import first.spring.introductionspring.repository.JdbcMemberRepository;
import first.spring.introductionspring.repository.JdbcTemplateMemberRepository;
import first.spring.introductionspring.repository.MemberRepository;
import first.spring.introductionspring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpiringConfig {
    private final DataSource dataSource;

   @Autowired
   public SpiringConfig(DataSource dataSource){
       this.dataSource = dataSource;
   }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
//        return new MemoryMemberRepository();
//        return new JdbcMemberRepository(dataSource);
        return new JdbcTemplateMemberRepository(dataSource);
    }
}
