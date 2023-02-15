package com.dkbmc.web.MobileOffice.Domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@NamedEntityGraph(name = "roles_members", attributeNodes = @NamedAttributeNode("members"))
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "varchar(10)", nullable = false)
    private String role;
    @OneToMany(mappedBy = "roles_id", fetch = FetchType.EAGER)
    @ToString.Exclude
    private List<Member> members;

    @Builder
    public Roles(Long id) {
        this.id = id;
    }
}
