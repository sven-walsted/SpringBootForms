package com.sven_walsted.spring.boot.mvc.forms.boundary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.sven_walsted.spring.boot.mvc.forms.controller.ApplicationService;
import com.sven_walsted.spring.boot.mvc.forms.entity.Computer;
import com.sven_walsted.spring.boot.mvc.forms.entity.SearchForm;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class SearchController {

  @Autowired
  ApplicationService service;

  @Autowired
  JdbcRepository jdbcRepository;

  @ModelAttribute("computerModels")
  public Iterable<String> getComputerModels() {
    return service.findComputerModels();
  }

  @GetMapping("/search")
  public String search(Model model) {
    log.info("Location: /search -> search(Model model)");
    SearchForm searchForm = new SearchForm();
    model.addAttribute("searchForm", searchForm);
    return "searchForm";
  }

  @GetMapping("/processSearch")
  public String processSearch(@Valid SearchForm searchForm, BindingResult result, Model model) {
    log.info("Location: /processSearch -> processSearch(@Valid SearchForm searchForm, BindingResult result)");
    log.info(searchForm.toString());
    if (result.hasErrors()) {
      log.info("..." + result.getAllErrors());
      return "searchForm";
    }
    Iterable<Computer> computers = jdbcRepository.findComputersBetweenLastSeenDate(searchForm.getStartDate(),
        searchForm.getEndDate());
    model.addAttribute("documents", computers);
    return "searchResults";
  }

}
