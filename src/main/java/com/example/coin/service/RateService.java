package com.example.coin.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.coin.dto.RateDataDto;
import com.example.coin.entity.RateData;
import com.example.coin.repository.CoinRepository;



@Service
public class RateService {

	private final CoinRepository coinRepository;
	private final WebClient webClient;

	public RateService(WebClient.Builder webClientBuilder, CoinRepository coinRepository) {
		this.coinRepository = coinRepository;
		this.webClient = webClientBuilder.baseUrl("api.coincap.io").build();

	}



	@Scheduled(fixedRate = 30000)
		public void getBitcoinRate() {
		// TODO: Этот метод должен получать с API RateDataDto, извлекать из него
		// RateData, добавлять в него timestamp и сохранять в базу

		RateDataDto rateDataDto = this.webClient.get().uri("/v2/rates/bitcoin")
				.retrieve().bodyToMono(RateDataDto.class).block();

		RateData rateData = rateDataDto.getData();

		rateData.setTimestamp(rateDataDto.getTimestamp());

		coinRepository.save(rateData);

	}

}