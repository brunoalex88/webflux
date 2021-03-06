package com.api.rest.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.api.rest.document.Playlist;

public interface PlaylistRepository extends ReactiveMongoRepository<Playlist, String> {

}