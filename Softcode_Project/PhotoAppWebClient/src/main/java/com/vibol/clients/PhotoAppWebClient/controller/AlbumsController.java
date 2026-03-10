package com.vibol.clients.PhotoAppWebClient.controller;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import com.vibol.clients.PhotoAppWebClient.controller.response.AlbumRest;

@Controller
public class AlbumsController {

    private final RestTemplate restTemplate;

    public AlbumsController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/albums")
    public String getAlbums(
            Model model,
            @AuthenticationPrincipal OidcUser principal,
            @RegisteredOAuth2AuthorizedClient("mywebclient") OAuth2AuthorizedClient authorizedClient) {

        String accessToken = authorizedClient.getAccessToken().getTokenValue();

        String url = "http://localhost:8082/albums";

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(accessToken);

        HttpEntity<?> entity = new HttpEntity<>(headers);

        ResponseEntity<List<AlbumRest>> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<List<AlbumRest>>() {}
        );

        List<AlbumRest> albumsList = responseEntity.getBody();
        model.addAttribute("albums", albumsList);
        model.addAttribute("username", principal.getPreferredUsername());

        return "albums";
    }
}