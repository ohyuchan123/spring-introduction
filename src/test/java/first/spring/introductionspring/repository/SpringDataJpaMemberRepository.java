package first.spring.introductionspring.repository;

import first.spring.introductionspring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member,Long>,MemberRepository {

    //JPQL select m from Member m where m.name?
    @Override
    Optional<Member> findByName(String name);
//    Optional<Member> findByAAndName(String name);
}

