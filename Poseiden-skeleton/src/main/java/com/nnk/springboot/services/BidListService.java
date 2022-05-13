package com.nnk.springboot.services;

import java.util.List;

import com.nnk.springboot.domain.BidList;

public interface BidListService {

  List<BidList> getAllBidList();

  BidList saveBidList(BidList bidList);

  BidList updateBidList(Integer id, BidList bidList);

  BidList getBidListById(Integer id);

  boolean deleteBidListById(Integer id);

}