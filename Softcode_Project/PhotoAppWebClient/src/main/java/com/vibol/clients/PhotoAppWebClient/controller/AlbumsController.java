package com.vibol.clients.PhotoAppWebClient.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.oidc.OidcIdToken;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.vibol.clients.PhotoAppWebClient.controller.response.AlbumRest;

@Controller
public class AlbumsController {
	
	@Autowired
	OAuth2AuthorizedClientService oauth2ClientService;
	// this client service
	
	@GetMapping("/albums")
	public String getAlbums(Model model, @AuthenticationPrincipal OidcUser principal) {
		
		// from spring security we can get the Authentication from SecurityContextHolder
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		OAuth2AuthenticationToken oauthToken = (OAuth2AuthenticationToken) authentication;
		//it means: “Treat auth as an OAuth2AuthenticationToken.”
		
//		1-step get the oath2 object 		
		OAuth2AuthorizedClient oauth2Client = oauth2ClientService.loadAuthorizedClient(oauthToken.getAuthorizedClientRegistrationId(), 
				oauthToken.getName());
		
		String jwtAccessToken = oauth2Client.getAccessToken().getTokenValue();
		
		System.out.println("*** jwtAccessToken = " + jwtAccessToken + "***");
		
		
		System.out.println("Principal = " + principal);
		
		
		OidcIdToken idToken = principal.getIdToken();
		String idTokenValue = idToken.getTokenValue();
		
		System.out.println("idTokenValue = " + idTokenValue);
		
		AlbumRest album = new AlbumRest();
		
		album.setAlbumId("albumOne");
		album.setAlbumTitle("Album one title");
		album.setAlbumUrl("http://localhost:8082/album/1");
		
		AlbumRest album2 = new AlbumRest();
		
		album2.setAlbumId("albumTwo");
		album2.setAlbumTitle("Album two title");
		album2.setAlbumUrl("http://localhost:8082/album/2");		
		
		/*
		// create list with two object album1 and album2
		List returnValue = Arrays.asList(album, album2);		
		//disply to the model 		
		model.addAttribute("albums",returnValue);		
		*/
		
		model.addAttribute("albums", Arrays.asList(album, album2));		
		return "albums";
	}
	
}
