package com.sven_walsted.spring.boot.mvc.forms.entity;

import java.util.Date;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SearchForm {

  private String computerModel;

  @NotNull(message = "Required")
  private Date startDate;

  @NotNull(message = "Required")
  private Date endDate;

  public String getStartDateDefaultValue() {
    return (startDate != null) ? new java.sql.Date(startDate.getTime()).toString() : "";
  }

  public String getEndDateDefaultValue() {
    return (endDate != null) ? new java.sql.Date(endDate.getTime()).toString() : "";
  }
}
