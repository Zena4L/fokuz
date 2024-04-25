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
@Table(name = "redirect_urls")
public class RedirectUrl {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String url;


    @ManyToOne
    private Client client;

    public static RedirectUrl from(String url, Client c) {
        RedirectUrl redirectUrl = new RedirectUrl();
        redirectUrl.setUrl(url);
        redirectUrl.setClient(c);
        return redirectUrl;
    }
}
