package com.clement.fokuz.enity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "redirect_urls")
public class RedirectUrl {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String url;


    @ManyToOne
    private Client client;
}
