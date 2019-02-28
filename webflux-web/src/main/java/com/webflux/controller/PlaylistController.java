package com.webflux.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.webflux.client.PlaylistServiceClient;

@Controller
public class PlaylistController {

	@Autowired
	private PlaylistServiceClient client;
	
	@GetMapping("/playlists")
	public ModelAndView listarPlaylists(Model model) {
		model.addAttribute("playlists", client.findAll());
		return new ModelAndView("listar");
	}
	
}
