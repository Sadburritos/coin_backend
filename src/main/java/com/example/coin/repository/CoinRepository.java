package com.example.coin.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.coin.entity.RateData;

@Repository
public interface CoinRepository extends JpaRepository<RateData, Long> {
    
    
}