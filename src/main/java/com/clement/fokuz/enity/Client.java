package com.clement.fokuz.enity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "client_id")
    private String clientId;

    private String secret;

    private String authentication;

    @OneToMany(mappedBy = "client")
    private List<GrantTypes> grantTypes;

    @OneToMany(mappedBy = "client")
    private List<RedirectUrl> redirectUrls;

}
