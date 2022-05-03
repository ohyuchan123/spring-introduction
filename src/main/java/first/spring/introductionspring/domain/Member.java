package first.spring.introductionspring.domain;

import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;

@Entity//jpa가 관리하는 entity
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
