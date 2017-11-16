/*
Navicat MySQL Data Transfer

Source Server         : 阿里云
Source Server Version : 50633
Source Host           : 118.190.74.13:3306
Source Database       : product

Target Server Type    : MYSQL
Target Server Version : 50633
File Encoding         : 65001

Date: 2017-11-16 17:47:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for attribute_name
-- ----------------------------
DROP TABLE IF EXISTS `attribute_name`;
CREATE TABLE `attribute_name` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `type` int(4) NOT NULL COMMENT '属性类型：0是属性分组,1类目属性，2商品属性，3产品属性，4商家属性',
  `is_available` tinyint(2) DEFAULT '0' COMMENT '是否可用:默认0否;1是',
  `is_deleted`  tinyint(2) DEFAULT '0' COMMENT '是否逻辑删除:默认0未删除;1已删除',
  `version_no` int(11) DEFAULT '0' COMMENT '版本号:默认0,每次更新+1',
  `create_userid` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `create_username` varchar(100) DEFAULT NULL COMMENT '创建人姓名',
  `create_userip` varchar(60) DEFAULT NULL COMMENT '创建人IP',
  `create_usermac` varchar(60) DEFAULT NULL COMMENT '创建人MAC地址',
  `create_time` timestamp NULL DEFAULT NULL,
  `create_time_db` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间-数据库操作时间',
  `server_ip` varchar(60) DEFAULT NULL COMMENT '服务器IP',
  `update_userid` bigint(20) DEFAULT NULL COMMENT '最后修改人ID',
  `update_username` varchar(100) DEFAULT NULL COMMENT '最后修改人姓名',
  `update_userip` varchar(60) DEFAULT NULL COMMENT '最后修改人IP',
  `update_usermac` varchar(60) DEFAULT NULL COMMENT '最后修改人MAC',
  `update_time` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改时间',
  `update_time_db` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改时间-数据库默认写入时间',
  `client_versionno` varchar(40) DEFAULT NULL COMMENT '客户端程序的版本号',
  `company_id` bigint(20) DEFAULT NULL COMMENT '公司id',
  PRIMARY KEY (`id`),
  KEY `company_id` (`company_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COMMENT='属性名称表';

-- ----------------------------
-- Table structure for attribute_value
-- ----------------------------
DROP TABLE IF EXISTS `attribute_value`;
CREATE TABLE `attribute_value` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) DEFAULT NULL,
  `attribute_name_id` bigint(20) NOT NULL,
  `value` varchar(255) DEFAULT NULL,
  `sort_value` int(11) NOT NULL DEFAULT '0',
  `is_available` tinyint(2) DEFAULT NULL COMMENT '是否可用:默认0否;1是',
  `is_deleted`  tinyint(2) DEFAULT '0' COMMENT '是否逻辑删除:默认0未删除;1已删除',
  `version_no` int(11) DEFAULT '0' COMMENT '版本号:默认0,每次更新+1',
  `create_userid` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `create_username` varchar(100) DEFAULT NULL COMMENT '创建人姓名',
  `create_userip` varchar(60) DEFAULT NULL COMMENT '创建人IP',
  `create_usermac` varchar(60) DEFAULT NULL COMMENT '创建人MAC地址',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间-应用操作时间',
  `create_time_db` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间-数据库操作时间',
  `server_ip` varchar(60) DEFAULT NULL COMMENT '服务器IP',
  `update_userid` bigint(20) DEFAULT NULL COMMENT '最后修改人ID',
  `update_username` varchar(100) DEFAULT NULL COMMENT '最后修改人姓名',
  `update_userip` varchar(60) DEFAULT NULL COMMENT '最后修改人IP',
  `update_usermac` varchar(60) DEFAULT NULL COMMENT '最后修改人MAC',
  `update_time` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改时间',
  `update_time_db` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改时间-数据库默认写入时间',
  `client_versionno` varchar(40) DEFAULT NULL COMMENT '客户端程序的版本号',
  `company_id` bigint(20) DEFAULT NULL COMMENT '公司id',
  `type` int(4) DEFAULT '0' COMMENT '0选择属性值，1自定义属性值',
  PRIMARY KEY (`id`),
  KEY `company_id` (`company_id`) USING BTREE,
  KEY `attribute_name_id` (`attribute_name_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COMMENT='属性值表';

-- ----------------------------
-- Table structure for brand
-- ----------------------------
DROP TABLE IF EXISTS `brand`;
CREATE TABLE `brand` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `chinese_name` varchar(255) NOT NULL COMMENT '品牌中文名称',
  `english_name` varchar(255) NOT NULL COMMENT '品牌英文名称',
  `alias` varchar(255) DEFAULT '' COMMENT '品牌别名',
  `log_url` varchar(255) DEFAULT '' COMMENT '品牌url地址',
  `ownedcompany_chinese_name` varchar(255) DEFAULT '' COMMENT '品牌所属公司中文名称',
  `ownedcompany_english_name` varchar(255) DEFAULT '' COMMENT '品牌所属公司英文名称',
  `introduction` varchar(2000) DEFAULT '' COMMENT '品牌介绍',
  `is_available` tinyint(2) DEFAULT NULL COMMENT '是否可用:默认0否;1是',
  `is_deleted`  tinyint(2) DEFAULT '0' COMMENT '是否逻辑删除:默认0未删除;1已删除',
  `version_no` int(11) DEFAULT '0' COMMENT '版本号:默认0,每次更新+1',
  `create_userid` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `create_username` varchar(100) DEFAULT NULL COMMENT '创建人姓名',
  `create_userip` varchar(60) DEFAULT NULL COMMENT '创建人IP',
  `create_usermac` varchar(60) DEFAULT NULL COMMENT '创建人MAC地址',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间-应用操作时间',
  `create_time_db` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间-数据库操作时间',
  `server_ip` varchar(60) DEFAULT NULL COMMENT '服务器IP',
  `update_userid` bigint(20) DEFAULT NULL COMMENT '最后修改人ID',
  `update_username` varchar(100) DEFAULT NULL COMMENT '最后修改人姓名',
  `update_userip` varchar(60) DEFAULT NULL COMMENT '最后修改人IP',
  `update_usermac` varchar(60) DEFAULT NULL COMMENT '最后修改人MAC',
  `update_time` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改时间',
  `update_time_db` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改时间-数据库默认写入时间',
  `client_versionno` varchar(40) DEFAULT NULL COMMENT '客户端程序的版本号',
  `company_id` bigint(20) DEFAULT NULL COMMENT '公司id',
  `proxy_book_url` varchar(255) DEFAULT NULL COMMENT '授权证书url',
  `trademark_url` varchar(255) DEFAULT NULL COMMENT '商标url',
  `type` int(4) DEFAULT '0' COMMENT '0平台/1商家',
  `STATUS` int(11) DEFAULT '0' COMMENT '0待审核/1审核通过/2审核不通过',
  `remark` varchar(500) DEFAULT '' COMMENT '审核不通过原因',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='品牌表';

-- ----------------------------
-- Table structure for business_config
-- ----------------------------
DROP TABLE IF EXISTS `business_config`;
CREATE TABLE `business_config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL COMMENT '业务配置key',
  `value` int(11) DEFAULT NULL COMMENT '业务配置value',
  `is_available` tinyint(2) DEFAULT '0' COMMENT '是否可用:默认0否;1是',
  `is_deleted`  tinyint(2) DEFAULT '0' COMMENT '是否逻辑删除:默认0未删除;1已删除',
  `version_no` int(11) DEFAULT '0' COMMENT '版本号:默认0,每次更新+1',
  `create_userid` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `create_username` varchar(100) DEFAULT NULL COMMENT '创建人姓名',
  `create_userip` varchar(60) DEFAULT NULL COMMENT '创建人IP',
  `create_usermac` varchar(60) DEFAULT NULL COMMENT '创建人MAC地址',
  `create_time` timestamp NULL DEFAULT NULL,
  `create_time_db` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间-数据库操作时间',
  `server_ip` varchar(60) DEFAULT NULL COMMENT '服务器IP',
  `update_userid` bigint(20) DEFAULT NULL COMMENT '最后修改人ID',
  `update_username` varchar(100) DEFAULT NULL COMMENT '最后修改人姓名',
  `update_userip` varchar(60) DEFAULT NULL COMMENT '最后修改人IP',
  `update_usermac` varchar(60) DEFAULT NULL COMMENT '最后修改人MAC',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '最后修改时间',
  `update_time_db` timestamp NULL DEFAULT NULL COMMENT '最后修改时间-数据库默认写入时间',
  `client_versionno` varchar(40) DEFAULT NULL COMMENT '客户端程序的版本号',
  `company_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '公司id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='业务配置信息表';

-- ----------------------------
-- Table structure for cate_prod_ration
-- ----------------------------
DROP TABLE IF EXISTS `cate_prod_ration`;
CREATE TABLE `cate_prod_ration` (
  `id` bigint(12) NOT NULL AUTO_INCREMENT,
  `cate_gory_3id` bigint(20) DEFAULT NULL,
  `new_cate_gory_3id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for cate_tree_node_merchant_cate_tree_node_rel
-- ----------------------------
DROP TABLE IF EXISTS `cate_tree_node_merchant_cate_tree_node_rel`;
CREATE TABLE `cate_tree_node_merchant_cate_tree_node_rel` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cate_tree_node_id` bigint(20) NOT NULL COMMENT '类目树节点id',
  `merchant_cate_tree_node_id` bigint(20) NOT NULL COMMENT '商家类目树节点id',
  `merchant_id` bigint(20) DEFAULT NULL COMMENT '商家编号',
  `is_available` tinyint(2) DEFAULT '0' COMMENT '是否可用:默认0否;1是',
  `is_deleted`  tinyint(2) DEFAULT '0' COMMENT '是否逻辑删除:默认0未删除;1已删除',
  `version_no` int(11) DEFAULT '0' COMMENT '版本号:默认0,每次更新+1',
  `create_userid` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `create_username` varchar(100) DEFAULT NULL COMMENT '创建人姓名',
  `create_userip` varchar(60) DEFAULT NULL COMMENT '创建人IP',
  `create_usermac` varchar(60) DEFAULT NULL COMMENT '创建人MAC地址',
  `create_time` timestamp NULL DEFAULT NULL,
  `create_time_db` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间-数据库操作时间',
  `server_ip` varchar(60) DEFAULT NULL COMMENT '服务器IP',
  `update_userid` bigint(20) DEFAULT NULL COMMENT '最后修改人ID',
  `update_username` varchar(100) DEFAULT NULL COMMENT '最后修改人姓名',
  `update_userip` varchar(60) DEFAULT NULL COMMENT '最后修改人IP',
  `update_usermac` varchar(60) DEFAULT NULL COMMENT '最后修改人MAC',
  `update_time` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改时间',
  `update_time_db` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改时间-数据库默认写入时间',
  `client_versionno` varchar(40) DEFAULT NULL COMMENT '客户端程序的版本号',
  `company_id` bigint(20) DEFAULT NULL COMMENT '公司id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `category_lable` varchar(100) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `is_available` tinyint(2) DEFAULT NULL COMMENT '是否可用:默认0否;1是',
  `is_deleted`  tinyint(2) DEFAULT '0' COMMENT '是否逻辑删除:默认0未删除;1已删除',
  `version_no` int(11) DEFAULT '0' COMMENT '版本号:默认0,每次更新+1',
  `create_userid` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `create_username` varchar(100) DEFAULT NULL COMMENT '创建人姓名',
  `create_userip` varchar(60) DEFAULT NULL COMMENT '创建人IP',
  `create_usermac` varchar(60) DEFAULT NULL COMMENT '创建人MAC地址',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间-应用操作时间',
  `create_time_db` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间-数据库操作时间',
  `server_ip` varchar(60) DEFAULT NULL COMMENT '服务器IP',
  `update_userid` bigint(20) DEFAULT NULL COMMENT '最后修改人ID',
  `update_username` varchar(100) DEFAULT NULL COMMENT '最后修改人姓名',
  `update_userip` varchar(60) DEFAULT NULL COMMENT '最后修改人IP',
  `update_usermac` varchar(60) DEFAULT NULL COMMENT '最后修改人MAC',
  `update_time` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改时间',
  `update_time_db` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改时间-数据库默认写入时间',
  `client_versionno` varchar(40) DEFAULT NULL COMMENT '客户端程序的版本号',
  `company_id` bigint(20) DEFAULT NULL COMMENT '公司id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='类目表';

-- ----------------------------
-- Table structure for category_att_name
-- ----------------------------
DROP TABLE IF EXISTS `category_att_name`;
CREATE TABLE `category_att_name` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '分组id:默认为 -1 未分组,0分组',
  `category_id` bigint(20) NOT NULL,
  `att_name_id` bigint(20) NOT NULL,
  `sort_value` int(11) NOT NULL DEFAULT '0',
  `is_available` tinyint(2) DEFAULT NULL COMMENT '是否可用:默认0否;1是',
  `is_deleted`  tinyint(2) DEFAULT '0' COMMENT '是否逻辑删除:默认0未删除;1已删除',
  `version_no` int(11) DEFAULT '0' COMMENT '版本号:默认0,每次更新+1',
  `create_userid` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `create_username` varchar(100) DEFAULT NULL COMMENT '创建人姓名',
  `create_userip` varchar(60) DEFAULT NULL COMMENT '创建人IP',
  `create_usermac` varchar(60) DEFAULT NULL COMMENT '创建人MAC地址',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间-应用操作时间',
  `create_time_db` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间-数据库操作时间',
  `server_ip` varchar(60) DEFAULT NULL COMMENT '服务器IP',
  `update_userid` bigint(20) DEFAULT NULL COMMENT '最后修改人ID',
  `update_username` varchar(100) DEFAULT NULL COMMENT '最后修改人姓名',
  `update_userip` varchar(60) DEFAULT NULL COMMENT '最后修改人IP',
  `update_usermac` varchar(60) DEFAULT NULL COMMENT '最后修改人MAC',
  `update_time` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改时间',
  `update_time_db` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改时间-数据库默认写入时间',
  `client_versionno` varchar(40) DEFAULT NULL COMMENT '客户端程序的版本号',
  `company_id` bigint(20) DEFAULT NULL COMMENT '公司id',
  `type` int(4) DEFAULT '0' COMMENT '用途:1:基本,2:系列,4:导购',
  `uses` int(11) DEFAULT '1' COMMENT '用途:1:基本,2:系列,3:导购',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='类目属性名';

-- ----------------------------
-- Table structure for category_att_value
-- ----------------------------
DROP TABLE IF EXISTS `category_att_value`;
CREATE TABLE `category_att_value` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `category_att_name_id` bigint(20) NOT NULL,
  `att_value_id` bigint(20) NOT NULL,
  `att_value_custom` varchar(255) DEFAULT NULL,
  `sort_value` int(11) NOT NULL DEFAULT '0',
  `is_available` tinyint(2) DEFAULT NULL COMMENT '是否可用:默认0否;1是',
  `is_deleted`  tinyint(2) DEFAULT '0' COMMENT '是否逻辑删除:默认0未删除;1已删除',
  `version_no` int(11) DEFAULT '0' COMMENT '版本号:默认0,每次更新+1',
  `create_userid` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `create_username` varchar(100) DEFAULT NULL COMMENT '创建人姓名',
  `create_userip` varchar(60) DEFAULT NULL COMMENT '创建人IP',
  `create_usermac` varchar(60) DEFAULT NULL COMMENT '创建人MAC地址',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间-应用操作时间',
  `create_time_db` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间-数据库操作时间',
  `server_ip` varchar(60) DEFAULT NULL COMMENT '服务器IP',
  `update_userid` bigint(20) DEFAULT NULL COMMENT '最后修改人ID',
  `update_username` varchar(100) DEFAULT NULL COMMENT '最后修改人姓名',
  `update_userip` varchar(60) DEFAULT NULL COMMENT '最后修改人IP',
  `update_usermac` varchar(60) DEFAULT NULL COMMENT '最后修改人MAC',
  `update_time` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改时间',
  `update_time_db` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改时间-数据库默认写入时间',
  `client_versionno` varchar(40) DEFAULT NULL COMMENT '客户端程序的版本号',
  `company_id` bigint(20) DEFAULT NULL COMMENT '公司id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for category_tree
-- ----------------------------
DROP TABLE IF EXISTS `category_tree`;
CREATE TABLE `category_tree` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type` int(4) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `is_available` tinyint(2) DEFAULT NULL COMMENT '是否可用:默认0否;1是',
  `is_deleted`  tinyint(2) DEFAULT '0' COMMENT '是否逻辑删除:默认0未删除;1已删除',
  `version_no` int(11) DEFAULT '0' COMMENT '版本号:默认0,每次更新+1',
  `create_userid` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `create_username` varchar(100) DEFAULT NULL COMMENT '创建人姓名',
  `create_userip` varchar(60) DEFAULT NULL COMMENT '创建人IP',
  `create_usermac` varchar(60) DEFAULT NULL COMMENT '创建人MAC地址',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间-应用操作时间',
  `create_time_db` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间-数据库操作时间',
  `server_ip` varchar(60) DEFAULT NULL COMMENT '服务器IP',
  `update_userid` bigint(20) DEFAULT NULL COMMENT '最后修改人ID',
  `update_username` varchar(100) DEFAULT NULL COMMENT '最后修改人姓名',
  `update_userip` varchar(60) DEFAULT NULL COMMENT '最后修改人IP',
  `update_usermac` varchar(60) DEFAULT NULL COMMENT '最后修改人MAC',
  `update_time` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改时间',
  `update_time_db` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改时间-数据库默认写入时间',
  `client_versionno` varchar(40) DEFAULT NULL COMMENT '客户端程序的版本号',
  `company_id` bigint(20) DEFAULT NULL COMMENT '公司id',
  `description` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='类目Tree表';

-- ----------------------------
-- Table structure for category_tree_node
-- ----------------------------
DROP TABLE IF EXISTS `category_tree_node`;
CREATE TABLE `category_tree_node` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) NOT NULL,
  `category_tree_id` bigint(20) NOT NULL,
  `category_id` bigint(20) NOT NULL,
  `list_sort` int(11) DEFAULT NULL COMMENT '列表排序',
  `is_visible` int(11) DEFAULT NULL COMMENT '是否可见:默认0可见;1不可见',
  `is_available` tinyint(2) DEFAULT NULL COMMENT '是否可用:默认0否;1是',
  `is_deleted`  tinyint(2) DEFAULT '0' COMMENT '是否逻辑删除:默认0未删除;1已删除',
  `version_no` int(11) DEFAULT '0' COMMENT '版本号:默认0,每次更新+1',
  `create_userid` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `create_username` varchar(100) DEFAULT NULL COMMENT '创建人姓名',
  `create_userip` varchar(60) DEFAULT NULL COMMENT '创建人IP',
  `create_usermac` varchar(60) DEFAULT NULL COMMENT '创建人MAC地址',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间-应用操作时间',
  `create_time_db` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间-数据库操作时间',
  `server_ip` varchar(60) DEFAULT NULL COMMENT '服务器IP',
  `update_userid` bigint(20) DEFAULT NULL COMMENT '最后修改人ID',
  `update_username` varchar(100) DEFAULT NULL COMMENT '最后修改人姓名',
  `update_userip` varchar(60) DEFAULT NULL COMMENT '最后修改人IP',
  `update_usermac` varchar(60) DEFAULT NULL COMMENT '最后修改人MAC',
  `update_time` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改时间',
  `update_time_db` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改时间-数据库默认写入时间',
  `client_versionno` varchar(40) DEFAULT NULL COMMENT '客户端程序的版本号',
  `company_id` bigint(20) DEFAULT NULL COMMENT '公司id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='类目数节点';

-- ----------------------------
-- Table structure for category_tree_node_picture
-- ----------------------------
DROP TABLE IF EXISTS `category_tree_node_picture`;
CREATE TABLE `category_tree_node_picture` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cate_tree_node_id` bigint(20) NOT NULL COMMENT '产品树节点表ID',
  `picture_id` bigint(20) NOT NULL COMMENT '图片表ID',
  `is_available` tinyint(2) DEFAULT NULL COMMENT '是否可用:默认0否;1是',
  `is_deleted`  tinyint(2) DEFAULT '0' COMMENT '是否逻辑删除:默认0未删除;1已删除',
  `version_no` int(11) DEFAULT '0' COMMENT '版本号:默认0,每次更新+1',
  `create_userid` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `create_username` varchar(100) DEFAULT NULL COMMENT '创建人姓名',
  `create_userip` varchar(60) DEFAULT NULL COMMENT '创建人IP',
  `create_usermac` varchar(60) DEFAULT NULL COMMENT '创建人MAC地址',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间-应用操作时间',
  `create_time_db` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间-数据库操作时间',
  `server_ip` varchar(60) DEFAULT NULL COMMENT '服务器IP',
  `update_userid` bigint(20) DEFAULT NULL COMMENT '最后修改人ID',
  `update_username` varchar(100) DEFAULT NULL COMMENT '最后修改人姓名',
  `update_userip` varchar(60) DEFAULT NULL COMMENT '最后修改人IP',
  `update_usermac` varchar(60) DEFAULT NULL COMMENT '最后修改人MAC',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '最后修改时间',
  `update_time_db` timestamp NULL DEFAULT NULL COMMENT '最后修改时间-数据库默认写入时间',
  `client_versionno` varchar(40) DEFAULT NULL COMMENT '客户端程序的版本号',
  `company_id` bigint(20) DEFAULT NULL COMMENT '公司id',
  PRIMARY KEY (`id`),
  KEY `idx_node_id` (`cate_tree_node_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品树节点图片表';

-- ----------------------------
-- Table structure for category_tree_node_product
-- ----------------------------
DROP TABLE IF EXISTS `category_tree_node_product`;
CREATE TABLE `category_tree_node_product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `category_tree_node_relation_id` bigint(20) NOT NULL,
  `product_id` bigint(20) NOT NULL COMMENT '产品ID',
  `type` int(4) NOT NULL COMMENT '聚合类型:3:包含聚合,4:不包含聚合',
  `is_available` tinyint(2) DEFAULT '0' COMMENT '是否可用:默认0否;1是',
  `is_deleted`  tinyint(2) DEFAULT '0' COMMENT '是否逻辑删除:默认0未删除;1已删除',
  `version_no` int(11) DEFAULT '0' COMMENT '版本号:默认0,每次更新+1',
  `create_userid` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `create_username` varchar(100) DEFAULT NULL COMMENT '创建人姓名',
  `create_userip` varchar(60) DEFAULT NULL COMMENT '创建人IP',
  `create_usermac` varchar(60) DEFAULT NULL COMMENT '创建人MAC地址',
  `create_time` timestamp NULL DEFAULT NULL,
  `create_time_db` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间-数据库操作时间',
  `server_ip` varchar(60) DEFAULT NULL COMMENT '服务器IP',
  `update_userid` bigint(20) DEFAULT NULL COMMENT '最后修改人ID',
  `update_username` varchar(100) DEFAULT NULL COMMENT '最后修改人姓名',
  `update_userip` varchar(60) DEFAULT NULL COMMENT '最后修改人IP',
  `update_usermac` varchar(60) DEFAULT NULL COMMENT '最后修改人MAC',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '最后修改时间',
  `update_time_db` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后修改时间-数据库默认写入时间',
  `client_versionno` varchar(40) DEFAULT NULL COMMENT '客户端程序的版本号',
  `company_id` bigint(20) DEFAULT NULL COMMENT '公司id',
  PRIMARY KEY (`id`),
  KEY `idx_product_id` (`product_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for category_tree_node_rel_att_name
-- ----------------------------
DROP TABLE IF EXISTS `category_tree_node_rel_att_name`;
CREATE TABLE `category_tree_node_rel_att_name` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '分组id:默认为 -1 未分组,0分组',
  `cate_tree_node_rel_id` bigint(20) NOT NULL,
  `att_name_id` bigint(20) NOT NULL,
  `sort_value` int(11) NOT NULL DEFAULT '0',
  `is_available` tinyint(2) DEFAULT NULL COMMENT '是否可用:默认0否;1是',
  `is_deleted`  tinyint(2) DEFAULT '0' COMMENT '是否逻辑删除:默认0未删除;1已删除',
  `version_no` int(11) DEFAULT '0' COMMENT '版本号:默认0,每次更新+1',
  `create_userid` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `create_username` varchar(100) DEFAULT NULL COMMENT '创建人姓名',
  `create_userip` varchar(60) DEFAULT NULL COMMENT '创建人IP',
  `create_usermac` varchar(60) DEFAULT NULL COMMENT '创建人MAC地址',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间-应用操作时间',
  `create_time_db` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间-数据库操作时间',
  `server_ip` varchar(60) DEFAULT NULL COMMENT '服务器IP',
  `update_userid` bigint(20) DEFAULT NULL COMMENT '最后修改人ID',
  `update_username` varchar(100) DEFAULT NULL COMMENT '最后修改人姓名',
  `update_userip` varchar(60) DEFAULT NULL COMMENT '最后修改人IP',
  `update_usermac` varchar(60) DEFAULT NULL COMMENT '最后修改人MAC',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '最后修改时间',
  `update_time_db` timestamp NULL DEFAULT NULL COMMENT '最后修改时间-数据库默认写入时间',
  `client_versionno` varchar(40) DEFAULT NULL COMMENT '客户端程序的版本号',
  `company_id` bigint(20) DEFAULT NULL COMMENT '公司id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='类目聚合属性名';

-- ----------------------------
-- Table structure for category_tree_node_rel_att_value
-- ----------------------------
DROP TABLE IF EXISTS `category_tree_node_rel_att_value`;
CREATE TABLE `category_tree_node_rel_att_value` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `cate_tree_node_rel_att_name_id` bigint(20) NOT NULL,
  `att_value_id` bigint(20) NOT NULL,
  `att_value_custom` varchar(255) DEFAULT NULL,
  `sort_value` int(11) NOT NULL DEFAULT '0',
  `is_available` tinyint(2) DEFAULT NULL COMMENT '是否可用:默认0否;1是',
  `is_deleted`  tinyint(2) DEFAULT '0' COMMENT '是否逻辑删除:默认0未删除;1已删除',
  `version_no` int(11) DEFAULT '0' COMMENT '版本号:默认0,每次更新+1',
  `create_userid` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `create_username` varchar(100) DEFAULT NULL COMMENT '创建人姓名',
  `create_userip` varchar(60) DEFAULT NULL COMMENT '创建人IP',
  `create_usermac` varchar(60) DEFAULT NULL COMMENT '创建人MAC地址',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间-应用操作时间',
  `create_time_db` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间-数据库操作时间',
  `server_ip` varchar(60) DEFAULT NULL COMMENT '服务器IP',
  `update_userid` bigint(20) DEFAULT NULL COMMENT '最后修改人ID',
  `update_username` varchar(100) DEFAULT NULL COMMENT '最后修改人姓名',
  `update_userip` varchar(60) DEFAULT NULL COMMENT '最后修改人IP',
  `update_usermac` varchar(60) DEFAULT NULL COMMENT '最后修改人MAC',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '最后修改时间',
  `update_time_db` timestamp NULL DEFAULT NULL COMMENT '最后修改时间-数据库默认写入时间',
  `client_versionno` varchar(40) DEFAULT NULL COMMENT '客户端程序的版本号',
  `company_id` bigint(20) DEFAULT NULL COMMENT '公司id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='类目聚合属性值';

-- ----------------------------
-- Table structure for category_tree_node_relation
-- ----------------------------
DROP TABLE IF EXISTS `category_tree_node_relation`;
CREATE TABLE `category_tree_node_relation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `left_tree_node_id` bigint(20) NOT NULL,
  `right_tree_node_id` bigint(20) NOT NULL,
  `sort_value` int(11) NOT NULL,
  `is_available` tinyint(2) DEFAULT '0' COMMENT '是否可用:默认0否;1是',
  `is_deleted`  tinyint(2) DEFAULT '0' COMMENT '是否逻辑删除:默认0未删除;1已删除',
  `version_no` int(11) DEFAULT '0' COMMENT '版本号:默认0,每次更新+1',
  `create_userid` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `create_username` varchar(100) DEFAULT NULL COMMENT '创建人姓名',
  `create_userip` varchar(60) DEFAULT NULL COMMENT '创建人IP',
  `create_usermac` varchar(60) DEFAULT NULL COMMENT '创建人MAC地址',
  `create_time` timestamp NULL DEFAULT NULL,
  `create_time_db` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间-数据库操作时间',
  `server_ip` varchar(60) DEFAULT NULL COMMENT '服务器IP',
  `update_userid` bigint(20) DEFAULT NULL COMMENT '最后修改人ID',
  `update_username` varchar(100) DEFAULT NULL COMMENT '最后修改人姓名',
  `update_userip` varchar(60) DEFAULT NULL COMMENT '最后修改人IP',
  `update_usermac` varchar(60) DEFAULT NULL COMMENT '最后修改人MAC',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '最后修改时间',
  `update_time_db` timestamp NULL DEFAULT NULL COMMENT '最后修改时间-数据库默认写入时间',
  `client_versionno` varchar(40) DEFAULT NULL COMMENT '客户端程序的版本号',
  `company_id` bigint(20) DEFAULT NULL COMMENT '公司id',
  `type` int(4) NOT NULL DEFAULT '1' COMMENT '属性聚合类型:1:全部聚合,2:部分聚合',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='类目节点聚合表';

-- ----------------------------
-- Table structure for merchant
-- ----------------------------
DROP TABLE IF EXISTS `merchant`;
CREATE TABLE `merchant` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `is_available` tinyint(2) DEFAULT NULL COMMENT '是否可用:默认0否;1是',
  `is_deleted`  tinyint(2) DEFAULT '0' COMMENT '是否逻辑删除:默认0未删除;1已删除',
  `version_no` int(11) DEFAULT '0' COMMENT '版本号:默认0,每次更新+1',
  `create_userid` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `create_username` varchar(100) DEFAULT NULL COMMENT '创建人姓名',
  `create_userip` varchar(60) DEFAULT NULL COMMENT '创建人IP',
  `create_usermac` varchar(60) DEFAULT NULL COMMENT '创建人MAC地址',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间-应用操作时间',
  `create_time_db` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间-数据库操作时间',
  `server_ip` varchar(60) DEFAULT NULL COMMENT '服务器IP',
  `update_userid` bigint(20) DEFAULT NULL COMMENT '最后修改人ID',
  `update_username` varchar(100) DEFAULT NULL COMMENT '最后修改人姓名',
  `update_userip` varchar(60) DEFAULT NULL COMMENT '最后修改人IP',
  `update_usermac` varchar(60) DEFAULT NULL COMMENT '最后修改人MAC',
  `update_time` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改时间',
  `update_time_db` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改时间-数据库默认写入时间',
  `client_versionno` varchar(40) DEFAULT NULL COMMENT '客户端程序的版本号',
  `company_id` bigint(20) DEFAULT NULL COMMENT '公司id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商家表';

-- ----------------------------
-- Table structure for merchant_att_name
-- ----------------------------
DROP TABLE IF EXISTS `merchant_att_name`;
CREATE TABLE `merchant_att_name` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '分组id:默认为 -1 未分组,0分组',
  `merchant_id` bigint(20) NOT NULL,
  `att_name_id` bigint(20) NOT NULL,
  `sort_value` int(11) NOT NULL DEFAULT '0',
  `is_available` tinyint(2) DEFAULT NULL COMMENT '是否可用:默认0否;1是',
  `is_deleted`  tinyint(2) DEFAULT '0' COMMENT '是否逻辑删除:默认0未删除;1已删除',
  `version_no` int(11) DEFAULT '0' COMMENT '版本号:默认0,每次更新+1',
  `create_userid` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `create_username` varchar(100) DEFAULT NULL COMMENT '创建人姓名',
  `create_userip` varchar(60) DEFAULT NULL COMMENT '创建人IP',
  `create_usermac` varchar(60) DEFAULT NULL COMMENT '创建人MAC地址',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间-应用操作时间',
  `create_time_db` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间-数据库操作时间',
  `server_ip` varchar(60) DEFAULT NULL COMMENT '服务器IP',
  `update_userid` bigint(20) DEFAULT NULL COMMENT '最后修改人ID',
  `update_username` varchar(100) DEFAULT NULL COMMENT '最后修改人姓名',
  `update_userip` varchar(60) DEFAULT NULL COMMENT '最后修改人IP',
  `update_usermac` varchar(60) DEFAULT NULL COMMENT '最后修改人MAC',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '最后修改时间',
  `update_time_db` timestamp NULL DEFAULT NULL COMMENT '最后修改时间-数据库默认写入时间',
  `client_versionno` varchar(40) DEFAULT NULL COMMENT '客户端程序的版本号',
  `company_id` bigint(20) DEFAULT NULL COMMENT '公司id',
  `uses` int(11) DEFAULT '1' COMMENT '用途:1:基本,2:系列,3:导购',
  `type` int(4) DEFAULT '1' COMMENT '用途:1:基本,2:系列,3:导购',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商家自有属性名';

-- ----------------------------
-- Table structure for merchant_att_value
-- ----------------------------
DROP TABLE IF EXISTS `merchant_att_value`;
CREATE TABLE `merchant_att_value` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `merchant_att_name_id` bigint(20) NOT NULL,
  `att_value_id` bigint(20) NOT NULL,
  `att_value_custom` varchar(255) DEFAULT NULL,
  `sort_value` int(11) NOT NULL DEFAULT '0',
  `is_available` tinyint(2) DEFAULT NULL COMMENT '是否可用:默认0否;1是',
  `is_deleted`  tinyint(2) DEFAULT '0' COMMENT '是否逻辑删除:默认0未删除;1已删除',
  `version_no` int(11) DEFAULT '0' COMMENT '版本号:默认0,每次更新+1',
  `create_userid` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `create_username` varchar(100) DEFAULT NULL COMMENT '创建人姓名',
  `create_userip` varchar(60) DEFAULT NULL COMMENT '创建人IP',
  `create_usermac` varchar(60) DEFAULT NULL COMMENT '创建人MAC地址',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间-应用操作时间',
  `create_time_db` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间-数据库操作时间',
  `server_ip` varchar(60) DEFAULT NULL COMMENT '服务器IP',
  `update_userid` bigint(20) DEFAULT NULL COMMENT '最后修改人ID',
  `update_username` varchar(100) DEFAULT NULL COMMENT '最后修改人姓名',
  `update_userip` varchar(60) DEFAULT NULL COMMENT '最后修改人IP',
  `update_usermac` varchar(60) DEFAULT NULL COMMENT '最后修改人MAC',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '最后修改时间',
  `update_time_db` timestamp NULL DEFAULT NULL COMMENT '最后修改时间-数据库默认写入时间',
  `client_versionno` varchar(40) DEFAULT NULL COMMENT '客户端程序的版本号',
  `company_id` bigint(20) DEFAULT NULL COMMENT '公司id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商家自有属性值';

-- ----------------------------
-- Table structure for merchant_brand
-- ----------------------------
DROP TABLE IF EXISTS `merchant_brand`;
CREATE TABLE `merchant_brand` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `merchant_id` bigint(20) NOT NULL,
  `brand_id` bigint(20) NOT NULL,
  `is_available` tinyint(2) DEFAULT NULL COMMENT '是否可用:默认0否;1是',
  `is_deleted`  tinyint(2) DEFAULT '0' COMMENT '是否逻辑删除:默认0未删除;1已删除',
  `version_no` int(11) DEFAULT '0' COMMENT '版本号:默认0,每次更新+1',
  `create_userid` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `create_username` varchar(100) DEFAULT NULL COMMENT '创建人姓名',
  `create_userip` varchar(60) DEFAULT NULL COMMENT '创建人IP',
  `create_usermac` varchar(60) DEFAULT NULL COMMENT '创建人MAC地址',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间-应用操作时间',
  `create_time_db` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间-数据库操作时间',
  `server_ip` varchar(60) DEFAULT NULL COMMENT '服务器IP',
  `update_userid` bigint(20) DEFAULT NULL COMMENT '最后修改人ID',
  `update_username` varchar(100) DEFAULT NULL COMMENT '最后修改人姓名',
  `update_userip` varchar(60) DEFAULT NULL COMMENT '最后修改人IP',
  `update_usermac` varchar(60) DEFAULT NULL COMMENT '最后修改人MAC',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '最后修改时间',
  `update_time_db` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后修改时间-数据库默认写入时间',
  `client_versionno` varchar(40) DEFAULT NULL COMMENT '客户端程序的版本号',
  `company_id` bigint(20) DEFAULT NULL COMMENT '公司id',
  `STATUS` int(11) DEFAULT '1' COMMENT '审核状态(1待审核、2审核通过、3审核不通过)',
  `proxy_level` int(11) DEFAULT '1' COMMENT '代理级别(1全国、2省、3市、4县、5镇、6村)',
  `remark` varchar(2000) DEFAULT NULL COMMENT '审核拒绝备注',
  `NAME` varchar(255) DEFAULT NULL COMMENT '品牌申请名称',
  `seniority_url` varchar(255) DEFAULT NULL COMMENT '资质图片url地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商家_品牌表';

-- ----------------------------
-- Table structure for merchant_cate_tree
-- ----------------------------
DROP TABLE IF EXISTS `merchant_cate_tree`;
CREATE TABLE `merchant_cate_tree` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `merchant_id` bigint(20) NOT NULL,
  `type` int(4) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `is_available` tinyint(2) DEFAULT NULL COMMENT '是否可用:默认0否;1是',
  `is_deleted`  tinyint(2) DEFAULT '0' COMMENT '是否逻辑删除:默认0未删除;1已删除',
  `version_no` int(11) DEFAULT '0' COMMENT '版本号:默认0,每次更新+1',
  `create_userid` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `create_username` varchar(100) DEFAULT NULL COMMENT '创建人姓名',
  `create_userip` varchar(60) DEFAULT NULL COMMENT '创建人IP',
  `create_usermac` varchar(60) DEFAULT NULL COMMENT '创建人MAC地址',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间-应用操作时间',
  `create_time_db` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间-数据库操作时间',
  `server_ip` varchar(60) DEFAULT NULL COMMENT '服务器IP',
  `update_userid` bigint(20) DEFAULT NULL COMMENT '最后修改人ID',
  `update_username` varchar(100) DEFAULT NULL COMMENT '最后修改人姓名',
  `update_userip` varchar(60) DEFAULT NULL COMMENT '最后修改人IP',
  `update_usermac` varchar(60) DEFAULT NULL COMMENT '最后修改人MAC',
  `update_time` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改时间',
  `update_time_db` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改时间-数据库默认写入时间',
  `client_versionno` varchar(40) DEFAULT NULL COMMENT '客户端程序的版本号',
  `company_id` bigint(20) DEFAULT NULL COMMENT '公司id',
  `description` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商家类目树表';

-- ----------------------------
-- Table structure for merchant_cate_tree_node
-- ----------------------------
DROP TABLE IF EXISTS `merchant_cate_tree_node`;
CREATE TABLE `merchant_cate_tree_node` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) NOT NULL,
  `merchant_cat_tree_id` bigint(20) NOT NULL,
  `category_id` bigint(20) NOT NULL,
  `is_visible` int(11) DEFAULT NULL COMMENT '是否可见: 0可见;1不可见',
  `is_available` tinyint(2) DEFAULT NULL COMMENT '是否可用:默认0否;1是',
  `is_deleted`  tinyint(2) DEFAULT '0' COMMENT '是否逻辑删除:默认0未删除;1已删除',
  `version_no` int(11) DEFAULT '0' COMMENT '版本号:默认0,每次更新+1',
  `create_userid` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `create_username` varchar(100) DEFAULT NULL COMMENT '创建人姓名',
  `create_userip` varchar(60) DEFAULT NULL COMMENT '创建人IP',
  `create_usermac` varchar(60) DEFAULT NULL COMMENT '创建人MAC地址',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间-应用操作时间',
  `create_time_db` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间-数据库操作时间',
  `server_ip` varchar(60) DEFAULT NULL COMMENT '服务器IP',
  `update_userid` bigint(20) DEFAULT NULL COMMENT '最后修改人ID',
  `update_username` varchar(100) DEFAULT NULL COMMENT '最后修改人姓名',
  `update_userip` varchar(60) DEFAULT NULL COMMENT '最后修改人IP',
  `update_usermac` varchar(60) DEFAULT NULL COMMENT '最后修改人MAC',
  `update_time` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改时间',
  `update_time_db` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改时间-数据库默认写入时间',
  `client_versionno` varchar(40) DEFAULT NULL COMMENT '客户端程序的版本号',
  `company_id` bigint(20) DEFAULT NULL COMMENT '公司id',
  `list_sort` int(11) DEFAULT '0' COMMENT '排序字段',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商家类目树节点表';

-- ----------------------------
-- Table structure for merchant_cate_tree_node_picture
-- ----------------------------
DROP TABLE IF EXISTS `merchant_cate_tree_node_picture`;
CREATE TABLE `merchant_cate_tree_node_picture` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `merchant_cate_tree_node_id` bigint(20) NOT NULL COMMENT '产品树节点表ID',
  `merchant_picture_id` bigint(20) NOT NULL COMMENT '图片表ID',
  `is_available` tinyint(2) DEFAULT NULL COMMENT '是否可用:默认0否;1是',
  `is_deleted`  tinyint(2) DEFAULT '0' COMMENT '是否逻辑删除:默认0未删除;1已删除',
  `version_no` int(11) DEFAULT '0' COMMENT '版本号:默认0,每次更新+1',
  `create_userid` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `create_username` varchar(100) DEFAULT NULL COMMENT '创建人姓名',
  `create_userip` varchar(60) DEFAULT NULL COMMENT '创建人IP',
  `create_usermac` varchar(60) DEFAULT NULL COMMENT '创建人MAC地址',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间-应用操作时间',
  `create_time_db` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间-数据库操作时间',
  `server_ip` varchar(60) DEFAULT NULL COMMENT '服务器IP',
  `update_userid` bigint(20) DEFAULT NULL COMMENT '最后修改人ID',
  `update_username` varchar(100) DEFAULT NULL COMMENT '最后修改人姓名',
  `update_userip` varchar(60) DEFAULT NULL COMMENT '最后修改人IP',
  `update_usermac` varchar(60) DEFAULT NULL COMMENT '最后修改人MAC',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '最后修改时间',
  `update_time_db` timestamp NULL DEFAULT NULL COMMENT '最后修改时间-数据库默认写入时间',
  `client_versionno` varchar(40) DEFAULT NULL COMMENT '客户端程序的版本号',
  `company_id` bigint(20) DEFAULT NULL COMMENT '公司id',
  PRIMARY KEY (`id`),
  KEY `idx_node_id` (`merchant_cate_tree_node_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品树节点图片表';

-- ----------------------------
-- Table structure for merchant_picture
-- ----------------------------
DROP TABLE IF EXISTS `merchant_picture`;
CREATE TABLE `merchant_picture` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `merchant_id` bigint(20) NOT NULL,
  `picture_id` bigint(20) NOT NULL,
  `sort_value` int(11) NOT NULL,
  `is_available` tinyint(2) DEFAULT NULL COMMENT '是否可用:默认0否;1是',
  `is_deleted`  tinyint(2) DEFAULT '0' COMMENT '是否逻辑删除:默认0未删除;1已删除',
  `version_no` int(11) DEFAULT '0' COMMENT '版本号:默认0,每次更新+1',
  `create_userid` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `create_username` varchar(100) DEFAULT NULL COMMENT '创建人姓名',
  `create_userip` varchar(60) DEFAULT NULL COMMENT '创建人IP',
  `create_usermac` varchar(60) DEFAULT NULL COMMENT '创建人MAC地址',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间-应用操作时间',
  `create_time_db` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间-数据库操作时间',
  `server_ip` varchar(60) DEFAULT NULL COMMENT '服务器IP',
  `update_userid` bigint(20) DEFAULT NULL COMMENT '最后修改人ID',
  `update_username` varchar(100) DEFAULT NULL COMMENT '最后修改人姓名',
  `update_userip` varchar(60) DEFAULT NULL COMMENT '最后修改人IP',
  `update_usermac` varchar(60) DEFAULT NULL COMMENT '最后修改人MAC',
  `update_time` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改时间',
  `update_time_db` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改时间-数据库默认写入时间',
  `client_versionno` varchar(40) DEFAULT NULL COMMENT '客户端程序的版本号',
  `company_id` bigint(20) DEFAULT NULL COMMENT '公司id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商家图片表';

-- ----------------------------
-- Table structure for merchant_prod_after_sale
-- ----------------------------
DROP TABLE IF EXISTS `merchant_prod_after_sale`;
CREATE TABLE `merchant_prod_after_sale` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `merchant_product_id` bigint(20) NOT NULL COMMENT '产品Id',
  `content` varchar(5000) DEFAULT NULL COMMENT '售后描述',
  `is_available` tinyint(2) DEFAULT NULL COMMENT '是否可用:默认0否;1是',
  `is_deleted`  tinyint(2) DEFAULT '0' COMMENT '是否逻辑删除:默认0未删除;1已删除',
  `version_no` int(11) DEFAULT '0' COMMENT '版本号:默认0,每次更新+1',
  `create_userid` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `create_username` varchar(100) DEFAULT NULL COMMENT '创建人姓名',
  `create_userip` varchar(60) DEFAULT NULL COMMENT '创建人IP',
  `create_usermac` varchar(60) DEFAULT NULL COMMENT '创建人MAC地址',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间-应用操作时间',
  `create_time_db` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间-数据库操作时间',
  `server_ip` varchar(60) DEFAULT NULL COMMENT '服务器IP',
  `update_userid` bigint(20) DEFAULT NULL COMMENT '最后修改人ID',
  `update_username` varchar(100) DEFAULT NULL COMMENT '最后修改人姓名',
  `update_userip` varchar(60) DEFAULT NULL COMMENT '最后修改人IP',
  `update_usermac` varchar(60) DEFAULT NULL COMMENT '最后修改人MAC',
  `update_time` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改时间',
  `update_time_db` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改时间-数据库默认写入时间',
  `client_versionno` varchar(40) DEFAULT NULL COMMENT '客户端程序的版本号',
  `company_id` bigint(20) DEFAULT NULL COMMENT '公司id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品售后表';

-- ----------------------------
-- Table structure for merchant_prod_att_name
-- ----------------------------
DROP TABLE IF EXISTS `merchant_prod_att_name`;
CREATE TABLE `merchant_prod_att_name` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) NOT NULL,
  `merchant_product_id` bigint(20) NOT NULL,
  `att_Name_id` bigint(20) NOT NULL,
  `sort_value` int(11) NOT NULL DEFAULT '0',
  `is_available` tinyint(2) DEFAULT NULL COMMENT '是否可用:默认0否;1是',
  `is_deleted`  tinyint(2) DEFAULT '0' COMMENT '是否逻辑删除:默认0未删除;1已删除',
  `version_no` int(11) DEFAULT '0' COMMENT '版本号:默认0,每次更新+1',
  `create_userid` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `create_username` varchar(100) DEFAULT NULL COMMENT '创建人姓名',
  `create_userip` varchar(60) DEFAULT NULL COMMENT '创建人IP',
  `create_usermac` varchar(60) DEFAULT NULL COMMENT '创建人MAC地址',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间-应用操作时间',
  `create_time_db` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间-数据库操作时间',
  `server_ip` varchar(60) DEFAULT NULL COMMENT '服务器IP',
  `update_userid` bigint(20) DEFAULT NULL COMMENT '最后修改人ID',
  `update_username` varchar(100) DEFAULT NULL COMMENT '最后修改人姓名',
  `update_userip` varchar(60) DEFAULT NULL COMMENT '最后修改人IP',
  `update_usermac` varchar(60) DEFAULT NULL COMMENT '最后修改人MAC',
  `update_time` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改时间',
  `update_time_db` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改时间-数据库默认写入时间',
  `client_versionno` varchar(40) DEFAULT NULL COMMENT '客户端程序的版本号',
  `company_id` bigint(20) DEFAULT NULL COMMENT '公司id',
  `type` int(4) DEFAULT '0',
  `source` int(11) DEFAULT '0' COMMENT '0:从产品复制(商品层面不可修改) 1:商品自有属性',
  PRIMARY KEY (`id`),
  KEY `company_id` (`company_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品属性名';

-- ----------------------------
-- Table structure for merchant_prod_att_value
-- ----------------------------
DROP TABLE IF EXISTS `merchant_prod_att_value`;
CREATE TABLE `merchant_prod_att_value` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `merchant_prod_att_name_id` bigint(20) NOT NULL,
  `att_value_id` bigint(20) NOT NULL,
  `att_value_Custom` varchar(255) DEFAULT NULL,
  `sort_value` int(11) NOT NULL DEFAULT '0',
  `is_available` tinyint(2) DEFAULT NULL COMMENT '是否可用:默认0否;1是',
  `is_deleted`  tinyint(2) DEFAULT '0' COMMENT '是否逻辑删除:默认0未删除;1已删除',
  `version_no` int(11) DEFAULT '0' COMMENT '版本号:默认0,每次更新+1',
  `create_userid` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `create_username` varchar(100) DEFAULT NULL COMMENT '创建人姓名',
  `create_userip` varchar(60) DEFAULT NULL COMMENT '创建人IP',
  `create_usermac` varchar(60) DEFAULT NULL COMMENT '创建人MAC地址',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间-应用操作时间',
  `create_time_db` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间-数据库操作时间',
  `server_ip` varchar(60) DEFAULT NULL COMMENT '服务器IP',
  `update_userid` bigint(20) DEFAULT NULL COMMENT '最后修改人ID',
  `update_username` varchar(100) DEFAULT NULL COMMENT '最后修改人姓名',
  `update_userip` varchar(60) DEFAULT NULL COMMENT '最后修改人IP',
  `update_usermac` varchar(60) DEFAULT NULL COMMENT '最后修改人MAC',
  `update_time` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改时间',
  `update_time_db` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改时间-数据库默认写入时间',
  `client_versionno` varchar(40) DEFAULT NULL COMMENT '客户端程序的版本号',
  `company_id` bigint(20) DEFAULT NULL COMMENT '公司id',
  PRIMARY KEY (`id`),
  KEY `company_id` (`company_id`) USING BTREE,
  KEY `merchant_prod_att_name_id` (`merchant_prod_att_name_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品属性值';

-- ----------------------------
-- Table structure for merchant_prod_describe
-- ----------------------------
DROP TABLE IF EXISTS `merchant_prod_describe`;
CREATE TABLE `merchant_prod_describe` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `merchant_product_id` bigint(20) NOT NULL,
  `content` text,
  `is_available` tinyint(2) DEFAULT NULL COMMENT '是否可用:默认0否;1是',
  `is_deleted`  tinyint(2) DEFAULT '0' COMMENT '是否逻辑删除:默认0未删除;1已删除',
  `version_no` int(11) DEFAULT '0' COMMENT '版本号:默认0,每次更新+1',
  `create_userid` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `create_username` varchar(100) DEFAULT NULL COMMENT '创建人姓名',
  `create_userip` varchar(60) DEFAULT NULL COMMENT '创建人IP',
  `create_usermac` varchar(60) DEFAULT NULL COMMENT '创建人MAC地址',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间-应用操作时间',
  `create_time_db` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间-数据库操作时间',
  `server_ip` varchar(60) DEFAULT NULL COMMENT '服务器IP',
  `update_userid` bigint(20) DEFAULT NULL COMMENT '最后修改人ID',
  `update_username` varchar(100) DEFAULT NULL COMMENT '最后修改人姓名',
  `update_userip` varchar(60) DEFAULT NULL COMMENT '最后修改人IP',
  `update_usermac` varchar(60) DEFAULT NULL COMMENT '最后修改人MAC',
  `update_time` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改时间',
  `update_time_db` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改时间-数据库默认写入时间',
  `client_versionno` varchar(40) DEFAULT NULL COMMENT '客户端程序的版本号',
  `company_id` bigint(20) DEFAULT NULL COMMENT '公司id',
  PRIMARY KEY (`id`),
  KEY `idx_merchant_product_id` (`merchant_product_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品文描表';

-- ----------------------------
-- Table structure for merchant_prod_flash
-- ----------------------------
DROP TABLE IF EXISTS `merchant_prod_flash`;
CREATE TABLE `merchant_prod_flash` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `merchant_product_id` bigint(20) NOT NULL,
  `is_group_flash` int(11) NOT NULL DEFAULT '0' COMMENT '0可以团闪、1否',
  `is_available` tinyint(2) DEFAULT NULL COMMENT '是否可用:默认0否;1是',
  `is_deleted`  tinyint(2) DEFAULT '0' COMMENT '是否逻辑删除:默认0未删除;1已删除',
  `version_no` int(11) DEFAULT '0' COMMENT '版本号:默认0,每次更新+1',
  `create_userid` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `create_username` varchar(100) DEFAULT NULL COMMENT '创建人姓名',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间-应用操作时间',
  `update_userid` bigint(20) DEFAULT NULL COMMENT '最后修改人ID',
  `update_username` varchar(100) DEFAULT NULL COMMENT '最后修改人姓名',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '最后修改时间',
  `company_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `company_id` (`company_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='团闪表';

-- ----------------------------
-- Table structure for merchant_prod_group
-- ----------------------------
DROP TABLE IF EXISTS `merchant_prod_group`;
CREATE TABLE `merchant_prod_group` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(100) NOT NULL COMMENT '组合CODE',
  `name` varchar(100) NOT NULL COMMENT '组合名称',
  `type` int(4) NOT NULL COMMENT '组合类型(1、子品总价百分比、3子品总价减、3绝对单价)',
  `scale` double(10,2) DEFAULT '0.00' COMMENT '组合比例',
  `status` int(11) DEFAULT '1' COMMENT '1上架、2下架',
  `merchant_id` bigint(20) NOT NULL COMMENT '商家id',
  `is_deleted`  tinyint(2) DEFAULT '0' COMMENT '是否逻辑删除:默认0未删除;1已删除',
  `version_no` int(11) DEFAULT '0' COMMENT '版本号:默认0,每次更新+1',
  `create_userid` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `create_username` varchar(100) DEFAULT NULL COMMENT '创建人姓名',
  `create_userip` varchar(60) DEFAULT NULL COMMENT '创建人IP',
  `create_usermac` varchar(60) DEFAULT NULL COMMENT '创建人MAC地址',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间-应用操作时间',
  `create_time_db` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间-数据库操作时间',
  `server_ip` varchar(60) DEFAULT NULL COMMENT '服务器IP',
  `update_userid` bigint(20) DEFAULT NULL COMMENT '最后修改人ID',
  `update_username` varchar(100) DEFAULT NULL COMMENT '最后修改人姓名',
  `update_userip` varchar(60) DEFAULT NULL COMMENT '最后修改人IP',
  `update_usermac` varchar(60) DEFAULT NULL COMMENT '最后修改人MAC',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后修改时间',
  `update_time_db` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后修改时间-数据库默认写入时间',
  `client_versionno` varchar(40) DEFAULT NULL COMMENT '客户端程序的版本号',
  `company_id` bigint(20) DEFAULT NULL COMMENT '公司id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品组合表';

-- ----------------------------
-- Table structure for merchant_prod_group_relation
-- ----------------------------
DROP TABLE IF EXISTS `merchant_prod_group_relation`;
CREATE TABLE `merchant_prod_group_relation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `merchant_prod_group_id` bigint(20) NOT NULL COMMENT '组合商品id',
  `merchant_prod_id` bigint(20) NOT NULL COMMENT '商品id',
  `merchant_id` bigint(20) NOT NULL COMMENT '商家id',
  `is_deleted`  tinyint(2) DEFAULT '0' COMMENT '是否逻辑删除:默认0未删除;1已删除',
  `version_no` int(11) DEFAULT '0' COMMENT '版本号:默认0,每次更新+1',
  `create_userid` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `create_username` varchar(100) DEFAULT NULL COMMENT '创建人姓名',
  `create_userip` varchar(60) DEFAULT NULL COMMENT '创建人IP',
  `create_usermac` varchar(60) DEFAULT NULL COMMENT '创建人MAC地址',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间-应用操作时间',
  `create_time_db` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间-数据库操作时间',
  `server_ip` varchar(60) DEFAULT NULL COMMENT '服务器IP',
  `update_userid` bigint(20) DEFAULT NULL COMMENT '最后修改人ID',
  `update_username` varchar(100) DEFAULT NULL COMMENT '最后修改人姓名',
  `update_userip` varchar(60) DEFAULT NULL COMMENT '最后修改人IP',
  `update_usermac` varchar(60) DEFAULT NULL COMMENT '最后修改人MAC',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后修改时间',
  `update_time_db` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后修改时间-数据库默认写入时间',
  `client_versionno` varchar(40) DEFAULT NULL COMMENT '客户端程序的版本号',
  `company_id` bigint(20) DEFAULT NULL COMMENT '公司id',
  `is_available` tinyint(2) DEFAULT NULL COMMENT '是否可用:默认0否;1是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品组合关联关系表';

-- ----------------------------
-- Table structure for merchant_prod_merchant_cate_tree_node
-- ----------------------------
DROP TABLE IF EXISTS `merchant_prod_merchant_cate_tree_node`;
CREATE TABLE `merchant_prod_merchant_cate_tree_node` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `merchant_cate_tree_node_id` bigint(20) NOT NULL COMMENT '商家类目树节点id',
  `merchant_product_id` bigint(20) NOT NULL COMMENT '商家商品id',
  `is_available` tinyint(2) DEFAULT NULL,
  `is_deleted`  tinyint(2) DEFAULT NULL,
  `verison_no` int(11) DEFAULT '0' COMMENT '版本号:默认0,每次更新+1',
  `create_userid` bigint(20) DEFAULT NULL,
  `create_username` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `create_userip` varchar(60) COLLATE utf8_unicode_ci DEFAULT NULL,
  `create_usermac` varchar(60) COLLATE utf8_unicode_ci DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `create_time_db` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `server_ip` varchar(60) COLLATE utf8_unicode_ci DEFAULT NULL,
  `update_userid` bigint(20) DEFAULT NULL,
  `update_username` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `update_userip` varchar(60) COLLATE utf8_unicode_ci DEFAULT NULL,
  `update_usermac` varchar(60) COLLATE utf8_unicode_ci DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  `update_time_db` timestamp NULL DEFAULT NULL,
  `company_id` bigint(20) DEFAULT NULL COMMENT '公司编号',
  `merchant_id` bigint(20) DEFAULT NULL COMMENT '商家编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='商家类目数节点';

-- ----------------------------
-- Table structure for merchant_prod_oversea
-- ----------------------------
DROP TABLE IF EXISTS `merchant_prod_oversea`;
CREATE TABLE `merchant_prod_oversea` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `merchant_product_id` bigint(20) DEFAULT NULL COMMENT '商品id',
  `mode` bigint(20) DEFAULT NULL COMMENT '海购模式',
  `record_no` varchar(64) DEFAULT NULL COMMENT '商品备案号',
  `tax_no` varchar(64) DEFAULT NULL COMMENT '商品税号',
  `mp_warehouse_code` varchar(64) DEFAULT NULL COMMENT '仓库商品编码',
  `supplier_id` bigint(20) DEFAULT NULL COMMENT '供应商id',
  `postal_articles_tax` decimal(12,6) DEFAULT NULL COMMENT '行邮税',
  `excise_tax` decimal(12,6) DEFAULT NULL COMMENT '消费税',
  `increment_tax` decimal(12,6) DEFAULT NULL COMMENT '增值税',
  `customs_duties` decimal(12,6) DEFAULT NULL COMMENT '关税',
  `declare_state` int(11) DEFAULT '0' COMMENT '备案状态:默认0待报关、1报关通过、2报关不通过',
  `is_available` tinyint(2) DEFAULT NULL COMMENT '是否可用:默认0否;1是',
  `is_deleted`  tinyint(2) DEFAULT '0' COMMENT '是否逻辑删除:默认0未删除;1已删除',
  `version_no` int(11) DEFAULT '0' COMMENT '版本号:默认0,每次更新+1',
  `create_userid` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `create_username` varchar(100) DEFAULT NULL COMMENT '创建人姓名',
  `create_userip` varchar(60) DEFAULT NULL COMMENT '创建人IP',
  `create_usermac` varchar(60) DEFAULT NULL COMMENT '创建人MAC地址',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间-应用操作时间',
  `create_time_db` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间-数据库操作时间',
  `server_ip` varchar(60) DEFAULT NULL COMMENT '服务器IP',
  `update_userid` bigint(20) DEFAULT NULL COMMENT '最后修改人ID',
  `update_username` varchar(100) DEFAULT NULL COMMENT '最后修改人姓名',
  `update_userip` varchar(60) DEFAULT NULL COMMENT '最后修改人IP',
  `update_usermac` varchar(60) DEFAULT NULL COMMENT '最后修改人MAC',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '最后修改时间',
  `update_time_db` timestamp NULL DEFAULT NULL COMMENT '最后修改时间-数据库默认写入时间',
  `client_versionno` varchar(40) DEFAULT NULL COMMENT '客户端程序的版本号',
  `company_id` bigint(20) DEFAULT NULL COMMENT '公司id',
  PRIMARY KEY (`id`),
  KEY `idx_mpid` (`merchant_product_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='海购商品表';

-- ----------------------------
-- Table structure for merchant_prod_picture
-- ----------------------------
DROP TABLE IF EXISTS `merchant_prod_picture`;
CREATE TABLE `merchant_prod_picture` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `merchant_prod_id` bigint(20) NOT NULL,
  `merchant_picture_id` bigint(20) NOT NULL,
  `is_available` tinyint(2) DEFAULT NULL COMMENT '是否可用:默认0否;1是',
  `is_deleted`  tinyint(2) DEFAULT '0' COMMENT '是否逻辑删除:默认0未删除;1已删除',
  `version_no` int(11) DEFAULT '0' COMMENT '版本号:默认0,每次更新+1',
  `create_userid` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `create_username` varchar(100) DEFAULT NULL COMMENT '创建人姓名',
  `create_userip` varchar(60) DEFAULT NULL COMMENT '创建人IP',
  `create_usermac` varchar(60) DEFAULT NULL COMMENT '创建人MAC地址',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间-应用操作时间',
  `create_time_db` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间-数据库操作时间',
  `server_ip` varchar(60) DEFAULT NULL COMMENT '服务器IP',
  `update_userid` bigint(20) DEFAULT NULL COMMENT '最后修改人ID',
  `update_username` varchar(100) DEFAULT NULL COMMENT '最后修改人姓名',
  `update_userip` varchar(60) DEFAULT NULL COMMENT '最后修改人IP',
  `update_usermac` varchar(60) DEFAULT NULL COMMENT '最后修改人MAC',
  `update_time` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改时间',
  `update_time_db` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改时间-数据库默认写入时间',
  `client_versionno` varchar(40) DEFAULT NULL COMMENT '客户端程序的版本号',
  `company_id` bigint(20) DEFAULT NULL COMMENT '公司id',
  `sort_value` int(11) DEFAULT '0',
  `type` int(4) DEFAULT '0' COMMENT '商品PDF:默认0其他;1主图;2附件下载',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商家商品图片表';

-- ----------------------------
-- Table structure for merchant_prod_sales_record
-- ----------------------------
DROP TABLE IF EXISTS `merchant_prod_sales_record`;
CREATE TABLE `merchant_prod_sales_record` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `sales_volume` bigint(20) DEFAULT NULL COMMENT '当月累计销售数量',
  `sales_date` varchar(10) DEFAULT NULL COMMENT '销售月分',
  `product_id` bigint(20) DEFAULT NULL COMMENT '产品id',
  `merchant_id` bigint(20) DEFAULT NULL COMMENT '商家id',
  `chinese_name` varchar(255) DEFAULT NULL COMMENT '商品中文名称',
  `english_name` varchar(255) DEFAULT NULL COMMENT '商品英文名称',
  `is_available` tinyint(2) DEFAULT NULL COMMENT '是否可用:默认0否;1是',
  `is_deleted`  tinyint(2) DEFAULT '0' COMMENT '是否逻辑删除:默认0未删除;1已删除',
  `version_no` int(11) DEFAULT '0' COMMENT '版本号:默认0,每次更新+1',
  `create_userid` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `create_username` varchar(100) DEFAULT NULL COMMENT '创建人姓名',
  `create_userip` varchar(60) DEFAULT NULL COMMENT '创建人IP',
  `create_usermac` varchar(60) DEFAULT NULL COMMENT '创建人MAC地址',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间-应用操作时间',
  `create_time_db` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间-数据库操作时间',
  `server_ip` varchar(60) DEFAULT NULL COMMENT '服务器IP',
  `update_userid` bigint(20) DEFAULT NULL COMMENT '最后修改人ID',
  `update_username` varchar(100) DEFAULT NULL COMMENT '最后修改人姓名',
  `update_userip` varchar(60) DEFAULT NULL COMMENT '最后修改人IP',
  `update_usermac` varchar(60) DEFAULT NULL COMMENT '最后修改人MAC',
  `update_time` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改时间',
  `update_time_db` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改时间-数据库默认写入时间',
  `client_versionno` varchar(40) DEFAULT NULL COMMENT '客户端程序的版本号',
  `company_id` bigint(20) DEFAULT NULL COMMENT '公司id',
  `merchat_product_id` bigint(20) DEFAULT NULL COMMENT '商品主键id',
  `merchant_prod_id` bigint(20) DEFAULT NULL COMMENT '商家产品id',
  `cumulative_sales_volume` int(11) DEFAULT '1' COMMENT '商品累计销售数量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品交易记录表';

-- ----------------------------
-- Table structure for merchant_prod_security
-- ----------------------------
DROP TABLE IF EXISTS `merchant_prod_security`;
CREATE TABLE `merchant_prod_security` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `company_id` bigint(20) DEFAULT NULL,
  `type` int(4) NOT NULL DEFAULT '0' COMMENT '保障类型',
  `security_date` int(11) DEFAULT '0' COMMENT '保障天数',
  `title` varchar(255) NOT NULL DEFAULT '' COMMENT '标题',
  `content` text COMMENT '富文本',
  `version_no` int(11) DEFAULT '0' COMMENT '版本号:默认0,每次更新+1',
  `create_userid` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `create_username` varchar(100) DEFAULT NULL COMMENT '创建人姓名',
  `create_userip` varchar(60) DEFAULT NULL COMMENT '创建人IP',
  `create_usermac` varchar(60) DEFAULT NULL COMMENT '创建人MAC地址',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间-应用操作时间',
  `create_time_db` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间-数据库操作时间',
  `server_ip` varchar(60) DEFAULT NULL COMMENT '服务器IP',
  `update_userid` bigint(20) DEFAULT NULL COMMENT '最后修改人ID',
  `update_username` varchar(100) DEFAULT NULL COMMENT '最后修改人姓名',
  `update_userip` varchar(60) DEFAULT NULL COMMENT '最后修改人IP',
  `update_usermac` varchar(60) DEFAULT NULL COMMENT '最后修改人MAC',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '最后修改时间',
  `update_time_db` timestamp NULL DEFAULT NULL COMMENT '最后修改时间-数据库默认写入时间',
  `client_versionno` varchar(40) DEFAULT NULL COMMENT '客户端程序的版本号',
  `is_deleted`  tinyint(2) DEFAULT '0' COMMENT '是否逻辑删除:默认0未删除;1已删除',
  `url` varchar(255) DEFAULT NULL COMMENT '保障图片url地址',
  `is_available` tinyint(2) DEFAULT NULL COMMENT '是否可用:默认0否;1是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品保障表';

-- ----------------------------
-- Table structure for merchant_prod_video
-- ----------------------------
DROP TABLE IF EXISTS `merchant_prod_video`;
CREATE TABLE `merchant_prod_video` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `merchant_prod_id` bigint(20) NOT NULL,
  `merchant_video_id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `video_pc_url` varchar(255) DEFAULT NULL,
  `pc_thumbnail_url` varchar(255) DEFAULT NULL,
  `mobile_hd_url` varchar(255) DEFAULT NULL,
  `mobile_hd_thumbnail_url` varchar(255) DEFAULT NULL,
  `mobile_ld_url` varchar(255) DEFAULT NULL,
  `mobile_ld_thumbnail_url` varchar(255) DEFAULT NULL,
  `version_no` int(11) DEFAULT '0' COMMENT '版本号:默认0,每次更新+1',
  `create_userid` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `create_username` varchar(100) DEFAULT NULL COMMENT '创建人姓名',
  `create_userip` varchar(60) DEFAULT NULL COMMENT '创建人IP',
  `create_usermac` varchar(60) DEFAULT NULL COMMENT '创建人MAC地址',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间-应用操作时间',
  `create_time_db` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间-数据库操作时间',
  `server_ip` varchar(60) DEFAULT NULL COMMENT '服务器IP',
  `update_userid` bigint(20) DEFAULT NULL COMMENT '最后修改人ID',
  `update_username` varchar(100) DEFAULT NULL COMMENT '最后修改人姓名',
  `update_userip` varchar(60) DEFAULT NULL COMMENT '最后修改人IP',
  `update_usermac` varchar(60) DEFAULT NULL COMMENT '最后修改人MAC',
  `update_time` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改时间',
  `update_time_db` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改时间-数据库默认写入时间',
  `client_versionno` varchar(40) DEFAULT NULL COMMENT '客户端程序的版本号',
  `company_id` bigint(20) DEFAULT NULL COMMENT '公司id',
  `thumbnail_url` varchar(255) DEFAULT NULL,
  `video_url` varchar(255) DEFAULT NULL,
  `is_available` tinyint(2) DEFAULT NULL COMMENT '是否可用:默认0否;1是',
  `is_deleted`  tinyint(2) DEFAULT '0' COMMENT '是否逻辑删除:默认0未删除;1已删除',
  PRIMARY KEY (`id`),
  KEY `company_id` (`company_id`) USING BTREE,
  KEY `merchant_prod_id` (`merchant_prod_id`) USING BTREE,
  KEY `merchant_video_id` (`merchant_video_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for merchant_product
-- ----------------------------
DROP TABLE IF EXISTS `merchant_product`;
CREATE TABLE `merchant_product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `merchant_id` bigint(20) NOT NULL,
  `product_id` bigint(20) NOT NULL,
  `merchant_cate_tree_node_id` bigint(20) NOT NULL,
  `merchant_series_id` bigint(20) DEFAULT NULL,
  `chinese_name` varchar(300) NOT NULL,
  `english_name` varchar(300) DEFAULT NULL,
  `is_visible` int(11) NOT NULL,
  `subtitle` varchar(255) DEFAULT '' COMMENT '副标题(商家自定义名称)',
  `warehouse_merchant_no` varchar(255) DEFAULT '' COMMENT '仓库商品编号(海关回写抓取)',
  `customs_merchant_record_no` varchar(255) DEFAULT NULL COMMENT '海关商品备案编号',
  `supplier_id` bigint(20) DEFAULT NULL COMMENT '供应商Id',
  `type` int(4) DEFAULT '1' COMMENT '商品类型(1普通商品、2生鲜产品、3卡券、4增值服务、5其他)',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `sale_price` decimal(12,3) DEFAULT '0.000' COMMENT '销售价格',
  `sale_tax_rate` double(10,2) DEFAULT '0.00' COMMENT '销售税率',
  `return_days` int(11) DEFAULT '0' COMMENT '包退天数',
  `replacement_days` int(11) DEFAULT '0' COMMENT '包换天数',
  `guarantee_days` int(11) DEFAULT '0' COMMENT '保修天数',
  `deliver_period` int(11) DEFAULT '0' COMMENT '预计发货周期',
  `is_vat_invoice` int(11) DEFAULT '0' COMMENT '是否可开增值税发票',
  `is_vip_card` int(11) DEFAULT '0' COMMENT '是否支持VIP',
  `is_enable_shelfLife` int(11) DEFAULT '0' COMMENT '是否启用保质期控制',
  `shelfLife_days` int(11) DEFAULT '0' COMMENT '保质期天数',
  `is_vendible` int(11) DEFAULT '0' COMMENT '是否可销售:默认0是;1否',
  `is_voice` int(11) DEFAULT NULL COMMENT '否强制发票0默认否;1是',
  `is_available` tinyint(2) DEFAULT NULL COMMENT '是否可用:默认0否;1是',
  `is_deleted`  tinyint(2) DEFAULT '0' COMMENT '是否逻辑删除:默认0未删除;1已删除',
  `version_no` int(11) DEFAULT '0' COMMENT '版本号:默认0,每次更新+1',
  `create_userid` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `create_username` varchar(100) DEFAULT NULL COMMENT '创建人姓名',
  `create_userip` varchar(60) DEFAULT NULL COMMENT '创建人IP',
  `create_usermac` varchar(60) DEFAULT NULL COMMENT '创建人MAC地址',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间-应用操作时间',
  `create_time_db` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间-数据库操作时间',
  `server_ip` varchar(60) DEFAULT NULL COMMENT '服务器IP',
  `update_userid` bigint(20) DEFAULT NULL COMMENT '最后修改人ID',
  `update_username` varchar(100) DEFAULT NULL COMMENT '最后修改人姓名',
  `update_userip` varchar(60) DEFAULT NULL COMMENT '最后修改人IP',
  `update_usermac` varchar(60) DEFAULT NULL COMMENT '最后修改人MAC',
  `update_time` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改时间',
  `update_time_db` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改时间-数据库默认写入时间',
  `client_versionno` varchar(40) DEFAULT NULL COMMENT '客户端程序的版本号',
  `company_id` bigint(20) DEFAULT NULL COMMENT '公司id',
  `gross_weight` double(10,3) DEFAULT '0.000' COMMENT '商品毛重',
  `net_weight` double(10,3) DEFAULT '0.000' COMMENT '商品净重',
  `code` varchar(50) DEFAULT NULL COMMENT '商品编码',
  `merchant_brand_id` bigint(20) NOT NULL COMMENT '商家品牌Id',
  `purchase_price` decimal(12,3) DEFAULT '0.000' COMMENT '商品买入价',
  `status` int(11) DEFAULT '0' COMMENT '审核状态:默认0预审核、 1待审核、 2审核通过、 3审核不通过、 4永久下架',
  `is_priture` int(11) DEFAULT NULL,
  `is_description` int(11) DEFAULT NULL,
  `freight_attribute` int(11) DEFAULT NULL COMMENT '1:重货;2：抛货',
  `tax_no` varchar(255) DEFAULT NULL COMMENT '商品税号',
  `merchant_prod_length` double(10,2) DEFAULT NULL COMMENT '长度',
  `merchant_prod_width` double(10,2) DEFAULT NULL COMMENT '宽度',
  `merchant_prod_height` double(10,2) DEFAULT NULL COMMENT '高度',
  `merchant_prod_volume` double(10,2) DEFAULT NULL COMMENT '体积',
  `box_specifications` varchar(255) DEFAULT NULL COMMENT '箱规(规格如长、宽、高)',
  `place_of_origin` varchar(255) DEFAULT '' COMMENT '产地(国)',
  `copy_type` int(11) DEFAULT '0' COMMENT '商品复制类型(0无、1继承产品、2商品复制、3直接添加)',
  `sale_type` int(11) DEFAULT '1' COMMENT '销售类型(1普通、2海购、3精品、4赠品)',
  `freight_template_id` bigint(20) DEFAULT NULL COMMENT '运费模板id',
  `third_merchant_product_code` varchar(50) DEFAULT NULL COMMENT '第三方商品编码',
  `mp_model` varchar(50) DEFAULT NULL COMMENT '商品型号',
  `oem_code` varchar(50) DEFAULT NULL COMMENT '原厂编码',
  `mp_source` int(11) DEFAULT NULL COMMENT '商品来源',
  `is_bargain` int(11) DEFAULT NULL COMMENT '是否可以议价：1 一口价  2可议价  3强制性议价',
  `is_rent` int(11) DEFAULT NULL COMMENT '是否可租赁 0不可以， 1 可以',
  `shortcut_purchase` int(1) DEFAULT '0' COMMENT '一键快捷购买 0:不支持  1:支持  2:强制一键购',
  `management_state` int(20) DEFAULT '0' COMMENT '默认0下架、1上架',
  `billing_type` int(1) DEFAULT NULL COMMENT '计费方式 0重量(默认) 1件  2体积',
  `is_sn` int(1) DEFAULT '0' COMMENT '是否序列号控制  0不受序列号控制，1受序列号控制，默认0',
  `ext_1` varchar(50) DEFAULT NULL COMMENT '业务扩展字段1',
  `ext_2` varchar(50) DEFAULT NULL COMMENT '业务扩展字段2',
  `ext_3` varchar(255) DEFAULT NULL COMMENT '业务扩展字段3',
  `ext_4` varchar(255) DEFAULT NULL COMMENT '业务扩展字段4',
  `ext_5` text COMMENT '通用字段',
  PRIMARY KEY (`id`),
  KEY `status` (`status`) USING BTREE,
  KEY `company_id` (`company_id`) USING BTREE,
  KEY `idx_product_id` (`product_id`) USING BTREE,
  KEY `idx_code` (`code`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品表';

-- ----------------------------
-- Table structure for merchant_product_articles_tax
-- ----------------------------
DROP TABLE IF EXISTS `merchant_product_articles_tax`;
CREATE TABLE `merchant_product_articles_tax` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tax_number` bigint(20) NOT NULL COMMENT '税号',
  `merchant_explain` varchar(255) DEFAULT '0.000' COMMENT '商品说明',
  `merchant_range` varchar(2000) NOT NULL DEFAULT '' COMMENT '商品范围',
  `tax_rale` double(10,2) NOT NULL DEFAULT '0.00' COMMENT '税率',
  `is_available` tinyint(2) DEFAULT NULL COMMENT '是否可用:默认0否;1是',
  `is_deleted`  tinyint(2) DEFAULT '0' COMMENT '是否逻辑删除:默认0未删除;1已删除',
  `version_no` int(11) DEFAULT '0' COMMENT '版本号:默认0,每次更新+1',
  `create_userid` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `create_username` varchar(100) DEFAULT NULL COMMENT '创建人姓名',
  `create_userip` varchar(60) DEFAULT NULL COMMENT '创建人IP',
  `create_usermac` varchar(60) DEFAULT NULL COMMENT '创建人MAC地址',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间-应用操作时间',
  `create_time_db` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间-数据库操作时间',
  `server_ip` varchar(60) DEFAULT NULL COMMENT '服务器IP',
  `update_userid` bigint(20) DEFAULT NULL COMMENT '最后修改人ID',
  `update_username` varchar(100) DEFAULT NULL COMMENT '最后修改人姓名',
  `update_userip` varchar(60) DEFAULT NULL COMMENT '最后修改人IP',
  `update_usermac` varchar(60) DEFAULT NULL COMMENT '最后修改人MAC',
  `update_time` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改时间',
  `update_time_db` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改时间-数据库默认写入时间',
  `client_versionno` varchar(40) DEFAULT NULL COMMENT '客户端程序的版本号',
  `company_id` bigint(20) DEFAULT NULL COMMENT '公司id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='行邮税';

-- ----------------------------
-- Table structure for merchant_product_sn
-- ----------------------------
DROP TABLE IF EXISTS `merchant_product_sn`;
CREATE TABLE `merchant_product_sn` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `merchant_product_id` bigint(20) NOT NULL COMMENT '商品id',
  `sn` varchar(50) NOT NULL COMMENT '序列号（捆包号）',
  `weight` double(10,3) DEFAULT NULL COMMENT '重量',
  `is_available` tinyint(2) DEFAULT NULL COMMENT '是否可用:默认0否;1是',
  `is_deleted`  tinyint(2) DEFAULT '0' COMMENT '是否逻辑删除:默认0未删除;1已删除',
  `version_no` int(11) DEFAULT '0' COMMENT '版本号:默认0,每次更新+1',
  `create_userid` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `create_username` varchar(100) DEFAULT NULL COMMENT '创建人姓名',
  `create_userip` varchar(60) DEFAULT NULL COMMENT '创建人IP',
  `create_usermac` varchar(60) DEFAULT NULL COMMENT '创建人MAC地址',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间-应用操作时间',
  `create_time_db` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间-数据库操作时间',
  `server_ip` varchar(60) DEFAULT NULL COMMENT '服务器IP',
  `update_userid` bigint(20) DEFAULT NULL COMMENT '最后修改人ID',
  `update_username` varchar(100) DEFAULT NULL COMMENT '最后修改人姓名',
  `update_userip` varchar(60) DEFAULT NULL COMMENT '最后修改人IP',
  `update_usermac` varchar(60) DEFAULT NULL COMMENT '最后修改人MAC',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '最后修改时间',
  `update_time_db` timestamp NULL DEFAULT NULL COMMENT '最后修改时间-数据库默认写入时间',
  `client_versionno` varchar(40) DEFAULT NULL COMMENT '客户端程序的版本号',
  `company_id` bigint(20) DEFAULT NULL COMMENT '公司id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='捆包号表';

-- ----------------------------
-- Table structure for merchant_security_relation
-- ----------------------------
DROP TABLE IF EXISTS `merchant_security_relation`;
CREATE TABLE `merchant_security_relation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `merchant_id` bigint(20) NOT NULL,
  `merchant_prod_id` bigint(20) NOT NULL,
  `compay_id` bigint(20) NOT NULL,
  `security_id` bigint(20) NOT NULL,
  `version_no` int(11) DEFAULT '0' COMMENT '版本号:默认0,每次更新+1',
  `create_userid` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `create_username` varchar(100) DEFAULT NULL COMMENT '创建人姓名',
  `create_userip` varchar(60) DEFAULT NULL COMMENT '创建人IP',
  `create_usermac` varchar(60) DEFAULT NULL COMMENT '创建人MAC地址',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间-应用操作时间',
  `create_time_db` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间-数据库操作时间',
  `server_ip` varchar(60) DEFAULT NULL COMMENT '服务器IP',
  `update_userid` bigint(20) DEFAULT NULL COMMENT '最后修改人ID',
  `update_username` varchar(100) DEFAULT NULL COMMENT '最后修改人姓名',
  `update_userip` varchar(60) DEFAULT NULL COMMENT '最后修改人IP',
  `update_usermac` varchar(60) DEFAULT NULL COMMENT '最后修改人MAC',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '最后修改时间',
  `update_time_db` timestamp NULL DEFAULT NULL COMMENT '最后修改时间-数据库默认写入时间',
  `client_versionno` varchar(40) DEFAULT NULL COMMENT '客户端程序的版本号',
  `is_deleted`  tinyint(2) DEFAULT '0' COMMENT '是否逻辑删除:默认0未删除;1已删除',
  `is_available` int(10) DEFAULT NULL COMMENT '是否可用:默认0否;1是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品保障关联表';

-- ----------------------------
-- Table structure for merchant_series
-- ----------------------------
DROP TABLE IF EXISTS `merchant_series`;
CREATE TABLE `merchant_series` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `merchant_id` bigint(20) NOT NULL COMMENT '商家Id',
  `main_merchant_product_id` bigint(20) NOT NULL COMMENT '主商品Id',
  `name` varchar(255) NOT NULL COMMENT '系列产品名称',
  `is_available` tinyint(2) DEFAULT NULL COMMENT '是否可用:默认0否;1是',
  `is_deleted`  tinyint(2) DEFAULT '0' COMMENT '是否逻辑删除:默认0未删除;1已删除',
  `version_no` int(11) DEFAULT '0' COMMENT '版本号:默认0,每次更新+1',
  `create_userid` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `create_username` varchar(100) DEFAULT NULL COMMENT '创建人姓名',
  `create_userip` varchar(60) DEFAULT NULL COMMENT '创建人IP',
  `create_usermac` varchar(60) DEFAULT NULL COMMENT '创建人MAC地址',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间-应用操作时间',
  `create_time_db` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间-数据库操作时间',
  `server_ip` varchar(60) DEFAULT NULL COMMENT '服务器IP',
  `update_userid` bigint(20) DEFAULT NULL COMMENT '最后修改人ID',
  `update_username` varchar(100) DEFAULT NULL COMMENT '最后修改人姓名',
  `update_userip` varchar(60) DEFAULT NULL COMMENT '最后修改人IP',
  `update_usermac` varchar(60) DEFAULT NULL COMMENT '最后修改人MAC',
  `update_time` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改时间',
  `update_time_db` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改时间-数据库默认写入时间',
  `client_versionno` varchar(40) DEFAULT NULL COMMENT '客户端程序的版本号',
  `company_id` bigint(20) DEFAULT NULL COMMENT '公司id',
  `code` varchar(50) DEFAULT NULL COMMENT '系列品编码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系列产品表';

-- ----------------------------
-- Table structure for merchant_series_product_att
-- ----------------------------
DROP TABLE IF EXISTS `merchant_series_product_att`;
CREATE TABLE `merchant_series_product_att` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `merchant_series_id` bigint(20) NOT NULL COMMENT '系列商品Id',
  `att_name_id` bigint(20) NOT NULL COMMENT '商品属性表Id',
  `is_available` tinyint(2) DEFAULT NULL COMMENT '是否可用:默认0否;1是',
  `is_deleted`  tinyint(2) DEFAULT '0' COMMENT '是否逻辑删除:默认0未删除;1已删除',
  `version_no` int(11) DEFAULT '0' COMMENT '版本号:默认0,每次更新+1',
  `create_userid` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `create_username` varchar(100) DEFAULT NULL COMMENT '创建人姓名',
  `create_userip` varchar(60) DEFAULT NULL COMMENT '创建人IP',
  `create_usermac` varchar(60) DEFAULT NULL COMMENT '创建人MAC地址',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间-应用操作时间',
  `create_time_db` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间-数据库操作时间',
  `server_ip` varchar(60) DEFAULT NULL COMMENT '服务器IP',
  `update_userid` bigint(20) DEFAULT NULL COMMENT '最后修改人ID',
  `update_username` varchar(100) DEFAULT NULL COMMENT '最后修改人姓名',
  `update_userip` varchar(60) DEFAULT NULL COMMENT '最后修改人IP',
  `update_usermac` varchar(60) DEFAULT NULL COMMENT '最后修改人MAC',
  `update_time` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改时间',
  `update_time_db` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改时间-数据库默认写入时间',
  `client_versionno` varchar(40) DEFAULT NULL COMMENT '客户端程序的版本号',
  `company_id` bigint(20) DEFAULT NULL COMMENT '公司id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品系列(系列、商品、属性)表';

-- ----------------------------
-- Table structure for merchant_video
-- ----------------------------
DROP TABLE IF EXISTS `merchant_video`;
CREATE TABLE `merchant_video` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `merchant_id` bigint(20) DEFAULT NULL,
  `video_id` bigint(20) DEFAULT NULL,
  `is_available` tinyint(2) DEFAULT NULL COMMENT '是否可用:默认0否;1是',
  `is_deleted`  tinyint(2) DEFAULT '0' COMMENT '是否逻辑删除:默认0未删除;1已删除',
  `version_no` int(11) DEFAULT '0' COMMENT '版本号:默认0,每次更新+1',
  `create_userid` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `create_username` varchar(100) DEFAULT NULL COMMENT '创建人姓名',
  `create_userip` varchar(60) DEFAULT NULL COMMENT '创建人IP',
  `create_usermac` varchar(60) DEFAULT NULL COMMENT '创建人MAC地址',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间-应用操作时间',
  `create_time_db` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间-数据库操作时间',
  `server_ip` varchar(60) DEFAULT NULL COMMENT '服务器IP',
  `update_userid` bigint(20) DEFAULT NULL COMMENT '最后修改人ID',
  `update_username` varchar(100) DEFAULT NULL COMMENT '最后修改人姓名',
  `update_userip` varchar(60) DEFAULT NULL COMMENT '最后修改人IP',
  `update_usermac` varchar(60) DEFAULT NULL COMMENT '最后修改人MAC',
  `update_time` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改时间',
  `update_time_db` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改时间-数据库默认写入时间',
  `client_versionno` varchar(40) DEFAULT NULL COMMENT '客户端程序的版本号',
  `company_id` bigint(20) DEFAULT NULL COMMENT '公司id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for oversea_custom
-- ----------------------------
DROP TABLE IF EXISTS `oversea_custom`;
CREATE TABLE `oversea_custom` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) DEFAULT NULL COMMENT '海关名称',
  `record_no` varchar(64) DEFAULT NULL COMMENT '平台海关备案号码',
  `record_name` varchar(64) DEFAULT NULL COMMENT '平台海关备案名称',
  `is_available` tinyint(2) DEFAULT NULL COMMENT '是否可用:默认0否;1是',
  `is_deleted`  tinyint(2) DEFAULT '0' COMMENT '是否逻辑删除:默认0未删除;1已删除',
  `version_no` int(11) DEFAULT '0' COMMENT '版本号:默认0,每次更新+1',
  `create_userid` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `create_username` varchar(100) DEFAULT NULL COMMENT '创建人姓名',
  `create_userip` varchar(60) DEFAULT NULL COMMENT '创建人IP',
  `create_usermac` varchar(60) DEFAULT NULL COMMENT '创建人MAC地址',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间-应用操作时间',
  `create_time_db` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间-数据库操作时间',
  `server_ip` varchar(60) DEFAULT NULL COMMENT '服务器IP',
  `update_userid` bigint(20) DEFAULT NULL COMMENT '最后修改人ID',
  `update_username` varchar(100) DEFAULT NULL COMMENT '最后修改人姓名',
  `update_userip` varchar(60) DEFAULT NULL COMMENT '最后修改人IP',
  `update_usermac` varchar(60) DEFAULT NULL COMMENT '最后修改人MAC',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '最后修改时间',
  `update_time_db` timestamp NULL DEFAULT NULL COMMENT '最后修改时间-数据库默认写入时间',
  `client_versionno` varchar(40) DEFAULT NULL COMMENT '客户端程序的版本号',
  `company_id` bigint(20) DEFAULT NULL COMMENT '公司id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='海关表';

-- ----------------------------
-- Table structure for oversea_purchase_mode
-- ----------------------------
DROP TABLE IF EXISTS `oversea_purchase_mode`;
CREATE TABLE `oversea_purchase_mode` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) DEFAULT NULL COMMENT '模式名称',
  `oversea_custom_id` bigint(20) DEFAULT NULL COMMENT '海关id，关联oversea_custom',
  `oversea_supplier_id` bigint(20) DEFAULT NULL COMMENT '服务商id， 关联oversea_supplier',
  `is_product_to_custom` int(11) DEFAULT '1' COMMENT '商品是否对接',
  `is_order_to_custom` int(11) DEFAULT '1' COMMENT '订单是否对接',
  `is_payment_to_custom` int(11) DEFAULT '1' COMMENT '支付是否对接',
  `is_logistics_to_custom` int(11) DEFAULT '1' COMMENT '物流是否对接',
  `is_pay_alone` int(11) DEFAULT '1' COMMENT '是否独立支付',
  `is_available` tinyint(2) DEFAULT NULL COMMENT '是否可用:默认0否;1是',
  `is_deleted`  tinyint(2) DEFAULT '0' COMMENT '是否逻辑删除:默认0未删除;1已删除',
  `version_no` int(11) DEFAULT '0' COMMENT '版本号:默认0,每次更新+1',
  `create_userid` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `create_username` varchar(100) DEFAULT NULL COMMENT '创建人姓名',
  `create_userip` varchar(60) DEFAULT NULL COMMENT '创建人IP',
  `create_usermac` varchar(60) DEFAULT NULL COMMENT '创建人MAC地址',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间-应用操作时间',
  `create_time_db` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间-数据库操作时间',
  `server_ip` varchar(60) DEFAULT NULL COMMENT '服务器IP',
  `update_userid` bigint(20) DEFAULT NULL COMMENT '最后修改人ID',
  `update_username` varchar(100) DEFAULT NULL COMMENT '最后修改人姓名',
  `update_userip` varchar(60) DEFAULT NULL COMMENT '最后修改人IP',
  `update_usermac` varchar(60) DEFAULT NULL COMMENT '最后修改人MAC',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '最后修改时间',
  `update_time_db` timestamp NULL DEFAULT NULL COMMENT '最后修改时间-数据库默认写入时间',
  `client_versionno` varchar(40) DEFAULT NULL COMMENT '客户端程序的版本号',
  `company_id` bigint(20) DEFAULT NULL COMMENT '公司id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='海购模式表';

-- ----------------------------
-- Table structure for oversea_supplier
-- ----------------------------
DROP TABLE IF EXISTS `oversea_supplier`;
CREATE TABLE `oversea_supplier` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) DEFAULT NULL COMMENT '服务商名称',
  `out_no` varchar(64) DEFAULT NULL COMMENT '平台接入代码',
  `out_name` varchar(64) DEFAULT NULL COMMENT '平台接入名称',
  `is_available` tinyint(2) DEFAULT NULL COMMENT '是否可用:默认0否;1是',
  `is_deleted`  tinyint(2) DEFAULT '0' COMMENT '是否逻辑删除:默认0未删除;1已删除',
  `version_no` int(11) DEFAULT '0' COMMENT '版本号:默认0,每次更新+1',
  `create_userid` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `create_username` varchar(100) DEFAULT NULL COMMENT '创建人姓名',
  `create_userip` varchar(60) DEFAULT NULL COMMENT '创建人IP',
  `create_usermac` varchar(60) DEFAULT NULL COMMENT '创建人MAC地址',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间-应用操作时间',
  `create_time_db` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间-数据库操作时间',
  `server_ip` varchar(60) DEFAULT NULL COMMENT '服务器IP',
  `update_userid` bigint(20) DEFAULT NULL COMMENT '最后修改人ID',
  `update_username` varchar(100) DEFAULT NULL COMMENT '最后修改人姓名',
  `update_userip` varchar(60) DEFAULT NULL COMMENT '最后修改人IP',
  `update_usermac` varchar(60) DEFAULT NULL COMMENT '最后修改人MAC',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '最后修改时间',
  `update_time_db` timestamp NULL DEFAULT NULL COMMENT '最后修改时间-数据库默认写入时间',
  `client_versionno` varchar(40) DEFAULT NULL COMMENT '客户端程序的版本号',
  `company_id` bigint(20) DEFAULT NULL COMMENT '公司id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='海购模式表';

-- ----------------------------
-- Table structure for page
-- ----------------------------
DROP TABLE IF EXISTS `page`;
CREATE TABLE `page` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type` int(4) NOT NULL,
  `name` varchar(255) NOT NULL,
  `is_available` tinyint(2) DEFAULT '0' COMMENT '是否可用:默认0否;1是',
  `is_deleted`  tinyint(2) DEFAULT '0' COMMENT '是否逻辑删除:默认0未删除;1已删除',
  `version_no` int(11) DEFAULT '0' COMMENT '版本号:默认0,每次更新+1',
  `create_userid` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `create_username` varchar(100) DEFAULT NULL COMMENT '创建人姓名',
  `create_userip` varchar(60) DEFAULT NULL COMMENT '创建人IP',
  `create_usermac` varchar(60) DEFAULT NULL COMMENT '创建人MAC地址',
  `create_time` timestamp NULL DEFAULT NULL,
  `create_time_db` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间-数据库操作时间',
  `server_ip` varchar(60) DEFAULT NULL COMMENT '服务器IP',
  `update_userid` bigint(20) DEFAULT NULL COMMENT '最后修改人ID',
  `update_username` varchar(100) DEFAULT NULL COMMENT '最后修改人姓名',
  `update_userip` varchar(60) DEFAULT NULL COMMENT '最后修改人IP',
  `update_usermac` varchar(60) DEFAULT NULL COMMENT '最后修改人MAC',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '最后修改时间',
  `update_time_db` timestamp NULL DEFAULT NULL COMMENT '最后修改时间-数据库默认写入时间',
  `client_versionno` varchar(40) DEFAULT NULL COMMENT '客户端程序的版本号',
  `company_id` bigint(20) DEFAULT NULL COMMENT '公司id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='页面信息表';

-- ----------------------------
-- Table structure for page_category_tree
-- ----------------------------
DROP TABLE IF EXISTS `page_category_tree`;
CREATE TABLE `page_category_tree` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `page_id` bigint(20) NOT NULL,
  `category_tree_id` bigint(20) NOT NULL,
  `is_available` tinyint(2) DEFAULT '0' COMMENT '是否可用:默认0否;1是',
  `is_deleted`  tinyint(2) DEFAULT '0' COMMENT '是否逻辑删除:默认0未删除;1已删除',
  `version_no` int(11) DEFAULT '0' COMMENT '版本号:默认0,每次更新+1',
  `create_userid` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `create_username` varchar(100) DEFAULT NULL COMMENT '创建人姓名',
  `create_userip` varchar(60) DEFAULT NULL COMMENT '创建人IP',
  `create_usermac` varchar(60) DEFAULT NULL COMMENT '创建人MAC地址',
  `create_time` timestamp NULL DEFAULT NULL,
  `create_time_db` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间-数据库操作时间',
  `server_ip` varchar(60) DEFAULT NULL COMMENT '服务器IP',
  `update_userid` bigint(20) DEFAULT NULL COMMENT '最后修改人ID',
  `update_username` varchar(100) DEFAULT NULL COMMENT '最后修改人姓名',
  `update_userip` varchar(60) DEFAULT NULL COMMENT '最后修改人IP',
  `update_usermac` varchar(60) DEFAULT NULL COMMENT '最后修改人MAC',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '最后修改时间',
  `update_time_db` timestamp NULL DEFAULT NULL COMMENT '最后修改时间-数据库默认写入时间',
  `client_versionno` varchar(40) DEFAULT NULL COMMENT '客户端程序的版本号',
  `company_id` bigint(20) DEFAULT NULL COMMENT '公司id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='页面树关联表';

-- ----------------------------
-- Table structure for picture
-- ----------------------------
DROP TABLE IF EXISTS `picture`;
CREATE TABLE `picture` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `is_available` tinyint(2) DEFAULT NULL COMMENT '是否可用:默认0否;1是',
  `is_deleted`  tinyint(2) DEFAULT '0' COMMENT '是否逻辑删除:默认0未删除;1已删除',
  `version_no` int(11) DEFAULT '0' COMMENT '版本号:默认0,每次更新+1',
  `create_userid` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `create_username` varchar(100) DEFAULT NULL COMMENT '创建人姓名',
  `create_userip` varchar(60) DEFAULT NULL COMMENT '创建人IP',
  `create_usermac` varchar(60) DEFAULT NULL COMMENT '创建人MAC地址',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间-应用操作时间',
  `create_time_db` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间-数据库操作时间',
  `server_ip` varchar(60) DEFAULT NULL COMMENT '服务器IP',
  `update_userid` bigint(20) DEFAULT NULL COMMENT '最后修改人ID',
  `update_username` varchar(100) DEFAULT NULL COMMENT '最后修改人姓名',
  `update_userip` varchar(60) DEFAULT NULL COMMENT '最后修改人IP',
  `update_usermac` varchar(60) DEFAULT NULL COMMENT '最后修改人MAC',
  `update_time` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改时间',
  `update_time_db` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改时间-数据库默认写入时间',
  `client_versionno` varchar(40) DEFAULT NULL COMMENT '客户端程序的版本号',
  `company_id` bigint(20) DEFAULT NULL COMMENT '公司id',
  `sort_value` int(11) NOT NULL DEFAULT '0' COMMENT '排序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='图片表';

-- ----------------------------
-- Table structure for prod_brand_relation
-- ----------------------------
DROP TABLE IF EXISTS `prod_brand_relation`;
CREATE TABLE `prod_brand_relation` (
  `id` bigint(12) NOT NULL AUTO_INCREMENT,
  `old_brand_id` bigint(20) DEFAULT NULL,
  `new_brand_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for prod_detail_image
-- ----------------------------
DROP TABLE IF EXISTS `prod_detail_image`;
CREATE TABLE `prod_detail_image` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `image_url` varchar(500) DEFAULT NULL,
  `create_at` datetime DEFAULT NULL,
  `update_at` datetime DEFAULT NULL,
  `status` smallint(6) DEFAULT NULL,
  `product_id` bigint(12) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `brand_id` bigint(20) DEFAULT NULL,
  `category_tree_node_id` bigint(20) NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `english_name` varchar(255) DEFAULT NULL,
  `chinese_name` varchar(255) NOT NULL,
  `tax_no` varchar(255) DEFAULT '' COMMENT '税号(海购商品必须有税号,普通商品无)',
  `ean_no` varchar(100) DEFAULT '' COMMENT 'EAN(商品条形码)',
  `place_of_origin` varchar(255) DEFAULT '' COMMENT '产地',
  `product_length` double(10,2) DEFAULT '0.00' COMMENT '商品长度',
  `product_width` double(10,2) DEFAULT '0.00' COMMENT '商品宽度',
  `product_weight` double(10,2) DEFAULT '0.00' COMMENT '商品高度',
  `product_volume` double(10,2) DEFAULT '0.00' COMMENT '商品体积',
  `product_material` varchar(20) DEFAULT NULL COMMENT '产品材质',
  `box_specifications` varchar(255) DEFAULT '' COMMENT '箱规(规格如长、宽、高)',
  `calculation_unit` varchar(255) DEFAULT '' COMMENT '计量单位',
  `is_available` tinyint(2) DEFAULT NULL COMMENT '是否可用:默认0否;1是',
  `is_deleted`  tinyint(2) DEFAULT '0' COMMENT '是否逻辑删除:默认0未删除;1已删除',
  `version_no` int(11) DEFAULT '0' COMMENT '版本号:默认0,每次更新+1',
  `create_userid` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `create_username` varchar(100) DEFAULT NULL COMMENT '创建人姓名',
  `create_userip` varchar(60) DEFAULT NULL COMMENT '创建人IP',
  `create_usermac` varchar(60) DEFAULT NULL COMMENT '创建人MAC地址',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间-应用操作时间',
  `create_time_db` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间-数据库操作时间',
  `server_ip` varchar(60) DEFAULT NULL COMMENT '服务器IP',
  `update_userid` bigint(20) DEFAULT NULL COMMENT '最后修改人ID',
  `update_username` varchar(100) DEFAULT NULL COMMENT '最后修改人姓名',
  `update_userip` varchar(60) DEFAULT NULL COMMENT '最后修改人IP',
  `update_usermac` varchar(60) DEFAULT NULL COMMENT '最后修改人MAC',
  `update_time` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改时间',
  `update_time_db` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改时间-数据库默认写入时间',
  `client_versionno` varchar(40) DEFAULT NULL COMMENT '客户端程序的版本号',
  `company_id` bigint(20) DEFAULT NULL COMMENT '公司id',
  `STATUS` int(11) DEFAULT '0' COMMENT '审核状态:默认0预审核、 1待审核、 2审核通过、 3审核不通过',
  `reason` varchar(255) DEFAULT NULL COMMENT '审核未通过原因',
  `CODE` varchar(100) DEFAULT NULL COMMENT '产品编码',
  `weight` double(10,3) DEFAULT NULL COMMENT '产品净重',
  `type` int(4) DEFAULT NULL COMMENT '产品类型',
  `weight_name` varchar(50) DEFAULT NULL COMMENT '重量单位名称',
  `weight_value` varchar(50) DEFAULT NULL COMMENT '重量值',
  `model_name` varchar(50) DEFAULT NULL COMMENT '规格单位名称',
  `model_value` varchar(50) DEFAULT NULL COMMENT '规格值',
  `model_type` int(11) DEFAULT '0',
  `standard` varchar(50) DEFAULT NULL COMMENT '产品规格',
  `source_type` int(11) NOT NULL DEFAULT '1' COMMENT '产品来源类型  1:平台添加（默认）   2:商家添加',
  PRIMARY KEY (`id`),
  KEY `idx_ean_no` (`ean_no`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='产品表';

-- ----------------------------
-- Table structure for product_att_name
-- ----------------------------
DROP TABLE IF EXISTS `product_att_name`;
CREATE TABLE `product_att_name` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) NOT NULL,
  `product_id` bigint(20) NOT NULL,
  `att_name_id` bigint(20) NOT NULL,
  `sort_value` int(11) NOT NULL DEFAULT '0',
  `is_available` tinyint(2) DEFAULT NULL COMMENT '是否可用:默认0否;1是',
  `is_deleted`  tinyint(2) DEFAULT '0' COMMENT '是否逻辑删除:默认0未删除;1已删除',
  `version_no` int(11) DEFAULT '0' COMMENT '版本号:默认0,每次更新+1',
  `create_userid` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `create_username` varchar(100) DEFAULT NULL COMMENT '创建人姓名',
  `create_userip` varchar(60) DEFAULT NULL COMMENT '创建人IP',
  `create_usermac` varchar(60) DEFAULT NULL COMMENT '创建人MAC地址',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间-应用操作时间',
  `create_time_db` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间-数据库操作时间',
  `server_ip` varchar(60) DEFAULT NULL COMMENT '服务器IP',
  `update_userid` bigint(20) DEFAULT NULL COMMENT '最后修改人ID',
  `update_username` varchar(100) DEFAULT NULL COMMENT '最后修改人姓名',
  `update_userip` varchar(60) DEFAULT NULL COMMENT '最后修改人IP',
  `update_usermac` varchar(60) DEFAULT NULL COMMENT '最后修改人MAC',
  `update_time` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改时间',
  `update_time_db` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改时间-数据库默认写入时间',
  `client_versionno` varchar(40) DEFAULT NULL COMMENT '客户端程序的版本号',
  `company_id` bigint(20) DEFAULT NULL COMMENT '公司id',
  `type` int(4) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `idx_product_id` (`product_id`) USING BTREE,
  KEY `idx_att_name_id_att` (`att_name_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='产品属性名表';

-- ----------------------------
-- Table structure for product_att_value
-- ----------------------------
DROP TABLE IF EXISTS `product_att_value`;
CREATE TABLE `product_att_value` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_att_name_id` bigint(20) NOT NULL,
  `att_value_id` bigint(20) NOT NULL,
  `att_value_custom` varchar(255) DEFAULT NULL,
  `sort_value` int(11) NOT NULL DEFAULT '0',
  `is_available` tinyint(2) DEFAULT NULL COMMENT '是否可用:默认0否;1是',
  `is_deleted`  tinyint(2) DEFAULT '0' COMMENT '是否逻辑删除:默认0未删除;1已删除',
  `version_no` int(11) DEFAULT '0' COMMENT '版本号:默认0,每次更新+1',
  `create_userid` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `create_username` varchar(100) DEFAULT NULL COMMENT '创建人姓名',
  `create_userip` varchar(60) DEFAULT NULL COMMENT '创建人IP',
  `create_usermac` varchar(60) DEFAULT NULL COMMENT '创建人MAC地址',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间-应用操作时间',
  `create_time_db` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间-数据库操作时间',
  `server_ip` varchar(60) DEFAULT NULL COMMENT '服务器IP',
  `update_userid` bigint(20) DEFAULT NULL COMMENT '最后修改人ID',
  `update_username` varchar(100) DEFAULT NULL COMMENT '最后修改人姓名',
  `update_userip` varchar(60) DEFAULT NULL COMMENT '最后修改人IP',
  `update_usermac` varchar(60) DEFAULT NULL COMMENT '最后修改人MAC',
  `update_time` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改时间',
  `update_time_db` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改时间-数据库默认写入时间',
  `client_versionno` varchar(40) DEFAULT NULL COMMENT '客户端程序的版本号',
  `company_id` bigint(20) DEFAULT NULL COMMENT '公司id',
  PRIMARY KEY (`id`),
  KEY `idx_product_att_name_id` (`product_att_name_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='产品属性值表';

-- ----------------------------
-- Table structure for product_calculation_unit
-- ----------------------------
DROP TABLE IF EXISTS `product_calculation_unit`;
CREATE TABLE `product_calculation_unit` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '唯一主键：计量单位ID',
  `calculation_unit_name` varchar(255) NOT NULL COMMENT '计量单位名称',
  `calculation_unit_code` varchar(255) NOT NULL COMMENT '计量单位编码',
  `is_sys_create` int(1) NOT NULL DEFAULT '1' COMMENT '是否为系统内置 0：否  1：是',
  `is_available` tinyint(2) DEFAULT NULL COMMENT '是否可用:默认0否;1是',
  `is_deleted`  tinyint(2) DEFAULT '0' COMMENT '是否逻辑删除:默认0未删除;1已删除',
  `version_no` int(11) DEFAULT '0' COMMENT '版本号:默认0,每次更新+1',
  `create_userid` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `create_username` varchar(100) DEFAULT NULL COMMENT '创建人姓名',
  `create_userip` varchar(60) DEFAULT NULL COMMENT '创建人IP',
  `create_usermac` varchar(60) DEFAULT NULL COMMENT '创建人MAC地址',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间-应用操作时间',
  `create_time_db` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间-数据库操作时间',
  `server_ip` varchar(60) DEFAULT NULL COMMENT '服务器IP',
  `update_userid` bigint(20) DEFAULT NULL COMMENT '最后修改人ID',
  `update_username` varchar(100) DEFAULT NULL COMMENT '最后修改人姓名',
  `update_userip` varchar(60) DEFAULT NULL COMMENT '最后修改人IP',
  `update_usermac` varchar(60) DEFAULT NULL COMMENT '最后修改人MAC',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '最后修改时间',
  `update_time_db` timestamp NULL DEFAULT NULL COMMENT '最后修改时间-数据库默认写入时间',
  `client_versionno` varchar(40) DEFAULT NULL COMMENT '客户端程序的版本号',
  `company_id` bigint(20) DEFAULT NULL COMMENT '公司id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='产品计量单位表';

-- ----------------------------
-- Table structure for product_cate_tree_node
-- ----------------------------
DROP TABLE IF EXISTS `product_cate_tree_node`;
CREATE TABLE `product_cate_tree_node` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `product_id` bigint(20) NOT NULL,
  `cate_tree_node_id` bigint(20) NOT NULL,
  `sort_value` int(11) NOT NULL,
  `is_available` tinyint(2) DEFAULT '0' COMMENT '是否可用:默认0否;1是',
  `is_deleted`  tinyint(2) DEFAULT '0' COMMENT '是否逻辑删除:默认0未删除;1已删除',
  `version_no` int(11) DEFAULT '0' COMMENT '版本号:默认0,每次更新+1',
  `create_userid` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `create_username` varchar(100) DEFAULT NULL COMMENT '创建人姓名',
  `create_userip` varchar(60) DEFAULT NULL COMMENT '创建人IP',
  `create_usermac` varchar(60) DEFAULT NULL COMMENT '创建人MAC地址',
  `create_time` timestamp NULL DEFAULT NULL,
  `create_time_db` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间-数据库操作时间',
  `server_ip` varchar(60) DEFAULT NULL COMMENT '服务器IP',
  `update_userid` bigint(20) DEFAULT NULL COMMENT '最后修改人ID',
  `update_username` varchar(100) DEFAULT NULL COMMENT '最后修改人姓名',
  `update_userip` varchar(60) DEFAULT NULL COMMENT '最后修改人IP',
  `update_usermac` varchar(60) DEFAULT NULL COMMENT '最后修改人MAC',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '最后修改时间',
  `update_time_db` timestamp NULL DEFAULT NULL COMMENT '最后修改时间-数据库默认写入时间',
  `client_versionno` varchar(40) DEFAULT NULL COMMENT '客户端程序的版本号',
  `company_id` bigint(20) DEFAULT NULL COMMENT '公司id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品类目节点关联表(前台聚合)';

-- ----------------------------
-- Table structure for product_description
-- ----------------------------
DROP TABLE IF EXISTS `product_description`;
CREATE TABLE `product_description` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_id` bigint(20) NOT NULL COMMENT '产品Id',
  `content` text NOT NULL COMMENT '产品描述',
  `is_available` tinyint(2) DEFAULT NULL COMMENT '是否可用:默认0否;1是',
  `is_deleted`  tinyint(2) DEFAULT '0' COMMENT '是否逻辑删除:默认0未删除;1已删除',
  `version_no` int(11) DEFAULT '0' COMMENT '版本号:默认0,每次更新+1',
  `create_userid` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `create_username` varchar(100) DEFAULT NULL COMMENT '创建人姓名',
  `create_userip` varchar(60) DEFAULT NULL COMMENT '创建人IP',
  `create_usermac` varchar(60) DEFAULT NULL COMMENT '创建人MAC地址',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间-应用操作时间',
  `create_time_db` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间-数据库操作时间',
  `server_ip` varchar(60) DEFAULT NULL COMMENT '服务器IP',
  `update_userid` bigint(20) DEFAULT NULL COMMENT '最后修改人ID',
  `update_username` varchar(100) DEFAULT NULL COMMENT '最后修改人姓名',
  `update_userip` varchar(60) DEFAULT NULL COMMENT '最后修改人IP',
  `update_usermac` varchar(60) DEFAULT NULL COMMENT '最后修改人MAC',
  `update_time` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改时间',
  `update_time_db` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改时间-数据库默认写入时间',
  `client_versionno` varchar(40) DEFAULT NULL COMMENT '客户端程序的版本号',
  `company_id` bigint(20) DEFAULT NULL COMMENT '公司id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='产品描述表';

-- ----------------------------
-- Table structure for product_description_copy
-- ----------------------------
DROP TABLE IF EXISTS `product_description_copy`;
CREATE TABLE `product_description_copy` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_id` bigint(20) NOT NULL COMMENT '产品Id',
  `content` varchar(5000) NOT NULL COMMENT '产品描述',
  `is_available` tinyint(2) DEFAULT NULL COMMENT '是否可用:默认0否;1是',
  `is_deleted`  tinyint(2) DEFAULT '0' COMMENT '是否逻辑删除:默认0未删除;1已删除',
  `version_no` int(11) DEFAULT '0' COMMENT '版本号:默认0,每次更新+1',
  `create_userid` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `create_username` varchar(100) DEFAULT NULL COMMENT '创建人姓名',
  `create_userip` varchar(60) DEFAULT NULL COMMENT '创建人IP',
  `create_usermac` varchar(60) DEFAULT NULL COMMENT '创建人MAC地址',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间-应用操作时间',
  `create_time_db` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间-数据库操作时间',
  `server_ip` varchar(60) DEFAULT NULL COMMENT '服务器IP',
  `update_userid` bigint(20) DEFAULT NULL COMMENT '最后修改人ID',
  `update_username` varchar(100) DEFAULT NULL COMMENT '最后修改人姓名',
  `update_userip` varchar(60) DEFAULT NULL COMMENT '最后修改人IP',
  `update_usermac` varchar(60) DEFAULT NULL COMMENT '最后修改人MAC',
  `update_time` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改时间',
  `update_time_db` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改时间-数据库默认写入时间',
  `client_versionno` varchar(40) DEFAULT NULL COMMENT '客户端程序的版本号',
  `company_id` bigint(20) DEFAULT NULL COMMENT '公司id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品描述表';

-- ----------------------------
-- Table structure for product_picture
-- ----------------------------
DROP TABLE IF EXISTS `product_picture`;
CREATE TABLE `product_picture` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_id` bigint(20) NOT NULL COMMENT '产品Id',
  `picture_id` bigint(20) NOT NULL COMMENT '图片表ID',
  `type` int(4) DEFAULT '0' COMMENT '商品PDF:默认0其他;1主图;2附件下载',
  `sort_value` int(11) NOT NULL DEFAULT '0' COMMENT '排序号',
  `is_available` tinyint(2) DEFAULT NULL COMMENT '是否可用:默认0否;1是',
  `is_deleted`  tinyint(2) DEFAULT '0' COMMENT '是否逻辑删除:默认0未删除;1已删除',
  `version_no` int(11) DEFAULT '0' COMMENT '版本号:默认0,每次更新+1',
  `create_userid` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `create_username` varchar(100) DEFAULT NULL COMMENT '创建人姓名',
  `create_userip` varchar(60) DEFAULT NULL COMMENT '创建人IP',
  `create_usermac` varchar(60) DEFAULT NULL COMMENT '创建人MAC地址',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间-应用操作时间',
  `create_time_db` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间-数据库操作时间',
  `server_ip` varchar(60) DEFAULT NULL COMMENT '服务器IP',
  `update_userid` bigint(20) DEFAULT NULL COMMENT '最后修改人ID',
  `update_username` varchar(100) DEFAULT NULL COMMENT '最后修改人姓名',
  `update_userip` varchar(60) DEFAULT NULL COMMENT '最后修改人IP',
  `update_usermac` varchar(60) DEFAULT NULL COMMENT '最后修改人MAC',
  `update_time` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改时间',
  `update_time_db` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改时间-数据库默认写入时间',
  `client_versionno` varchar(40) DEFAULT NULL COMMENT '客户端程序的版本号',
  `company_id` bigint(20) DEFAULT NULL COMMENT '公司id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品图片表';

-- ----------------------------
-- Table structure for product_picture_ration
-- ----------------------------
DROP TABLE IF EXISTS `product_picture_ration`;
CREATE TABLE `product_picture_ration` (
  `id` bigint(12) NOT NULL AUTO_INCREMENT,
  `bl_picture_id` bigint(20) DEFAULT NULL,
  `ody_picture_id` bigint(20) DEFAULT NULL,
  `bl_product_id` bigint(20) DEFAULT NULL,
  `sort_value` int(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for product_relation
-- ----------------------------
DROP TABLE IF EXISTS `product_relation`;
CREATE TABLE `product_relation` (
  `id` bigint(12) NOT NULL AUTO_INCREMENT,
  `old_product_id` bigint(20) DEFAULT NULL,
  `new_product_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for product_video
-- ----------------------------
DROP TABLE IF EXISTS `product_video`;
CREATE TABLE `product_video` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_id` bigint(20) NOT NULL,
  `video_id` bigint(20) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `type` int(4) DEFAULT NULL,
  `thumbnail_url` varchar(255) DEFAULT NULL,
  `video_url` varchar(255) DEFAULT NULL,
  `is_available` tinyint(2) DEFAULT NULL COMMENT '是否可用:默认0否;1是',
  `is_deleted`  tinyint(2) DEFAULT '0' COMMENT '是否逻辑删除:默认0未删除;1已删除',
  `version_no` int(11) DEFAULT '0' COMMENT '版本号:默认0,每次更新+1',
  `create_userid` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `create_username` varchar(100) DEFAULT NULL COMMENT '创建人姓名',
  `create_userip` varchar(60) DEFAULT NULL COMMENT '创建人IP',
  `create_usermac` varchar(60) DEFAULT NULL COMMENT '创建人MAC地址',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间-应用操作时间',
  `create_time_db` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间-数据库操作时间',
  `server_ip` varchar(60) DEFAULT NULL COMMENT '服务器IP',
  `update_userid` bigint(20) DEFAULT NULL COMMENT '最后修改人ID',
  `update_username` varchar(100) DEFAULT NULL COMMENT '最后修改人姓名',
  `update_userip` varchar(60) DEFAULT NULL COMMENT '最后修改人IP',
  `update_usermac` varchar(60) DEFAULT NULL COMMENT '最后修改人MAC',
  `update_time` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改时间',
  `update_time_db` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改时间-数据库默认写入时间',
  `client_versionno` varchar(40) DEFAULT NULL COMMENT '客户端程序的版本号',
  `company_id` bigint(20) DEFAULT NULL COMMENT '公司id',
  `video_pc_url` varchar(255) DEFAULT NULL,
  `pc_thumbnail_url` varchar(255) DEFAULT NULL,
  `mobile_hd_url` varchar(255) DEFAULT NULL,
  `mobile_hd_thumbnail_url` varchar(255) DEFAULT NULL,
  `mobile_ld_url` varchar(255) DEFAULT NULL,
  `mobile_ld_thumbnail_url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for shop_ref_product
-- ----------------------------
DROP TABLE IF EXISTS `shop_ref_product`;
CREATE TABLE `shop_ref_product` (
  `id` bigint(12) NOT NULL AUTO_INCREMENT,
  `shop_id` bigint(12) DEFAULT NULL,
  `product_id` bigint(12) DEFAULT NULL,
  `product_price` decimal(10,2) DEFAULT NULL COMMENT '类型：1实体卷，2电子卷',
  `instead_price` decimal(10,2) DEFAULT NULL,
  `create_at` datetime DEFAULT NULL,
  `update_at` datetime DEFAULT NULL,
  `status` smallint(6) DEFAULT '0',
  `category1_id` bigint(12) DEFAULT '0',
  `category2_id` bigint(12) DEFAULT '0',
  `category3_id` bigint(12) DEFAULT '0',
  `inventory_qty` int(11) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  `is_free` int(11) DEFAULT NULL,
  `is_send` int(11) DEFAULT NULL,
  `settle_price` decimal(10,2) DEFAULT NULL,
  `out_price` decimal(10,2) DEFAULT '0.00',
  PRIMARY KEY (`id`),
  KEY `index_shop_ref_product` (`shop_id`,`product_id`,`category1_id`,`category2_id`,`category3_id`) USING BTREE,
  KEY `idx_shop_ref_product_product_id` (`product_id`) USING BTREE,
  KEY `idx_shop_ref_product_shop_id` (`shop_id`,`status`) USING BTREE,
  KEY `IDX_shop_ref_product_product_id1` (`product_id`,`status`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for supplier
-- ----------------------------
DROP TABLE IF EXISTS `supplier`;
CREATE TABLE `supplier` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `is_available` tinyint(2) DEFAULT NULL COMMENT '是否可用:默认0否;1是',
  `is_deleted`  tinyint(2) DEFAULT '0' COMMENT '是否逻辑删除:默认0未删除;1已删除',
  `version_no` int(11) DEFAULT '0' COMMENT '版本号:默认0,每次更新+1',
  `create_userid` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `create_username` varchar(100) DEFAULT NULL COMMENT '创建人姓名',
  `create_userip` varchar(60) DEFAULT NULL COMMENT '创建人IP',
  `create_usermac` varchar(60) DEFAULT NULL COMMENT '创建人MAC地址',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间-应用操作时间',
  `create_time_db` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间-数据库操作时间',
  `server_ip` varchar(60) DEFAULT NULL COMMENT '服务器IP',
  `update_userid` bigint(20) DEFAULT NULL COMMENT '最后修改人ID',
  `update_username` varchar(100) DEFAULT NULL COMMENT '最后修改人姓名',
  `update_userip` varchar(60) DEFAULT NULL COMMENT '最后修改人IP',
  `update_usermac` varchar(60) DEFAULT NULL COMMENT '最后修改人MAC',
  `update_time` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改时间',
  `update_time_db` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改时间-数据库默认写入时间',
  `client_versionno` varchar(40) DEFAULT NULL COMMENT '客户端程序的版本号',
  `company_id` bigint(20) DEFAULT NULL COMMENT '公司id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='供应商表';

-- ----------------------------
-- Table structure for supplier_product
-- ----------------------------
DROP TABLE IF EXISTS `supplier_product`;
CREATE TABLE `supplier_product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `supplier_id` bigint(20) NOT NULL,
  `product_id` bigint(20) NOT NULL,
  `is_available` tinyint(2) DEFAULT NULL COMMENT '是否可用:默认0否;1是',
  `is_deleted`  tinyint(2) DEFAULT '0' COMMENT '是否逻辑删除:默认0未删除;1已删除',
  `version_no` int(11) DEFAULT '0' COMMENT '版本号:默认0,每次更新+1',
  `create_userid` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `create_username` varchar(100) DEFAULT NULL COMMENT '创建人姓名',
  `create_userip` varchar(60) DEFAULT NULL COMMENT '创建人IP',
  `create_usermac` varchar(60) DEFAULT NULL COMMENT '创建人MAC地址',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间-应用操作时间',
  `create_time_db` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间-数据库操作时间',
  `server_ip` varchar(60) DEFAULT NULL COMMENT '服务器IP',
  `update_userid` bigint(20) DEFAULT NULL COMMENT '最后修改人ID',
  `update_username` varchar(100) DEFAULT NULL COMMENT '最后修改人姓名',
  `update_userip` varchar(60) DEFAULT NULL COMMENT '最后修改人IP',
  `update_usermac` varchar(60) DEFAULT NULL COMMENT '最后修改人MAC',
  `update_time` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改时间',
  `update_time_db` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改时间-数据库默认写入时间',
  `client_versionno` varchar(40) DEFAULT NULL COMMENT '客户端程序的版本号',
  `company_id` bigint(20) DEFAULT NULL COMMENT '公司id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='供应商产品表';

-- ----------------------------
-- Table structure for temporary_table
-- ----------------------------
DROP TABLE IF EXISTS `temporary_table`;
CREATE TABLE `temporary_table` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `ean-13` varchar(255) NOT NULL COMMENT '产品ean-13',
  `price` decimal(12,3) DEFAULT NULL COMMENT '价格',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for video
-- ----------------------------
DROP TABLE IF EXISTS `video`;
CREATE TABLE `video` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `url` varchar(100) DEFAULT NULL,
  `thumbnail_url` varchar(100) DEFAULT NULL COMMENT '缩略图地址',
  `type` int(4) DEFAULT NULL COMMENT '0：PC视频;1:移动高清;2:移动低清;',
  `is_available` tinyint(2) DEFAULT NULL COMMENT '是否可用:默认0否;1是',
  `is_deleted`  tinyint(2) DEFAULT '0' COMMENT '是否逻辑删除:默认0未删除;1已删除',
  `version_no` int(11) DEFAULT '0' COMMENT '版本号:默认0,每次更新+1',
  `create_userid` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `create_username` varchar(100) DEFAULT NULL COMMENT '创建人姓名',
  `create_userip` varchar(60) DEFAULT NULL COMMENT '创建人IP',
  `create_usermac` varchar(60) DEFAULT NULL COMMENT '创建人MAC地址',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间-应用操作时间',
  `create_time_db` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间-数据库操作时间',
  `server_ip` varchar(60) DEFAULT NULL COMMENT '服务器IP',
  `update_userid` bigint(20) DEFAULT NULL COMMENT '最后修改人ID',
  `update_username` varchar(100) DEFAULT NULL COMMENT '最后修改人姓名',
  `update_userip` varchar(60) DEFAULT NULL COMMENT '最后修改人IP',
  `update_usermac` varchar(60) DEFAULT NULL COMMENT '最后修改人MAC',
  `update_time` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改时间',
  `update_time_db` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改时间-数据库默认写入时间',
  `client_versionno` varchar(40) DEFAULT NULL COMMENT '客户端程序的版本号',
  `company_id` bigint(20) DEFAULT NULL COMMENT '公司id',
  `pc_url` varchar(255) DEFAULT NULL,
  `pc_thumbnail_url` varchar(255) DEFAULT NULL,
  `mobile_hd_url` varchar(255) DEFAULT NULL,
  `mobile_hd_thumbnail_url` varchar(255) DEFAULT NULL,
  `mobile_ld_url` varchar(255) DEFAULT NULL,
  `mobile_ld_thumbnail_url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
