package com.clement.fokuz.enity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.oauth2.core.AuthorizationGrantType;

import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "grant_types")
public class GrantTypes {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "grant_type")
    private String grantType;

    @ManyToOne
    private Client client;

    public static GrantTypes from(AuthorizationGrantType authorizationGrantType, Client client) {
        GrantTypes c = new GrantTypes();
        c.setGrantType(authorizationGrantType.getValue());
        c.setClient(client);

        return c;
    }
}
