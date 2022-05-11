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
@Table(name = "curvepoint")
public class CurvePoint {
  
  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private Integer id;
  @NotNull(message = "CurveId is mandatory")
  @Digits(fraction = 0, integer = 10)
  @Positive(message = "CurveId must be positive")
  private Integer curveId;
  private Timestamp asOfDate;
  @NotNull(message = "Term is mandatory")
  @Digits(fraction = 2, integer = 10)
  @Positive(message = "Term must be positive")
  private Double term;
  @NotNull(message = "Value is mandatory")
  @Digits(fraction = 2, integer = 10)
  @Positive(message = "Value must be positive")
  private Double value;
  private Timestamp creationDate;
  
  
  public CurvePoint() {
  }

  public CurvePoint(@NotNull Integer curveId, @NotBlank Double term,
      @NotBlank Double value) {
    this.curveId = curveId;
    this.term = term;
    this.value = value;
  }
  
  
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }
  public Integer getCurveId() {
    return curveId;
  }
  public void setCurveId(Integer curveId) {
    this.curveId = curveId;
  }
  public Timestamp getAsOfDate() {
    return asOfDate;
  }
  public void setAsOfDate(Timestamp asOfDate) {
    this.asOfDate = asOfDate;
  }
  public Double getTerm() {
    return term;
  }
  public void setTerm(Double term) {
    this.term = term;
  }
  public Double getValue() {
    return value;
  }
  public void setValue(Double value) {
    this.value = value;
  }
  public Timestamp getCreationDate() {
    return creationDate;
  }
  public void setCreationDate(Timestamp creationDate) {
    this.creationDate = creationDate;
  }
  
  
}
