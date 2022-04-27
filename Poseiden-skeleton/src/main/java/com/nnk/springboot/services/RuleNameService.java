package com.nnk.springboot.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nnk.springboot.domain.RuleName;
import com.nnk.springboot.repositories.RuleNameRepository;

@Service
public class RuleNameService {
  
  private RuleNameRepository ruleNameRepository;
  
  public List<RuleName> getAllRuleName(){
    return ruleNameRepository.findAll();
  }
  
  public RuleName saveRuleName(RuleName ruleName) {
    return ruleNameRepository.save(ruleName);
  }
  
  public RuleName getRuleNameById(Integer id) {
    return ruleNameRepository.findById(id).orElse(null);
  }
  
  public void deleteRuleNameById(Integer id) {
    ruleNameRepository.deleteById(id);
  }

}
