CREATE DATABASE springboot_mybaties_generator_demo DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

DROP TABLE IF EXISTS Artile;

CREATE TABLE Article (
`id`  int(11) NOT NULL AUTO_INCREMENT ,
`title`  varchar(30) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL ,
`author`  varchar(30) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL ,
`content`  mediumtext CHARACTER SET gbk COLLATE gbk_chinese_ci NULL ,
`file_name`  varchar(30) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL ,
`state`  smallint(2) NULL DEFAULT 1 COMMENT '状态' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
AUTO_INCREMENT=11
ROW_FORMAT=COMPACT;

DROP TABLE IF EXISTS `User`;

CREATE TABLE `User` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `userName` varchar(32) NOT NULL,
  `passWord` varchar(50) NOT NULL,
  `realName` varchar(32) DEFAULT NULL COMMENT '真实姓名',
  PRIMARY KEY (`id`)
)
ENGINE=InnoDB
AUTO_INCREMENT=3;