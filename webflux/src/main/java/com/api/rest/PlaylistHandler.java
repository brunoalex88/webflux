package com.api.rest;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;
import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.api.rest.document.Playlist;
import com.api.rest.service.PlaylistService;

import reactor.core.publisher.Mono;

@Component
public class PlaylistHandler {

	@Autowired
	private PlaylistService playlistService;

	public Mono<ServerResponse> findAll(ServerRequest request) {
		return ok()
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.body(playlistService.findAll(), Playlist.class);
	}
	
	public Mono<ServerResponse> findAllStream(ServerRequest request) {
		return ok()
				.contentType(MediaType.TEXT_EVENT_STREAM)
				.body(playlistService.findAll(), Playlist.class);
	}

	public Mono<ServerResponse> findById(ServerRequest request) {
		String id = request.pathVariable("id");
		return ok()
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.body(playlistService.findById(id), Playlist.class);
	}
	
	public Mono<ServerResponse> save(ServerRequest request) {
		final Mono<Playlist> playlist = request.bodyToMono(Playlist.class);
		return ok()
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.body(fromPublisher(playlist.flatMap(playlistService::save), Playlist.class));
	}

}
