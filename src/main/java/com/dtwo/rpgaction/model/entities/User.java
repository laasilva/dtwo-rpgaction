package com.dtwo.rpgaction.model.entities;

import com.dtwo.rpgaction.model.enums.Role;
import lombok.*;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user", schema = "public")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private Long id;

    @NonNull
    private String username;

    @NonNull
    private String email;

    @NonNull
    private String password;

    @Column(name = "reg_date")
    @NonNull
    private Date registrationDate;

    @NonNull
    private Role role;
}
