package com.dkbmc.web.MobileOffice.Domain;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@Getter
@DynamicInsert
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@ToString
@NamedEntityGraph(name = "office_office_desks", attributeNodes = @NamedAttributeNode("officeDesks"))
public class Office extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20)
    private String officeName;
    @Column( columnDefinition = "int(3)")
    private int floor;

    @OneToMany(mappedBy = "office", fetch = FetchType.EAGER)
    @ToString.Exclude
    private List<OfficeDesk> officeDesks;

    public void update(String officeName, int floor){
        this.officeName = officeName;
        this.floor = floor;
    }
    @Builder
    public Office(String officeName, int floor){
        this.officeName = officeName;
        this.floor = floor;
    }
}
