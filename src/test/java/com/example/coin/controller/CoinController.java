package com.example.coin.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.coin.entity.RateData;
import com.example.coin.repository.CoinRepository;

@RestController
public class CoinController {
    private final CoinRepository coinRepository;

    public CoinController(CoinRepository coinRepository) {
        this.coinRepository = coinRepository;
    }

    @GetMapping("/rateData")
	public ResponseEntity<List<RateData>> getAllData() {
		List<RateData> rateData = coinRepository.findAll();
		return ResponseEntity.ok(rateData);
	}

    
	@GetMapping("/rateData/{timestamp}")
	public ResponseEntity<Optional<RateData>> getUserById(@PathVariable Long timestamp) {        
        Optional<RateData> findedCoin = coinRepository.findById(timestamp);

		if (findedCoin.isEmpty()) {
			return ResponseEntity.badRequest().build();
		}

		return ResponseEntity.ok(findedCoin);
	}


	@PostMapping("/rateData")
	public ResponseEntity<RateData> createNewData(@RequestBody RateData rateData) {
		RateData savedData = coinRepository.save(rateData);

		return ResponseEntity.ok(savedData);
	}

	@DeleteMapping("/users/{id}")
	public ResponseEntity<Void> deleteDataByTimestamp(@PathVariable Long timestamp) {

		 coinRepository.deleteById(timestamp);

		return ResponseEntity.ok().build();
	}


    
}
