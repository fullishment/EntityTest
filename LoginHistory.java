package com.dkbmc.web.MobileOffice.Domain;

import lombok.Getter;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@ToString
@DynamicInsert
public class LoginHistory{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "login_id", nullable = false)
    @ToString.Exclude
    private Login login;

    @CreatedDate
    private LocalDateTime created_datetime;

    public void setLogin(Login login) {
        this.login = login;
    }
}
