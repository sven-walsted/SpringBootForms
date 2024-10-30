drop table if exists computer;

create table if not exists computer (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  computer_name varchar(255) default NULL,
  computer_model varchar(255) default NULL,
  computer_serial_no varchar(255),
  inventory_id varchar(255) default NULL,
  location varchar(255) default NULL,
  user_name varchar(255) default NULL,
  user_email varchar(255) default NULL,
  notes varchar(1000) default NULL,
  last_seen_date DATE NULL,
  PRIMARY KEY(id)
);

