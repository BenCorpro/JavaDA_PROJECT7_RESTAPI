package com.nnk.springboot.domain;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import java.sql.Timestamp;

@DynamicUpdate
@Entity
@Table(name = "bidlist")
public class BidList {
  
  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private Integer bidListId;
  @NotBlank(message = "Account is mandatory")
  private String account;
  @NotBlank(message = "Type is mandatory")
  private String type;
  @NotNull
  @Digits(fraction = 2, integer = 10)
  @Positive(message="Bid Quantity must be positive")
  private Double bidQuantity;
  private Double askQuantity;
  private Double bid;
  private Double ask;
  private String benchmark;
  private Timestamp bidListDate;
  private String commentary;
  private String security;
  private String status;
  private String trader;
  private String book;
  private String creationName;
  private Timestamp creationDate;
  private String revisionName;
  private Timestamp revisionDate;
  private String dealName;
  private String dealType;
  private String sourceListId;
  private String side;
  
  
  public BidList() {
  }

  public BidList(@NotBlank(message = "Account is mandatory") String account,
      @NotBlank(message = "Type is mandatory") String type,
      @NotBlank Double bidQuantity) {
    this.account = account;
    this.type = type;
    this.bidQuantity = bidQuantity;
  }
  
  
  public Integer getBidListId() {
    return bidListId;
  }
  public void setBidListId(Integer bidListId) {
    this.bidListId = bidListId;
  }
  public String getAccount() {
    return account;
  }
  public void setAccount(String account) {
    this.account = account;
  }
  public String getType() {
    return type;
  }
  public void setType(String type) {
    this.type = type;
  }
  public Double getBidQuantity() {
    return bidQuantity;
  }
  public void setBidQuantity(Double bidQuantity) {
    this.bidQuantity = bidQuantity;
  }

  public Double getAskQuantity() {
    return askQuantity;
  }

  public Double getBid() {
    return bid;
  }

  public Double getAsk() {
    return ask;
  }

  public String getBenchmark() {
    return benchmark;
  }

  public Timestamp getBidListDate() {
    return bidListDate;
  }

  public String getCommentary() {
    return commentary;
  }

  public String getSecurity() {
    return security;
  }

  public String getStatus() {
    return status;
  }

  public String getTrader() {
    return trader;
  }

  public String getBook() {
    return book;
  }

  public String getCreationName() {
    return creationName;
  }

  public Timestamp getCreationDate() {
    return creationDate;
  }

  public String getRevisionName() {
    return revisionName;
  }

  public Timestamp getRevisionDate() {
    return revisionDate;
  }

  public String getDealName() {
    return dealName;
  }

  public String getDealType() {
    return dealType;
  }

  public String getSourceListId() {
    return sourceListId;
  }

  public String getSide() {
    return side;
  }

  
}
