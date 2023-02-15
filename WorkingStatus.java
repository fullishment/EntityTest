package com.dkbmc.web.MobileOffice.Domain;

import com.dkbmc.web.MobileOffice.DTO.WorkingStatusDTO;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

@Getter
@Entity
@DynamicInsert
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class WorkingStatus extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "attendance_sub_id")
    private AttendanceSub attendanceSub;
    @Column(length = 20)
    private String eventsTxt;

    public void update (WorkingStatusDTO.RequestUpdate requestDTO){

        this.attendanceSub = requestDTO.getAttendance_sub();
        this.eventsTxt = requestDTO.getEvents_txt();

    }
    @Builder
    public WorkingStatus(Employee employee, AttendanceSub attendanceSub, String eventsTxt) {
        this.employee = employee;
        this.attendanceSub = attendanceSub;
        this.eventsTxt = eventsTxt;
    }
}
