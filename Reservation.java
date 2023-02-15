package com.dkbmc.web.MobileOffice.Domain;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Entity
@ToString
@DynamicInsert
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Reservation extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "employed_id", nullable = false)
    private Employee employee;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Office_desk_id", nullable = false)
    @ToString.Exclude
    private OfficeDesk officeDesk;

    @Column(nullable = false)
    private LocalDate startDate;
    @Column(nullable = false)
    private LocalDate endDate;

    public void setOfficeDesk(OfficeDesk officeDesk) {
        this.officeDesk = officeDesk;
    }


    @Builder
    public Reservation( Long id, Employee employee, OfficeDesk officeDesk, LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.employee = employee;
        this.officeDesk = officeDesk;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
