/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50645
Source Host           : localhost:3306
Source Database       : blogger

Target Server Type    : MYSQL
Target Server Version : 50645
File Encoding         : 65001

Date: 2020-01-12 21:17:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_article
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
  `master_id` int(11) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_article
-- ----------------------------
INSERT INTO `tb_article` VALUES ('1', '1', '4324', 'articleContent', null, null, null, '12', null, null);
INSERT INTO `tb_article` VALUES ('2', '1', '4324', 'articleContent', null, null, null, '12', '2019-12-19 22:31:53', '2019-12-19 22:31:53');
INSERT INTO `tb_article` VALUES ('3', '1', 'test', 'undefined', null, null, null, '1', '2019-12-22 14:05:10', '2019-12-22 14:05:10');
INSERT INTO `tb_article` VALUES ('4', '1', 'test', 'undefined', null, null, null, '1', '2019-12-22 15:01:18', '2019-12-22 15:01:18');
INSERT INTO `tb_article` VALUES ('5', '1', 'test', 'undefined', null, null, null, '1', '2019-12-22 15:01:18', '2019-12-22 15:01:18');
INSERT INTO `tb_article` VALUES ('6', '1', 'test', 'undefined', null, null, null, '1', '2019-12-22 15:01:18', '2019-12-22 15:01:18');
INSERT INTO `tb_article` VALUES ('7', '1', 'test', 'undefined', null, null, null, '1', '2019-12-22 15:01:18', '2019-12-22 15:01:18');
INSERT INTO `tb_article` VALUES ('8', '1', 'test', 'undefined', null, null, null, '1', '2019-12-22 15:01:18', '2019-12-22 15:01:18');
INSERT INTO `tb_article` VALUES ('9', '1', 'test', 'undefined', null, null, null, '1', '2019-12-22 15:01:18', '2019-12-22 15:01:18');
INSERT INTO `tb_article` VALUES ('10', '1', 'test', 'undefined', null, null, null, '1', '2019-12-22 15:01:18', '2019-12-22 15:01:18');
INSERT INTO `tb_article` VALUES ('11', '1', 'test', 'undefined', null, null, null, '1', '2019-12-22 15:01:18', '2019-12-22 15:01:18');
INSERT INTO `tb_article` VALUES ('12', '1', 'test', 'undefined', null, null, null, '1', '2019-12-22 15:01:18', '2019-12-22 15:01:18');
INSERT INTO `tb_article` VALUES ('13', '1', 'test', 'undefined', null, null, null, '1', '2019-12-22 15:01:18', '2019-12-22 15:01:18');
INSERT INTO `tb_article` VALUES ('14', '1', 'test', 'undefined', null, null, null, '1', '2019-12-22 15:01:18', '2019-12-22 15:01:18');
INSERT INTO `tb_article` VALUES ('15', '1', 'test', 'undefined', null, null, null, '1', '2019-12-22 15:01:18', '2019-12-22 15:01:18');
INSERT INTO `tb_article` VALUES ('16', '2', '我是谁', '请输入内容', null, null, null, '1', '2019-12-23 22:03:09', '2019-12-23 22:03:09');

-- ----------------------------
-- Table structure for tb_article_type
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_article_type
-- ----------------------------
INSERT INTO `tb_article_type` VALUES ('1', '学习笔记', null, '2', '2019-12-19 22:03:46', '2019-12-19 22:03:46');
INSERT INTO `tb_article_type` VALUES ('2', '生活剪影', null, '1', '2019-12-19 22:03:43', '2019-12-19 22:03:43');
INSERT INTO `tb_article_type` VALUES ('3', '福利专区', null, '3', '2019-12-19 22:03:47', '2019-12-19 22:03:47');
INSERT INTO `tb_article_type` VALUES ('4', '关于站长', null, '5', '2019-12-19 22:52:27', '2019-12-19 22:52:27');
INSERT INTO `tb_article_type` VALUES ('5', '发表博客', null, '4', '2019-12-19 22:03:49', '2019-12-19 22:03:49');

-- ----------------------------
-- Table structure for tb_master
-- ----------------------------
DROP TABLE IF EXISTS `tb_master`;
CREATE TABLE `tb_master` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login_name` varchar(255) DEFAULT NULL,
  `master_name` varchar(255) DEFAULT NULL,
  `master_email` varchar(255) DEFAULT NULL,
  `master_password` varchar(255) DEFAULT NULL,
  `master_gender` varchar(11) DEFAULT NULL,
  `is_admin` int(11) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_master
-- ----------------------------
INSERT INTO `tb_master` VALUES ('1', 'qzw', null, null, '123456', null, null, null, null);

-- ----------------------------
-- Table structure for tb_photo
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
-- Records of tb_photo
-- ----------------------------

-- ----------------------------
-- Table structure for tb_replay
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
-- Records of tb_replay
-- ----------------------------

-- ----------------------------
-- Table structure for tb_review
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
-- Records of tb_review
-- ----------------------------

-- ----------------------------
-- Table structure for tb_word
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

-- ----------------------------
-- Records of tb_word
-- ----------------------------
