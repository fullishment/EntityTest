package com.dkbmc.web.MobileOffice.Domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@NamedEntityGraph(name = "attendance_main_attendance_subs", attributeNodes = @NamedAttributeNode("attendanceSubs"))
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AttendanceMain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20)
    private String main_code;


    @OneToMany(mappedBy = "attendanceMain", fetch = FetchType.EAGER)
    private List<AttendanceSub> attendanceSubs;

    @Builder
    public AttendanceMain(String main_code) {
        this.main_code = main_code;
    }
}
