package com.dkbmc.web.MobileOffice.Domain;

import com.dkbmc.web.MobileOffice.DTO.TeamDTO;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@Entity
@ToString
@Getter
@DynamicInsert
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@NamedEntityGraph(name = "team_employees", attributeNodes = @NamedAttributeNode("employees"))
public class Team extends BaseEntity implements Serializable {
    @Id
    @Column(unique = true, name = "team_id", columnDefinition = "int(6)")
    private int teamId;
    @Column(nullable = false, length = 50)
    private String teamName;
    @Column(nullable = false, columnDefinition = "int(5)")
    private int teamNums;

    @OneToMany(mappedBy = "teamId", fetch = FetchType.EAGER)
    @ToString.Exclude
    private List<Employee> employees;

    public void update(TeamDTO.RequestUpdate updateDTO) {
        this.teamName = updateDTO.getTeam_name();
        this.teamNums = updateDTO.getTeam_nums();

    }

    @Builder
    public Team(int teamId, String teamName, int teamNums) {
        this.teamId = teamId;
        this.teamName = teamName;
        this.teamNums = teamNums;
    }

}
