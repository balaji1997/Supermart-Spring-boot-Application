package com.example.Supermart.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="UserTable")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "userId", nullable = false)
    private Long userId;
    private String userName;
    private String password;


}
