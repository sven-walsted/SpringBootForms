package com.sven_walsted.spring.boot.mvc.forms.boundary;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HomeController {

  @GetMapping("/")
  public String uswds() {
    String msg = "Location: /";
    log.info(msg);
    return "home";
  }
  
}
