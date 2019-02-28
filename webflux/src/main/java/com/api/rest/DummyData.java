package com.api.rest;

import java.util.UUID;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.api.rest.document.Playlist;
import com.api.rest.repository.PlaylistRepository;

import reactor.core.publisher.Flux;

@Component
public class DummyData implements CommandLineRunner {

	private final PlaylistRepository playlistRepository;

	DummyData(PlaylistRepository playlistRepository) {
		this.playlistRepository = playlistRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		playlistRepository.deleteAll()
			.thenMany(Flux.just("Bruno", "GitHub", "Web Service")
					.map(nome -> new Playlist(UUID.randomUUID().toString(), nome))
					.flatMap(playlistRepository::save))
			.subscribe(System.out::println);
	}

}