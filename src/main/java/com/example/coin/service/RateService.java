package com.example.coin.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.coin.dto.RateDataDto;

import reactor.core.publisher.Mono;

@Service
public class RateService {

	private final WebClient webClient;

	public RateService(WebClient.Builder webClientBuilder) {
		this.webClient = webClientBuilder.baseUrl("api.coincap.io").build();
	}

	public Mono<RateDataDto> getBitcoinRate() {
		//TODO: Этот метод должен получать с API  RateDataDto, извлекать из него RateData, добавлять в него timestamp и сохранять в базу
		return this.webClient.get().uri("/v2/rates/bitcoin")
			.retrieve().bodyToMono(RateDataDto.class);
	}

}