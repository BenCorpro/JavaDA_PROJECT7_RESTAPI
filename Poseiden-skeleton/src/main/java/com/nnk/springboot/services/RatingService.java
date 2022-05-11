package com.nnk.springboot.services;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.repositories.RatingRepository;

@Service
public class RatingService {
  
  private static Logger logger = LoggerFactory.getLogger(RatingService.class);
  
  private RatingRepository ratingRepository;
  
  public RatingService(RatingRepository ratingRepository) {
    this.ratingRepository = ratingRepository;
  }

  public List<Rating> getAllRating(){
    logger.info("Getting a list of all Rating");
    return ratingRepository.findAll();
  }
  
  @Transactional
  public Rating saveRating(Rating rating) {
    if(Objects.isNull(rating)) {
      logger.error("New Rating must not be null"); 
      return null;
    }
    logger.info("Creating a New Rating");
    return ratingRepository.save(rating);
  }
  
  @Transactional
  public Rating updateRating(Integer id, Rating rating) {
    Optional<Rating> optRating = ratingRepository.findById(id);
    if(optRating.isPresent()) {
      Rating updatingRating = optRating.get();
      updatingRating.setMoodysRating(rating.getMoodysRating());
      updatingRating.setSandPRating(rating.getSandPRating());
      updatingRating.setFitchRating(rating.getFitchRating());
      updatingRating.setOrderNumber(rating.getOrderNumber());
      logger.info("Rating " + id + " updated");
      return ratingRepository.save(updatingRating);
    } else {
      logger.error("Rating with id: " + id + " not found nor updated");
      return null;
    }
  }
  
  public Rating getRatingById(Integer id) {
    Optional<Rating> optRating = ratingRepository.findById(id);
    if(optRating.isPresent()) {
      logger.info("Rating with id " + id + " found");
      return optRating.get();
    } else {
      logger.error("Rating with id: " + id + " not found");
      return null;
    }
  }
  
  @Transactional
  public boolean deleteRatingById(Integer id) {
    Optional<Rating> optRating = ratingRepository.findById(id);
    if(optRating.isPresent()) {
      ratingRepository.deleteById(id);
      logger.info("Rating with id " + id + " deleted");
      return true;
    } else {
      logger.error("Rating with id: " + id + " not found nor deleted");
      return false;
    }
  }

}
