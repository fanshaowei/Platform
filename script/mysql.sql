/*
Navicat MySQL Data Transfer

Source Server         : ssm
Source Server Version : 50622
Source Host           : localhost:3306
Source Database       : ssm

Target Server Type    : MYSQL
Target Server Version : 50622
File Encoding         : 65001

Date: 2016-05-04 14:25:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `con_test`
-- ----------------------------
DROP TABLE IF EXISTS `con_test`;
CREATE TABLE `con_test` (
  `A` varchar(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of con_test
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_authorities`
-- ----------------------------
DROP TABLE IF EXISTS `sys_authorities`;
CREATE TABLE `sys_authorities` (
  `authority_id` int(10) NOT NULL AUTO_INCREMENT,
  `parent_authority_id` decimal(10,0) DEFAULT NULL,
  `authority_name` varchar(50) DEFAULT NULL,
  `authority_type` decimal(10,0) DEFAULT NULL,
  `authority_url` varchar(255) DEFAULT NULL,
  `authority_flag` varchar(50) DEFAULT NULL,
  `authority_level` decimal(6,0) DEFAULT NULL,
  `disp_order` decimal(6,0) DEFAULT NULL,
  `is_valid` varchar(2) DEFAULT NULL,
  `is_show` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`authority_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_authorities
-- ----------------------------
INSERT INTO `sys_authorities` VALUES ('1', null, '全部权限', '100100', '#', '#', '1', '1', 'Y', 'Y');
INSERT INTO `sys_authorities` VALUES ('2', '1', '系统管理', '100100', '#', 'system_management', '1', '2', 'Y', 'Y');
INSERT INTO `sys_authorities` VALUES ('3', '2', '组织管理', '100200', '/framework/views/security/sys_org/sys_org.jsp', 'system_organizerInfo_list', '2', '1', 'Y', 'Y');
INSERT INTO `sys_authorities` VALUES ('4', '2', '权限管理', '100200', '/framework/views/security/sys_auth/auth_list.jsp', 'system_auth_list', '2', '2', 'Y', 'Y');
INSERT INTO `sys_authorities` VALUES ('5', '1', '基本业务', '100100', '#', 'business_management', '1', '3', 'Y', 'Y');
INSERT INTO `sys_authorities` VALUES ('6', '5', '哈哈哈哈', '100200', '/framework/views/security/sys_user/sys_user.jsp', 'hehe_list', '2', '1', 'Y', 'Y');
INSERT INTO `sys_authorities` VALUES ('7', '5', '添加用户', '100200', '#', '#', '2', '1', 'Y', 'Y');
INSERT INTO `sys_authorities` VALUES ('8', '5', '编辑权限', '100200', '#', '#', '2', '2', 'Y', 'Y');
INSERT INTO `sys_authorities` VALUES ('9', '6', '啦啦啦', '100200', '', null, null, null, null, null);

-- ----------------------------
-- Table structure for `sys_organizer_info`
-- ----------------------------
DROP TABLE IF EXISTS `sys_organizer_info`;
CREATE TABLE `sys_organizer_info` (
  `organizer_id` int(10) NOT NULL AUTO_INCREMENT,
  `organizer_name` varchar(50) DEFAULT NULL,
  `organizer_memo` varchar(200) DEFAULT NULL,
  `phone_number` varchar(50) DEFAULT NULL,
  `is_valid` varchar(2) DEFAULT NULL,
  `parent_org_id` int(10) DEFAULT NULL,
  `organizer_type` int(1) DEFAULT NULL,
  `begindate` date DEFAULT NULL,
  `enddate` date DEFAULT NULL,
  `status` int(2) DEFAULT NULL,
  PRIMARY KEY (`organizer_id`),
  KEY `R_6` (`parent_org_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_organizer_info
-- ----------------------------
INSERT INTO `sys_organizer_info` VALUES ('1', '好', '组织管理', null, 'Y', null, '1', '2016-01-20', '2017-01-20', '1');
INSERT INTO `sys_organizer_info` VALUES ('2', '子公司1', '子公司', null, 'Y', '1', '2', null, null, '2');
INSERT INTO `sys_organizer_info` VALUES ('3', '子公司2', '子公司', null, 'Y', '1', '2', null, null, '2');
INSERT INTO `sys_organizer_info` VALUES ('4', '子公司3', '子公司', null, 'Y', '1', '2', null, null, '2');
INSERT INTO `sys_organizer_info` VALUES ('5', '子公司4', '子公司', null, 'Y', '3', '2', null, null, '3');

-- ----------------------------
-- Table structure for `sys_organizer_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_organizer_user`;
CREATE TABLE `sys_organizer_user` (
  `autoId` decimal(10,0) NOT NULL,
  `organizer_id` int(10) NOT NULL,
  `user_id` int(10) NOT NULL,
  `user_type` varchar(50) DEFAULT NULL,
  `ispost` varchar(50) DEFAULT NULL,
  `primaryduty` varchar(2) DEFAULT NULL,
  `mngofleader` varchar(2) DEFAULT NULL,
  `mngofuser` varchar(2) DEFAULT NULL,
  `is_valid` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`autoId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_organizer_user
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_roles`
-- ----------------------------
DROP TABLE IF EXISTS `sys_roles`;
CREATE TABLE `sys_roles` (
  `role_id` int(10) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(50) DEFAULT NULL,
  `role_desc` varchar(50) DEFAULT NULL,
  `is_valid` varchar(2) DEFAULT NULL,
  `is_admin` varchar(2) DEFAULT NULL,
  `organizer_id` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_roles
-- ----------------------------
INSERT INTO `sys_roles` VALUES ('1', '管理员', '系统管理员', 'Y', 'Y', '1');
INSERT INTO `sys_roles` VALUES ('2', '二管理员', '比系统管理员低一级', 'N', 'Y', '1');
INSERT INTO `sys_roles` VALUES ('3', 'HAHA', 'dddd', 'Y', 'Y', '3');
INSERT INTO `sys_roles` VALUES ('4', 'AAA', 'ddd', 'Y', 'Y', '2');
INSERT INTO `sys_roles` VALUES ('5', 'dfdf', 'ddd', 'N', 'N', '3');
INSERT INTO `sys_roles` VALUES ('6', 'kkk', 'hhh', 'Y', 'Y', '2');
INSERT INTO `sys_roles` VALUES ('7', 'kkk', 'hhh', 'Y', 'Y', '2');
INSERT INTO `sys_roles` VALUES ('9', 'gfdg', 'gfgf', 'Y', 'Y', '1');

-- ----------------------------
-- Table structure for `sys_role_authorities`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_authorities`;
CREATE TABLE `sys_role_authorities` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(10) NOT NULL,
  `authority_id` int(10) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `R_5` (`authority_id`),
  KEY `role_id_foreign` (`role_id`),
  CONSTRAINT `authority_id_foreign` FOREIGN KEY (`authority_id`) REFERENCES `sys_authorities` (`authority_id`),
  CONSTRAINT `role_id_foreign` FOREIGN KEY (`role_id`) REFERENCES `sys_roles` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2135 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_authorities
-- ----------------------------
INSERT INTO `sys_role_authorities` VALUES ('1515', '6', '2');
INSERT INTO `sys_role_authorities` VALUES ('1516', '6', '3');
INSERT INTO `sys_role_authorities` VALUES ('1517', '6', '4');
INSERT INTO `sys_role_authorities` VALUES ('1518', '6', '5');
INSERT INTO `sys_role_authorities` VALUES ('1519', '6', '6');
INSERT INTO `sys_role_authorities` VALUES ('1520', '6', '7');
INSERT INTO `sys_role_authorities` VALUES ('1521', '6', '8');
INSERT INTO `sys_role_authorities` VALUES ('1923', '1', '1');
INSERT INTO `sys_role_authorities` VALUES ('1924', '1', '2');
INSERT INTO `sys_role_authorities` VALUES ('1925', '1', '3');
INSERT INTO `sys_role_authorities` VALUES ('1926', '1', '4');
INSERT INTO `sys_role_authorities` VALUES ('1927', '1', '5');
INSERT INTO `sys_role_authorities` VALUES ('1928', '1', '6');
INSERT INTO `sys_role_authorities` VALUES ('1929', '1', '9');
INSERT INTO `sys_role_authorities` VALUES ('1930', '1', '8');
INSERT INTO `sys_role_authorities` VALUES ('2059', '7', '1');
INSERT INTO `sys_role_authorities` VALUES ('2060', '7', '2');
INSERT INTO `sys_role_authorities` VALUES ('2061', '7', '3');
INSERT INTO `sys_role_authorities` VALUES ('2062', '7', '4');
INSERT INTO `sys_role_authorities` VALUES ('2063', '7', '5');
INSERT INTO `sys_role_authorities` VALUES ('2064', '7', '6');
INSERT INTO `sys_role_authorities` VALUES ('2065', '7', '9');
INSERT INTO `sys_role_authorities` VALUES ('2066', '7', '8');
INSERT INTO `sys_role_authorities` VALUES ('2105', '4', '1');
INSERT INTO `sys_role_authorities` VALUES ('2106', '4', '2');
INSERT INTO `sys_role_authorities` VALUES ('2107', '4', '3');
INSERT INTO `sys_role_authorities` VALUES ('2108', '4', '4');
INSERT INTO `sys_role_authorities` VALUES ('2109', '4', '5');
INSERT INTO `sys_role_authorities` VALUES ('2110', '4', '6');
INSERT INTO `sys_role_authorities` VALUES ('2111', '4', '9');
INSERT INTO `sys_role_authorities` VALUES ('2112', '5', '1');
INSERT INTO `sys_role_authorities` VALUES ('2113', '5', '2');
INSERT INTO `sys_role_authorities` VALUES ('2114', '5', '3');
INSERT INTO `sys_role_authorities` VALUES ('2115', '5', '4');
INSERT INTO `sys_role_authorities` VALUES ('2116', '5', '5');
INSERT INTO `sys_role_authorities` VALUES ('2117', '5', '6');
INSERT INTO `sys_role_authorities` VALUES ('2118', '5', '9');
INSERT INTO `sys_role_authorities` VALUES ('2119', '5', '8');
INSERT INTO `sys_role_authorities` VALUES ('2120', '2', '1');
INSERT INTO `sys_role_authorities` VALUES ('2121', '2', '2');
INSERT INTO `sys_role_authorities` VALUES ('2122', '2', '3');
INSERT INTO `sys_role_authorities` VALUES ('2123', '2', '4');
INSERT INTO `sys_role_authorities` VALUES ('2124', '2', '5');
INSERT INTO `sys_role_authorities` VALUES ('2125', '2', '7');
INSERT INTO `sys_role_authorities` VALUES ('2126', '2', '8');
INSERT INTO `sys_role_authorities` VALUES ('2127', '3', '2');
INSERT INTO `sys_role_authorities` VALUES ('2128', '3', '3');
INSERT INTO `sys_role_authorities` VALUES ('2129', '3', '1');
INSERT INTO `sys_role_authorities` VALUES ('2130', '3', '5');
INSERT INTO `sys_role_authorities` VALUES ('2131', '3', '6');
INSERT INTO `sys_role_authorities` VALUES ('2132', '3', '9');
INSERT INTO `sys_role_authorities` VALUES ('2133', '3', '7');
INSERT INTO `sys_role_authorities` VALUES ('2134', '3', '8');

-- ----------------------------
-- Table structure for `sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(50) DEFAULT NULL,
  `trueName` varchar(10) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `sex` char(5) DEFAULT NULL,
  `phoneNum` varchar(12) DEFAULT NULL,
  `province` varchar(30) DEFAULT NULL,
  `city` varchar(30) DEFAULT NULL,
  `district` varchar(30) DEFAULT NULL,
  `enabled` char(5) DEFAULT NULL,
  `role` varchar(30) DEFAULT NULL,
  `neighborhood` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', 'admin', '111111', '', '888888888888', '广东省', '广东省', '天河区', 'Y', '系统管理h去', '华景新城111');
INSERT INTO `sys_user` VALUES ('2', 'TEST2', 'TEST', '111111', null, '123333333333', '广东省', '增城', '挂绿', 'Y', '小区管理员1', '五仙桥');
INSERT INTO `sys_user` VALUES ('4', 'TEST4', 'TEST', '111111', null, '123333333333', '广东省', '广东省', '挂绿', 'Y', '小区管理1', '五仙桥');
INSERT INTO `sys_user` VALUES ('5', 'TEST5', 'TEST', '111111', null, '123333333333', '广东省', '啦哇', '卡上', 'Y', '小区管理员2', '五仙桥');
INSERT INTO `sys_user` VALUES ('6', 'TEST6', 'TEST', '111111', null, '123333333333', '广东省和我', '广州', '挂绿', 'Y', '小区管理员发', '五仙桥');
INSERT INTO `sys_user` VALUES ('7', 'dddd', 'TEST', '111111', null, '123333333333', '不存在去', '不存在去', '不存在去', 'Y', '小区管理员q去', '五仙桥去');
INSERT INTO `sys_user` VALUES ('8', 'TEST8', 'TEST', '111111', null, '123333333333', '广东sh', '广州', '复古风格', 'Y', '小区管理管理', '');
INSERT INTO `sys_user` VALUES ('9', 'TEST9', 'TEST', '111111', null, '123333333333', '广东省', '增城', '挂绿', 'Y', '小区管理员', '五仙桥');
INSERT INTO `sys_user` VALUES ('10', 'TEST10', 'TEST', '111111', null, '123333333333', '广东', '增城', '挂绿', 'Y', '小区呵呵', '五仙桥');
INSERT INTO `sys_user` VALUES ('11', 'TEST11', 'TEST', '111111', null, '123333333333', '广东省', '增城', '挂绿', 'Y', '小区管理员', '五仙桥');
INSERT INTO `sys_user` VALUES ('12', 'TEST12', 'TEST', '111111', null, '123333333333', '广东省', '增城', '挂绿', 'Y', '小区管理员', '五仙桥');
INSERT INTO `sys_user` VALUES ('13', 'TEST13', 'TEST', '111111', null, '123333333333', '广东省', '增城', '挂绿', 'Y', '小区管理员', '五仙桥');
INSERT INTO `sys_user` VALUES ('14', 'TEST14', 'TEST', '111111', null, '123333333333', '广东省', '增城', '挂绿', 'Y', '小区管理员', '五仙桥');
INSERT INTO `sys_user` VALUES ('17', 'TEST16', 'TEST', '111111', null, '123333333333', '广东省', '增城', '挂绿', 'Y', '小区管理员', '五仙桥');
INSERT INTO `sys_user` VALUES ('18', 'TEST17', 'TEST', '111111', null, '123333333333', '广东省', '增城', '挂绿', 'Y', '小区管理员', '五仙桥');
INSERT INTO `sys_user` VALUES ('19', 'TEST18', 'TEST', '111111', null, '123333333333', '广东省', '增城', '挂绿', 'Y', '小区管理员', '五仙桥');

-- ----------------------------
-- Table structure for `sys_users`
-- ----------------------------
DROP TABLE IF EXISTS `sys_users`;
CREATE TABLE `sys_users` (
  `user_id` int(10) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) DEFAULT NULL,
  `user_account` varchar(50) DEFAULT NULL,
  `user_password` varchar(50) DEFAULT NULL,
  `is_valid` varchar(2) DEFAULT NULL,
  `organizer_id` int(10) DEFAULT NULL,
  `is_admin` varchar(2) DEFAULT NULL,
  `mobile_number` varchar(20) DEFAULT NULL,
  `phone_number` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  KEY `R_3` (`organizer_id`),
  CONSTRAINT `org` FOREIGN KEY (`organizer_id`) REFERENCES `sys_organizer_info` (`organizer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_users
-- ----------------------------
INSERT INTO `sys_users` VALUES ('1', '管理员', 'admin', 'c3891c11bbbdd05bdd99ce67737df8f7', 'Y', '2', 'Y', '88888888888', '8888888');
INSERT INTO `sys_users` VALUES ('2', '好员工1', '80013', 'c3891c11bbbdd05bdd99ce67737df8f7', 'Y', '2', 'N', '', '');
INSERT INTO `sys_users` VALUES ('3', '好员工2', 'HAHA', '123456', 'Y', '4', 'Y', null, null);
INSERT INTO `sys_users` VALUES ('5', 'gaga1', 'agag', null, null, '4', null, null, null);
INSERT INTO `sys_users` VALUES ('6', 'gaga2', 'agag', null, null, '5', null, null, null);
INSERT INTO `sys_users` VALUES ('7', 'gaga3', 'agag', null, null, '5', null, null, null);
INSERT INTO `sys_users` VALUES ('8', 'gaga4', 'agag', null, null, '5', null, null, null);
INSERT INTO `sys_users` VALUES ('9', 'gaga5', 'agag', null, null, '5', null, null, null);
INSERT INTO `sys_users` VALUES ('10', 'gaga6', 'agag', null, null, '5', null, null, null);
INSERT INTO `sys_users` VALUES ('11', 'gaga7', 'agag', null, null, '5', null, null, null);
INSERT INTO `sys_users` VALUES ('12', 'gaga8', 'agag', null, null, '5', null, null, null);
INSERT INTO `sys_users` VALUES ('13', 'gaga9', 'agag', null, null, '4', null, null, null);
INSERT INTO `sys_users` VALUES ('14', 'haha1', 'agag2', null, '', '2', '', '', '');
INSERT INTO `sys_users` VALUES ('15', 'haha2', 'agag34', null, '', '2', '', '', '');
INSERT INTO `sys_users` VALUES ('16', 'haha3', 'agagd', null, '', '4', '', '', '');
INSERT INTO `sys_users` VALUES ('17', 'haha4', 'haha3', 'agag', '', '3', '', '', '');
INSERT INTO `sys_users` VALUES ('19', '好员工1', '8001', null, null, '2', null, null, null);
INSERT INTO `sys_users` VALUES ('20', '好员工2', 'HAHA', null, '', '2', '', '', '');
INSERT INTO `sys_users` VALUES ('21', 'gaga11', 'agag', null, null, '4', null, null, null);
INSERT INTO `sys_users` VALUES ('22', 'gaga22', 'agag', null, null, '5', null, null, null);
INSERT INTO `sys_users` VALUES ('23', 'gaga33', 'agag', null, null, '5', null, null, null);
INSERT INTO `sys_users` VALUES ('24', 'gaga44', 'agag', null, null, '5', null, null, null);
INSERT INTO `sys_users` VALUES ('25', 'gaga55', 'agag', null, null, '5', null, null, null);
INSERT INTO `sys_users` VALUES ('26', 'gaga66', 'agag', null, null, '5', null, null, null);
INSERT INTO `sys_users` VALUES ('27', 'gaga77', 'agag', null, null, '5', null, null, null);
INSERT INTO `sys_users` VALUES ('28', 'gaga88', 'agag', null, null, '5', null, null, null);
INSERT INTO `sys_users` VALUES ('29', 'gaga99', 'agag4', null, '', '4', '', '', '');
INSERT INTO `sys_users` VALUES ('30', 'haha11', 'agag', null, null, '2', null, null, null);
INSERT INTO `sys_users` VALUES ('31', 'haha33', 'agag', null, null, '2', null, null, null);
INSERT INTO `sys_users` VALUES ('49', 'gggg', 'sssss', null, 'N', '2', 'Y', '', '');
INSERT INTO `sys_users` VALUES ('51', 'haha123', 'dfdfdfd', null, 'Y', '5', 'Y', '', '');

-- ----------------------------
-- Table structure for `sys_users_roles`
-- ----------------------------
DROP TABLE IF EXISTS `sys_users_roles`;
CREATE TABLE `sys_users_roles` (
  `user_id` int(10) NOT NULL,
  `role_id` int(10) NOT NULL,
  `id` int(10) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  KEY `R_2` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=86 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_users_roles
-- ----------------------------
INSERT INTO `sys_users_roles` VALUES ('1', '1', '1');
INSERT INTO `sys_users_roles` VALUES ('2', '1', '2');
INSERT INTO `sys_users_roles` VALUES ('3', '2', '3');
INSERT INTO `sys_users_roles` VALUES ('5', '1', '4');
INSERT INTO `sys_users_roles` VALUES ('6', '1', '5');
INSERT INTO `sys_users_roles` VALUES ('7', '1', '6');
INSERT INTO `sys_users_roles` VALUES ('8', '1', '7');
INSERT INTO `sys_users_roles` VALUES ('9', '1', '8');
INSERT INTO `sys_users_roles` VALUES ('10', '1', '9');
INSERT INTO `sys_users_roles` VALUES ('11', '1', '10');
INSERT INTO `sys_users_roles` VALUES ('12', '1', '11');
INSERT INTO `sys_users_roles` VALUES ('13', '1', '12');
INSERT INTO `sys_users_roles` VALUES ('17', '2', '15');
INSERT INTO `sys_users_roles` VALUES ('2', '5', '16');
INSERT INTO `sys_users_roles` VALUES ('3', '5', '17');
INSERT INTO `sys_users_roles` VALUES ('3', '3', '18');
INSERT INTO `sys_users_roles` VALUES ('5', '5', '19');
INSERT INTO `sys_users_roles` VALUES ('5', '6', '20');
INSERT INTO `sys_users_roles` VALUES ('5', '7', '21');
INSERT INTO `sys_users_roles` VALUES ('5', '8', '22');
INSERT INTO `sys_users_roles` VALUES ('6', '6', '23');
INSERT INTO `sys_users_roles` VALUES ('6', '8', '25');
INSERT INTO `sys_users_roles` VALUES ('6', '7', '26');
INSERT INTO `sys_users_roles` VALUES ('6', '8', '27');
INSERT INTO `sys_users_roles` VALUES ('7', '7', '28');
INSERT INTO `sys_users_roles` VALUES ('8', '7', '29');
INSERT INTO `sys_users_roles` VALUES ('9', '7', '30');
INSERT INTO `sys_users_roles` VALUES ('5', '3', '32');
INSERT INTO `sys_users_roles` VALUES ('13', '2', '35');
INSERT INTO `sys_users_roles` VALUES ('6', '2', '36');
INSERT INTO `sys_users_roles` VALUES ('9', '5', '43');
INSERT INTO `sys_users_roles` VALUES ('7', '5', '45');
INSERT INTO `sys_users_roles` VALUES ('10', '5', '46');
INSERT INTO `sys_users_roles` VALUES ('11', '5', '47');
INSERT INTO `sys_users_roles` VALUES ('13', '5', '48');
INSERT INTO `sys_users_roles` VALUES ('7', '4', '49');
INSERT INTO `sys_users_roles` VALUES ('10', '4', '50');
INSERT INTO `sys_users_roles` VALUES ('5', '4', '51');
INSERT INTO `sys_users_roles` VALUES ('3', '4', '52');
INSERT INTO `sys_users_roles` VALUES ('10', '2', '55');
INSERT INTO `sys_users_roles` VALUES ('8', '2', '56');
INSERT INTO `sys_users_roles` VALUES ('11', '2', '57');
INSERT INTO `sys_users_roles` VALUES ('2', '3', '58');
INSERT INTO `sys_users_roles` VALUES ('1', '3', '59');
INSERT INTO `sys_users_roles` VALUES ('12', '3', '60');
INSERT INTO `sys_users_roles` VALUES ('12', '7', '61');
INSERT INTO `sys_users_roles` VALUES ('3', '1', '62');
INSERT INTO `sys_users_roles` VALUES ('11', '6', '64');
INSERT INTO `sys_users_roles` VALUES ('49', '6', '66');
INSERT INTO `sys_users_roles` VALUES ('12', '6', '68');
INSERT INTO `sys_users_roles` VALUES ('2000', '3', '69');
INSERT INTO `sys_users_roles` VALUES ('2100', '3', '70');
INSERT INTO `sys_users_roles` VALUES ('2000', '3', '71');
INSERT INTO `sys_users_roles` VALUES ('9', '4', '72');
INSERT INTO `sys_users_roles` VALUES ('22', '7', '75');
INSERT INTO `sys_users_roles` VALUES ('8', '3', '78');
INSERT INTO `sys_users_roles` VALUES ('33', '5', '79');
INSERT INTO `sys_users_roles` VALUES ('5', '2', '80');
INSERT INTO `sys_users_roles` VALUES ('16', '4', '81');
INSERT INTO `sys_users_roles` VALUES ('1', '4', '82');
INSERT INTO `sys_users_roles` VALUES ('1', '2', '83');
INSERT INTO `sys_users_roles` VALUES ('33', '2', '84');
INSERT INTO `sys_users_roles` VALUES ('6', '4', '85');

