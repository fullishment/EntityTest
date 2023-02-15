package com.dkbmc.web.MobileOffice.Domain;

import com.dkbmc.web.MobileOffice.DTO.EmployeeDTO;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Entity
@ToString
@DynamicInsert
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Employee extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "employee_number", nullable = false)
    private Member member;

    @OneToOne
    @JoinColumn(name = "email", referencedColumnName = "email", nullable = false)
    private Member email;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(referencedColumnName = "team_id", name = "team_id")
    @ToString.Exclude
    private Team teamId;

    @Column(nullable = false, length = 50)
    private String name;
    @Column(nullable = false, length = 20)
    private String position;
    @Column(nullable = false, length = 50)
    private String division;

    @Column(nullable = false, length = 20)
    private String status;

    @OneToOne(mappedBy = "employee")
    private WorkingStatus workingStatus;
    @OneToOne(mappedBy = "employee")
    private Reservation reservation;

    public void setTeamId(Team teamId) {
        this.teamId = teamId;
    }

    public void update(EmployeeDTO.RequestUpdate updateDTO) {
        this.member = updateDTO.getMember();
        this.email = updateDTO.getMember();
        this.name = updateDTO.getName();
        this.position = updateDTO.getPosition();
        this.division = updateDTO.getDivision();
        this.status = updateDTO.getStatus();
        this.teamId = updateDTO.getTeamId();
    }

    @Builder
    public Employee(Member member, String name, String position, String division, String status, Team teamId) {
        this.member = member;
        this.email = member;
        this.name = name;
        this.position = position;
        this.division = division;
        this.status = status;
        this.teamId = teamId;
    }
}

