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

@Entity
@Getter
@ToString
@DynamicInsert
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@NamedEntityGraph(name = "office_desk_status_office_desks", attributeNodes = @NamedAttributeNode("officeDesks"))
public class OfficeDeskStatus{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length = 20)
    private String status;

    @OneToMany(mappedBy = "officeDeskStatus", fetch = FetchType.EAGER)
    @ToString.Exclude
    private List<OfficeDesk> officeDesks;
}
