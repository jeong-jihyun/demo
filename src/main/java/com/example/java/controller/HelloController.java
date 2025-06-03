package com.example.java.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class HelloController {
  @GetMapping("/hello")
  public String getMethodName(@RequestParam(required = false) String param) {
      return "Hello \"" + param + "\" Spring!";
  }
  
}
