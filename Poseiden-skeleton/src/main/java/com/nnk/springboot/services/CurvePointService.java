package com.nnk.springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.repositories.CurvePointRepository;

@Service
public class CurvePointService {
  
  @Autowired
  private CurvePointRepository curvePointRepository;
  
  public List<CurvePoint> getAllCurvePoint() {
    return curvePointRepository.findAll();
  }
  
  public CurvePoint saveCurvePoint(CurvePoint curvePoint) {
    return curvePointRepository.save(curvePoint);
  }
  
  public CurvePoint getCurvePointById(Integer id) {
    return curvePointRepository.findById(id).orElse(null);
  }
  
  public void deleteCurvePointById(Integer id) {
    curvePointRepository.deleteById(id);
  }

}
