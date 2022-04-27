package com.nnk.springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.repositories.RatingRepository;

@Service
public class RatingService {
  
  @Autowired
  private RatingRepository ratingRepository;
  
  public List<Rating> getAllRating(){
    return ratingRepository.findAll();
  }
  
  public Rating saveRating(Rating rating) {
    return ratingRepository.save(rating);
  }
  
  public Rating getRatingById(Integer id) {
    return ratingRepository.findById(id).orElse(null);
  }
  
  public void deleteRatingById(Integer id) {
    ratingRepository.deleteById(id);
  }

}
