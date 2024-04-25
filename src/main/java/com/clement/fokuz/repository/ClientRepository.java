package com.clement.fokuz.repository;

import com.clement.fokuz.enity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface ClientRepository extends JpaRepository<Client, UUID> {

    @Query("select u  from Client u where u.clientId = :clientId")
    Optional<Client> findByClientId(UUID clientId);
}
