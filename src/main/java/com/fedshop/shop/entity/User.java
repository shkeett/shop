package com.fedshop.shop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fedshop.shop.model.Role;
import com.fedshop.shop.model.Status;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(schema = "fed", name = "users")
public class User {

    @Id
    private Long id;

    @Column(name = "first_name", length = 30)
    private String firstName;

    @Column(name = "last_name", length = 30)
    private String lastName;

    @Email
    @Size(min = 5, max = 254)
    @Column(length = 254, unique = true)
    private String email;

    @Column(name = "password")
    @JsonIgnore
    private String password;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "role")
    private Role role;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "status")
    private Status status;

}
