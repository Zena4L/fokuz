package com.clement.fokuz.enity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;

import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "authentication_methods")
public class AuthenticationMethods {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;


    @Column(name = "authentication_method")
    private String authentcationMethod;

    @ManyToOne
    private Client client;

    public static AuthenticationMethods from(ClientAuthenticationMethod authenticationMethod, Client client) {
        AuthenticationMethods a = new AuthenticationMethods();
        a.setAuthentcationMethod(authenticationMethod.getValue());
        a.setClient(client);
        return a;
    }
}
