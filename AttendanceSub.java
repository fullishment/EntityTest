package com.dkbmc.web.MobileOffice.Domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@NamedEntityGraph(name = "attendance_sub_working_statuses", attributeNodes = @NamedAttributeNode("workingStatuses"))
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AttendanceSub {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "attendance_main_id")
    private AttendanceMain attendanceMain;

    @Column(length = 50)
    private String sub_code;

    @OneToMany(mappedBy = "attendanceSub", fetch = FetchType.EAGER)
    private List<WorkingStatus> workingStatuses;

    @Builder
    public AttendanceSub(AttendanceMain attendanceMain, String sub_code) {
        this.attendanceMain = attendanceMain;
        this.sub_code = sub_code;
    }
}
