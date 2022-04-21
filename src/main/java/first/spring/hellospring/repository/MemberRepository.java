package first.spring.hellospring.repository;

import first.spring.hellospring.domain.Member;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
