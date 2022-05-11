package com.nnk.springboot.services;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.repositories.BidListRepository;

@Service
public class BidListService {
  
  private static Logger logger = LoggerFactory.getLogger(BidListService.class);
  
  private BidListRepository bidListRepository;
  
  public BidListService(BidListRepository bidListRepository) {
    this.bidListRepository = bidListRepository;
  }

  public List<BidList> getAllBidList(){
    logger.info("Getting a list of all BidList");
    return bidListRepository.findAll();
  }
  
  @Transactional
  public BidList saveBidList (BidList bidList) {
    if(Objects.isNull(bidList)) {
      logger.error("New BidList must not be null"); 
      return null;
    }
    logger.info("Creating a New BidList");
    return bidListRepository.save(bidList);
  }
  
  @Transactional
  public BidList updateBidList (Integer id, BidList bidList){
    Optional<BidList> optBidList = bidListRepository.findById(id);
    if(optBidList.isPresent()) {
      BidList updatingBidList = optBidList.get();
      updatingBidList.setAccount(bidList.getAccount());
      updatingBidList.setType(bidList.getType());
      updatingBidList.setBidQuantity(bidList.getBidQuantity());
      logger.info("BidList " + id + " updated");
      return bidListRepository.save(updatingBidList);
    } else {
      logger.error("BidList with id: " + id + " not found nor updated");
      return null;
    }
  }
  
  public BidList getBidListById (Integer id){
    Optional<BidList> optBidList = bidListRepository.findById(id);
    if(optBidList.isPresent()) {
      logger.info("BidList with id " + id + " found");
      return optBidList.get();
    } else {
      logger.error("BidList with id: " + id + " not found");
      return null;
    }
  }
  
  @Transactional
  public boolean deleteBidListById (Integer id){
    Optional<BidList> optBidList = bidListRepository.findById(id);
    if(optBidList.isPresent()) {
      bidListRepository.deleteById(id);
      logger.info("BidList with id " + id + " deleted");
      return true;
    } else {
      logger.error("BidList with id: " + id + " not found nor deleted");
      return false;
    }
  }
 
}
