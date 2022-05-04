package first.spring.introductionspring;

import first.spring.introductionspring.domain.Member;
import first.spring.introductionspring.repository.JpaMemberRepository;
import first.spring.introductionspring.repository.MemberRepository;
import first.spring.introductionspring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpiringConfig {
//    private final DataSource dataSource;
//   @Autowired
//   public SpiringConfig(DataSource dataSource){
//       this.dataSource = dataSource;
//   }

//    @PersistenceContext
//    private EntityManager em;
//
//    @Autowired
//    public SpiringConfig(DataSource dataSource, EntityManager em){
//        this.dataSource = dataSource;
//        this.em=em;
//    }

    public MemberService

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//        return new JdbcMemberRepository(dataSource);
//        return new JdbcTemplateMemberRepository(dataSource);
        return new JpaMemberRepository(em);
    }
}
