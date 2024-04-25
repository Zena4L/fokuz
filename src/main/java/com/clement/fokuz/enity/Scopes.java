package com.clement.fokuz.enity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Scopes {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String scope;

    @ManyToOne
    private Client client;

    public static Scopes from(String scope, Client c) {
        Scopes scopes = new Scopes();
        scopes.setScope(scope);
        scopes.setClient(c);
        return scopes;
    }
}
