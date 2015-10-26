CREATE TABLE IF NOT EXISTS `server_group` (
  `group_code` VARCHAR(20) NOT NULL,
  `list_order` TINYINT(4) NOT NULL DEFAULT 1,
  `crt_date` DATETIME NOT NULL,
  `upd_date` DATETIME NOT NULL,
  PRIMARY KEY (`group_code`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin;