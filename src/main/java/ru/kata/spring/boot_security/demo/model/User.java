package ru.kata.spring.boot_security.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;


@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "age")
    private Byte age;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @ManyToMany
    @JoinTable(name = "users_roles",
            joinColumns  = @JoinColumn(name = "user_id"),
            inverseJoinColumns  = @JoinColumn(name = " role_id"))
    private Collection<Role> roles;

}
