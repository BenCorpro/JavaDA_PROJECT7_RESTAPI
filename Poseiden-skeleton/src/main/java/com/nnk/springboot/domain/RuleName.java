package com.nnk.springboot.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.DynamicUpdate;

@DynamicUpdate
@Entity
@Table(name = "rulename")
public class RuleName {
  
  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private Integer id;
  @NotBlank(message = "Name is mandatory")
  private String name;
  @NotBlank(message = "Description is mandatory")
  private String description;
  @NotBlank(message = "Json is mandatory")
  private String json;
  @NotBlank(message = "Template is mandatory")
  private String template;
  @NotBlank(message = "SqlStr is mandatory")
  private String sqlStr;
  @NotBlank(message = "SqlPart is mandatory")
  private String sqlPart;
  
  
  public RuleName() {
  }

  public RuleName(@NotBlank String name, @NotBlank String description,
      @NotBlank String json, @NotBlank String template, @NotBlank String sqlStr,
      @NotBlank String sqlPart) {
    super();
    this.name = name;
    this.description = description;
    this.json = json;
    this.template = template;
    this.sqlStr = sqlStr;
    this.sqlPart = sqlPart;
  }
  
  
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }
  public String getJson() {
    return json;
  }
  public void setJson(String json) {
    this.json = json;
  }
  public String getTemplate() {
    return template;
  }
  public void setTemplate(String template) {
    this.template = template;
  }
  public String getSqlStr() {
    return sqlStr;
  }
  public void setSqlStr(String sqlStr) {
    this.sqlStr = sqlStr;
  }
  public String getSqlPart() {
    return sqlPart;
  }
  public void setSqlPart(String sqlPart) {
    this.sqlPart = sqlPart;
  }
  
  
}
