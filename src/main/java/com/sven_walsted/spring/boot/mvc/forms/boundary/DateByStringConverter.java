package com.sven_walsted.spring.boot.mvc.forms.boundary;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class DateByStringConverter implements Converter<String, Date> {

  @Override
  public Date convert(String dateString) {
    Date date;
    if (dateString == null || "".equals(dateString.trim())) {
      date = null;
    } else {
      SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
      dateFormat.setLenient(false);
      try {
        date = dateFormat.parse(dateString);
      } catch (ParseException e) {
        log.error("Could not convert " + dateString + " to date: " + e.getMessage());
        date = null;
      }
    }
    log.info("Converted '" + dateString + "' to Date: " + date);
    return date;
  }

}
