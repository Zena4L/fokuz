package com.clement.fokuz.enity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.settings.OAuth2TokenFormat;
import org.springframework.security.oauth2.server.authorization.settings.TokenSettings;

import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.function.Consumer;

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

    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
    private List<AuthenticationMethods> authenticationMethods;

    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
    private List<GrantTypes> grantTypes;

    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
    private List<RedirectUrl> redirectUrls;


    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
    private List<Scopes> scopes;

    @OneToOne(mappedBy = "client")
    private Token token;

    public static RegisteredClient fromRegisterClient(Client c) {
        return RegisteredClient.withId(String.valueOf(c.getId()))
                .clientId(c.clientId)
                .clientSecret(c.clientId)
                .clientAuthenticationMethods(clientAuthenticationMethod(c.getAuthenticationMethods()))
                .authorizationGrantTypes(authorizationGrantTypes(c.getGrantTypes()))
                .scopes(scopes(c.getScopes()))
                .redirectUris(redirectUris(c.getRedirectUrls()))
                .tokenSettings(TokenSettings.builder()
                        .accessTokenTimeToLive(Duration.ofHours(c.token.getAccessTokenTTL()))
                        .accessTokenFormat(new OAuth2TokenFormat(c.token.getType()))
                        .build())
                .build();

    }

    private static Consumer<Set<AuthorizationGrantType>> authorizationGrantTypes(List<GrantTypes> grantTypes) {
        return s -> {
            for (GrantTypes g : grantTypes) {
                s.add(new AuthorizationGrantType(g.getGrantType()));
            }
        };

    }

    private static Consumer<Set<ClientAuthenticationMethod>> clientAuthenticationMethod(List<AuthenticationMethods> authenticationMethods) {
        return m -> {
            for (AuthenticationMethods a : authenticationMethods) {
                m.add(new ClientAuthenticationMethod(a.getAuthentcationMethod()));
            }
        };
    }

    private static Consumer<Set<String>> scopes(List<Scopes> scopes) {
        return m -> {
            for (Scopes s : scopes) {
                m.add(s.getScope());
            }
        };
    }

    private static Consumer<Set<String>> redirectUris(List<RedirectUrl> redirectUrls) {
        return m -> {
            for (RedirectUrl x : redirectUrls) {
                m.add(x.getUrl());
            }
        };
    }

}
