package com.dkbmc.web.MobileOffice.Domain;

import com.dkbmc.web.MobileOffice.DTO.MemberDTO;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.beans.BeanProperty;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@Entity
@ToString
@DynamicInsert
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseEntity implements Serializable {

    @Id
    @Column(unique = true, nullable = false, columnDefinition = "int(7)")
    private Integer employeeNumber;

    @Column(nullable = false, unique = true, length = 50)
    private String email;

    @Column(nullable = false)
    private String password;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "roles_id", nullable = false)
    @ToString.Exclude
    private Roles roles_id;

    @OneToOne(mappedBy = "member")
    private Login login;

    @OneToOne(mappedBy = "member")
    private Employee employee;

    @ColumnDefault("now()")
    @Column(nullable = false)
    private LocalDateTime pwModifiedDatetime;

    public void setRoles_id(Roles roles_id) {
        this.roles_id = roles_id;
    }

    public List<String> getRoleList() {
        if (this.roles_id.getRole().length() > 0) {
            return Arrays.asList(this.roles_id.getRole());
        }
        return new ArrayList<>();
    }

    public void passwordUpdate(MemberDTO.RequestPasswordUpdate requestDTO) {
        this.password = requestDTO.getPassword();
        this.pwModifiedDatetime = requestDTO.getPwModifiedDatetime();
    }

    public void update(MemberDTO.RequestUpdate requestDTO) {
        this.email = requestDTO.getEmail();
        this.roles_id = requestDTO.getRoles_id();
    }

    @Builder
    public Member( int employeeNumber, String password, String email, Roles roles_id) {
        this.employeeNumber = employeeNumber;
        this.email = email;
        this.password = password;
        this.roles_id = roles_id;
    }

}
