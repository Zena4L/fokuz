package com.clement.fokuz.service;


import com.clement.fokuz.enity.*;
import com.clement.fokuz.repository.ClientRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
@Primary
public class ClientService implements RegisteredClientRepository {

    private ClientRepository clientRepository;

    @Override
    public void save(RegisteredClient registeredClient) {
//        Client client = Client.builder()
//                .clientId(registeredClient.getClientId())
//                .secret(registeredClient.getClientSecret())
//                .authenticationMethods(registeredClient.getClientAuthenticationMethods().stream()
//                        .map(AuthenticationMethods.from()).toList())
//                .build();

        Client c = new Client();
        c.setClientId(registeredClient.getClientId());
        c.setSecret(registeredClient.getClientSecret());
        c.setAuthenticationMethods(registeredClient.getClientAuthenticationMethods().stream()
                .map(a -> AuthenticationMethods.from(a, c)).toList());
        c.setGrantTypes(registeredClient.getAuthorizationGrantTypes().stream().map(g -> GrantTypes.from(g, c)).toList());
        c.setRedirectUrls(registeredClient.getRedirectUris().stream().map(url -> RedirectUrl.from(url, c)).toList());
        c.setScopes(registeredClient.getScopes().stream().map(s -> Scopes.from(s, c)).toList());
        clientRepository.save(c);

    }

    @Override
    public RegisteredClient findById(String id) {
        var c = clientRepository.findById(UUID.fromString(id));
        return c.map(Client::fromRegisterClient).orElseThrow(() -> new RuntimeException("Error"));
    }

    @Override
    public RegisteredClient findByClientId(String clientId) {
        var c = clientRepository.findByClientId(UUID.fromString(clientId));
        return c.map(Client::fromRegisterClient).orElseThrow(() -> new RuntimeException("Error"));
    }
}
