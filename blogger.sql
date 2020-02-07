/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 50641
 Source Host           : localhost
 Source Database       : blogger

 Target Server Type    : MySQL
 Target Server Version : 50641
 File Encoding         : utf-8

 Date: 02/07/2020 14:46:20 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `tb_article`
-- ----------------------------
DROP TABLE IF EXISTS `tb_article`;
CREATE TABLE `tb_article` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `article_type_id` int(11) DEFAULT NULL,
  `article_title` varchar(255) DEFAULT NULL,
  `article_content` text,
  `article_info` varchar(255) DEFAULT NULL,
  `article_count` int(11) DEFAULT NULL,
  `article_from` varchar(255) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `tb_article`
-- ----------------------------
BEGIN;
INSERT INTO `tb_article` VALUES ('1', '1', '4324', 'articleContent', null, null, null, '12', null, null), ('2', '1', '4324', 'articleContent', null, null, null, '12', '2019-12-19 22:31:53', '2019-12-19 22:31:53'), ('3', '1', 'test', 'undefined', null, null, null, '1', '2019-12-22 14:05:10', '2019-12-22 14:05:10'), ('4', '1', 'test', 'undefined', null, null, null, '1', '2019-12-22 15:01:18', '2019-12-22 15:01:18'), ('5', '1', 'test', 'undefined', null, null, null, '1', '2019-12-22 15:01:18', '2019-12-22 15:01:18'), ('6', '1', 'test', 'undefined', null, null, null, '1', '2019-12-22 15:01:18', '2019-12-22 15:01:18'), ('7', '1', 'test', 'undefined', null, null, null, '1', '2019-12-22 15:01:18', '2019-12-22 15:01:18'), ('8', '1', 'test', 'undefined', null, null, null, '1', '2019-12-22 15:01:18', '2019-12-22 15:01:18'), ('9', '1', 'test', 'undefined', null, null, null, '1', '2019-12-22 15:01:18', '2019-12-22 15:01:18'), ('10', '1', 'test', 'undefined', null, null, null, '1', '2019-12-22 15:01:18', '2019-12-22 15:01:18'), ('11', '1', 'test', 'undefined', null, null, null, '1', '2019-12-22 15:01:18', '2019-12-22 15:01:18'), ('12', '1', 'test', 'undefined', null, null, null, '1', '2019-12-22 15:01:18', '2019-12-22 15:01:18'), ('13', '1', 'test', 'undefined', null, null, null, '1', '2019-12-22 15:01:18', '2019-12-22 15:01:18'), ('14', '1', 'test', 'undefined', null, null, null, '1', '2019-12-22 15:01:18', '2019-12-22 15:01:18'), ('15', '1', 'test', 'undefined', null, null, null, '1', '2019-12-22 15:01:18', '2019-12-22 15:01:18'), ('16', '2', '我是谁', '请输入内容', null, null, null, '1', '2019-12-23 22:03:09', '2019-12-23 22:03:09');
COMMIT;

-- ----------------------------
--  Table structure for `tb_article_type`
-- ----------------------------
DROP TABLE IF EXISTS `tb_article_type`;
CREATE TABLE `tb_article_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `article_type_name` varchar(255) DEFAULT NULL,
  `article_type_info` varchar(255) DEFAULT NULL,
  `sort_order` int(11) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `tb_article_type`
-- ----------------------------
BEGIN;
INSERT INTO `tb_article_type` VALUES ('1', '技术', null, '2', '2020-01-24 17:07:24', '2020-01-24 17:07:24'), ('2', '生活', null, '1', '2020-01-24 17:07:16', '2020-01-24 17:07:16'), ('3', '福利', null, '3', '2020-01-24 17:07:28', '2020-01-24 17:07:28');
COMMIT;

-- ----------------------------
--  Table structure for `tb_photo`
-- ----------------------------
DROP TABLE IF EXISTS `tb_photo`;
CREATE TABLE `tb_photo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `photo_addr` varchar(500) DEFAULT NULL,
  `photo_info` varchar(255) DEFAULT NULL,
  `master_id` int(11) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tb_replay`
-- ----------------------------
DROP TABLE IF EXISTS `tb_replay`;
CREATE TABLE `tb_replay` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `review_id` int(11) DEFAULT NULL,
  `has_replay` int(11) DEFAULT NULL,
  `replay_id` int(11) DEFAULT NULL,
  `master_id` int(11) DEFAULT NULL,
  `article_id` int(11) DEFAULT NULL,
  `replay_content` varchar(255) NOT NULL,
  `created_at` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tb_review`
-- ----------------------------
DROP TABLE IF EXISTS `tb_review`;
CREATE TABLE `tb_review` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `article_id` int(11) DEFAULT NULL,
  `master_id` int(11) DEFAULT NULL,
  `review_content` varchar(255) DEFAULT NULL,
  `have_replay` int(11) DEFAULT NULL,
  `review_status` int(11) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tb_user`
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login_name` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `user_email` varchar(255) DEFAULT NULL,
  `user_password` varchar(255) DEFAULT NULL,
  `user_gender` varchar(11) DEFAULT NULL,
  `is_admin` int(11) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `tb_user`
-- ----------------------------
BEGIN;
INSERT INTO `tb_user` VALUES ('1', 'qzw', null, null, '123456', null, null, null, null);
COMMIT;

-- ----------------------------
--  Table structure for `tb_word`
-- ----------------------------
DROP TABLE IF EXISTS `tb_word`;
CREATE TABLE `tb_word` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `word_title` varchar(255) DEFAULT NULL,
  `word_content` varchar(255) DEFAULT NULL,
  `master_id` int(11) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
