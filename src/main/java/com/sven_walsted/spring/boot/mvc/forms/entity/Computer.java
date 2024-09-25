package com.sven_walsted.spring.boot.mvc.forms.entity;

import java.util.Date;

import lombok.Data;

@Data
//Entity important for Spring Boot to determine this is controlled by JPA.
//@Entity
//@Table(name = "COMPUTER")
public class Computer {

  public static class Builder {

    private Long id;

    private String computerName;

    private String computerModel;

    private String computerSerialNo;
//
    private String inventoryId;

    private String location;

    private String userName;

    private String userEmail;
    
    private Date lastSeenDate;

    private String notes;

    private Builder() {

    }

    public static Builder instance() {
      return new Builder();
    }

    public Long getId() {
      return id;
    }

    public Builder setComputerName(String computerName) {
      this.computerName = computerName;
      return this;
    }

    public void setId(Long id) {
      this.id = id;
    }

    public Builder setComputerModel(String computerModel) {
      this.computerModel = computerModel;
      return this;
    }

    public Builder setComputerSerialNo(String computerSerialNo) {
      this.computerSerialNo = computerSerialNo;
      return this;
    }

    public Builder setInventoryId(String inventoryId) {
      this.inventoryId = inventoryId;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setUserName(String userName) {
      this.userName = userName;
      return this;
    }

    public Builder setUserEmail(String userEmail) {
      this.userEmail = userEmail;
      return this;
    }

    public Builder setNotes(String notes) {
      this.notes = notes;
      return this;
    }

    public Computer build() {
      Computer computer = new Computer();
      computer.setComputerName(this.computerName);
      computer.setComputerModel(this.computerModel);
      return computer;
    }
  }

  private static final long serialVersionUID = 1L;

//  @Id
//  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String computerName;

  private String computerModel;

  private String computerSerialNo;

  private String inventoryId;

  private String location;

  private String userName;

  private String userEmail;
  
  private Date lastSeenDate;

  private String notes;
  
}
