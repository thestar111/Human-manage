/*
Navicat MySQL Data Transfer

Source Server         : tland
Source Server Version : 50636
Source Host           : 192.168.0.11:21000
Source Database       : human

Target Server Type    : MYSQL
Target Server Version : 50636
File Encoding         : 65001

Date: 2019-03-21 15:37:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for T_ADMINROLERLAT
-- ----------------------------
DROP TABLE IF EXISTS `T_ADMINROLERLAT`;
CREATE TABLE `T_ADMINROLERLAT` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '业务编号',
  `adminId` varchar(64) DEFAULT NULL COMMENT '员工编号',
  `roleId` int(11) DEFAULT NULL COMMENT '角色编号',
  `memo` varchar(64) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `IDX_ROLE_ADMIN` (`adminId`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of T_ADMINROLERLAT
-- ----------------------------
INSERT INTO `T_ADMINROLERLAT` VALUES ('20', '107189', '2', null);
INSERT INTO `T_ADMINROLERLAT` VALUES ('22', '20113392', '1', null);
INSERT INTO `T_ADMINROLERLAT` VALUES ('23', '20114789', '1', null);
INSERT INTO `T_ADMINROLERLAT` VALUES ('24', '20331234', '1', null);
INSERT INTO `T_ADMINROLERLAT` VALUES ('25', '2011445687', '1', null);
INSERT INTO `T_ADMINROLERLAT` VALUES ('26', '20551234', '1', null);
INSERT INTO `T_ADMINROLERLAT` VALUES ('27', '20113348', '1', null);
INSERT INTO `T_ADMINROLERLAT` VALUES ('28', '20113336', '2', null);
INSERT INTO `T_ADMINROLERLAT` VALUES ('29', '205512349', '1', null);
INSERT INTO `T_ADMINROLERLAT` VALUES ('35', 'adminatmb', '1', null);
INSERT INTO `T_ADMINROLERLAT` VALUES ('36', '11', '1', null);
INSERT INTO `T_ADMINROLERLAT` VALUES ('37', 'T001', '1', null);
INSERT INTO `T_ADMINROLERLAT` VALUES ('38', '20114897', '1', null);
INSERT INTO `T_ADMINROLERLAT` VALUES ('39', '20113343', '1', null);
INSERT INTO `T_ADMINROLERLAT` VALUES ('40', '201165489', '1', null);
INSERT INTO `T_ADMINROLERLAT` VALUES ('41', '20112233', '1', null);

-- ----------------------------
-- Table structure for T_ASSESS_CATALOG
-- ----------------------------
DROP TABLE IF EXISTS `T_ASSESS_CATALOG`;
CREATE TABLE `T_ASSESS_CATALOG` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '业务编号',
  `name` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '分类名称',
  `createTime` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '创建时间',
  `memo` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `IDX_CATALOG_NAME` (`name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of T_ASSESS_CATALOG
-- ----------------------------
INSERT INTO `T_ASSESS_CATALOG` VALUES ('1', '德', null, null);
INSERT INTO `T_ASSESS_CATALOG` VALUES ('2', '智', null, null);

-- ----------------------------
-- Table structure for T_ASSESS_CATALOG_RELA
-- ----------------------------
DROP TABLE IF EXISTS `T_ASSESS_CATALOG_RELA`;
CREATE TABLE `T_ASSESS_CATALOG_RELA` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '业务编号',
  `topicId` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '考核主题编号',
  `assessCatalogId` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '考核分类编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='考核主题分类关系编号';

-- ----------------------------
-- Records of T_ASSESS_CATALOG_RELA
-- ----------------------------
INSERT INTO `T_ASSESS_CATALOG_RELA` VALUES ('1', '2018-09', '1');
INSERT INTO `T_ASSESS_CATALOG_RELA` VALUES ('2', '2018-09', '2');

-- ----------------------------
-- Table structure for T_ASSESS_CONTENT
-- ----------------------------
DROP TABLE IF EXISTS `T_ASSESS_CONTENT`;
CREATE TABLE `T_ASSESS_CONTENT` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '业务编号',
  `content` text COLLATE utf8_bin NOT NULL COMMENT '考核标准内容',
  `grade` int(11) DEFAULT '0' COMMENT '分数',
  `catalog` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '考核分类编号',
  `time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '考核年份',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of T_ASSESS_CONTENT
-- ----------------------------
INSERT INTO `T_ASSESS_CONTENT` VALUES ('13', 0xE5B7A5E4BD9CE5AE8CE68890E5BAA6, '10', '1', '2018-05-10 07:02:50');
INSERT INTO `T_ASSESS_CONTENT` VALUES ('14', 0xE5B7A5E4BD9CE5AE8CE68890, '2', '1', '2018-05-10 07:02:51');
INSERT INTO `T_ASSESS_CONTENT` VALUES ('16', 0xE5B7A5E4BD9CE5AE8CE68890, '11', '1', '2018-05-10 07:02:53');
INSERT INTO `T_ASSESS_CONTENT` VALUES ('17', 0x73686966E698AFE590A620616E736869E68C89E697B62077616E63E5AE8CE6889020676F6E677AE5B7A5E4BD9C20, '0', '2', '2018-05-10 04:07:17');
INSERT INTO `T_ASSESS_CONTENT` VALUES ('18', 0x73686966E698AFE590A620616E736869E68C89E697B62077616E63E5AE8CE6889020676F6E677AE5B7A5E4BD9C20, '0', '2', '2018-05-10 04:07:17');

-- ----------------------------
-- Table structure for T_ASSESS_RESULT
-- ----------------------------
DROP TABLE IF EXISTS `T_ASSESS_RESULT`;
CREATE TABLE `T_ASSESS_RESULT` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '考核成绩编号',
  `employee` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '考核员工',
  `topic` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '考核主题编号',
  `weight` int(11) NOT NULL COMMENT '考核指标权重',
  `score` double NOT NULL COMMENT '考核分数',
  `time` datetime NOT NULL COMMENT '考核时间',
  `discussant` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '评论人',
  PRIMARY KEY (`id`,`time`),
  KEY `IDX_ASSESS_EMPLOYEE` (`employee`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='员工考核成绩表';

-- ----------------------------
-- Records of T_ASSESS_RESULT
-- ----------------------------
INSERT INTO `T_ASSESS_RESULT` VALUES ('3', '107189', '20180413', '60', '90', '2017-01-01 00:00:00', '20113392');
INSERT INTO `T_ASSESS_RESULT` VALUES ('4', '107189', '20180413', '60', '95', '2017-01-01 00:00:00', '20113394');
INSERT INTO `T_ASSESS_RESULT` VALUES ('7', '107189', '20180413', '20', '86', '2017-01-01 00:00:00', '20113358');
INSERT INTO `T_ASSESS_RESULT` VALUES ('8', '107189', '20180413', '20', '85', '2017-01-01 00:00:00', '20113367');
INSERT INTO `T_ASSESS_RESULT` VALUES ('9', '107189', '20180413', '10', '95', '2017-01-01 00:00:00', '107189');
INSERT INTO `T_ASSESS_RESULT` VALUES ('10', '107189', '20180413', '10', '90', '2017-01-01 00:00:00', '20113348');
INSERT INTO `T_ASSESS_RESULT` VALUES ('11', '107189', '20180413', '10', '92', '2017-01-01 00:00:00', '20113324');
INSERT INTO `T_ASSESS_RESULT` VALUES ('12', '107189', '20180413', '60', '85', '2017-01-01 00:00:00', '201149');
INSERT INTO `T_ASSESS_RESULT` VALUES ('13', '20113392', '2018-09', '0', '1', '2018-01-01 00:00:00', '107189');
INSERT INTO `T_ASSESS_RESULT` VALUES ('14', '20113348', '2018-09', '0', '0', '2018-01-01 00:00:00', '107189');
INSERT INTO `T_ASSESS_RESULT` VALUES ('15', '', '2018-09', '0', '0', '2018-01-01 00:00:00', '107189');
INSERT INTO `T_ASSESS_RESULT` VALUES ('16', '', '2018-09', '0', '0', '2018-01-01 00:00:00', '107189');
INSERT INTO `T_ASSESS_RESULT` VALUES ('17', '', '2018-09', '0', '0', '2018-01-01 00:00:00', '107189');

-- ----------------------------
-- Table structure for T_ASSESS_TOPIC
-- ----------------------------
DROP TABLE IF EXISTS `T_ASSESS_TOPIC`;
CREATE TABLE `T_ASSESS_TOPIC` (
  `id` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '考核主题编号',
  `rank` int(11) DEFAULT NULL COMMENT '目标职级',
  `department` int(11) DEFAULT NULL COMMENT '目标部门',
  `title` varchar(500) COLLATE utf8_bin NOT NULL COMMENT '考核标题',
  `startTime` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '考核开始时间',
  `endTime` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '考核结束时间',
  `status` int(11) NOT NULL COMMENT '发布状态(0: 已发布， 1: 未发布)',
  `extend1` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '扩展字段1',
  `extend2` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '扩展字段2',
  `extend3` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '扩展字段3',
  `extend4` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '扩展字段4',
  `extend5` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '扩展字段5',
  `extend6` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '扩展字段6',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of T_ASSESS_TOPIC
-- ----------------------------
INSERT INTO `T_ASSESS_TOPIC` VALUES ('2018-09', '2', '2', '年度考核', '2018-04-25', '2018-05-27', '0', null, null, null, null, null, null);

-- ----------------------------
-- Table structure for T_ATTENDANCE
-- ----------------------------
DROP TABLE IF EXISTS `T_ATTENDANCE`;
CREATE TABLE `T_ATTENDANCE` (
  `id` int(11) NOT NULL,
  `employeeId` varchar(128) COLLATE utf8_bin NOT NULL,
  `absence` int(11) DEFAULT NULL COMMENT '缺勤天数',
  `late` int(11) DEFAULT NULL COMMENT '迟到天数',
  `leftEarly` int(11) DEFAULT NULL COMMENT '早退天数',
  `time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '日期',
  PRIMARY KEY (`id`),
  KEY `INDX_EMPLOYEE` (`employeeId`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='员工考勤信息表';

-- ----------------------------
-- Records of T_ATTENDANCE
-- ----------------------------

-- ----------------------------
-- Table structure for T_DEPARTMENT
-- ----------------------------
DROP TABLE IF EXISTS `T_DEPARTMENT`;
CREATE TABLE `T_DEPARTMENT` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '业务编号',
  `name` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '部门名称',
  `createTime` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '创建时间',
  `memo` varchar(2000) COLLATE utf8_bin DEFAULT NULL COMMENT '部门描述',
  `tel` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '部门电话',
  `manager` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '部门经理',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of T_DEPARTMENT
-- ----------------------------
INSERT INTO `T_DEPARTMENT` VALUES ('1', '技术部', '2018-03-26 09:22:09', '技术部2', '15011899564', '20113348');
INSERT INTO `T_DEPARTMENT` VALUES ('2', '人事部', '2018-03-26 09:24:09', '人事部', '15011899564', '201133483');
INSERT INTO `T_DEPARTMENT` VALUES ('3', '事业部', '2018-03-26 09:24:54', '事业部', '15011899564', '2');
INSERT INTO `T_DEPARTMENT` VALUES ('4', '技术部2', '2018-03-26 09:22:09', '技术部', '15011899564', '1');
INSERT INTO `T_DEPARTMENT` VALUES ('5', '人事部3', '2018-03-26 09:24:09', '人事部', '15011899564', '20551234');
INSERT INTO `T_DEPARTMENT` VALUES ('6', '事业部4', '2018-03-26 09:24:54', '事业部', '15011899564', '205512349');
INSERT INTO `T_DEPARTMENT` VALUES ('7', '技术部5', '2018-03-26 09:22:09', '技术部', '15011899564', '107189');
INSERT INTO `T_DEPARTMENT` VALUES ('8', '人事部6', '2018-03-26 09:24:09', '人事部', '15011899564', '1');
INSERT INTO `T_DEPARTMENT` VALUES ('9', '事业部7', '2018-03-26 09:24:54', '事业部', '15011899564', '2');
INSERT INTO `T_DEPARTMENT` VALUES ('10', '技术部8', '2018-03-26 09:22:09', '技术部', '15011899564', '1');
INSERT INTO `T_DEPARTMENT` VALUES ('11', '人事部18', '2018-03-26 09:24:09', '人事部', '15011899564', '1');
INSERT INTO `T_DEPARTMENT` VALUES ('12', '事业部9', '2018-03-26 09:24:54', '事业部', '15011899564', '2');

-- ----------------------------
-- Table structure for T_EMPLOYEE
-- ----------------------------
DROP TABLE IF EXISTS `T_EMPLOYEE`;
CREATE TABLE `T_EMPLOYEE` (
  `id` varchar(128) NOT NULL COMMENT '员工编号',
  `name` varchar(64) DEFAULT NULL COMMENT '姓名',
  `password` varchar(64) DEFAULT NULL COMMENT '密码',
  `englishName` varchar(64) DEFAULT NULL COMMENT '外文名称',
  `sex` varchar(64) DEFAULT NULL COMMENT '性别',
  `homeAddr` varchar(64) DEFAULT NULL COMMENT '家庭住址',
  `birthday` varchar(64) DEFAULT NULL COMMENT '出生日期',
  `tel` varchar(64) DEFAULT NULL COMMENT '电话号码',
  `nation` varchar(64) DEFAULT NULL COMMENT '民族',
  `email` varchar(64) DEFAULT NULL COMMENT '电子邮件',
  `lastUpdateTime` varchar(64) NOT NULL COMMENT '更新时间',
  `createTime` varchar(64) DEFAULT NULL COMMENT '创建时间',
  `department` varchar(32) DEFAULT NULL COMMENT '部门',
  `salary` varchar(64) DEFAULT NULL COMMENT '基本工资',
  `job` varchar(32) DEFAULT NULL COMMENT '职位称呼',
  `rank` varchar(32) DEFAULT NULL COMMENT '职级',
  `supplement` int(12) DEFAULT NULL COMMENT '是否需要补充(0：要补充  1：已补充)',
  `office` varchar(12) DEFAULT NULL COMMENT '所属科室',
  PRIMARY KEY (`id`),
  KEY `INDX_NAME` (`name`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of T_EMPLOYEE
-- ----------------------------
INSERT INTO `T_EMPLOYEE` VALUES ('101', '乔科尔', '4QrcOUm6Wau+VuBX8g+IPg==', null, null, null, null, '15011899564', null, '111@dd.com', '2018-05-09 08:14:39', '2018-05-09 08:14:39', null, null, null, null, '0', null);
INSERT INTO `T_EMPLOYEE` VALUES ('107189', '周平', '/OqSD3QStdp74M9CuMk3WQ==', '周平', '0', '呜呜呜呜1', '2018-05-02', '15011899564', '汉', 'zhouping19911013@163.com', '2018-05-03 12:53:21', '2018-04-23 11:25:49', '1', '1111', '1', '2', '1', '1');
INSERT INTO `T_EMPLOYEE` VALUES ('20112233', '丽丽', 'SHrp/YAp8sWFcxz+WBrWkA==', '丽丽', '0', '', '2018-05-17', '15011899564', '汉', '', '2018-05-17 02:25:32', '2018-05-17 02:25:32', '2', '', '1', '1', '1', '15');
INSERT INTO `T_EMPLOYEE` VALUES ('20113336', '张珊', '4QrcOUm6Wau+VuBX8g+IPg==', '', null, '', '2018-04-24', '15011899564', '', 'zhouping@quanten.cn', '2018-04-24 14:39:56', '2018-04-24 14:39:23', '2', '', '1', '2', '1', '1');
INSERT INTO `T_EMPLOYEE` VALUES ('201133361', '周平12', '4QrcOUm6Wau+VuBX8g+IPg==', '周平', '0', '', '2018-04-23', '15011899564', '汉', 'zhouping19911013@163.com', '2018-04-24 01:56:41', '2018-04-23 11:25:49', '1', '', '1', '2', '1', '1');
INSERT INTO `T_EMPLOYEE` VALUES ('201133362', '张珊33', '4QrcOUm6Wau+VuBX8g+IPg==', '', null, '', '2018-04-24', '15011899564', '', 'zhouping@quanten.cn', '2018-04-24 14:39:56', '2018-04-24 14:39:23', '2', '', '1', '2', '1', '1');
INSERT INTO `T_EMPLOYEE` VALUES ('20113343', '汪汪', '4QrcOUm6Wau+VuBX8g+IPg==', '', null, '', '', '15011899564', '', 'zhouping@quanten.cn', '2018-05-15 08:37:28', '2018-05-15 07:16:07', '1', '', '1', '1', '1', '9');
INSERT INTO `T_EMPLOYEE` VALUES ('20113348', '周平1', '4QrcOUm6Wau+VuBX8g+IPg==', '周平', '0', '333ddddddd', '2018-04-30', '15011899564', '333', 'zhouping@quanten.cn', '2018-05-09 08:16:41', '2018-04-24 14:37:33', '1', '2222333', '1', '1', '1', '1');
INSERT INTO `T_EMPLOYEE` VALUES ('201133483', '周平31', 'SHrp/YAp8sWFcxz+WBrWkA==', '周平', null, '', '2018-04-24', '15011899564', '', 'zhouping@quanten.cn', '2018-04-24 14:37:54', '2018-04-24 14:37:33', '1', '', '1', '1', '1', '1');
INSERT INTO `T_EMPLOYEE` VALUES ('20113392', '周平2', '4QrcOUm6Wau+VuBX8g+IPg==', '', null, '', '', '12345678978', '', 'zhouping@quanten.cn', '2018-04-23 11:41:52', '2018-04-23 11:41:14', '1', '', '', '1', '1', '1');
INSERT INTO `T_EMPLOYEE` VALUES ('201133924', '周平32', '4QrcOUm6Wau+VuBX8g+IPg==', '', null, '', '', '12345678978', '', 'zhouping@quanten.cn', '2018-04-23 11:41:52', '2018-04-23 11:41:14', '1', '', '', '1', '1', '1');
INSERT INTO `T_EMPLOYEE` VALUES ('20113598', '周平3', '4QrcOUm6Wau+VuBX8g+IPg==', null, null, null, null, '15011899564', null, 'zhouping@quanten.cn', '2018-04-24 10:38:05', '2018-04-24 10:38:05', '3', null, null, null, '0', '1');
INSERT INTO `T_EMPLOYEE` VALUES ('201135985', '周平33', '4QrcOUm6Wau+VuBX8g+IPg==', null, null, null, null, '15011899564', null, 'zhouping@quanten.cn', '2018-04-24 10:38:05', '2018-04-24 10:38:05', '3', null, null, null, '0', '1');
INSERT INTO `T_EMPLOYEE` VALUES ('2011445687', '周平4', '4QrcOUm6Wau+VuBX8g+IPg==', '周平', null, '', '2018-04-24', '15011899564', '汉', 'zhouping@quanten.cn', '2018-04-24 14:24:48', '2018-04-24 14:23:59', '1', '', '1', '3', '1', '1');
INSERT INTO `T_EMPLOYEE` VALUES ('20114456876', '周平34', '4QrcOUm6Wau+VuBX8g+IPg==', '周平', null, '', '2018-04-24', '15011899564', '汉', 'zhouping@quanten.cn', '2018-04-24 14:24:48', '2018-04-24 14:23:59', '1', '', '1', '3', '1', '1');
INSERT INTO `T_EMPLOYEE` VALUES ('20114789', '周平5', '4QrcOUm6Wau+VuBX8g+IPg==', 'zhouping', null, '', '2018-04-24', '15011899564', '汉', 'zhouping@quanten.cn', '2018-04-24 13:53:19', '2018-04-24 10:44:34', '2', '', '1', '1', '1', '1');
INSERT INTO `T_EMPLOYEE` VALUES ('201147897', '周平35', '4QrcOUm6Wau+VuBX8g+IPg==', 'zhouping', null, '', '2018-04-24', '15011899564', '汉', 'zhouping@quanten.cn', '2018-04-24 13:53:19', '2018-04-24 10:44:34', '2', '', '1', '1', '1', '1');
INSERT INTO `T_EMPLOYEE` VALUES ('20114897', '李四', 'SHrp/YAp8sWFcxz+WBrWkA==', '', '1', 'China', '2012-05-16', '15011899564', '汉', '', '2018-05-15 08:37:39', '2018-05-15 07:13:36', '2', '', '1', '1', '1', '15');
INSERT INTO `T_EMPLOYEE` VALUES ('201165489', '李武', 'SHrp/YAp8sWFcxz+WBrWkA==', '李武', '0', '', '2018-05-17', '15011899564', '汉', '', '2018-05-17 02:22:30', '2018-05-17 02:22:30', '12', '', '1', '1', '1', '0');
INSERT INTO `T_EMPLOYEE` VALUES ('20331234', '周平6', '4QrcOUm6Wau+VuBX8g+IPg==', '周平', null, '', '2018-04-24', '15011899564', '汉', 'zhouping@quanten.cn', '2018-04-24 13:57:16', '2018-04-24 13:56:35', '1', '', '2', '4', '1', '1');
INSERT INTO `T_EMPLOYEE` VALUES ('203312348', '周平36', '4QrcOUm6Wau+VuBX8g+IPg==', '周平', null, '', '2018-04-24', '15011899564', '汉', 'zhouping@quanten.cn', '2018-04-24 13:57:16', '2018-04-24 13:56:35', '1', '', '2', '4', '1', '1');
INSERT INTO `T_EMPLOYEE` VALUES ('20551234', '周平7', '4QrcOUm6Wau+VuBX8g+IPg==', '', '0', '', '2018-04-24', '15011899564', '', 'zhouping@quanten.cn', '2018-04-24 14:36:03', '2018-04-24 14:35:45', '1', '', '1', '1', '1', '1');
INSERT INTO `T_EMPLOYEE` VALUES ('205512349', '周平37', '4QrcOUm6Wau+VuBX8g+IPg==', '111', '0', '111122333333333', '2018-05-02', '15011899564', '22', 'zhouping@quanten.cn', '2018-05-03 07:30:38', '2018-04-24 14:35:45', '1', '2001', '1', '1', '1', '1');
INSERT INTO `T_EMPLOYEE` VALUES ('20551236', '周平9', '4QrcOUm6Wau+VuBX8g+IPg==', '', '0', '', '2018-04-24', '15011899564', '', 'zhouping@quanten.cn', '2018-04-30 03:25:27', '2018-04-24 14:35:45', '1', '100', '1', '4', '1', '1');
INSERT INTO `T_EMPLOYEE` VALUES ('20551237', '周平10', '4QrcOUm6Wau+VuBX8g+IPg==', '', '0', '', '2018-04-24', '15011899564', '', 'zhouping@quanten.cn', '2018-04-24 14:36:03', '2018-04-24 14:35:45', '1', '100', '1', '1', '1', '1');
INSERT INTO `T_EMPLOYEE` VALUES ('20551238', '周平11', '4QrcOUm6Wau+VuBX8g+IPg==', '', '0', '', '2018-04-24', '15011899564', '', 'zhouping@quanten.cn', '2018-04-24 14:36:03', '2018-04-24 14:35:45', '1', '100', '1', '1', '1', '1');
INSERT INTO `T_EMPLOYEE` VALUES ('20551239', '周平12', '4QrcOUm6Wau+VuBX8g+IPg==', '', '0', '', '2018-04-24', '15011899564', '', 'zhouping@quanten.cn', '2018-04-24 14:36:03', '2018-04-24 14:35:45', '1', '100100', '1', '1', '1', '1');
INSERT INTO `T_EMPLOYEE` VALUES ('20551240', '周平13', '4QrcOUm6Wau+VuBX8g+IPg==', '', '0', '', '2018-04-24', '15011899564', '', 'zhouping@quanten.cn', '2018-04-24 14:36:03', '2018-04-24 14:35:45', '1', '100', '1', '1', '1', '1');
INSERT INTO `T_EMPLOYEE` VALUES ('20551241', '周平14', '4QrcOUm6Wau+VuBX8g+IPg==', '', '0', '', '2018-04-24', '15011899564', '', 'zhouping@quanten.cn', '2018-04-24 14:36:03', '2018-04-24 14:35:45', '1', '100', '1', '1', '1', '1');
INSERT INTO `T_EMPLOYEE` VALUES ('20551243', '周平16', '4QrcOUm6Wau+VuBX8g+IPg==', '', '0', '', '2018-04-24', '15011899564', '', 'zhouping@quanten.cn', '2018-04-24 14:36:03', '2018-04-24 14:35:45', '1', '100', '1', '1', '1', '1');
INSERT INTO `T_EMPLOYEE` VALUES ('20551245', '周平18', '4QrcOUm6Wau+VuBX8g+IPg==', '', '0', '', '2018-04-24', '15011899564', '', 'zhouping@quanten.cn', '2018-04-24 14:36:03', '2018-04-24 14:35:45', '1', '100', '1', '1', '1', '1');
INSERT INTO `T_EMPLOYEE` VALUES ('20551246', '周平19', '4QrcOUm6Wau+VuBX8g+IPg==', '', '0', '', '2018-04-24', '15011899564', '', 'zhouping@quanten.cn', '2018-04-24 14:36:03', '2018-04-24 14:35:45', '', '100', '1', '1', '1', '1');
INSERT INTO `T_EMPLOYEE` VALUES ('adminatmb', 'adm', 'SHrp/YAp8sWFcxz+WBrWkA==', '111', '0', '111', '2018-05-09', '12345678909', '111', '2222@dd.com', '2018-05-09 11:04:42', '2018-05-09 11:04:42', '3', '111', '1', '2', '1', '1');
INSERT INTO `T_EMPLOYEE` VALUES ('T001', 'T001', '4QrcOUm6Wau+VuBX8g+IPg==', '', '0', 'T001', '', '12345678901', '', '333@c.com', '2018-05-09 11:06:31', '2018-05-09 11:05:31', '1', 'T001', '1', '1', '1', '0');

-- ----------------------------
-- Table structure for T_EMPLOYEE_RELATION
-- ----------------------------
DROP TABLE IF EXISTS `T_EMPLOYEE_RELATION`;
CREATE TABLE `T_EMPLOYEE_RELATION` (
  `id` int(11) NOT NULL,
  `employeeId` varchar(128) COLLATE utf8_bin NOT NULL COMMENT '员工编号',
  `departmentId` int(11) NOT NULL COMMENT '部门编号',
  `rankId` int(11) NOT NULL COMMENT '职级编号',
  `jobId` int(11) NOT NULL COMMENT '职位编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of T_EMPLOYEE_RELATION
-- ----------------------------

-- ----------------------------
-- Table structure for T_JOB
-- ----------------------------
DROP TABLE IF EXISTS `T_JOB`;
CREATE TABLE `T_JOB` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '职位称呼',
  `memo` varchar(1000) COLLATE utf8_bin DEFAULT NULL COMMENT '职位描述',
  `createTime` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of T_JOB
-- ----------------------------
INSERT INTO `T_JOB` VALUES ('1', '局级', '222', '2018-03-29 07:06:21');
INSERT INTO `T_JOB` VALUES ('2', '处级', '2233', '2018-03-29 07:06:21');

-- ----------------------------
-- Table structure for T_MENU
-- ----------------------------
DROP TABLE IF EXISTS `T_MENU`;
CREATE TABLE `T_MENU` (
  `menuId` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜单编号',
  `menuName` varchar(40) DEFAULT NULL COMMENT '菜单名称',
  `parentMenuId` int(11) DEFAULT NULL COMMENT '父菜单编号',
  `menuType` int(2) DEFAULT NULL COMMENT '菜单类型',
  `leaf` int(2) DEFAULT NULL COMMENT '是否子节点',
  `menuUrl` varchar(256) DEFAULT NULL COMMENT '菜单地址',
  `sort` int(1) DEFAULT NULL COMMENT '排序字段',
  `memo` varchar(200) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`menuId`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of T_MENU
-- ----------------------------
INSERT INTO `T_MENU` VALUES ('1', '员工管理', null, '0', '1', null, '1', '&#xe6b8;');
INSERT INTO `T_MENU` VALUES ('2', '系统管理', null, '0', '0', null, '2', '&#xe723;');
INSERT INTO `T_MENU` VALUES ('3', '部门管理', '2', '0', '1', 'dpt_list.html', '21', '部门信息管理');
INSERT INTO `T_MENU` VALUES ('4', '科室管理', '2', '0', '1', 'office_list.html', '22', '科室管理');
INSERT INTO `T_MENU` VALUES ('5', '职位管理', '2', '0', '1', 'rank_relation_list.html', '24', '职位称呼信息管理');
INSERT INTO `T_MENU` VALUES ('7', '员工考核', null, '0', '0', 'emp_assess.html', '3', '&#xe6b8;');
INSERT INTO `T_MENU` VALUES ('8', '员工互评', '7', '0', '1', 'assess.html', '31', '员工信息互评管理');
INSERT INTO `T_MENU` VALUES ('9', '员工自评', '7', '0', '1', 'assess_own.html', '32', '员工信息自评管理');
INSERT INTO `T_MENU` VALUES ('10', '员工列表', '1', '0', '1', 'emp_list.html', '11', '员工列表');
INSERT INTO `T_MENU` VALUES ('12', '考核列表', '7', '0', '1', 'topic_list.html', '34', '考核列表信息');
INSERT INTO `T_MENU` VALUES ('13', '职级管理', '2', '0', '1', 'rank_list.html', '23', '职位级别信息管理');
INSERT INTO `T_MENU` VALUES ('14', '考核分类', '7', '0', '1', 'catalog_list.html', '35', '考核分类');
INSERT INTO `T_MENU` VALUES ('15', '考核内容', '7', '0', '1', 'content_list.html', '36', '考核内容');
INSERT INTO `T_MENU` VALUES ('16', '考核成绩', '7', '0', '1', null, '37', '考核成绩');
INSERT INTO `T_MENU` VALUES ('17', '新员工', '1', '0', '0', 'newemp_list.html', '12', '新注册的用户信息');

-- ----------------------------
-- Table structure for T_MENUROLERLAT
-- ----------------------------
DROP TABLE IF EXISTS `T_MENUROLERLAT`;
CREATE TABLE `T_MENUROLERLAT` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '业务编号',
  `menuId` int(11) NOT NULL COMMENT '菜单编号',
  `roleId` int(11) NOT NULL COMMENT '角色编号',
  `memo` varchar(200) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=68 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of T_MENUROLERLAT
-- ----------------------------
INSERT INTO `T_MENUROLERLAT` VALUES ('1', '1', '2', null);
INSERT INTO `T_MENUROLERLAT` VALUES ('2', '2', '2', null);
INSERT INTO `T_MENUROLERLAT` VALUES ('3', '3', '2', null);
INSERT INTO `T_MENUROLERLAT` VALUES ('4', '4', '2', null);
INSERT INTO `T_MENUROLERLAT` VALUES ('5', '5', '2', null);
INSERT INTO `T_MENUROLERLAT` VALUES ('7', '7', '2', null);
INSERT INTO `T_MENUROLERLAT` VALUES ('8', '10', '2', null);
INSERT INTO `T_MENUROLERLAT` VALUES ('10', '12', '2', null);
INSERT INTO `T_MENUROLERLAT` VALUES ('11', '13', '2', null);
INSERT INTO `T_MENUROLERLAT` VALUES ('12', '1', '1', null);
INSERT INTO `T_MENUROLERLAT` VALUES ('13', '10', '1', null);
INSERT INTO `T_MENUROLERLAT` VALUES ('14', '7', '1', null);
INSERT INTO `T_MENUROLERLAT` VALUES ('15', '8', '1', null);
INSERT INTO `T_MENUROLERLAT` VALUES ('16', '9', '1', null);
INSERT INTO `T_MENUROLERLAT` VALUES ('64', '14', '2', null);
INSERT INTO `T_MENUROLERLAT` VALUES ('65', '15', '2', null);
INSERT INTO `T_MENUROLERLAT` VALUES ('66', '16', '2', null);
INSERT INTO `T_MENUROLERLAT` VALUES ('67', '17', '2', null);

-- ----------------------------
-- Table structure for T_OFFICE
-- ----------------------------
DROP TABLE IF EXISTS `T_OFFICE`;
CREATE TABLE `T_OFFICE` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) COLLATE utf8_bin NOT NULL,
  `createTime` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  `department` int(11) DEFAULT NULL,
  `memo` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `manager` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '科室负责人',
  `tel` varchar(16) COLLATE utf8_bin DEFAULT NULL COMMENT '电话号码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of T_OFFICE
-- ----------------------------
INSERT INTO `T_OFFICE` VALUES ('0', '无', '2018-05-09 08:36:43', null, '默认部门', null, null);
INSERT INTO `T_OFFICE` VALUES ('1', '人事部', '2018-05-09 08:36:43', '1', 'dsfsadf', '203312348', null);
INSERT INTO `T_OFFICE` VALUES ('2', '333', '2018-05-04 03:35:50', '1', '444', null, null);
INSERT INTO `T_OFFICE` VALUES ('5', '444', '2018-05-04 03:36:32', '2', '444', null, null);
INSERT INTO `T_OFFICE` VALUES ('6', '111', '2018-05-04 08:11:03', '6', '2222', null, null);
INSERT INTO `T_OFFICE` VALUES ('7', '33311', '2018-05-04 08:17:27', '1', '3333', null, null);
INSERT INTO `T_OFFICE` VALUES ('8', '33', '2018-05-04 08:17:36', '1', '3344', null, null);
INSERT INTO `T_OFFICE` VALUES ('9', '技术部', '2018-05-08 08:20:01', '1', '技术部', '20113348', null);
INSERT INTO `T_OFFICE` VALUES ('10', 'f1', '2018-05-09 08:28:08', '1', '2222', '20551234', null);
INSERT INTO `T_OFFICE` VALUES ('11', '3333444', '2018-05-09 08:35:54', '1', '444', '201133483', null);
INSERT INTO `T_OFFICE` VALUES ('12', 't001', '2018-05-09 08:36:20', '3', 'ttt', '205512349', null);
INSERT INTO `T_OFFICE` VALUES ('13', 't003', '2018-05-09 08:36:43', '1', '333', '203312348', null);
INSERT INTO `T_OFFICE` VALUES ('15', 'T0001', '2018-05-09 11:15:47', '2', '1111', '201147897', '11');
INSERT INTO `T_OFFICE` VALUES ('16', 'test001', '2018-05-24 02:55:38', '3', 'entity', 'adminatmb', '111');

-- ----------------------------
-- Table structure for T_PERMSION
-- ----------------------------
DROP TABLE IF EXISTS `T_PERMSION`;
CREATE TABLE `T_PERMSION` (
  `permsionId` int(11) NOT NULL AUTO_INCREMENT COMMENT '权限编号',
  `permsionName` varchar(64) DEFAULT NULL COMMENT '权限名称',
  `permsionFlag` varchar(64) DEFAULT NULL COMMENT '权限标识',
  `menuId` int(11) DEFAULT NULL COMMENT '菜单编号',
  `memo` varchar(64) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`permsionId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of T_PERMSION
-- ----------------------------
INSERT INTO `T_PERMSION` VALUES ('1', '系统添加', 'system:add', null, null);
INSERT INTO `T_PERMSION` VALUES ('2', '系统修改', 'system:modify', null, null);
INSERT INTO `T_PERMSION` VALUES ('3', '系统删除', 'system:delete', null, null);

-- ----------------------------
-- Table structure for T_PERMSIONROLERLAT
-- ----------------------------
DROP TABLE IF EXISTS `T_PERMSIONROLERLAT`;
CREATE TABLE `T_PERMSIONROLERLAT` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '业务编号',
  `permsionId` int(11) DEFAULT NULL COMMENT '权限编号',
  `roleId` int(11) DEFAULT NULL COMMENT '角色编号',
  `optType` varchar(64) DEFAULT NULL COMMENT '操作类型',
  `memo` varchar(64) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of T_PERMSIONROLERLAT
-- ----------------------------
INSERT INTO `T_PERMSIONROLERLAT` VALUES ('1', '1', '1', null, null);
INSERT INTO `T_PERMSIONROLERLAT` VALUES ('2', '2', '1', null, null);
INSERT INTO `T_PERMSIONROLERLAT` VALUES ('3', '3', '2', null, null);

-- ----------------------------
-- Table structure for T_RANK
-- ----------------------------
DROP TABLE IF EXISTS `T_RANK`;
CREATE TABLE `T_RANK` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '业务编号',
  `name` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '职级名称',
  `memo` varchar(1000) COLLATE utf8_bin DEFAULT NULL COMMENT '描述',
  `createTime` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of T_RANK
-- ----------------------------
INSERT INTO `T_RANK` VALUES ('1', '局级', '局上级别', null);
INSERT INTO `T_RANK` VALUES ('2', '处级', '处级', null);
INSERT INTO `T_RANK` VALUES ('3', '科级', '科级', null);
INSERT INTO `T_RANK` VALUES ('4', '普通员工', '普通员工', null);

-- ----------------------------
-- Table structure for T_ROLE
-- ----------------------------
DROP TABLE IF EXISTS `T_ROLE`;
CREATE TABLE `T_ROLE` (
  `roleId` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色编号',
  `parentRoleId` int(11) DEFAULT NULL COMMENT '父角色编号',
  `roleType` varchar(64) DEFAULT NULL COMMENT '角色类型',
  `roleName` varchar(64) DEFAULT NULL COMMENT '角色名称',
  `memo` varchar(64) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`roleId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of T_ROLE
-- ----------------------------
INSERT INTO `T_ROLE` VALUES ('1', null, '1', '普通员工', '普通员工角色');
INSERT INTO `T_ROLE` VALUES ('2', null, '0', '系统管理员', '系统管理员角色');

-- ----------------------------
-- Procedure structure for PRO_ADMINROLE
-- ----------------------------
DROP PROCEDURE IF EXISTS `PRO_ADMINROLE`;
DELIMITER ;;
CREATE DEFINER=`human`@`%` PROCEDURE `PRO_ADMINROLE`(IN `admin` varchar(64), IN `role` varchar(16))
    COMMENT '添加或修改管理员角色信息'
BEGIN
	DECLARE total INT DEFAULT 0;
	SELECT COUNT(1) FROM T_ADMINROLERLAT WHERE adminId=admin INTO total;
	IF total > 0 THEN 
		UPDATE T_ADMINROLERLAT SET roleId=role WHERE adminId=admin;
	ELSE
		INSERT INTO T_ADMINROLERLAT(`adminId`, `roleId`) VALUES(admin, role);
	END IF;
END
;;
DELIMITER ;
