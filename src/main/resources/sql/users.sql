/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50173
Source Host           : localhost:3306
Source Database       : enterprise

Target Server Type    : MYSQL
Target Server Version : 50173
File Encoding         : 65001

Date: 2017-12-28 18:37:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `user_sex` varchar(50) DEFAULT NULL,
  `nick_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', 'aa', 'a123456', 'MAN', null);
INSERT INTO `users` VALUES ('2', 'bb', 'b123456', 'WOMAN', null);
INSERT INTO `users` VALUES ('3', 'cc', 'b123456', 'WOMAN', 'neo');
INSERT INTO `users` VALUES ('4', 'aa', 'a123456', 'MAN', null);
INSERT INTO `users` VALUES ('5', 'bb', 'b123456', 'WOMAN', null);
INSERT INTO `users` VALUES ('6', 'cc', 'b123456', 'WOMAN', null);
