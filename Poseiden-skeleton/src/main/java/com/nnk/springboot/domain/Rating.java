package com.nnk.springboot.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Entity
@Table(name = "rating")
public class Rating {
  
  @GeneratedValue(strategy= GenerationType.AUTO)
  private Integer id;
  @NotBlank
  private String moodysRating;
  @NotBlank
  private String sandPRating;
  @NotBlank
  private String fitchRating;
  @NotNull
  private Integer orderNumber;
  
  
  public Rating() {
  }

  public Rating(@NotBlank String moodysRating, @NotBlank String sandPRating,
      @NotBlank String fitchRating, @NotNull Integer orderNumber) {
    this.moodysRating = moodysRating;
    this.sandPRating = sandPRating;
    this.fitchRating = fitchRating;
    this.orderNumber = orderNumber;
  }
  
  
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }
  public String getMoodysRating() {
    return moodysRating;
  }
  public void setMoodysRating(String moodysRating) {
    this.moodysRating = moodysRating;
  }
  public String getSandPRating() {
    return sandPRating;
  }
  public void setSandPRating(String sandPRating) {
    this.sandPRating = sandPRating;
  }
  public String getFitchRating() {
    return fitchRating;
  }
  public void setFitchRating(String fitchRating) {
    this.fitchRating = fitchRating;
  }
  public Integer getOrderNumber() {
    return orderNumber;
  }
  public void setOrderNumber(Integer orderNumber) {
    this.orderNumber = orderNumber;
  }
  
  
}
