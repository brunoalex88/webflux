package com.webflux.client;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.webflux.entity.Playlist;

@Service
public class PlaylistServiceClient {

	public List<Playlist> findAll() {

		WebClient client = WebClient.builder().baseUrl("http://localhost:8090")
				.defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).build();

		return client.get()
			.uri("/playlist")
			.accept(MediaType.APPLICATION_JSON_UTF8)
			.retrieve()
			.bodyToFlux(Playlist.class)
			.collectList()
			.block();
		
	}
	
}
