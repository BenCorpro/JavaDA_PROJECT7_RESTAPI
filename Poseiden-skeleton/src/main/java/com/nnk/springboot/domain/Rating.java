package com.nnk.springboot.domain;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.hibernate.annotations.DynamicUpdate;

@DynamicUpdate
@Entity
@Table(name = "rating")
public class Rating {
  
  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private Integer id;
  @NotBlank(message = "Moodys Rating is mandatory")
  private String moodysRating;
  @NotBlank(message = "SandP Rating is mandatory")
  private String sandPRating;
  @NotBlank(message = "Fitch Rating is mandatory")
  private String fitchRating;
  @NotNull(message = "Order Number is mandatory")
  @Digits(fraction = 0, integer = 10)
  @Positive(message = "Order Number must be positive")
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
