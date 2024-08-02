package com.sven_walsted.spring.boot.mvc.forms.boundary;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.sven_walsted.spring.boot.mvc.forms.controller.ApplicationService;
import com.sven_walsted.spring.boot.mvc.forms.controller.ApplicationService.Entity;
import com.sven_walsted.spring.boot.mvc.forms.entity.SearchForm;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class SearchController {

  @Autowired
  ApplicationService service;

  @ModelAttribute("accounts")
  public List<Entity> getAccounts() {
    return service.findAccounts();
  }
  
  @ModelAttribute("payees")
  public List<Entity> getPayees() {
    return service.findPayees();
  }

  /**
   * Search page components:
   * 
   * Account Name (drop-down): Wells, Cabela's, etc.
   * 
   * Budget Category Name (drop-down): Spending Money, Groceries, etc. Variation
   * on this could be, selecting parent category vs. child category.
   * 
   * Transaction Date range (two date selectors):
   * 
   * @return String - view template
   */
  @GetMapping("/search")
  public String search(Model model) {
    log.info("Location: /search -> search(Model model)");
    SearchForm searchForm = new SearchForm();
    model.addAttribute("searchForm", searchForm);
    return "searchForm";
  }

  /**
   * 
   * 
   * TODO: need to confirm my thinking here - the old way of passing in the
   * "parameters" object argument was to use: @ModelAttribute("searchForm")
   * 
   * @param searchForm
   * @param errors
   * @return
   */
  @GetMapping("/processSearch")
  public String processSearch(@Valid SearchForm searchForm, BindingResult result) {
    log.info("Location: /processSearch -> processSearch(@Valid SearchForm searchForm, BindingResult result)");
    log.info(searchForm.toString());
    if (result.hasErrors()) {
      // Normally this would be a different template
      log.info("..." + result.getAllErrors());
      return "searchForm";
    }
    return "searchForm";
  }

}
