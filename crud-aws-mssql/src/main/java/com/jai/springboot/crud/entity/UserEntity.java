package com.jai.springboot.crud.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private Date dateOfBirth;


}
