package com.dkbmc.web.MobileOffice.Domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@Getter
@Entity
@ToString
@DynamicInsert
@NamedEntityGraph(name = "login_login_history",attributeNodes = @NamedAttributeNode("loginHistory"))
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Login extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "int(1)")
    private int fail_cnt;

    @OneToOne
    @JoinColumn(name = "employee_number", nullable = false)
    private Member member;

    @OneToMany(mappedBy = "login", fetch = FetchType.EAGER)
    @ToString.Exclude
    private List<LoginHistory> loginHistory;

    @Column(nullable = false)
    private String token;
    private String refreshToken;

}
