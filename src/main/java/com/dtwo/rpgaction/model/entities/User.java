package com.dtwo.rpgaction.model.entities;

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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NonNull
    private Long id;

    @NonNull
    private String username;

    @NonNull
    private String password;

    @Column(name = "reg_date")
    @NonNull
    private Date registrationDate;
}
