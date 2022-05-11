package com.nnk.springboot.services;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.nnk.springboot.domain.RuleName;
import com.nnk.springboot.repositories.RuleNameRepository;

@Service
public class RuleNameService {
  
  private static Logger logger = LoggerFactory.getLogger(RuleNameService.class);
  
  private RuleNameRepository ruleNameRepository;
  
  public RuleNameService(RuleNameRepository ruleNameRepository) {
    this.ruleNameRepository = ruleNameRepository;
  }

  public List<RuleName> getAllRuleName(){
    logger.info("Getting a list of all RuleName");
    return ruleNameRepository.findAll();
  }
  
  @Transactional
  public RuleName saveRuleName(RuleName ruleName) {
    if(Objects.isNull(ruleName)) {
      logger.error("New RuleName must not be null"); 
      return null;
    }
    logger.info("Creating a New RuleName");
    return ruleNameRepository.save(ruleName);
  }
  
  @Transactional
  public RuleName updateRuleName(Integer id, RuleName ruleName) {
    Optional<RuleName> optRuleName = ruleNameRepository.findById(id);
    if(optRuleName.isPresent()) {
      RuleName updatingRuleName = optRuleName.get();
      updatingRuleName.setName(ruleName.getName());
      updatingRuleName.setDescription(ruleName.getDescription());
      updatingRuleName.setJson(ruleName.getJson());
      updatingRuleName.setTemplate(ruleName.getTemplate());
      updatingRuleName.setSqlStr(ruleName.getSqlStr());
      updatingRuleName.setSqlPart(ruleName.getSqlPart());
      return ruleNameRepository.save(updatingRuleName);
    } else {
      logger.error("RuleName with id: " + id + " not found nor updated");
      return null;
    }
  }
  
  public RuleName getRuleNameById(Integer id) {
    Optional<RuleName> optRuleName = ruleNameRepository.findById(id);
    if(optRuleName.isPresent()) {
      logger.info("RuleName with id " + id + " found");
      return optRuleName.get();
    } else {
      logger.error("RuleName with id: " + id + " not found");
      return null;
    }
  }
  
  @Transactional
  public boolean deleteRuleNameById(Integer id) {
    Optional<RuleName> optRuleName = ruleNameRepository.findById(id);
    if(optRuleName.isPresent()) {
      logger.info("RuleName with id " + id + " deleted");
      ruleNameRepository.deleteById(id);
      return true;
    } else {
      logger.error("RuleName with id: " + id + " not found nor deleted");
      return false;
    } 
  }

}
