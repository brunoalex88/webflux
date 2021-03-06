package com.api.rest;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class PlaylistRouter {

	@Bean
	public RouterFunction<ServerResponse> route(PlaylistHandler handler) {
		return RouterFunctions
				.route(GET("/playlist").and(accept(MediaType.APPLICATION_JSON_UTF8)), handler::findAll)
				.andRoute(GET("/stream/playlist").and(accept(MediaType.TEXT_EVENT_STREAM)), handler::findAll)
				.andRoute(GET("/playlist/{id}").and(accept(MediaType.APPLICATION_JSON_UTF8)), handler::findById)
				.andRoute(POST("/playlist").and(accept(MediaType.APPLICATION_JSON_UTF8)), handler::save);
	}
	
}
