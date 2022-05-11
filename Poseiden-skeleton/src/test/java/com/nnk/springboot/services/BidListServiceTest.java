package com.nnk.springboot.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.repositories.BidListRepository;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
public class BidListServiceTest {

  @Autowired
  private BidListService bidListService;
  @Autowired
  private BidListRepository bidListRepository;
  
  BidList bidTest = new BidList("Account Test", "Type Test", 10d);
  BidList bidDeleteTest = new BidList("Account Delete Test", "Type Delete Test", 30d);
  BidList bidUpdateTest = new BidList("Account Update Test", "Type Update Test", 50d);
  
  @BeforeAll
  public void setDb() {
    bidListRepository.deleteAll();
    bidListService.saveBidList(bidTest);
    bidListService.saveBidList(bidDeleteTest);
    bidListService.saveBidList(bidUpdateTest);
  }
  
  @Test
  public void testGetAllBidList() {
    List<BidList> bidListTest = bidListService.getAllBidList();
    assertNotNull(bidListTest);
    assertTrue(bidListTest.size()>0);
  }
  
  @Test
  public void testSaveBidList() {
    BidList saveBidListTest = new BidList("Account Save Test", "Type Save Test", 20d);
    saveBidListTest = bidListService.saveBidList(saveBidListTest);
    assertNotNull(saveBidListTest);
    assertEquals("Account Save Test",saveBidListTest.getAccount());
  }
  
  @Test
  public void testUpdateBidList() {
    Integer bidupdateIdTest = bidUpdateTest.getBidListId();
    BidList updateBidListTest = new BidList("Account Test Update", "Type Test Update", 40d);
    updateBidListTest = bidListService.updateBidList(bidupdateIdTest, updateBidListTest);
    assertNotNull(updateBidListTest);
    assertEquals("Account Test Update",updateBidListTest.getAccount());
  }
  
  @Test
  public void testGetBidListById() {
    Integer bidIdTest = bidTest.getBidListId();
    BidList bidByIdTest = bidListService.getBidListById(bidIdTest);
    assertNotNull(bidByIdTest);
    assertEquals("Type Test", bidByIdTest.getType());
  }
  
  @Test
  public void testDeleteBidListById() {
    Integer biddeleteIdTest = bidDeleteTest.getBidListId();
    bidListService.deleteBidListById(biddeleteIdTest);
    assertNull(bidListService.getBidListById(biddeleteIdTest));
  }
}
