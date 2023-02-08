package com.geekbrains.springboot.Entity;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

}
