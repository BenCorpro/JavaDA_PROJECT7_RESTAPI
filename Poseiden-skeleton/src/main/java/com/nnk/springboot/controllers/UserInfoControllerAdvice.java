package com.nnk.springboot.controllers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;


@ControllerAdvice
@SessionAttributes("userInfo")
public class UserInfoControllerAdvice {

  @ModelAttribute("userInfo")
  public String handleRequest(@ModelAttribute("userInfo") String userInfo) {
    return userInfo;
  }
}
