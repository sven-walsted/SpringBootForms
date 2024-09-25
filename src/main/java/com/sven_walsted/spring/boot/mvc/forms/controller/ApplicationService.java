package com.sven_walsted.spring.boot.mvc.forms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicationService {
  
  @Autowired
  JdbcRepository jdbcRepository;


  public Iterable<String> findComputerModels() {
    Iterable<String> models = jdbcRepository.findAllComputerModel();
    return models;
  }

}
