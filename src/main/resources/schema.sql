DROP TABLE IF EXISTS task;
-- -----------------------------------------------------
-- Table `taskDB`.`task`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS task (
  id BIGINT(20) NOT NULL AUTO_INCREMENT,
  title VARCHAR(45) NOT NULL,
  description LONGTEXT NULL,
  priority VARCHAR(10) NOT NULL,
  complete TINYINT(1) DEFAULT 0,
  deadline_date DATETIME NULL,
  created_date TIMESTAMP DEFAULT NOW(),
  time_over TINYINT(1) DEFAULT 0,
  PRIMARY KEY (id));