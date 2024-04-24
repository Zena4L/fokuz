package com.clement.fokuz.enity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "grant_types")
public class GrantTypes {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "grant_type")
    private String grantType;

    @ManyToOne
    private Client client;
}
