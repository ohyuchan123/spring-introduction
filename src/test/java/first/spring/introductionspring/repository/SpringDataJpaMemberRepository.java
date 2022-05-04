package first.spring.introductionspring.repository;

import first.spring.introductionspring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member,Long>,MemberRepository {

    @Override
    Optional<Member> findName(String name);
}
