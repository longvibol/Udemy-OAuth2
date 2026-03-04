package com.vibol.clients.PhotoAppWebClient.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.vibol.clients.PhotoAppWebClient.controller.response.AlbumRest;

@Controller
public class AlbumsController {
	
	@GetMapping("/albums")
	public String getAlbums(Model model) {
		
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
