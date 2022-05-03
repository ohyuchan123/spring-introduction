package first.spring.introductionspring;

import first.spring.introductionspring.repository.JpamemberRepository;
import first.spring.introductionspring.repository.MemberRepository;
import first.spring.introductionspring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Configuration
public class SpiringConfig {
//    private final DataSource dataSource;
//
//   @Autowired
//   public SpiringConfig(DataSource dataSource){
//       this.dataSource = dataSource;
//   }

//    @PersistenceContext
    private EntityManager em;

    @Autowired
    public SpiringConfig(EntityManager em){
        this.em=em;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//        return new JdbcMemberRepository(dataSource);
//        return new JdbcTemplateMemberRepository(dataSource);
        return new JpamemberRepository(em);
    }
}
