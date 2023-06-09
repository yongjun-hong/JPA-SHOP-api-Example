package jpabook.jpashop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
public class Member {
    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;
    @Embedded
    private Address address;
    @JsonIgnore // 주문 정보가 빠진다.
    @OneToMany(mappedBy = "member") // order 테이블에 있는 Member 필드에 의해 나는 mapping 된거야
    private List<Order> orders = new ArrayList<>();
}
