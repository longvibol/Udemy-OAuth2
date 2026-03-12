package com.vibol.clients.PhotoAppWebClient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.reactive.function.client.WebClient;

import com.vibol.clients.PhotoAppWebClient.controller.response.AlbumRest;

@Controller
public class AlbumsController {

	
	@Autowired
	WebClient webClient;

    @GetMapping("/albums")
    public String getAlbums(
            Model model,@AuthenticationPrincipal OidcUser principal) {

        String url = "http://localhost:8082/albums";
        
        List<AlbumRest> albums = webClient.get()
        		.uri(url).retrieve().bodyToMono(new ParameterizedTypeReference<List<AlbumRest>>() {
				}).block();

        model.addAttribute("albums", albums);

        return "albums";
    }
}