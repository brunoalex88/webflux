package com.webflux.client;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.webflux.entity.Playlist;

import reactor.core.publisher.Flux;

@Service
public class PlaylistServiceClient {

	public Flux<Playlist> findAll() {
			
		  WebClient client = WebClient 
				  .builder() 
				  .baseUrl("http://localhost:8090")
				  .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				  .build();
		  
		  return client.get()
				  .uri("/playlists")
				  .exchange()
				  .flatMapMany(clientResponse -> clientResponse.bodyToFlux(Playlist.class));
		
	}
	
}
