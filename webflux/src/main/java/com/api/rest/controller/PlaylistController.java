package com.api.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.api.rest.document.Playlist;
import com.api.rest.service.PlaylistService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

// @RestController
public class PlaylistController {

	@Autowired
	private PlaylistService playlistService;
	
	@GetMapping("/playlist")
	public Flux<Playlist> getPlaylists() {
		return playlistService.findAll();
	}
	
	@GetMapping("/playlist/{id}")
	public Mono<Playlist> getPlaylistById(@PathVariable String id) {
		return playlistService.findById(id);
	}
	
	@PostMapping("/playlist")
	public Mono<Playlist> savePlaylist(@RequestBody Playlist playlist) {
		return playlistService.save(playlist);
	}
	
}
