package com.nnk.springboot.domain;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.hibernate.annotations.DynamicUpdate;

import java.sql.Timestamp;

@DynamicUpdate
@Entity
@Table(name = "trade")
public class Trade {
  
  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private Integer tradeId;
  @NotBlank(message = "Account is mandatory")
  private String account;
  @NotBlank(message = "Type is mandatory")
  private String type;
  @NotNull(message = "Buy Quantity is mandatory")
  @Digits(fraction = 2, integer = 10)
  @Positive(message = "Buy Quantity must be positive")
  private Double buyQuantity;
  private Double sellQuantity;
  private Double buyPrice;
  private Double sellPrice;
  private Timestamp tradeDate;
  private String security;
  private String status;
  private String trader;
  private String benchmark;
  private String book;
  private String creationName;
  private Timestamp creationDate;
  private String revisionName;
  private Timestamp revisionDate;
  private String dealName;
  private String dealType;
  private String sourceListId;
  private String side;
  
  
  public Trade() {
  }
  
  public Trade(@NotBlank String account, @NotBlank String type,
      @NotNull Double buyQuantity) {
    super();
    this.account = account;
    this.type = type;
    this.buyQuantity = buyQuantity;
  }


  public Integer getTradeId() {
    return tradeId;
  }
  public void setTradeId(Integer tradeId) {
    this.tradeId = tradeId;
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
  public Double getBuyQuantity() {
    return buyQuantity;
  }
  public void setBuyQuantity(Double buyQuantity) {
    this.buyQuantity = buyQuantity;
  }
  
  
}
