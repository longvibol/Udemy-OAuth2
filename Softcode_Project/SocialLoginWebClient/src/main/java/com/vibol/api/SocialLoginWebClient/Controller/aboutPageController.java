package com.vibol.api.SocialLoginWebClient.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class aboutPageController {
	
	@GetMapping("/about")
	public String displayIndexPage(Model model) {
		
		return "about";
		
	}

}