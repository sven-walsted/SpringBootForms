package com.sven_walsted.spring.boot.mvc.forms.boundary;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sven_walsted.spring.boot.mvc.forms.entity.Computer;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class JdbcRepository {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  public Iterable<Computer> findAllComputers() {
    final String sqlQuery = """
          select
          id, computer_name, computer_model, computer_serial_no, inventory_id,
          location, user_name, user_email, last_seen_date, notes
        from computer
        order by
          inventory_id ASC
            """;
    return jdbcTemplate.query(sqlQuery, this::mapRowToComputer);
  }

  public Iterable<Computer> findComputersBetweenLastSeenDate(Date startDate, Date endDate) {
    final String sqlQuery = """
          select
          id, computer_name, computer_model, computer_serial_no, inventory_id,
          location, user_name, user_email, last_seen_date, notes
        from computer
          where last_seen_date between ? and ?
        order by
          inventory_id ASC
            """;
    return jdbcTemplate.query(sqlQuery, this::mapRowToComputer, startDate, endDate);
  }

  private Computer mapRowToComputer(ResultSet rs, int rowNum) throws SQLException {
    Computer computer = new Computer();
    computer.setId(rs.getLong("id"));
    computer.setComputerName(rs.getString("computer_name"));
    computer.setComputerModel(rs.getString("computer_model"));
    computer.setComputerSerialNo(rs.getString("computer_serial_no"));
    computer.setInventoryId(rs.getString("inventory_id"));
    computer.setLocation(rs.getString("location"));
    computer.setUserName(rs.getString("user_name"));
    computer.setUserEmail(rs.getString("user_email"));
    computer.setLastSeenDate(rs.getDate("last_seen_date"));
    computer.setNotes(rs.getString("notes"));
    return computer;
  }

  public Iterable<String> findAllComputerModel() {
    final String sqlQuery = """
          select distinct
          computer_model
        from computer
        order by
          computer_model ASC
            """;
    return jdbcTemplate.query(sqlQuery, this::mapRowToComputerModel);
  }
  
  private String mapRowToComputerModel(ResultSet rs, int rowNum) throws SQLException {
    return rs.getString("computer_model");
  }

}
