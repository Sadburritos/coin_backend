package com.example.coin.service;


import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.coin.dto.RateDataDto;
import com.example.coin.entity.RateData;
import com.example.coin.repository.CoinRepository;


import reactor.netty.http.client.HttpClient;

@Service
public class RateService {

	private final CoinRepository coinRepository;
	private final WebClient webClient;

	public RateService(WebClient.Builder webClientBuilder, CoinRepository coinRepository) {
		this.coinRepository = coinRepository;
		this.webClient = webClientBuilder.baseUrl("api.coincap.io")
				.clientConnector(
						new ReactorClientHttpConnector(HttpClient.create().compress(true).followRedirect(true)))
				.build();

	}

	@Scheduled(fixedRate = 10000)
	public void getBitcoinRate() {

		RateDataDto rateDataDto = webClient.get().uri("/v2/rates/bitcoin")
				.retrieve().bodyToMono(RateDataDto.class).block();
		RateData rateData = rateDataDto.getData();

		rateData.setTimestamp(rateDataDto.getTimestamp());

		coinRepository.save(rateData);

	}

}