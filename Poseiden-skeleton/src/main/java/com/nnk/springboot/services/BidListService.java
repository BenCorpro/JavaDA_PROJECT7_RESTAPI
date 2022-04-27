package com.nnk.springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.repositories.BidListRepository;

@Service
public class BidListService {
  
  @Autowired
  private BidListRepository bidListRepository;
  
  public List<BidList> getAllBidList(){
    return bidListRepository.findAll();
  }
  
  public BidList saveBidList (BidList bidList) {
    return bidListRepository.save(bidList);
  }
  
  public BidList getBidListById (Integer id) {
    return bidListRepository.findById(id).orElse(null);
  }
  
  public void deleteBidListById (Integer id) {
    bidListRepository.deleteById(id);
  }
 
}
