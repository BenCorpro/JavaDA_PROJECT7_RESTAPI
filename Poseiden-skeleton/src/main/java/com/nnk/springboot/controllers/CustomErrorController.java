package com.nnk.springboot.controllers;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomErrorController implements ErrorController{

  @RequestMapping("/error")
  public String handleError(HttpServletRequest request) {
    String errorPage ="";
    int errorCode = getErrorCode(request);
    
    switch(errorCode) {
      case 400:{
        errorPage = "error/400";
        break;
      }
      case 401: case 403:{
        errorPage = "error/403";
        break;
      }
      case 404: case 405:{
        errorPage = "error/404";
        break;
      }
      case 500:{
        errorPage = "error/500";
        break;
      }
      default:{
        errorPage = "home";
      }
    }
    return errorPage;
  }
  
  private int getErrorCode(HttpServletRequest request) {
    return (Integer)request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
  }
}
