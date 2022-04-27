package com.nnk.springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.repositories.TradeRepository;

@Service
public class TradeService {

  @Autowired
  private TradeRepository tradeRepository;
  
  public List<Trade> getAllTrade(){
    return tradeRepository.findAll();
  }
  
  public Trade saveTrade(Trade trade) {
    return tradeRepository.save(trade);
  }
  
  public Trade getTradeById(Integer id) {
    return tradeRepository.findById(id).orElse(null);
  }
  
  public void deleteById(Integer id) {
    tradeRepository.deleteById(id);
  }
}
