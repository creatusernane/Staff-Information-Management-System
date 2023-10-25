/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50022
Source Host           : localhost:3306
Source Database       : staff

Target Server Type    : MYSQL
Target Server Version : 50022
File Encoding         : 65001

Date: 2023-10-25 18:16:23
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `degree`
-- ----------------------------
DROP TABLE IF EXISTS `degree`;
CREATE TABLE `degree` (
  `id` int(11) NOT NULL auto_increment,
  `degree_name` varchar(30) collate utf8_unicode_ci NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of degree
-- ----------------------------
INSERT INTO degree VALUES ('1', '大专');
INSERT INTO degree VALUES ('2', '本科');
INSERT INTO degree VALUES ('3', '研究生');

-- ----------------------------
-- Table structure for `dept`
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
  `deptno` int(11) NOT NULL auto_increment,
  `deptName` varchar(30) collate utf8_unicode_ci NOT NULL,
  PRIMARY KEY  (`deptno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO dept VALUES ('1', '业务部');
INSERT INTO dept VALUES ('2', '后勤部');
INSERT INTO dept VALUES ('3', '人事部');

-- ----------------------------
-- Table structure for `emp`
-- ----------------------------
DROP TABLE IF EXISTS `emp`;
CREATE TABLE `emp` (
  `id` int(11) NOT NULL auto_increment,
  `emp_name` varchar(30) collate utf8_unicode_ci NOT NULL,
  `sex` int(11) NOT NULL,
  `age` int(11) NOT NULL,
  `dept_name` int(11) NOT NULL,
  `emp_degree_name` int(11) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of emp
-- ----------------------------
INSERT INTO emp VALUES ('23001', 'yxy', '1', '25', '1', '3');
INSERT INTO emp VALUES ('23002', 'lxx', '2', '22', '3', '2');
INSERT INTO emp VALUES ('23003', 'lyh', '1', '24', '1', '2');
INSERT INTO emp VALUES ('23004', 'lzy', '1', '25', '1', '3');
INSERT INTO emp VALUES ('23005', 'cj', '2', '24', '1', '1');
INSERT INTO emp VALUES ('23008', 'mark', '1', '24', '2', '1');
INSERT INTO emp VALUES ('23009', '张一', '1', '25', '1', '2');
INSERT INTO emp VALUES ('23010', '张二', '2', '26', '3', '2');
INSERT INTO emp VALUES ('23011', '张三', '1', '27', '2', '1');
INSERT INTO emp VALUES ('23012', '张四', '2', '28', '3', '1');
INSERT INTO emp VALUES ('23013', '张五', '1', '29', '2', '1');
INSERT INTO emp VALUES ('23014', '张六', '2', '29', '2', '2');
INSERT INTO emp VALUES ('23015', '张七', '1', '33', '1', '3');
INSERT INTO emp VALUES ('23016', '张八', '1', '32', '1', '2');
INSERT INTO emp VALUES ('23017', '张九', '2', '33', '1', '1');
INSERT INTO emp VALUES ('23018', '李一', '2', '45', '1', '3');
INSERT INTO emp VALUES ('23019', '李二', '2', '19', '3', '2');
INSERT INTO emp VALUES ('23020', '李三', '1', '28', '1', '3');
INSERT INTO emp VALUES ('23021', '李四', '2', '46', '2', '3');
INSERT INTO emp VALUES ('23022', '李五', '1', '58', '1', '1');
INSERT INTO emp VALUES ('23023', '李六', '2', '22', '3', '3');
INSERT INTO emp VALUES ('23024', '李七', '1', '26', '2', '1');
INSERT INTO emp VALUES ('23025', '李八', '1', '25', '3', '3');
INSERT INTO emp VALUES ('23026', '李九', '2', '29', '2', '3');
INSERT INTO emp VALUES ('23027', '王一', '1', '45', '2', '2');
INSERT INTO emp VALUES ('23028', '王二', '2', '21', '1', '2');
INSERT INTO emp VALUES ('23029', '王三', '1', '21', '1', '1');
INSERT INTO emp VALUES ('23030', '王四', '1', '23', '1', '1');
INSERT INTO emp VALUES ('23031', '王五', '2', '33', '1', '1');
INSERT INTO emp VALUES ('23032', '王六', '1', '45', '3', '2');
INSERT INTO emp VALUES ('23033', '王七', '1', '35', '1', '3');
INSERT INTO emp VALUES ('23034', '王八', '1', '41', '2', '2');
INSERT INTO emp VALUES ('23035', '王九', '2', '25', '1', '1');
INSERT INTO emp VALUES ('23036', '赵一', '1', '26', '3', '3');
INSERT INTO emp VALUES ('23037', '赵二', '1', '20', '2', '2');
INSERT INTO emp VALUES ('23038', '赵三', '2', '21', '3', '3');
INSERT INTO emp VALUES ('23039', '赵四', '1', '19', '2', '3');
INSERT INTO emp VALUES ('23040', '赵五', '2', '35', '2', '1');
INSERT INTO emp VALUES ('23041', '赵六', '1', '24', '1', '3');
INSERT INTO emp VALUES ('23042', '赵七', '1', '29', '1', '1');
INSERT INTO emp VALUES ('23043', '赵八', '2', '33', '1', '3');
INSERT INTO emp VALUES ('23044', '赵九', '1', '45', '1', '2');

-- ----------------------------
-- Table structure for `sex`
-- ----------------------------
DROP TABLE IF EXISTS `sex`;
CREATE TABLE `sex` (
  `id` int(11) NOT NULL auto_increment,
  `sex_name` char(1) collate utf8_unicode_ci NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of sex
-- ----------------------------
INSERT INTO sex VALUES ('1', '男');
INSERT INTO sex VALUES ('2', '女');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL auto_increment,
  `user_name` varchar(30) collate utf8_unicode_ci NOT NULL,
  `pwd` varchar(30) collate utf8_unicode_ci NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO user VALUES ('1', 'admin', '111111');
