package com.dkbmc.web.MobileOffice.Domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@Getter
@Entity
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@NamedEntityGraph(name = "office_desk_reservation", attributeNodes = @NamedAttributeNode("reservation"))
public class OfficeDesk extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(foreignKey = @ForeignKey(name = "office_id"))
    @ToString.Exclude
    private Office office;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "office_desk_status_id")
    @ToString.Exclude
    private OfficeDeskStatus officeDeskStatus;

    @Column (columnDefinition = "int(5)")
    private int deskNumber;

    @OneToMany(mappedBy = "officeDesk", fetch = FetchType.EAGER)
    @ToString.Exclude
    private List<Reservation> reservation;

    public void setOfficeDeskStatus(OfficeDeskStatus officeDeskStatus) {
        this.officeDeskStatus = officeDeskStatus;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

}
