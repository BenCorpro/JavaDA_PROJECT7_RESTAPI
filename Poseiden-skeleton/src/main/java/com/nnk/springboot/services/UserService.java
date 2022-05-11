package com.nnk.springboot.services;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.nnk.springboot.domain.User;
import com.nnk.springboot.repositories.UserRepository;

@Service
public class UserService {
  
  private static Logger logger = LoggerFactory.getLogger(UserService.class);
  
  private UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  
  @Autowired
  public UserService(UserRepository userRepository,
      PasswordEncoder passwordEncoder) {
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
  }

  
  public List<User> getAllUser(){
    logger.info("Getting a list of all User");
    return userRepository.findAll();
  }
  
  @Transactional
  public User saveUser(User user) {
    if(Objects.isNull(user)) {
      logger.error("New User must not be null"); 
      return null;
    }
    logger.info("Creating a New User");
    User newUser = new User();
    newUser.setUsername(user.getUsername());
    newUser.setPassword(passwordEncoder.encode(user.getPassword()));
    newUser.setRole(user.getRole());
    newUser.setFullname(user.getFullname());
    return userRepository.save(newUser);    
  }
  
  @Transactional
  public User updateUser(Integer id, User user) {
    Optional<User> optUser = userRepository.findById(id);
    if(optUser.isPresent()) {
      User updatingUser = optUser.get();
      updatingUser.setUsername(user.getUsername());
      updatingUser.setPassword(passwordEncoder.encode(user.getPassword()));
      updatingUser.setRole(user.getRole());
      updatingUser.setFullname(user.getFullname());
      logger.info("User " + id + " updated");
      return userRepository.save(updatingUser);
    } else {
      logger.error("User with id: " + id + " not found nor updated");
      return null;
    }
  }
  
  public User getUserById(Integer id) {
    Optional<User> optUser = userRepository.findById(id);
    if(optUser.isPresent()) {
      logger.info("User with id " + id + " found");
      return optUser.get();
    } else {
      logger.error("User with id: " + id + " not found");
      return null;
    }
  }
  
  @Transactional
  public boolean deleteUserById(Integer id) {
    Optional<User> optUser = userRepository.findById(id);
    if(optUser.isPresent()) {
    userRepository.deleteById(id);
    logger.info("User with id " + id + " deleted");
    return true;
  } else {
    logger.error("User with id: " + id + " not found nor deleted");
    return false;
  }
  }
  
  public User getUserByUserName(String username){
    return userRepository.findByUsername(username);
  }
}
