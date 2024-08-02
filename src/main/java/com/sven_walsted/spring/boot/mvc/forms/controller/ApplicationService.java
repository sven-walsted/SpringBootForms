package com.sven_walsted.spring.boot.mvc.forms.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ApplicationService {

  public static class Entity {

    Integer id;
    String name;

    public Entity(Integer id, String name) {
      this.id = id;
      this.name = name;
    }

    public Integer getId() {
      return id;
    }

    public String getName() {
      return name;
    }

  }

  public List<Entity> findAccounts() {
    List<Entity> results = new ArrayList<Entity>();
    String[] payees = { "All Accounts", "Bank of America CC", "Chase CC", "USAA CC", "Wells Fargo ATM" };
    for (int i = 0; i < payees.length; i++) {
      results.add(new Entity((i == 0) ? null : i + 10, payees[i]));
    }
    return results;
  }
  
  public List<Entity> findPayees() {
    List<Entity> results = new ArrayList<Entity>();
    String[] payees = { "Choose", "Accenture", "Amazon", "Bass Pro Shop", "Cabela's", "Costco", "Dell",
        "Deluth Trading Co", "Home Depot", "IBM", "Oracle", "REI", "Sportsman's", "Starbucks", "Target" };
    for (int i = 0; i < payees.length; i++) {
      results.add(new Entity((i == 0) ? null : i + 100, payees[i]));
    }
    return results;
  }
}
