/*
 Navicat Premium Dump SQL

 Source Server         : Mysql
 Source Server Type    : MySQL
 Source Server Version : 80404 (8.4.4)
 Source Host           : localhost:3306
 Source Schema         : training_db

 Target Server Type    : MySQL
 Target Server Version : 80404 (8.4.4)
 File Encoding         : 65001

 Date: 10/06/2025 17:44:30
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for chapter
-- ----------------------------
DROP TABLE IF EXISTS `chapter`;
CREATE TABLE `chapter`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `cou_id` bigint NOT NULL,
  `cha_index` int NOT NULL,
  `cha_title` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `cha_url` varchar(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `deleted` int NOT NULL DEFAULT 0,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9014 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of chapter
-- ----------------------------
INSERT INTO `chapter` VALUES (9001, 7001, 1, 'Python简介', 'https://example.com/videos/python-intro.mp4', '2023-01-20 09:00:00', 1, '2025-06-08 19:38:44');
INSERT INTO `chapter` VALUES (9002, 7001, 2, '变量和数据类型', '/uploads/b96839dd-0f05-4d7c-8919-41b48cd3a2a2.mp4', '2023-01-21 10:00:00', 1, '2025-06-08 19:38:46');
INSERT INTO `chapter` VALUES (9003, 7002, 1, '机器学习概述', '/uploads/7007b201-dde7-4b92-bd29-2aa205724b6a.mp4', '2023-01-22 09:00:00', 1, '2025-06-08 19:38:35');
INSERT INTO `chapter` VALUES (9004, 7002, 2, 'SADSADASD', '/uploads/82722ea8-d97d-4b43-9d25-7ff621b64f45.mp4', '2025-05-10 17:27:12', 1, '2025-06-08 19:38:34');
INSERT INTO `chapter` VALUES (9005, 7003, 1, 'SADSADSAD师德SSDSD撒大声', '/uploads/4a915817-e77f-4703-bd78-d83f2c21e64a.mp4', '2025-05-10 17:30:18', 1, '2025-06-08 19:38:38');
INSERT INTO `chapter` VALUES (9006, 7003, 2, 'SADSADSADASASDSADS', '/uploads/62e0ac02-f159-45b9-a215-10b82036b1d0.mp4', '2025-05-10 17:31:09', 1, '2025-06-08 19:38:39');
INSERT INTO `chapter` VALUES (9007, 7003, 3, '佛挡杀佛胜多负少', '', '2025-05-12 22:06:04', 1, '2025-05-12 22:06:05');
INSERT INTO `chapter` VALUES (9010, 7001, 3, '123', '/uploads/5c2b8bd3-503c-46f7-a347-ede840fdf290.mp4', '2025-06-05 19:44:39', 1, '2025-06-05 21:57:23');
INSERT INTO `chapter` VALUES (9011, 7002, 3, '123', '', '2025-06-05 21:44:21', 1, '2025-06-05 21:44:25');
INSERT INTO `chapter` VALUES (9012, 7001, 3, '213123', '', '2025-06-05 21:57:26', 0, '2025-06-05 21:57:26');
INSERT INTO `chapter` VALUES (9013, 7005, 1, '21312312', '/uploads/video/2a5aadca-3886-4610-b479-eaae975ae8ad.mp4', '2025-06-10 16:24:24', 0, '2025-06-10 16:24:38');

-- ----------------------------
-- Table structure for class
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `class_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `class_stu_num` int NOT NULL DEFAULT 0,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `deleted` int NOT NULL DEFAULT 0,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3009 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of class
-- ----------------------------
INSERT INTO `class` VALUES (3001, '计算机科学2023班', 0, '2023-01-05 09:00:00', 1, '2025-05-26 17:06:10');
INSERT INTO `class` VALUES (3002, '人工智能2023班', 0, '2023-01-06 10:00:00', 0, '2025-05-29 10:03:22');
INSERT INTO `class` VALUES (3003, '软件232班', 0, '2025-05-10 18:48:32', 0, '2025-06-10 10:56:34');
INSERT INTO `class` VALUES (3004, '软件231班', 0, '2025-05-11 22:50:15', 1, '2025-05-11 22:53:24');
INSERT INTO `class` VALUES (3005, '软件231班', 1, '2025-05-11 22:54:37', 1, '2025-05-11 22:54:44');
INSERT INTO `class` VALUES (3006, '软件231班', 0, '2025-05-11 22:56:11', 1, '2025-05-11 22:56:37');
INSERT INTO `class` VALUES (3007, '撒旦撒旦', 0, '2025-05-14 11:53:19', 1, '2025-05-14 11:53:21');
INSERT INTO `class` VALUES (3008, '软件231', 0, '2025-05-26 17:06:16', 0, '2025-06-10 10:56:30');

-- ----------------------------
-- Table structure for context_subtype
-- ----------------------------
DROP TABLE IF EXISTS `context_subtype`;
CREATE TABLE `context_subtype`  (
  `id` bigint NOT NULL,
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `deleted` int NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of context_subtype
-- ----------------------------
INSERT INTO `context_subtype` VALUES (40001, '政治敏感', '2023-03-26 09:00:00', '2023-03-26 09:00:00', 0);
INSERT INTO `context_subtype` VALUES (40002, '色情低俗', '2023-03-27 10:00:00', '2023-03-27 10:00:00', 0);
INSERT INTO `context_subtype` VALUES (40003, '暴力恐怖', '2023-03-28 09:00:00', '2023-03-28 09:00:00', 0);

-- ----------------------------
-- Table structure for context_violations
-- ----------------------------
DROP TABLE IF EXISTS `context_violations`;
CREATE TABLE `context_violations`  (
  `id` bigint NOT NULL,
  `uid` bigint NOT NULL,
  `role` int NOT NULL COMMENT '1：资讯文字，2：问题文字，3：资讯评论，4：问题评论，5：课程信息，6：章节信息，7：实践活动信息，8：课程评论',
  `reference_id` bigint NOT NULL,
  `conclusion_type` int NOT NULL,
  `context_subtype_Id` int NOT NULL,
  `msg` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `keyword` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `context` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `deleted` int NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '内容违规记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of context_violations
-- ----------------------------
INSERT INTO `context_violations` VALUES (41001, 1001, 4, 28001, 2, 40001, '包含政治敏感内容', '政府', '我认为政府应该...', '2023-03-29 09:00:00', '2023-03-29 09:00:00', 0);
INSERT INTO `context_violations` VALUES (41002, 1002, 3, 28002, 2, 40002, '包含低俗内容', '色情', '这个图片很性感...', '2023-03-30 10:00:00', '2023-03-30 10:00:00', 0);

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `tea_id` bigint NOT NULL COMMENT '教师ID',
  `cou_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '课程名称',
  `cou_introduction` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '课程介绍',
  `cou_pic` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `cou_type_id` bigint NOT NULL COMMENT '子类别ID',
  `cou_par_type_id` bigint NOT NULL COMMENT '父类别ID',
  `cou_price` bigint NOT NULL DEFAULT 0 COMMENT '课程价格(单位：分)',
  `cou_cata_num` int NOT NULL DEFAULT 0 COMMENT '课程章节数',
  `cou_coll_num` bigint NOT NULL DEFAULT 0 COMMENT '课程收藏数',
  `cou_like_num` bigint NOT NULL DEFAULT 0 COMMENT '课程点赞数',
  `cou_share_num` bigint NOT NULL DEFAULT 0 COMMENT '课程分享数',
  `clicks` bigint NOT NULL DEFAULT 0 COMMENT '课程点击量',
  `purchase` bigint NOT NULL DEFAULT 0 COMMENT '课程购买量',
  `deleted` int NOT NULL DEFAULT 0 COMMENT '删除标记(0:未删除,1:已删除)',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7006 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '课程信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES (7001, 2001, 'Python编程基础', '本课程介绍Python编程语言的基础知识', '/uploads/img/fe29678a-9440-4c66-86bd-2beae1420949.png', 6002, 6001, 1, 0, 0, 0, 0, 500, 1, 0, '2023-01-16 09:00:00', '2025-06-10 16:23:52');
INSERT INTO `course` VALUES (7002, 2002, '机器学习入门', '本课程介绍机器学习的基本概念和算法', '/uploads/img/c24237b3-da35-44cd-8a4c-cfa1389e5138.png', 6005, 6004, 1, 0, 0, 0, 0, 300, 1, 0, '2023-01-17 10:00:00', '2025-06-10 16:23:46');
INSERT INTO `course` VALUES (7003, 2001, '撒旦撒旦撒旦师德232', '萨迪撒旦撒大声地啊实撒旦撒旦撒', '/uploads/img/795b876c-8e7d-48d8-b853-7b22be8ca51a.png', 6005, 6004, 1, 0, 0, 0, 0, 0, 0, 1, '2025-05-10 17:30:11', '2025-06-10 16:23:57');
INSERT INTO `course` VALUES (7004, 2001, '12323', '1123123123123123', 'data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABgAAAAYCAMAAADXqc3KAAAA9lBMVEUAAAD///+AgICZmZmfn5+VqqqkpLaZqqqfn6+WpbScqqqZprOdp7Gep7CZorOcpa2co7Gdo7GepLCapa+eo62bpa+dorGapK2bpK2cpK2dpbGboq6do6+bpLCdo7CcpK6bo6+co7Cco6+do66co7Cdo7Cdo6+do6+co66bo7Cdoq+dpLCboq+co6+dpLCcorCcpK+co6+bo7Cdo66cpK+co6+coq+co6+co6+do6+co6+co66co6+co6+coq+co6+co66co6+co6+co6+co6+co6+bo66co6+co6+coq+co6+co6+co6+co6+bo6+co6+co6+co68G9JFqAAAAUXRSTlMAAQIFCAwODxAREhQaHR4fJCcqMDIzNDU4O0FCU1ReYmZnb3J3en+CiIqMkZKTlJqfo6Srra+wubq9v8HCyMnO0dXb3N3h5Ovs7e7v9PX2/f5xeQ9MAAAAAWJLR0QB/wIt3gAAAM9JREFUGBmNwYlSgkAAgOEfr7JaS8suKhC1uzy7L8xMSEP3/V8m2HEcF6ap7+NvKbNa3U+RUHRl6G2DmNVP/yi3Zn0N8uhOpruE9qbH6F4fUB5f0PVbKO13dM8uivuErj4pEypP6uhWhj0BojfME2OO/WbT/zZJKHVHo26J/0vvWLWatZ1GJ649qXhXggVOELQOCpnM+mE7CBzmLuWNYEbcygtmbHlmMGecywrKsndnsMC495aI2HITzZa0iXT6xHx0iDRkQoNI1jmNcbL87gd4syF94ou9ugAAAABJRU5ErkJggg==', 6003, 6001, 1, 2, 0, 0, 0, 0, 0, 1, '2025-05-26 17:04:04', '2025-06-10 16:23:58');
INSERT INTO `course` VALUES (7005, 2001, 'SpringBoot实战项目开发', '刘小金是xx51515', '/uploads/img/f8bab475-25d8-44f8-9905-8a49616f636d.png', 6003, 6001, 1, 1, 0, 0, 0, 0, 1, 0, '2025-06-05 23:01:29', '2025-06-10 16:24:24');

-- ----------------------------
-- Table structure for course_appraise
-- ----------------------------
DROP TABLE IF EXISTS `course_appraise`;
CREATE TABLE `course_appraise`  (
  `id` bigint NOT NULL COMMENT '评价ID',
  `stu_id` bigint NOT NULL COMMENT '学生ID',
  `cou_appraise` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '课程评价内容',
  `evaluate_score` int NOT NULL DEFAULT 0 COMMENT '评分(0-5分)',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '评价时间',
  `deleted` int NOT NULL DEFAULT 0 COMMENT '删除标记(0:未删除,1:已删除)',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '课程评价表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course_appraise
-- ----------------------------
INSERT INTO `course_appraise` VALUES (20001, 1001, '课程内容很丰富，讲解清晰', 5, '2023-02-13 09:00:00', 0, '2023-02-13 09:00:00');
INSERT INTO `course_appraise` VALUES (20002, 1002, '课程难度适中，适合初学者', 4, '2023-02-14 10:00:00', 0, '2023-02-14 10:00:00');

-- ----------------------------
-- Table structure for course_class
-- ----------------------------
DROP TABLE IF EXISTS `course_class`;
CREATE TABLE `course_class`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `cou_id` bigint NOT NULL COMMENT '课程ID',
  `class_id` bigint NOT NULL COMMENT '班级ID',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8027 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '课程-班级关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course_class
-- ----------------------------
INSERT INTO `course_class` VALUES (8019, 7001, 3003, '2025-05-11 22:54:29', '2025-05-11 22:54:29');
INSERT INTO `course_class` VALUES (8026, 7001, 3002, '2025-05-26 17:06:54', '2025-05-26 17:06:54');

-- ----------------------------
-- Table structure for course_interaction
-- ----------------------------
DROP TABLE IF EXISTS `course_interaction`;
CREATE TABLE `course_interaction`  (
  `id` bigint NOT NULL COMMENT '互动记录ID',
  `cou_id` bigint NOT NULL COMMENT '课程ID',
  `stu_id` int NOT NULL COMMENT '学生ID',
  `collect` int NOT NULL DEFAULT 0 COMMENT '是否收藏(0:未收藏,1:已收藏)',
  `cart` int NOT NULL DEFAULT 0 COMMENT '是否加入购物车(0:未加入,1:已加入)',
  `have` int NOT NULL DEFAULT 0 COMMENT '是否购买(0:未购买,1:已购买)',
  `recommend` int NOT NULL DEFAULT 0 COMMENT '是否点赞(0:未点赞,1:已点赞)',
  `evaluate` int NOT NULL DEFAULT 0 COMMENT '是否评价(0:未评价,1:已评价)',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '课程互动记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course_interaction
-- ----------------------------
INSERT INTO `course_interaction` VALUES (19001, 7001, 1001, 1, 0, 1, 1, 1, '2023-02-10 09:00:00', '2023-02-10 09:00:00');
INSERT INTO `course_interaction` VALUES (19002, 7001, 1002, 0, 0, 1, 1, 1, '2023-02-11 10:00:00', '2023-02-11 10:00:00');
INSERT INTO `course_interaction` VALUES (19003, 7002, 1001, 0, 1, 0, 0, 0, '2023-02-12 09:00:00', '2023-02-12 09:00:00');

-- ----------------------------
-- Table structure for course_type
-- ----------------------------
DROP TABLE IF EXISTS `course_type`;
CREATE TABLE `course_type`  (
  `id` bigint NOT NULL COMMENT '主键ID',
  `parent_type_id` bigint NOT NULL COMMENT '父类型ID',
  `type_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '类型名称',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `deleted` int NOT NULL DEFAULT 0 COMMENT '删除标记(0:未删除,1:已删除)',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '课程类型表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course_type
-- ----------------------------
INSERT INTO `course_type` VALUES (6001, 0, '计算机科学', '2023-01-11 09:00:00', 0, '2023-01-11 09:00:00');
INSERT INTO `course_type` VALUES (6002, 6001, '编程语言', '2023-01-12 10:00:00', 0, '2023-01-12 10:00:00');
INSERT INTO `course_type` VALUES (6003, 6001, '数据结构', '2023-01-13 11:00:00', 0, '2023-01-13 11:00:00');
INSERT INTO `course_type` VALUES (6004, 0, '人工智能', '2023-01-14 09:00:00', 0, '2023-01-14 09:00:00');
INSERT INTO `course_type` VALUES (6005, 6004, '机器学习', '2023-01-15 10:00:00', 0, '2023-01-15 10:00:00');

-- ----------------------------
-- Table structure for image_subtype
-- ----------------------------
DROP TABLE IF EXISTS `image_subtype`;
CREATE TABLE `image_subtype`  (
  `id` bigint NOT NULL COMMENT '图片子类型ID',
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '子类型名称',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` int NOT NULL DEFAULT 0 COMMENT '删除标记(0:未删除,1:已删除)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '图片子类型表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of image_subtype
-- ----------------------------
INSERT INTO `image_subtype` VALUES (42001, '政治敏感图片', '2023-03-31 09:00:00', '2023-03-31 09:00:00', 0);
INSERT INTO `image_subtype` VALUES (42002, '色情图片', '2023-04-01 10:00:00', '2023-04-01 10:00:00', 0);
INSERT INTO `image_subtype` VALUES (42003, '暴力恐怖图片', '2023-04-02 09:00:00', '2023-04-02 09:00:00', 0);

-- ----------------------------
-- Table structure for image_violations
-- ----------------------------
DROP TABLE IF EXISTS `image_violations`;
CREATE TABLE `image_violations`  (
  `id` bigint NOT NULL COMMENT '违规记录ID',
  `uid` bigint NOT NULL COMMENT '用户ID',
  `role` int NOT NULL COMMENT '图片角色(1:课程图像,2:资讯图像,3:问题图像)',
  `reference_id` bigint NOT NULL COMMENT '关联业务ID',
  `conclusion_type` int NULL DEFAULT NULL COMMENT '判定结果(1:合规,2:不合规,3:怀疑)',
  `image_url` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '图片URL',
  `msg` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '违规描述',
  `image_subtype_id` int NOT NULL COMMENT '图片子类型ID',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` int NOT NULL DEFAULT 0 COMMENT '删除标记(0:未删除,1:已删除)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '图片违规记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of image_violations
-- ----------------------------
INSERT INTO `image_violations` VALUES (43001, 1001, 3, 35001, 2, 'https://example.com/questions/bad-image.jpg', '包含政治敏感内容', 42001, '2023-04-03 09:00:00', '2023-04-03 09:00:00', 0);
INSERT INTO `image_violations` VALUES (43002, 1002, 3, 35002, 2, 'https://example.com/questions/sex-image.jpg', '包含色情内容', 42002, '2023-04-04 10:00:00', '2023-04-04 10:00:00', 0);

-- ----------------------------
-- Table structure for information
-- ----------------------------
DROP TABLE IF EXISTS `information`;
CREATE TABLE `information`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '评论ID',
  `tea_id` bigint NOT NULL COMMENT '教师ID',
  `info_title` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '资讯标题',
  `info_main` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '资讯正文内容',
  `info_like` bigint NOT NULL DEFAULT 0 COMMENT '点赞数',
  `info_collection` bigint NOT NULL DEFAULT 0 COMMENT '收藏数',
  `info_comment` bigint NOT NULL DEFAULT 0 COMMENT '评论数',
  `info_image` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '资讯封面图URL',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `deleted` int NOT NULL DEFAULT 0 COMMENT '删除标记(0:未删除,1:已删除)',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 26009 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '资讯信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of information
-- ----------------------------
INSERT INTO `information` VALUES (26001, 2001, 'Python 3.11新特性', '<p>Python 3.11带来了多项性能改进和新特性...</p>', 0, 0, 2, '/uploads/img/5e440074-8b2e-4aab-ba76-1251a98667b4.png', '2023-02-24 09:00:00', 0, '2025-06-10 08:41:07');
INSERT INTO `information` VALUES (26002, 2002, '机器学习最新研究进展', '<p>近期机器学习领域有几项重要研究成果发表...</p>', 0, 0, 2, '/uploads/img/d26a736b-2210-409e-b8c1-91eb12cf58ef.png', '2023-02-25 10:00:00', 0, '2025-06-10 08:41:17');
INSERT INTO `information` VALUES (26003, 2002, '中国“拉索”观测站确认首个超级宇宙线源，破解百年天文之谜', '<p style=\"text-align: left;\"><br></p><p style=\"text-indent: 2em; text-align: start;\">“拉索”确认首个超级宇宙线源、世界首款类脑互补视觉芯片研制成功、嫦娥六号实现世界首次月背采样返回……回望2024，中国在实现高水平科技自立自强的道路上行稳致远。这一年，我们深刻体会到，“科技改变生活”“科技成就未来”这些宏大叙事愈加落地和具象化。在面临诸多不确定性的当下，科技创新正切实带来信心和希望。</p><p style=\"text-indent: 2em; text-align: start;\">1 全国科技大会、国家科学技术奖励大会、两院院士大会召开</p><p style=\"text-indent: 2em; text-align: start;\">科技兴则民族兴，科技强则国家强。6月24日，全国科技大会、国家科学技术奖励大会和中国科学院第二十一次院士大会、中国工程院第十七次院士大会隆重召开。这次大会是在以中国式现代化全面推进强国建设、民族复兴伟业关键时期召开的一次科技盛会，对加快实现高水平科技自立自强、建设科技强国具有重大意义。</p><p style=\"text-indent: 2em; text-align: start;\">“锚定2035年建成科技强国的战略目标”是这次大会传递的最强音。“现在距离实现建成科技强国目标只有11年时间了。我们要以‘十年磨一剑’的坚定决心和顽强意志，只争朝夕、埋头苦干，一步一个脚印把这一战略目标变为现实。”习近平总书记的重要讲话铿锵有力。</p><p style=\"text-indent: 2em; text-align: start;\">习近平总书记在讲话中充分肯定了近年来我国科技创新发展取得的历史性成就，深刻总结了新时代科技事业发展的重要经验，精辟论述了科技创新在推进中国式现代化、实现第二个百年奋斗目标伟大进程中的重要作用，系统阐明了新形势下加快建设科技强国的基本内涵和主要任务。</p><p style=\"text-indent: 2em; text-align: start;\">“冲锋号”吹响，新征程启航。这次大会为新时代科技工作指明前进方向，进一步统一思想、深化认识，凝聚起建设科技强国的创新伟力。</p><p style=\"text-indent: 2em; text-align: start;\">2 “拉索”确认首个超级宇宙线源</p><p style=\"text-indent: 2em; text-align: start;\">高能宇宙线从哪里来？这是一个世纪之谜。我国高海拔宇宙线观测站“拉索”（LHAASO）的新发现，让我们离解开这一谜题更近了一步。</p><p style=\"text-indent: 2em; text-align: start;\">2月26日，《科学通报》发表了一项关于高能宇宙线起源的重要成果。利用“拉索”的观测数据，我国科学家在天鹅座恒星形成区发现了一个巨型超高能伽马射线泡状结构，并从中找到了能量高于1亿亿电子伏宇宙线起源的候选天体。这是迄今人类能够确认的第一个超级宇宙线源。</p><p style=\"text-indent: 2em; text-align: start;\">宇宙线是从外太空来的带电粒子，主要成分为质子，携带着宇宙起源、天体演化等方面的重要科学信息。探究宇宙线起源之谜，是当代天体物理学的重大前沿科学问题之一。</p><p style=\"text-indent: 2em; text-align: start;\">据介绍，“拉索”此次发现的巨型超高能伽马射线泡状结构，距我们约5000光年，尺度超过1000万个太阳系。泡状结构内有多个能量超过1千万亿电子伏的光子，最高达到2千万亿电子伏。</p><p style=\"text-indent: 2em; text-align: start;\">“一般来说，产生能量为2千万亿电子伏的伽马光子，需要能量至少高10倍的宇宙线粒子。”论文通讯作者、中国科学技术大学教授杨睿智说，这表明泡状结构内部存在超级宇宙线源，源源不断地产生能量至少达到2亿亿电子伏的高能宇宙线粒子，并注入到星际空间。</p><p style=\"text-indent: 2em; text-align: start;\">研究表明，位于泡状结构中心附近的大质量恒星星团（Cygnus OB2星协），是超级宇宙线源最可能的对应天体。</p><p style=\"text-indent: 2em; text-align: start;\">3 复粒稻遗传奥秘破译</p><p style=\"text-indent: 2em; text-align: start;\">复粒稻是一种独特的水稻种质资源，与普通水稻穗子上种子粒粒分明不同，它结出的种子可以三粒长在一簇上，因此又被称为“三粒奇”。但这“三粒一簇”特性的机制一直是个谜。</p><p style=\"text-indent: 2em; text-align: start;\">3月8日，记者从中国农业科学院获悉，来自该院等单位的科研人员成功破译复粒稻“三粒一簇”的遗传奥秘，揭示了油菜素甾醇调控水稻穗粒数的机制，为培育高产水稻新品种提供了新的理论基础和路径。相关研究成果当日发表于《科学》杂志。</p><p style=\"text-indent: 2em; text-align: start;\">在这项工作中，研究团队历时7年，对复粒稻种质进行了大规模化学诱变，创制了1万份（约16万个单株）复粒稻诱变株系，通过在田间逐一鉴定穗部特征，从中筛选出2份不簇生的突变体株系，成功定位到发生突变的基因BRD3。</p><p style=\"text-indent: 2em; text-align: start;\">通过进一步分析，研究团队发现，油菜素甾醇可以通过调控水稻穗二级分枝调控穗粒数。</p><p style=\"text-indent: 2em; text-align: start;\">实验证明，正是在突变基因BRD3的作用下，油菜素甾醇这种激素的含量降低，导致复粒稻稻穗的二级枝梗增多，使得“三粒一簇”现象出现。</p><p style=\"text-indent: 2em; text-align: start;\">中国农业科学院副院长曹永生表示，水稻单产突破依赖种质资源中重大基因的发掘利用，油菜素甾醇调控水稻穗粒数机制的发现，提供了提高水稻单产的新视角。</p><p style=\"text-indent: 2em; text-align: start;\">4 光子的分数量子反常霍尔态首次实现</p><p style=\"text-indent: 2em; text-align: start;\">5月6日，记者从中国科学院获悉，利用“自底而上”的量子模拟方法，中国科学技术大学潘建伟院士团队在国际上首次实现了光子的分数量子反常霍尔态，为高效开展更多、更新奇的量子物态研究提供了新路径。相关研究成果发表于《科学》杂志。</p><p style=\"text-indent: 2em; text-align: start;\">霍尔效应是指当电流通过置于磁场中的材料时，电子受到洛伦兹力的作用，在材料内部产生垂直于电流和磁场方向的电压，该效应被广泛应用于电磁感测领域。反常霍尔效应则是指无需外部磁场的情况下观测到相关效应。量子霍尔效应是量子力学版本的霍尔效应，需要在低温强磁场的极端条件下才可被观察到。</p><p style=\"text-indent: 2em; text-align: start;\">“量子霍尔效应根据电子间相互作用方式的不同，分为整数量子霍尔效应和分数量子霍尔效应。”潘建伟说，其中，分数量子霍尔态展现出非平庸的多体纠缠，具有重要的观测研究价值，多年来受到学术界高度关注。</p><p style=\"text-indent: 2em; text-align: start;\">在此项研究中，团队利用“自底而上”的方式，基于自主研发的超导高非简谐性光学谐振器阵列，实现了光子间的非线性相互作用，并进一步在此系统中构建出作用于光子的等效磁场以构造人工规范场，从而实现了光子的分数量子反常霍尔态。</p><p style=\"text-indent: 2em; text-align: start;\">诺贝尔物理学奖获得者弗兰克·维尔切克评价，这项研究向基于任意子的量子信息处理迈出重要一步。</p><p style=\"text-indent: 2em; text-align: start;\">5 世界首款类脑互补视觉芯片研制成功</p><p style=\"text-indent: 2em; text-align: start;\">继2019年发布全球首款异构融合类脑芯片“天机芯”之后，清华大学精密仪器系类脑计算研究团队在类脑视觉感知芯片领域再获新突破，研制出世界首款类脑互补视觉芯片“天眸芯”。相关研究成果5月30日以封面文章的形式发表于《自然》杂志。</p><p style=\"text-indent: 2em; text-align: start;\">论文通讯作者、清华大学精密仪器系教授施路平介绍，在开放世界中，智能系统不仅要应对庞大的数据量，还需要应对极端场景，如驾驶场景中的突发危险、隧道口的剧烈光线变化和夜间强闪光干扰等。而传统视觉感知芯片面对此类场景往往出现失真、失效或高延迟，这样就会限制系统的稳定性和安全性。</p><p style=\"text-indent: 2em; text-align: start;\">为更好应对上述问题，研究团队聚焦类脑视觉感知芯片技术，提出了一种基于视觉原语的互补双通路类脑视觉感知新范式。</p><p style=\"text-indent: 2em; text-align: start;\">“该范式借鉴了人类视觉系统的基本原理，将开放世界的视觉信息拆解为基于视觉原语的信息表示，并通过有机组合这些原语，模仿人视觉系统的特征，形成两条优势互补、信息完备的视觉感知通路。”施路平介绍，基于这一新范式，团队研制的“天眸芯”不仅突破了传统视觉感知范式的性能瓶颈，而且能够高效应对各种极端场景，确保系统的稳定性和安全性。</p><p style=\"text-indent: 2em; text-align: start;\">6 嫦娥六号实现世界首次月球背面采样返回</p><p style=\"text-indent: 2em; text-align: start;\">敢上九天揽月，谈笑凯歌还！</p><p style=\"text-indent: 2em; text-align: start;\">6月25日，内蒙古四子王旗阿木古郎草原，一顶红白相间的巨型降落伞缓缓落下，嫦娥六号返回器回到地面。至此，嫦娥六号完成了世界首次月球背面采样返回的壮举。这是我国迄今为止开展的最复杂的深空探测任务。</p><p style=\"text-indent: 2em; text-align: start;\">嫦娥六号任务周期长，工程创新多、风险高、难度大，突破了月球逆行轨道设计与控制、月背智能快速采样、月背起飞上升等关键技术。</p><p style=\"text-indent: 2em; text-align: start;\">嫦娥六号自发射后历经53天，闯过地月转移、近月制动、环月飞行、着陆下降、月面工作、月面上升、交会对接与样品转移、环月等待、月地转移以及再入回收等多个难关，成功带回1935.3克月背样品。</p><p style=\"text-indent: 2em; text-align: start;\">这些珍贵的月背样品，不仅填补了月球背面研究的历史空白，也为我们研究月球早期演化提供了一手资料，更为理解月球背面与正面地质差异开辟了新的视角。</p><p style=\"text-indent: 2em; text-align: start;\">11月15日，月背样品研究传来好消息：我国科学家利用嫦娥六号月背样品做出的两项独立研究成果，分别登上国际顶级学术期刊《自然》杂志和《科学》杂志。这两项研究首次揭示月球背面约28亿年前仍存在年轻的岩浆活动，这一年龄填补了月球玄武岩样品在该时期的记录空白。</p><p style=\"text-indent: 2em; text-align: start;\">紧接着，12月20日，《自然》又报道我国科学家通过分析嫦娥六号月背样品，获得了人类首份月背古磁场信息。</p><p style=\"text-indent: 2em; text-align: start;\">7 国家重大工程深中通道建成开通</p><p style=\"text-indent: 2em; text-align: start;\">遥望珠江口，曾被伶仃洋隔开的两岸城市群，因一座超级工程而紧密连接。</p><p style=\"text-indent: 2em; text-align: start;\">6月30日，历时7年建设的国家重大工程深中通道建成开通，从深圳到中山的车程由原来的2小时缩短至30分钟。深中通道全长约24公里，集“桥、岛、隧、水下互通”于一体，是世界上综合建设难度最高的跨海集群工程之一。</p><p style=\"text-indent: 2em; text-align: start;\">作为环珠江口“A”字形交通网络骨架的关键一“横”，深中通道跨越伶仃洋，让珠江口东西两岸的“深莞惠”与“珠中江”两大城市群实现了跨海直连。</p><p style=\"text-indent: 2em; text-align: start;\">在建设过程中，项目团队创造了世界首例水下高速公路枢纽互通—机场互通立交、世界最长的双向八车道海底沉管隧道、世界最大跨径全离岸海中钢箱梁悬索桥、世界最高桥面最高通航净空海中大桥等10项“世界之最”。</p><p style=\"text-indent: 2em; text-align: start;\">自建设以来，深中通道获得发明专利200余项、行业协会奖项数十项，并屡获国际赞誉。2024年4月，深中大桥荣获被称为桥梁界“诺贝尔奖”的国际桥梁大会“乔治·理查德森奖”，深中隧道荣膺“全球隧道与地下工程领域50项标志性工程”。</p><p style=\"text-indent: 2em; text-align: start;\">“我们坚持关键技术自主创新，将创新主导权牢牢掌握在自己手中。”深中通道管理中心主任、总工程师宋神友说，深中通道完成了多项技术创新，特别是在钢壳—混凝土沉管隧道设计施工领域形成了原创性成果，实现了“从0到1”的突破，为世界跨海通道工程建设贡献了中国方案。</p><p style=\"text-indent: 2em; text-align: start;\">8 异体通用型CAR-T治疗自身免疫疾病获突破</p><p style=\"text-indent: 2em; text-align: start;\">7月16日，《细胞》杂志在线发表海军军医大学第二附属医院（上海长征医院）徐沪济教授团队的临床研究成果：3名患有严重复发难治性风湿免疫疾病的患者在接受通用型嵌合抗原受体T细胞免疫疗法（CAR-T）治疗后，病情得到明显改善。这是国际首次成功使用异体通用型CAR-T治疗自身免疫疾病。</p><p style=\"text-indent: 2em; text-align: start;\">如何提高风湿免疫性疾病的治愈率，最大限度降低患病率和致残率，改善患者生活质量是全球共同面临的医学难题。近年来，生物制剂和靶向小分子药物等在风湿免疫性疾病的治疗中取得了巨大进展，但其对许多患者仍无效，或改善后复发，患者最终发展出危及生命的并发症。</p><p style=\"text-indent: 2em; text-align: start;\">徐沪济介绍，CAR-T作为一种创新的治疗手段，已经在B淋巴细胞（以下简称“B细胞”）等恶性肿瘤的治疗中显示出较好的疗效。在一些风湿免疫性疾病发病过程中，B细胞的异常发育和功能失调是致病的关键因素之一。该团队使用健康供者来源的T细胞，经过基因工程改造，制备出针对B细胞CD19的异体通用型靶向CAR-T细胞药物，实现了CAR-T细胞药物的批量生产。使用该细胞药物，徐沪济教授团队成功治疗3名严重复发难治性风湿免疫疾病患者。</p><p style=\"text-indent: 2em; text-align: start;\">徐沪济表示，这项研究不仅为目前缺乏有效治疗手段的风湿免疫性疾病患者提供了新的治疗选择，还展示了通用型CAR-T细胞疗法在有效性和安全性方面的巨大潜力。</p><p style=\"text-indent: 2em; text-align: start;\">9 首个国产移动操作系统发布</p><p style=\"text-indent: 2em; text-align: start;\">10月22日，我国首个国产移动操作系统——华为原生鸿蒙操作系统（HarmonyOS NEXT）正式发布。这是继苹果iOS和安卓系统后，全球第三大移动操作系统。</p><p style=\"text-indent: 2em; text-align: start;\">此次发布的原生鸿蒙操作系统流畅度、性能、安全特性等提升显著，全面突破操作系统核心技术，实现系统底座的全部自研，也实现国产操作系统的自主可控。</p><p style=\"text-indent: 2em; text-align: start;\">由于不依赖国外编程语言和操作系统内核等核心技术，原生鸿蒙操作系统也被称为“纯血鸿蒙”。11月26日，搭载原生鸿蒙操作系统的华为Mate 70系列手机正式发布，标志着华为原生鸿蒙操作系统正式商用。</p><p style=\"text-indent: 2em; text-align: start;\">华为常务董事、终端业务董事长、智能汽车解决方案业务董事长余承东介绍，原生鸿蒙操作系统在续航时间、安全和隐私保护等方面均位于行业前列。</p><p style=\"text-indent: 2em; text-align: start;\">据悉，鸿蒙系统于2015年立项，持续打造操作系统根技术，用不到10年的时间走完同行30年的历程。2019年，华为公司正式对外发布鸿蒙系统，2021年该系统正式搭载到智能手机上。2023年9月，华为公司宣布全面启动鸿蒙原生应用，意味着鸿蒙系统完全使用自主“内核”，不再依赖其他操作系统的开放源代码。加速创新的鸿蒙系统不仅为国内终端、软件等产业链各环节发展带来新机遇，也正带动各行业、各领域的数智化转型。</p><p style=\"text-indent: 2em; text-align: start;\">10 大洋钻探船“梦想”号正式入列</p><p style=\"text-indent: 2em; text-align: start;\">“打穿地壳、进入地球深部”，这是人类长久以来的科学梦想。如今，中国最新入列的科考船有望将这一梦想变成现实。</p><p style=\"text-indent: 2em; text-align: start;\">11月17日，拥有最大11000米的钻深能力、我国自主设计建造的首艘大洋钻探船“梦想”号在广州正式入列。</p><p style=\"text-indent: 2em; text-align: start;\">“梦想”号全长179.8米，宽32.8米，排水量42600吨，续航力15000海里，自持力120天，载员180人。它的稳定性和结构强度按16级超强台风安全要求设计，可在6级海况下正常作业，具备全球海域无限航区作业能力。</p><p style=\"text-indent: 2em; text-align: start;\">中国船舶第七〇八研究所“梦想”号总设计师张海彬介绍，“梦想”号采用模块化设计理念，攻克多项世界级船舶设计难题，国际首次创新集成大洋科学钻探、深海油气勘探和天然气水合物勘查试采等多种功能，构建起我国自主的超深水钻探装备设计建造技术体系。经两轮海试验证，“梦想”号主要性能指标优于设计要求。</p><p style=\"text-indent: 2em; text-align: start;\">作为全球领先的深海作业平台，“梦想”号的科考实验功能和信息化水平国际领先。全船建有基础地质、古地磁、无机地化、有机地化、微生物、海洋科学、天然气水合物、地球物理、钻探技术等九大功能实验室，总面积超3000平方米，配置有全球首套船载岩心自动传输存储系统，可满足海洋领域全学科研究需求。</p><p style=\"text-indent: 2em; text-align: start;\">“梦想”号海试成功并正式入列，标志着我国在深海进入、深海探测、深海开发上迈出了重要一步，是建设海洋强国、科技强国取得的又一重大成果。</p>', 0, 0, 0, '/uploads/a0fda9ce-a911-444c-b9c5-d376eb1082ad.png', '2025-06-07 14:51:27', 1, '2025-06-08 20:11:24');
INSERT INTO `information` VALUES (26004, 2001, '大模型热潮第三年，“AI春晚”又换主角 为什么是具身智能？', '<p style=\"text-align: start;\">早早就没了位置，人墙围了一层又一层，宇树机器人、天工机器人一登场，就调动了全场气氛。</p><p style=\"text-align: start;\">6月6日，由北京智源人工智能研究院主办的“AI春晚”——第七届北京智源大会（以下简称智源大会）正式开幕。</p><p style=\"text-align: start;\">大模型热潮进入第三年，智源大会的关键词已经从“大语言模型”跃升为“具身智能”与“机器人2.0”。</p><p style=\"text-align: start;\">作为产业风向标，在智源大会上，OpenAI创始人山姆·奥特曼以及“深度学习之父”辛顿曾发表演讲；月之暗面创始人杨植麟曾经历人墙围堵，热度远超如今首个冲向IPO的智谱AI；而今，大会上的“明星”是宇树科技创始人、CEO（首席执行官）王兴兴。</p><p style=\"text-align: start;\">变化的背后，AI（人工智能）正加速迈入“干实事”的新阶段：从机器人表演走向实际应用，从模型训练走向产业闭环。物理世界的复杂性、数据采集的现实需求、人与机器的自然交互，正在共同推动具身智能成为AI发展的下一个技术高地。</p><p style=\"text-align: center;\"><img src=\"https://img-s.msn.cn/tenant/amp/entityid/AA1GdDQv.img?w=768&amp;h=512&amp;m=6\" alt=\"大模型热潮第三年，“AI春晚”又换主角 为什么是具身智能？\" data-href=\"\" style=\"width: auto !important;\"></p><p style=\"text-align: start;\"><span style=\"color: rgb(255, 255, 255);\">大模型热潮第三年，“AI春晚”又换主角 为什么是具身智能？</span></p><p style=\"text-align: start;\">具身智能会客厅对话现场 主办者供图</p><h2 style=\"text-align: start;\">“AI春晚”，主角又换了</h2><p style=\"text-align: start;\">结束开幕式上的“智源具身智能会客厅”圆桌对话后，宇树科技CEO王兴兴在现场安保引导下离场，想要上前与其交流的观众被隔绝在人墙外。</p><p style=\"text-align: start;\">这或许是吸取了去年的“教训”，彼时的明星公司是月之暗面，杨植麟在下场后几度被人墙围住无法脱身。</p><p style=\"text-align: start;\">如果以2022年末ChatGPT的发布作为节点，三届智源大会，不仅见证了大模型时代AI技术的跨越式发展，也折射出人工智能产业关注重心的变动轨迹。</p><p style=\"text-align: start;\">2023年，AI领域风头无两的是OpenAI所引领的生成式大语言模型热潮，当年大会的高光时刻是OpenAI的代表人物山姆·奥特曼（Sam Altman）与“深度学习之父”辛顿（Geoffrey Hinton）的亮相。</p><p style=\"text-align: start;\"><br></p><p style=\"text-align: start;\">2024年，以月之暗面、百度、智谱AI为代表的国产大模型厂商迅速崛起，在语言模型与多模态模型领域竞逐成“主角”，开发出Kimi的月之暗面备受追捧。</p><p style=\"text-align: start;\">2025年，具身智能集中抢镜，机器人、跨模态系统、物理智能等成为主论坛的重要议题。变化背后，是技术路线的演进和应用价值的再认识。</p><p style=\"text-align: start;\">面壁智能CEO兼联合创始人李大海在接受《每日经济新闻》记者采访时表示，技术的发展是非线性的。大模型本质上是一项基础性技术，未来一定是非常重要的底层基础设施。随着这项技术逐步成熟，产业关注的重心自然也开始从底层模型向其之上的具体应用转移，这种关注点的迁移是合理且必然的。</p><p style=\"text-align: start;\">同时，李大海认为，大模型“奇点”正在到来，其身处其中有非常强烈的感受，当前大模型在训练过程中，已经能够利用自身的特性，反哺训练过程，实现大模型训练的加速，形成“用大模型训练大模型”的良性循环。“整个技术的发展在加速，（所以）才有外面能看到的整个行业的变化越来越大（的情况）。”</p><p style=\"text-align: start;\">“人工智能正加速从数字世界走向物理世界，这是我们对整个大的技术发展趋势的判断。”智源研究院院长王仲远受访时表示。</p><h2 style=\"text-align: start;\">从“秀肌肉”到“干实事”</h2><p style=\"text-align: start;\">在2024年的智源大会开幕式上，月之暗面、百川智能、智谱AI与面壁智能四家国产大模型公司曾罕见同台，展开通往通用人工智能（AGI）之路的对话。而2025年，圆桌环节的对话主角，从大模型转向了具身智能。</p><p style=\"text-align: start;\">开年以来，具身智能成为人工智能领域最热的关键词，伴随而来的，是形态各异的机器人频繁亮相各种公众赛事：从春节晚会上的舞蹈表演，到格斗竞技场上的人形对抗赛；从物流分拣的真实场景模拟，到即将在北京举办的“世界人形机器人运动会”。</p><p style=\"text-align: start;\">眼下风靡的机器人比赛，是验证技术的试验场，还是秀肌肉的“秀场”？</p><p style=\"text-align: start;\">对此，王兴兴认为，当前机器人赛事的价值在于让大众“看到机器人已经发展到什么阶段了”。他坦言，尽管人形机器人还不能“真正进入家庭干活”，但通过格斗、跳舞等全身动作训练，一方面可以展示当前AI控制系统的水平，另一方面，跳舞和格斗，其实是机器人全身动作的一部分。“我们的目标一直是希望通过AI技术让机器人能做各种全身动作，来实现终极目标，去真正解放人类生产力。”</p><p style=\"text-align: start;\"><br></p><p style=\"text-align: start;\">王兴兴进一步解释道，这种展示不仅有助于训练和验证模型能力，也开始体现出一定的商业价值。今年上半年，人形机器人租赁市场就比较火爆，王兴兴认为，这也是一种产业价值的体现。</p><p style=\"text-align: start;\">北京人形机器人创新中心总经理熊友军也表示，接下来的“世界人形机器人运动会”，不仅包括格斗等竞技类项目，还将引入短跑、接力、足球、舞蹈等来自人类场景的形式。同时，赛事中还包含多个真实生活和工业场景，如工厂的物流搬运、医院的医药分拣、酒店的服务应用等。</p><p style=\"text-align: start;\">熊友军表示，这些比赛场景来自具体的企业提出的真实场景需求，和机器人即将走入现实的生活密切相关。“这是一个很好的训练场，对提升机器的技术有很大帮助，也是潜在客户了解和跟机器人企业沟通的桥梁。”</p><p style=\"text-align: start;\">尽管表演与赛事火热，但具身智能产业化真正的关键仍是“干活”能力的打造。对此，银河通用创始人王鹤指出，当前行业已经有许多炫酷技能，但需要反思的是，如果在真实环境下无法保证成功率，这些技能的产业价值就非常有限。</p><p style=\"text-align: start;\">王鹤介绍，银河通用与智源研究院的联合团队正在重点攻关“通用移动抓取”任务，即通过导航与抓取组合，让机器人在货架等实际工作场景中完成复杂动作。王鹤透露，银河通用的机器人已经在北京值守7家24小时无人药店，由人形机器人完成取药和对接骑手的任务。他进一步强调，希望赛事和应用场景能进一步打通，用赛事去引领有价值的、可落地的技能。</p><p style=\"text-align: center;\"><img src=\"https://img-s.msn.cn/tenant/amp/entityid/AA1GdDQI.img?w=768&amp;h=512&amp;m=6\" alt=\"大模型热潮第三年，“AI春晚”又换主角 为什么是具身智能？\" data-href=\"\" style=\"width: auto !important;\"></p><p style=\"text-align: start;\"><span style=\"color: rgb(255, 255, 255);\">大模型热潮第三年，“AI春晚”又换主角 为什么是具身智能？</span></p><p style=\"text-align: start;\">人形机器人现场展示格斗 主办方供图</p><h2 style=\"text-align: start;\">人形还是非人形？</h2><p style=\"text-align: start;\">在AI模型“上天入地”的浪潮中，被称为“AI+机器人”终极形态的具身智能，正成为产业界和学术界同时瞄准的下一个技术制高点。</p><p style=\"text-align: start;\">“其实我一直不坚持一定要做（成）人形（机器人）。”在谈到人形机器人是否是具身智能唯一形态时，王兴兴表示，从工程实践角度出发，宇树科技早期做机器狗，转向人形机器人属于“顺理成章”。在一些场景中，用轮式底盘替代腿部同样非常实用。</p><p style=\"text-align: start;\">“但为什么大家现在喜欢用人形，尤其上半身保留人的样子？核心是因为现在AI大部分还是依赖人来做数据采集。”王兴兴解释说，人形机器人上半身动作和人类一致，可以让AI采集数据、训练模型都更加方便，“包括我们机器人跳舞或者做一些格斗和别的比赛，说实在的，如果你做成别的样子就没办法做这个事情”。</p><p style=\"text-align: start;\"><br></p><p style=\"text-align: start;\">不过王兴兴也明确指出，未来随着AGI的诞生，机器人的形态将会“千奇百怪”，比现在要多非常多倍，甚至多100倍都有可能。但在当前阶段，人形形态仍在数据采集、模型训练和落地效率上具备“实用主义”的优势。</p><p style=\"text-align: start;\">与王兴兴偏向技术现实主义的观点不同，熊友军更看重人形在未来市场中的地位。他认为，虽然从技术上讲，具身智能载体可以多种多样，但“人形机器人是具身智能发展、研究的最佳载体”。他指出，未来具身智能的最大应用场景不是工业，而是家庭和商用服务，“今天工厂场景只是‘开胃小菜’”。</p><p style=\"text-align: start;\">熊友军认为，人形机器人更容易被人接受。它们会成为生活中的伙伴、朋友，甚至像现在很多年轻人所说的——可能是爱人。这种人机交互的自然程度是其他形态难以比拟的。他还补充道，人形机器人适配人类环境的成本更低，如果不是人形，就可能需要为机器人改造环境。这在实际部署中会带来额外成本。熊友军表示，长期来看，人形仍是具身智能最具发展潜力的形态。</p><p style=\"text-align: center;\"><img src=\"https://img-s.msn.cn/tenant/amp/entityid/AA1GdBoh.img?w=768&amp;h=512&amp;m=6\" alt=\"大模型热潮第三年，“AI春晚”又换主角 为什么是具身智能？\" data-href=\"\" style=\"width: auto !important;\"></p><p style=\"text-align: start;\"><span style=\"color: rgb(255, 255, 255);\">大模型热潮第三年，“AI春晚”又换主角 为什么是具身智能？</span></p><p style=\"text-align: start;\">展区机器狗 主办方供图</p><p style=\"text-align: start;\">在形态问题的背后，具身智能的“智能”来源何处，是另一个争议核心。自动驾驶中，VLA（视觉语言动作模型）已成为主流解决方案，但面对具身智能中复杂度更高的任务环境，VLA能否“泛化”仍待验证。</p><p style=\"text-align: start;\">王鹤认为，自动驾驶的经验已初步证明了“端到端”方案有更好的扩展性，不依赖无穷无尽的规则，而是通过数据去驱动模型。他表示，VLA的意义在于，通过视觉观测和自然语言指令，直接输出动作决策，中间不再需要其他环节。这种路径可以让模型更充分地吸收数据背后的知识，发挥出最大的性能，而不受制于模块化方案。</p><p style=\"text-align: start;\">不过，王鹤也直言，目前VLA是具身智能研究的热点，只是针对VLA究竟要突破什么，行业同样有不同观点。比如，有人希望把人类能做的所有事情都整合到VLA中，形成一个基座模型。王鹤认为这太着急了。他指出，人类认知不是只有视觉和语言，还包括力觉、触觉、嗅觉、味觉、温觉、听觉⋯⋯“所以VLA只能是一个起点，要想真正做到人类级别的具身智能，只能不断融合新的模态。”</p><p style=\"text-align: start;\"><br></p><p style=\"text-align: start;\">王鹤认为，目前VLA最适合的任务是移动、抓取和放置。这些以视觉为主，加上末端的触觉或力觉传感器即可执行，这类任务在工业和服务场景中已经足够广泛，如果能先将这类VLA模型做扎实，“将会是具身智能真正第一次高潮的到来”。</p><p style=\"text-align: start;\">穹彻智能联合创始⼈、上海交通⼤学教授、上海创智学院副院⻓卢策吾则补充，VLA模型“确实集合了机器人几件要干的事”——Vision（视觉）理解世界，Language（语言）与人类沟通，Action（动作）改变世界。但他也指出VLA当前存在很大的限制。具身智能面对的物理世界比无人驾驶复杂得多，无人车只需在两个维度做决策，且场景相对固定，而通用具身智能的场景是开放且有接触的，空间更大、不确定性更多。因此，要做到通用，就要压缩它的“不确定性”，并不停地在兼容框架中增加更多额外信息，在端到端的模型里压缩它的空间。</p><p style=\"text-align: start;\">此外，他强调对物理世界理解能力的增强也是“压缩任务空间”的关键。穹彻团队在其第二代“机器人大脑”中，加入了“数字基因”“仿真数据资产”等模块，希望通过仿真产生大量数据，减少真实世界中训练对样本量的依赖。卢策吾认为，找到更聪明的方式理解世界，把它们融合到VLA里，才可能真正推动通用智能的拐点出现。</p><p style=\"text-align: start;\">从人形机器人的路径分歧，到VLA模型的能力边界，在具身智能这条路上，数据仍是燃料，形态仍有博弈。但最终，理解世界并与之交互的能力，或许才是决定智能生命形态的关键点。</p>', 0, 0, 0, '/uploads/img/c0d2fa0f-5cc8-4bb6-ae5b-a95b324715c0.jpg', '2025-06-07 20:11:45', 0, '2025-06-08 20:08:32');
INSERT INTO `information` VALUES (26005, 2001, '123213', '<p>123213213213213</p>', 0, 0, 0, '', '2025-06-07 20:46:31', 1, '2025-06-08 04:56:22');
INSERT INTO `information` VALUES (26006, 2001, '21312', '<p>12321321</p>', 0, 0, 0, '', '2025-06-07 21:01:03', 1, '2025-06-08 05:01:05');
INSERT INTO `information` VALUES (26007, 2001, '十款大模型挑战高考作文：“新考生”DeepSeek夺冠，GPT第二，豆包和Kimi有点掉队', '<p style=\"text-align: justify;\"><br></p><p style=\"text-align: justify;\"><img src=\"https://n.sinaimg.cn/spider20250607/624/w1712h3712/20250607/36a8-a268bf3edb79ec799acb3995d8935f30.jpg\" alt=\"\" data-href=\"\" style=\"\"></p><p style=\"text-align: start;\">出品 | 搜狐科技&amp;搜狐教育</p><p style=\"text-align: start;\">作者 | 梁昌均</p><p style=\"text-align: start;\">6月7日，2025年全国高考拉开大幕。过去两年，搜狐科技&amp;搜狐教育均联合推出大模型参加高考系列策划，今年我们继续让大模型挑战高考作文。</p><p style=\"text-align: start;\">今年大模型考生还是10款模型，包括GPT-4.5、DeepSeek、通义千问、讯飞星火、文心一言、豆包、元宝、Kimi、学而思和商汤商量。今年高考作文试题我们选的是全国一卷，要求如下。</p><p style=\"text-align: start;\">在10款大模型答题结束后，我们邀请到四位高中语文教学名师，分别对这些作文进行了盲审盲评，并根据平均分进行成绩排序。</p><p style=\"text-align: start;\">结果显示，DeepSeek以54.25分的平均分夺得第一；GPT-4.5、腾讯元宝则各自以53分、51.75的成绩分列第二、第三，百度文心一言平均分达到51，这四款模型则是此次得分均超过50分的考生。</p><p style=\"text-align: start;\">今年是DeepSeek首次参加高考作文测评，并直接获得第一。北京市特级教师、北师大二附中语文老师何杰，以及北京中学语文高级教师，北京市骨干教师房树洪均对DeepSeek所写作文打出了55的高分，河南省骨干教师、信阳大别山高级中学语文老师陈光则给这篇文章打了54分。</p><p style=\"text-align: start;\">何杰老师认为，该文审题准确，认识深刻，从表达者深沉的情感入手，探讨表达者声音的实质与特点，显示出写作者对于文艺学知识的谙熟与深刻认知，成文有感染力。房树洪老师则表示，该文对概念的界定客观准确，为下文的论证奠定了较好的基础，论据较充实。</p><p style=\"text-align: start;\">这很大程度得益于DeepSeek模型的最新升级——最近更新的推理模型R1-0528，其思考更深，推理更强，测评表现在国内所有模型中首屈一指，并接近OpenAI的o3、谷歌Gemini-2.5-Pro等国际顶尖模型。</p><p style=\"text-align: start;\">同时，更新后的模型文本能力也有所升级。DeepSeek此前提到，在创意写作方面，R1-0528针对议论文、小说、散文等文体进行了进一步优化，能够输出篇幅更长、结构内容更完整的长篇作品，同时呈现出更加贴近人类偏好的写作风格，并降低了幻觉率。正高级教师、语文特级教师刘可翔就提到，该文语言表达较有韵味。</p><p style=\"text-align: start;\">GPT-4.5依然是此次十款大模型考生中唯一的外国考生，其是OpenAI今年2月发布的最新大模型版本。当时OpenAI声称GPT-4.5是“迄今规模最大、知识最丰富的模型”，能更精准理解用户意图，拥有更高的情商。</p><p style=\"text-align: start;\">在搜狐科技过往两年的高考作文评测中，OpenAI的GPT模型均位居第一，此次则被国产模型DeepSeek撼动，排名掉到了第二，平均分成绩53分。</p><p style=\"text-align: start;\">房树洪老师对GPT-4.5所写的作文点评到：面对困难与痛苦时竭力发出真实而向上的声音，阐释清晰，层次分明，纵横交错，但有些地方有点局限于“声音”本身，并打出了56的高分。</p><p style=\"text-align: start;\">刘可翔老师则给出54分，认为该文立意准确，逻辑性较强，能结合现实写作，引导人们怎么做，但深刻性方面还有待提高。</p><p style=\"text-align: start;\">腾讯元宝的表现依然不错，获得51.75的平均分，位居第三，其在去年则排名第二，仅次于GPT-4o。该产品基于腾讯自研的混元大模型，其在高质量的内容创作、数理逻辑、代码生成、多轮对话等性能表现优越。</p><p style=\"text-align: start;\">房树洪老师给元宝作文打出了55分，认为其由表及里，从具象到抽象，逐步展现了对问题的深入思考，指出了“声音”的不用表现形式。何杰老师认为，对题目要求理解正确且独特，举例与引述丰富，体现出丰富的语言积累，但文章论述不够深入。</p><p style=\"text-align: start;\">百度文心一言的表现也还不错，排名则从去年的第三落到第四，这两次成绩都是51分。也就是说，如果没有黑马DeepSeek今年杀出，今年高考作文评测前三名和去年一致，均为OpenAI的GPT模型、腾讯元宝和百度文心一言，可以说头部阵营非常稳固。</p><p style=\"text-align: start;\">去年均有参与评测的阿里通义千问、讯飞星火、字节豆包、月之暗面Kimi，今年成绩集中在47-49分之内；其中通义千问进步比较明显，排名从去年的第八升到了今年的第五，豆包和Kimi排名和得分均有所下降。</p><p style=\"text-align: start;\"><strong>商汤商量和学而思则位于最后两名，得分均在43左右。需要指出的是，学而思采用九章大模型进行评测，其主要是面向数学领域打造的大模型，可能并不擅长语文。</strong></p><p style=\"text-align: start;\"><img src=\"https://n.sinaimg.cn/spider20250607/312/w856h1856/20250607/976e-766f4de79771fef8aced10c77f612649.jpg\" alt=\"\" data-href=\"\" style=\"\"></p><p style=\"text-align: start;\">2024年十款大模型参加高考作文的成绩单</p><p style=\"text-align: start;\">整体来看，此次十款大模型在今年高考作文的表现比较悬殊，最高分和最低分的分值差达11分（去年为7分），显示模型之间能力差距有所扩大。</p><p style=\"text-align: start;\">同时，值得注意的是，此次评测除GPT-4.5、学而思外，其余模型均开启推理模式。因而在作答过程中，这些考生会先对题目材料和要求进行分析确认，像真正参加高考的学生们一样去审题并思考如何下笔。</p><p style=\"text-align: start;\">过往两次评测中，不少模型出现的缺少题目、字数不够等问题，这次基本没有出现（仅学而思出现字数不够的情况），评分老师在点评中多次提到文章审题准确。这也在一定程度上反映出，推理能力的提高对提升模型的文本能力有促进作用。</p><p style=\"text-align: start;\">这其中GPT-4.5是个例外，其并不具备类似推理模型o1或DeepSeek的链式推理功能，但其采用了无监督学习，用于增强词汇知识和直觉，并增强了推理能力，能以更低延迟提供更高水平的推理能力，因此取得不错表现。</p><p style=\"text-align: start;\">另外，从写作风格来看，此前两次高考作文测试中，不少大模型在内容结构上喜欢用首先、其次、另外、最后、综上所述等进行上下文的起承转合，总体给人感觉稍显呆板。</p><p style=\"text-align: start;\">这次测试，多数模型已放弃了这种方式，表明模型的表达风格更为自然，更加拟人。不少模型还有较多的举例论证或引用，但部分模型在内容深度上还有待加强。</p><p style=\"text-align: start;\">这十位大模型考生写的高考作文到底怎么样？可点击下文链接查看。</p><p style=\"text-align: start;\">DeepSeek：裂帛之声</p><p style=\"text-align: start;\">GPT-4.5：即使嘶哑 也要高歌</p><p style=\"text-align: start;\">元宝：沉默中的歌唱 论苦难时代的精神表达</p><p style=\"text-align: start;\">文心一言：以歌为刃 破晓而行</p><p style=\"text-align: start;\">通义千问：以血肉之躯，铸民族之声</p><p style=\"text-align: start;\">讯飞星火：心怀热忱 共谱时代华章</p><p style=\"text-align: start;\">豆包：嘶哑喉咙里的民族强音</p><p style=\"text-align: start;\">Kimi：心系家国 声嘶力竭亦无悔</p><p style=\"text-align: start;\">商汤商量：歌者无声处 赤子有回声</p><p style=\"text-align: start;\">学而思：歌唱的力量 民族精神的传承与弘扬</p>', 0, 0, 3, '/uploads/img/8ee2c0c9-1614-44f2-bfd6-5c96fced1849.jpg', '2025-06-08 12:13:10', 0, '2025-06-10 16:12:55');
INSERT INTO `information` VALUES (26008, 2001, '什么是大模型（LLMs）？一文读懂什么是大模型', '<p style=\"text-align: left; line-height: 2;\">“<a href=\"https://www.aigc.cn/large-models\" target=\"\">大模型</a>”（Large Language Models）通常指的是在<a href=\"https://www.aigc.cn/encyclopedia-of-artificial-intelligence\" target=\"_blank\">人工智能</a>领域中，具有大量参数的深度学习模型。这些模型通过训练大规模的数据集来学习复杂的模式和关系，从而在各种任务中表现出色。以下是对大模型的一些详细解释：</p><ol><li style=\"text-align: left;\"><strong>定义</strong>：</li><li style=\"text-align: left;\"><strong>类型</strong>：</li><li style=\"text-align: left;\"><strong>训练</strong>：</li><li style=\"text-align: left;\"><strong>优势</strong>：</li><li style=\"text-align: left;\"><strong>挑战</strong>：</li><li style=\"text-align: left;\"><strong>应用</strong>：</li><li style=\"text-align: left;\"><strong>发展趋势</strong>：</li></ol><p style=\"text-align: left; line-height: 2;\">大模型是人工智能领域的重要发展方向，它们在多个领域展现出强大的能力，但同时也带来了一系列挑战和问题，需要研究者、开发者和政策制定者共同努力来解决。</p><p style=\"text-align: left; line-height: 2;\">下文从大模型的基本概念出发，对大模型领域容易混淆的相关概念进行区分，并就大模型的发展历程、特点和分类、泛化与微调进行了详细解读，供大家在了解大模型基本知识的过程中起到一定参考作用。</p><h2 style=\"text-align: left;\">本文目录如下：</h2><ul><li style=\"text-align: left;\">大模型的定义</li><li style=\"text-align: left;\">大模型相关概念区分</li><li style=\"text-align: left;\">大模型的发展历程</li><li style=\"text-align: left;\">大模型的特点</li><li style=\"text-align: left;\">大模型的分类</li><li style=\"text-align: left;\">大模型的泛化与微调</li><li style=\"text-align: left;\">什么是大型语言模型？</li><li style=\"text-align: left;\">第一个大型语言模型是什么？</li><li style=\"text-align: left;\">大型语言模型的类型有哪些？</li><li style=\"text-align: left;\">基于自编码器的模型（Autoencoder-Based Model）</li><li style=\"text-align: left;\">列到序列模型（Sequence-to-Sequence Model）</li><li style=\"text-align: left;\">于Transformer的模型（Transformer-Based Models）</li><li style=\"text-align: left;\">归神经网络模型（Recursive Neural Network Models）</li><li style=\"text-align: left;\">层模型（Hierarchical Models）</li><li style=\"text-align: left;\">型语言模型是如何工作的？</li><li style=\"text-align: left;\">嵌入（Word Embedding）</li><li style=\"text-align: left;\">位置编码（Positional Encoding）</li><li style=\"text-align: left;\">自注意力机制（Self-Attention Mechanism）</li><li style=\"text-align: left;\">前馈神经网络（Feed-forward Neural Network）</li><li style=\"text-align: left;\">Transformers</li><li style=\"text-align: left;\">文本生成</li><li style=\"text-align: left;\">人类引导强化学习提升人工智能性能</li><li style=\"text-align: left;\">大型语言模型的例子</li><li style=\"text-align: left;\">BERT</li><li style=\"text-align: left;\">GPT-4</li><li style=\"text-align: left;\">大型语言模型的未来</li></ul><p style=\"text-align: left; line-height: 2;\"><strong>1.</strong> <strong>大模型的定义</strong></p><p style=\"text-align: left; line-height: 2;\"><strong>大模型是指具有大规模参数和复杂计算结构的机器学习模型。</strong>这些模型通常由<a href=\"https://www.aigc.cn/go/?url=aHR0cHM6Ly9saW5rLnpoaWh1LmNvbS8%2FdGFyZ2V0PWh0dHBzJTNBLy94aWUuaW5mb3EuY24vbGluayUzRnRhcmdldCUzRGh0dHBzJTI1M0ElMjUyRiUyNTJGd3d3LnpoaWh1LmNvbSUyNTJGc2VhcmNoJTI1M0ZxJTI1M0QlMjUyNUU2JTI1MjVCNyUyNTI1QjElMjUyNUU1JTI1MjVCQSUyNTI1QTYlMjUyNUU3JTI1MjVBNSUyNTI1OUUlMjUyNUU3JTI1MjVCQiUyNTI1OEYlMjUyNUU3JTI1MjVCRCUyNTI1OTElMjUyNUU3JTI1MjVCQiUyNTI1OUMlMjUyNnNlYXJjaF9zb3VyY2UlMjUzREVudGl0eSUyNTI2aHlicmlkX3NlYXJjaF9zb3VyY2UlMjUzREVudGl0eSUyNTI2aHlicmlkX3NlYXJjaF9leHRyYSUyNTNEJTI1MjU3QiUyNTI1MjJzb3VyY2VUeXBlJTI1MjUyMiUyNTI1M0ElMjUyNTIyYW5zd2VyJTI1MjUyMiUyNTI1MkMlMjUyNTIyc291cmNlSWQlMjUyNTIyJTI1MjUzQTMyNzE1MzM4MjQlMjUyNTdE\" target=\"_blank\">深度神经网络</a>构建而成，拥有数十亿甚至数千亿个参数。大模型的设计目的是为了提高模型的表达能力和预测性能，能够处理更加复杂的任务和数据。大模型在各种领域都有广泛的应用，包括自然语言处理、计算机视觉、语音识别和<a href=\"https://www.aigc.cn/go/?url=aHR0cHM6Ly9saW5rLnpoaWh1LmNvbS8%2FdGFyZ2V0PWh0dHBzJTNBLy94aWUuaW5mb3EuY24vbGluayUzRnRhcmdldCUzRGh0dHBzJTI1M0ElMjUyRiUyNTJGd3d3LnpoaWh1LmNvbSUyNTJGc2VhcmNoJTI1M0ZxJTI1M0QlMjUyNUU2JTI1MjU4RSUyNTI1QTglMjUyNUU4JTI1MjU4RCUyNTI1OTAlMjUyNUU3JTI1MjVCMyUyNTI1QkIlMjUyNUU3JTI1MjVCQiUyNTI1OUYlMjUyNnNlYXJjaF9zb3VyY2UlMjUzREVudGl0eSUyNTI2aHlicmlkX3NlYXJjaF9zb3VyY2UlMjUzREVudGl0eSUyNTI2aHlicmlkX3NlYXJjaF9leHRyYSUyNTNEJTI1MjU3QiUyNTI1MjJzb3VyY2VUeXBlJTI1MjUyMiUyNTI1M0ElMjUyNTIyYW5zd2VyJTI1MjUyMiUyNTI1MkMlMjUyNTIyc291cmNlSWQlMjUyNTIyJTI1MjUzQTMyNzE1MzM4MjQlMjUyNTdE\" target=\"_blank\">推荐系统</a>等。大模型通过训练海量数据来学习复杂的模式和特征，具有更强大的泛化能力，可以对未见过的数据做出准确的预测。</p><p style=\"text-align: left; line-height: 2;\">ChatGPT 对大模型的解释更为通俗易懂，也更体现出类似人类的归纳和思考能力：大模型本质上是一个使用海量数据训练而成的深度神经网络模型，其巨大的数据和参数规模，实现了智能的涌现，展现出类似人类的智能。</p><p style=\"text-align: left; line-height: 2;\"><strong>那么，大模型和小模型有什么区别？</strong></p><p style=\"text-align: left; line-height: 2;\">小模型通常指参数较少、层数较浅的模型，它们具有轻量级、高效率、易于部署等优点，适用于数据量较小、计算资源有限的场景，例如移动端应用、嵌入式设备、物联网等。</p><p style=\"text-align: left; line-height: 2;\">而当模型的训练数据和参数不断扩大，直到达到一定的临界规模后，其表现出了一些未能预测的、更复杂的能力和特性，模型能够从原始训练数据中自动学习并发现新的、更高层次的特征和模式，这种能力被称为“<a href=\"https://www.aigc.cn/go/?url=aHR0cHM6Ly9saW5rLnpoaWh1LmNvbS8%2FdGFyZ2V0PWh0dHBzJTNBLy94aWUuaW5mb3EuY24vbGluayUzRnRhcmdldCUzRGh0dHBzJTI1M0ElMjUyRiUyNTJGd3d3LnpoaWh1LmNvbSUyNTJGc2VhcmNoJTI1M0ZxJTI1M0QlMjUyNUU2JTI1MjVCNiUyNTI1OEMlMjUyNUU3JTI1MjU4RSUyNTI1QjAlMjUyNUU4JTI1MjU4MyUyNTI1QkQlMjUyNUU1JTI1MjU4QSUyNTI1OUIlMjUyNnNlYXJjaF9zb3VyY2UlMjUzREVudGl0eSUyNTI2aHlicmlkX3NlYXJjaF9zb3VyY2UlMjUzREVudGl0eSUyNTI2aHlicmlkX3NlYXJjaF9leHRyYSUyNTNEJTI1MjU3QiUyNTI1MjJzb3VyY2VUeXBlJTI1MjUyMiUyNTI1M0ElMjUyNTIyYW5zd2VyJTI1MjUyMiUyNTI1MkMlMjUyNTIyc291cmNlSWQlMjUyNTIyJTI1MjUzQTMyNzE1MzM4MjQlMjUyNTdE\" target=\"_blank\">涌现能力</a>”。而具备涌现能力的机器学习模型就被认为是独立意义上的大模型，这也是其和小模型最大意义上的区别。</p><p style=\"text-align: left; line-height: 2;\">相比小模型，大模型通常参数较多、层数较深，具有更强的表达能力和更高的准确度，但也需要更多的计算资源和时间来训练和推理，适用于数据量较大、计算资源充足的场景，例如云端计算、<a href=\"https://www.aigc.cn/go/?url=aHR0cHM6Ly9saW5rLnpoaWh1LmNvbS8%2FdGFyZ2V0PWh0dHBzJTNBLy94aWUuaW5mb3EuY24vbGluayUzRnRhcmdldCUzRGh0dHBzJTI1M0ElMjUyRiUyNTJGd3d3LnpoaWh1LmNvbSUyNTJGc2VhcmNoJTI1M0ZxJTI1M0QlMjUyNUU5JTI1MjVBQiUyNTI1OTglMjUyNUU2JTI1MjU4MCUyNTI1QTclMjUyNUU4JTI1MjU4MyUyNTI1QkQlMjUyNUU4JTI1MjVBRSUyNTI1QTElMjUyNUU3JTI1MjVBRSUyNTI1OTclMjUyNnNlYXJjaF9zb3VyY2UlMjUzREVudGl0eSUyNTI2aHlicmlkX3NlYXJjaF9zb3VyY2UlMjUzREVudGl0eSUyNTI2aHlicmlkX3NlYXJjaF9leHRyYSUyNTNEJTI1MjU3QiUyNTI1MjJzb3VyY2VUeXBlJTI1MjUyMiUyNTI1M0ElMjUyNTIyYW5zd2VyJTI1MjUyMiUyNTI1MkMlMjUyNTIyc291cmNlSWQlMjUyNTIyJTI1MjUzQTMyNzE1MzM4MjQlMjUyNTdE\" target=\"_blank\">高性能计算</a>、人工智能等。</p><p style=\"text-align: left; line-height: 2;\"><strong>2.</strong> <strong>大模型相关概念区分：</strong></p><p style=\"text-align: left; line-height: 2;\"><strong>大模型（Large Model,也称基础模型，即 Foundation Model），</strong>是指具有大量参数和复杂结构的机器学习模型，能够处理海量数据、完成各种复杂的任务，如自然语言处理、计算机视觉、语音识别等。</p><p style=\"text-align: left; line-height: 2;\"><strong>超大模型：</strong>超大模型是大模型的一个子集，它们的参数量远超过大模型。</p><p style=\"text-align: left; line-height: 2;\"><strong>大语言模型（Large Language Model）：</strong>通常是具有大规模参数和计算能力的自然语言处理模型，例如 OpenAI 的 GPT-3 模型。这些模型可以通过大量的数据和参数进行训练，以生成人类类似的文本或回答自然语言的问题。大型语言模型在自然语言处理、文本生成和智能对话等领域有广泛应用。</p><p style=\"text-align: left; line-height: 2;\"><strong>GPT（Generative Pre-trained Transformer）：</strong>GPT 和 ChatGPT 都是基于 Transformer 架构的语言模型，但它们在设计和应用上存在区别：GPT 模型旨在生成自然语言文本并处理各种自然语言处理任务，如文本生成、翻译、摘要等。它通常在单向生成的情况下使用，即根据给定的文本生成连贯的输出。</p><p style=\"text-align: left; line-height: 2;\"><strong>ChatGPT：</strong>ChatGPT 则专注于对话和交互式对话。它经过特定的训练，以更好地处理多轮对话和上下文理解。ChatGPT 设计用于提供流畅、连贯和有趣的对话体验，以响应用户的输入并生成合适的回复。</p><p style=\"text-align: left; line-height: 2;\"><strong>3.</strong> <strong>大模型的发展历程</strong></p><p style=\"text-align: left; line-height: 2;\"><img src=\"https://www.aigc.cn/wp-content/uploads/2024/01/v2-dac33d82783a9ea11427f48e09d20b94_720w.webp.jpg\" alt=\"v2-dac33d82783a9ea11427f48e09d20b94_720w.webp\" data-href=\"\" style=\"height: auto;\"></p><p style=\"text-align: left; line-height: 2;\"><strong>萌芽期（1950-2005）：以 CNN 为代表的传统神经网络模型阶段</strong></p><p style=\"text-align: left; line-height: 2;\"><strong>· </strong>1956 年，从计算机专家约翰·麦卡锡提出“人工智能”概念开始，AI 发展由最开始基于小规模专家知识逐步发展为基于机器学习。</p><p style=\"text-align: left; line-height: 2;\"><strong>·</strong> 1980 年，<a href=\"https://www.aigc.cn/go/?url=aHR0cHM6Ly9saW5rLnpoaWh1LmNvbS8%2FdGFyZ2V0PWh0dHBzJTNBLy94aWUuaW5mb3EuY24vbGluayUzRnRhcmdldCUzRGh0dHBzJTI1M0ElMjUyRiUyNTJGd3d3LnpoaWh1LmNvbSUyNTJGc2VhcmNoJTI1M0ZxJTI1M0QlMjUyNUU1JTI1MjU4RCUyNTI1QjclMjUyNUU3JTI1MjVBNyUyNTI1QUYlMjUyNUU3JTI1MjVBNSUyNTI1OUUlMjUyNUU3JTI1MjVCQiUyNTI1OEYlMjUyNUU3JTI1MjVCRCUyNTI1OTElMjUyNUU3JTI1MjVCQiUyNTI1OUMlMjUyNnNlYXJjaF9zb3VyY2UlMjUzREVudGl0eSUyNTI2aHlicmlkX3NlYXJjaF9zb3VyY2UlMjUzREVudGl0eSUyNTI2aHlicmlkX3NlYXJjaF9leHRyYSUyNTNEJTI1MjU3QiUyNTI1MjJzb3VyY2VUeXBlJTI1MjUyMiUyNTI1M0ElMjUyNTIyYW5zd2VyJTI1MjUyMiUyNTI1MkMlMjUyNTIyc291cmNlSWQlMjUyNTIyJTI1MjUzQTMyNzE1MzM4MjQlMjUyNTdE\" target=\"_blank\">卷积神经网络</a>的雏形 CNN 诞生。</p><p style=\"text-align: left; line-height: 2;\"><strong>· </strong>1998 年，现代卷积神经网络的基本结构 LeNet-5 诞生，机器学习方法由早期基于浅层机器学习的模型，变为了基于深度学习的模型,为自然语言生成、计算机视觉等领域的深入研究奠定了基础，对后续深度学习框架的迭代及大模型发展具有开创性的意义。</p><p style=\"text-align: left; line-height: 2;\"><strong>探索沉淀期（2006-2019）：以 Transformer 为代表的全新神经网络模型阶段</strong></p><p style=\"text-align: left; line-height: 2;\"><strong>· </strong>2013 年，自然语言处理模型 Word2Vec 诞生，首次提出将单词转换为向量的“词<a href=\"https://www.aigc.cn/go/?url=aHR0cHM6Ly9saW5rLnpoaWh1LmNvbS8%2FdGFyZ2V0PWh0dHBzJTNBLy94aWUuaW5mb3EuY24vbGluayUzRnRhcmdldCUzRGh0dHBzJTI1M0ElMjUyRiUyNTJGd3d3LnpoaWh1LmNvbSUyNTJGc2VhcmNoJTI1M0ZxJTI1M0QlMjUyNUU1JTI1MjU5MCUyNTI1OTElMjUyNUU5JTI1MjU4NyUyNTI1OEYlMjUyNUU2JTI1MjVBOCUyNTI1QTElMjUyNUU1JTI1MjU5RSUyNTI1OEIlMjUyNnNlYXJjaF9zb3VyY2UlMjUzREVudGl0eSUyNTI2aHlicmlkX3NlYXJjaF9zb3VyY2UlMjUzREVudGl0eSUyNTI2aHlicmlkX3NlYXJjaF9leHRyYSUyNTNEJTI1MjU3QiUyNTI1MjJzb3VyY2VUeXBlJTI1MjUyMiUyNTI1M0ElMjUyNTIyYW5zd2VyJTI1MjUyMiUyNTI1MkMlMjUyNTIyc291cmNlSWQlMjUyNTIyJTI1MjUzQTMyNzE1MzM4MjQlMjUyNTdE\" target=\"_blank\">向量模型</a>”，以便计算机更好地理解和处理文本数据。</p><p style=\"text-align: left; line-height: 2;\"><strong>· </strong>2014 年，被誉为 21 世纪最强大算法模型之一的 GAN（对抗式生成网络）诞生，标志着深度学习进入了生成模型研究的新阶段。</p><p style=\"text-align: left; line-height: 2;\"><strong>· </strong>2017 年，Google 颠覆性地提出了基于自注意力机制的神经网络结构——Transformer 架构，奠定了大模型预训练算法架构的基础。</p><p style=\"text-align: left; line-height: 2;\"><strong>· </strong>2018 年，OpenAI 和 Google 分别发布了 GPT-1 与 BERT 大模型，意味着预训练大模型成为自然语言处理领域的主流。在探索期，以 Transformer 为代表的全新神经网络架构，奠定了大模型的算法架构基础，使大模型技术的性能得到了显著提升。</p><p style=\"text-align: left; line-height: 2;\"><strong>迅猛发展期（2020-至今）：以 GPT 为代表的预训练大模型阶段</strong></p><p style=\"text-align: left; line-height: 2;\"><strong>· </strong>2020 年，OpenAI 公司推出了GPT-3，模型参数规模达到了 1750 亿，成为当时最大的语言模型，并且在零样本学习任务上实现了巨大性能提升。随后，更多策略如基于人类反馈的强化学习（RHLF）、代码预训练、<a href=\"https://www.aigc.cn/go/?url=aHR0cHM6Ly9saW5rLnpoaWh1LmNvbS8%2FdGFyZ2V0PWh0dHBzJTNBLy94aWUuaW5mb3EuY24vbGluayUzRnRhcmdldCUzRGh0dHBzJTI1M0ElMjUyRiUyNTJGd3d3LnpoaWh1LmNvbSUyNTJGc2VhcmNoJTI1M0ZxJTI1M0QlMjUyNUU2JTI1MjU4QyUyNTI1ODclMjUyNUU0JTI1MjVCQiUyNTI1QTQlMjUyNUU1JTI1MjVCRSUyNTI1QUUlMjUyNUU4JTI1MjVCMCUyNTI1ODMlMjUyNnNlYXJjaF9zb3VyY2UlMjUzREVudGl0eSUyNTI2aHlicmlkX3NlYXJjaF9zb3VyY2UlMjUzREVudGl0eSUyNTI2aHlicmlkX3NlYXJjaF9leHRyYSUyNTNEJTI1MjU3QiUyNTI1MjJzb3VyY2VUeXBlJTI1MjUyMiUyNTI1M0ElMjUyNTIyYW5zd2VyJTI1MjUyMiUyNTI1MkMlMjUyNTIyc291cmNlSWQlMjUyNTIyJTI1MjUzQTMyNzE1MzM4MjQlMjUyNTdE\" target=\"_blank\">指令微调</a>等开始出现, 被用于进一步提高推理能力和任务泛化。</p><p style=\"text-align: left; line-height: 2;\"><strong>· </strong>2022 年 11 月，搭载了GPT3.5的 ChatGPT横空出世，凭借逼真的自然语言交互与多场景内容生成能力，迅速引爆互联网。</p><p style=\"text-align: left; line-height: 2;\"><strong>· </strong>2023 年 3 月，最新发布的超大规模<a href=\"https://www.aigc.cn/go/?url=aHR0cHM6Ly9saW5rLnpoaWh1LmNvbS8%2FdGFyZ2V0PWh0dHBzJTNBLy94aWUuaW5mb3EuY24vbGluayUzRnRhcmdldCUzRGh0dHBzJTI1M0ElMjUyRiUyNTJGd3d3LnpoaWh1LmNvbSUyNTJGc2VhcmNoJTI1M0ZxJTI1M0QlMjUyNUU1JTI1MjVBNCUyNTI1OUElMjUyNUU2JTI1MjVBOCUyNTI1QTElMjUyNUU2JTI1MjU4MCUyNTI1ODElMjUyNnNlYXJjaF9zb3VyY2UlMjUzREVudGl0eSUyNTI2aHlicmlkX3NlYXJjaF9zb3VyY2UlMjUzREVudGl0eSUyNTI2aHlicmlkX3NlYXJjaF9leHRyYSUyNTNEJTI1MjU3QiUyNTI1MjJzb3VyY2VUeXBlJTI1MjUyMiUyNTI1M0ElMjUyNTIyYW5zd2VyJTI1MjUyMiUyNTI1MkMlMjUyNTIyc291cmNlSWQlMjUyNTIyJTI1MjUzQTMyNzE1MzM4MjQlMjUyNTdE\" target=\"_blank\">多模态</a>预训练大模型——GPT-4，具备了多模态理解与多类型内容生成能力。在迅猛发展期，大数据、大算力和大算法完美结合，大幅提升了大模型的预训练和生成能力以及多模态多场景应用能力。如 ChatGPT 的巨大成功,就是在微软Azure强大的算力以及 wiki 等海量数据支持下，在 Transformer 架构基础上，坚持 GPT 模型及人类反馈的强化学习（RLHF）进行精调的策略下取得的。</p><p style=\"text-align: left; line-height: 2;\"><strong>4.</strong> <strong>大模型的特点</strong></p><p style=\"text-align: left; line-height: 2;\"><strong>· 巨大的规模: </strong>大模型包含数十亿个参数，模型大小可以达到数百 GB 甚至更大。巨大的模型规模使大模型具有强大的表达能力和学习能力。</p><p style=\"text-align: left; line-height: 2;\"><strong>· 涌现能力：</strong>涌现（英语：emergence）或称创发、突现、呈展、演生，是一种现象，为许多小实体相互作用后产生了大实体，而这个大实体展现了组成它的小实体所不具有的特性。引申到模型层面，涌现能力指的是当模型的训练数据突破一定规模，模型突然涌现出之前小模型所没有的、意料之外的、能够综合分析和解决更深层次问题的复杂能力和特性，展现出类似人类的思维和智能。<strong>涌现能力也是大模型最显著的特点之一。</strong></p><p style=\"text-align: left; line-height: 2;\"><strong>· 更好的性能和泛化能力： </strong>大模型通常具有更强大的学习能力和泛化能力，能够在各种任务上表现出色，包括自然语言处理、图像识别、语音识别等。</p><p style=\"text-align: left; line-height: 2;\"><strong>· 多任务学习:</strong> 大模型通常会一起学习多种不同的 NLP 任务,如机器翻译、文本摘要、问答系统等。这可以使模型学习到更广泛和泛化的语言理解能力。</p><p style=\"text-align: left; line-height: 2;\"><strong>· 大数据训练</strong>: 大模型需要海量的数据来训练,通常在 TB 以上甚至 PB 级别的数据集。只有大量的数据才能发挥大模型的参数规模优势。</p><p style=\"text-align: left; line-height: 2;\"><strong>· 强大的计算资源</strong>: 训练大模型通常需要数百甚至上千个 GPU,以及大量的时间,通常在几周到几个月。</p><p style=\"text-align: left; line-height: 2;\"><strong>· 迁移学习和预训练</strong>： 大模型可以通过在大规模数据上进行预训练，然后在特定任务上进行微调，从而提高模型在新任务上的性能。</p><p style=\"text-align: left; line-height: 2;\"><strong>· 自监督学习</strong>： 大模型可以通过自监督学习在大规模未标记数据上进行训练，从而减少对标记数据的依赖，提高模型的效能。</p><p style=\"text-align: left; line-height: 2;\"><strong>· 领域知识融合</strong>： 大模型可以从多个领域的数据中学习知识，并在不同领域中进行应用，促进跨领域的创新。</p><p style=\"text-align: left; line-height: 2;\"><strong>· 自动化和效率</strong>：大模型可以自动化许多复杂的任务，提高工作效率，如自动编程、自动翻译、自动摘要等。</p><p style=\"text-align: left; line-height: 2;\"><strong>5.</strong> <strong>大模型的分类</strong></p><p style=\"text-align: left; line-height: 2;\">按照输入数据类型的不同，大模型主要可以分为以下三大类：</p><p style=\"text-align: left; line-height: 2;\"><img src=\"https://www.aigc.cn/wp-content/uploads/2024/01/v2-442579f2183a20c335729d2e0276a93c_720w.webp.jpg\" alt=\"v2-442579f2183a20c335729d2e0276a93c_720w.webp\" data-href=\"\" style=\"height: auto;\"></p><p style=\"text-align: left; line-height: 2;\"><strong>· 语言大模型（NLP）</strong>：是指在自然语言处理（Natural Language Processing，NLP）领域中的一类大模型，通常用于处理文本数据和理解自然语言。这类大模型的主要特点是它们在大规模语料库上进行了训练，以学习自然语言的各种语法、语义和语境规则。例如：GPT 系列（OpenAI）、Bard（Google）、<a href=\"https://www.aigc.cn/go/?url=aHR0cHM6Ly9saW5rLnpoaWh1LmNvbS8%2FdGFyZ2V0PWh0dHBzJTNBLy94aWUuaW5mb3EuY24vbGluayUzRnRhcmdldCUzRGh0dHBzJTI1M0ElMjUyRiUyNTJGd3d3LnpoaWh1LmNvbSUyNTJGc2VhcmNoJTI1M0ZxJTI1M0QlMjUyNUU2JTI1MjU5NiUyNTI1ODclMjUyNUU1JTI1MjVCRiUyNTI1ODMlMjUyNUU0JTI1MjVCOCUyNTI1ODAlMjUyNUU4JTI1MjVBOCUyNTI1ODAlMjUyNnNlYXJjaF9zb3VyY2UlMjUzREVudGl0eSUyNTI2aHlicmlkX3NlYXJjaF9zb3VyY2UlMjUzREVudGl0eSUyNTI2aHlicmlkX3NlYXJjaF9leHRyYSUyNTNEJTI1MjU3QiUyNTI1MjJzb3VyY2VUeXBlJTI1MjUyMiUyNTI1M0ElMjUyNTIyYW5zd2VyJTI1MjUyMiUyNTI1MkMlMjUyNTIyc291cmNlSWQlMjUyNTIyJTI1MjUzQTMyNzE1MzM4MjQlMjUyNTdE\" target=\"_blank\">文心一言</a>（百度）。</p><p style=\"text-align: left; line-height: 2;\"><strong>· 视觉大模型（CV）</strong>：是指在计算机视觉（Computer Vision，CV）领域中使用的大模型，通常用于图像处理和分析。这类模型通过在大规模图像数据上进行训练，可以实现各种视觉任务，如<a href=\"https://www.aigc.cn/go/?url=aHR0cHM6Ly9saW5rLnpoaWh1LmNvbS8%2FdGFyZ2V0PWh0dHBzJTNBLy94aWUuaW5mb3EuY24vbGluayUzRnRhcmdldCUzRGh0dHBzJTI1M0ElMjUyRiUyNTJGd3d3LnpoaWh1LmNvbSUyNTJGc2VhcmNoJTI1M0ZxJTI1M0QlMjUyNUU1JTI1MjU5QiUyNTI1QkUlMjUyNUU1JTI1MjU4MyUyNTI1OEYlMjUyNUU1JTI1MjU4OCUyNTI1ODYlMjUyNUU3JTI1MjVCMSUyNTI1QkIlMjUyNnNlYXJjaF9zb3VyY2UlMjUzREVudGl0eSUyNTI2aHlicmlkX3NlYXJjaF9zb3VyY2UlMjUzREVudGl0eSUyNTI2aHlicmlkX3NlYXJjaF9leHRyYSUyNTNEJTI1MjU3QiUyNTI1MjJzb3VyY2VUeXBlJTI1MjUyMiUyNTI1M0ElMjUyNTIyYW5zd2VyJTI1MjUyMiUyNTI1MkMlMjUyNTIyc291cmNlSWQlMjUyNTIyJTI1MjUzQTMyNzE1MzM4MjQlMjUyNTdE\" target=\"_blank\">图像分类</a>、目标检测、<a href=\"https://www.aigc.cn/go/?url=aHR0cHM6Ly9saW5rLnpoaWh1LmNvbS8%2FdGFyZ2V0PWh0dHBzJTNBLy94aWUuaW5mb3EuY24vbGluayUzRnRhcmdldCUzRGh0dHBzJTI1M0ElMjUyRiUyNTJGd3d3LnpoaWh1LmNvbSUyNTJGc2VhcmNoJTI1M0ZxJTI1M0QlMjUyNUU1JTI1MjU5QiUyNTI1QkUlMjUyNUU1JTI1MjU4MyUyNTI1OEYlMjUyNUU1JTI1MjU4OCUyNTI1ODYlMjUyNUU1JTI1MjU4OSUyNTI1QjIlMjUyNnNlYXJjaF9zb3VyY2UlMjUzREVudGl0eSUyNTI2aHlicmlkX3NlYXJjaF9zb3VyY2UlMjUzREVudGl0eSUyNTI2aHlicmlkX3NlYXJjaF9leHRyYSUyNTNEJTI1MjU3QiUyNTI1MjJzb3VyY2VUeXBlJTI1MjUyMiUyNTI1M0ElMjUyNTIyYW5zd2VyJTI1MjUyMiUyNTI1MkMlMjUyNTIyc291cmNlSWQlMjUyNTIyJTI1MjUzQTMyNzE1MzM4MjQlMjUyNTdE\" target=\"_blank\">图像分割</a>、<a href=\"https://www.aigc.cn/go/?url=aHR0cHM6Ly9saW5rLnpoaWh1LmNvbS8%2FdGFyZ2V0PWh0dHBzJTNBLy94aWUuaW5mb3EuY24vbGluayUzRnRhcmdldCUzRGh0dHBzJTI1M0ElMjUyRiUyNTJGd3d3LnpoaWh1LmNvbSUyNTJGc2VhcmNoJTI1M0ZxJTI1M0QlMjUyNUU1JTI1MjVBNyUyNTI1QkYlMjUyNUU2JTI1MjU4MCUyNTI1ODElMjUyNUU0JTI1MjVCQyUyNTI1QjAlMjUyNUU4JTI1MjVBRSUyNTI1QTElMjUyNnNlYXJjaF9zb3VyY2UlMjUzREVudGl0eSUyNTI2aHlicmlkX3NlYXJjaF9zb3VyY2UlMjUzREVudGl0eSUyNTI2aHlicmlkX3NlYXJjaF9leHRyYSUyNTNEJTI1MjU3QiUyNTI1MjJzb3VyY2VUeXBlJTI1MjUyMiUyNTI1M0ElMjUyNTIyYW5zd2VyJTI1MjUyMiUyNTI1MkMlMjUyNTIyc291cmNlSWQlMjUyNTIyJTI1MjUzQTMyNzE1MzM4MjQlMjUyNTdE\" target=\"_blank\">姿态估计</a>、人脸识别等。例如：VIT 系列（Google）、<a href=\"https://www.aigc.cn/go/?url=aHR0cHM6Ly9saW5rLnpoaWh1LmNvbS8%2FdGFyZ2V0PWh0dHBzJTNBLy94aWUuaW5mb3EuY24vbGluayUzRnRhcmdldCUzRGh0dHBzJTI1M0ElMjUyRiUyNTJGd3d3LnpoaWh1LmNvbSUyNTJGc2VhcmNoJTI1M0ZxJTI1M0QlMjUyNUU2JTI1MjU5NiUyNTI1ODclMjUyNUU1JTI1MjVCRiUyNTI1ODNVRk8lMjUyNnNlYXJjaF9zb3VyY2UlMjUzREVudGl0eSUyNTI2aHlicmlkX3NlYXJjaF9zb3VyY2UlMjUzREVudGl0eSUyNTI2aHlicmlkX3NlYXJjaF9leHRyYSUyNTNEJTI1MjU3QiUyNTI1MjJzb3VyY2VUeXBlJTI1MjUyMiUyNTI1M0ElMjUyNTIyYW5zd2VyJTI1MjUyMiUyNTI1MkMlMjUyNTIyc291cmNlSWQlMjUyNTIyJTI1MjUzQTMyNzE1MzM4MjQlMjUyNTdE\" target=\"_blank\">文心UFO</a>、华为盘古 CV、INTERN（商汤）。</p><p style=\"text-align: left; line-height: 2;\"><strong>· 多模态大模型：</strong>是指能够处理多种不同类型数据的大模型，例如文本、图像、音频等多模态数据。这类模型结合了 NLP 和 CV 的能力，以实现对多模态信息的综合理解和分析，从而能够更全面地理解和处理复杂的数据。例如：DingoDB 多模向量数据库（九章云极 DataCanvas）、DALL-E(OpenAI)、悟空画画（华为）、midjourney。</p><p style=\"text-align: left; line-height: 2;\">按照应用领域的不同，大模型主要可以分为 L0、L1、L2 三个层级：</p><p style=\"text-align: left; line-height: 2;\"><strong>· 通用大模型 L0</strong>：是指可以在多个领域和任务上通用的大模型。它们利用大算力、使用海量的开放数据与具有巨量参数的深度学习算法，在大规模无标注数据上进行训练，以寻找特征并发现规律，进而形成可“举一反三”的强大泛化能力，可在不进行微调或少量微调的情况下完成多场景任务，相当于 AI 完成了“通识教育”。</p><p style=\"text-align: left; line-height: 2;\"><strong>· 行业大模型 L1</strong>：是指那些针对特定行业或领域的大模型。它们通常使用行业相关的数据进行预训练或微调，以提高在该领域的性能和准确度，相当于 AI 成为“行业专家”。</p><p style=\"text-align: left; line-height: 2;\"><strong>· 垂直大模型 L2</strong>：是指那些针对特定任务或场景的大模型。它们通常使用任务相关的数据进行预训练或微调，以提高在该任务上的性能和效果。</p><p style=\"text-align: left; line-height: 2;\"><strong>6.</strong> <strong>大模型的泛化与微调</strong></p><p style=\"text-align: left; line-height: 2;\"><strong>模型的泛化能力：</strong>是指一个模型在面对新的、未见过的数据时，能够正确理解和预测这些数据的能力。在机器学习和人工智能领域，模型的泛化能力是评估模型性能的重要指标之一。</p><p style=\"text-align: left; line-height: 2;\"><strong>什么是模型微调：</strong>给定预训练模型（Pre-trained model），基于模型进行微调（Fine Tune）。相对于从头开始训练(Training a model from scatch)，微调可以省去大量计算资源和计算时间，提高计算效率,甚至提高准确率。</p><p style=\"text-align: left; line-height: 2;\">模型微调的基本思想是使用少量带标签的数据对预训练模型进行再次训练，以适应特定任务。在这个过程中，模型的参数会根据新的数据分布进行调整。这种方法的好处在于，它利用了预训练模型的强大能力，同时还能够适应新的数据分布。因此，模型微调能够提高模型的泛化能力，减少<a href=\"https://www.aigc.cn/go/?url=aHR0cHM6Ly9saW5rLnpoaWh1LmNvbS8%2FdGFyZ2V0PWh0dHBzJTNBLy94aWUuaW5mb3EuY24vbGluayUzRnRhcmdldCUzRGh0dHBzJTI1M0ElMjUyRiUyNTJGd3d3LnpoaWh1LmNvbSUyNTJGc2VhcmNoJTI1M0ZxJTI1M0QlMjUyNUU4JTI1MjVCRiUyNTI1ODclMjUyNUU2JTI1MjU4QiUyNTI1OUYlMjUyNUU1JTI1MjU5MCUyNTI1ODglMjUyNnNlYXJjaF9zb3VyY2UlMjUzREVudGl0eSUyNTI2aHlicmlkX3NlYXJjaF9zb3VyY2UlMjUzREVudGl0eSUyNTI2aHlicmlkX3NlYXJjaF9leHRyYSUyNTNEJTI1MjU3QiUyNTI1MjJzb3VyY2VUeXBlJTI1MjUyMiUyNTI1M0ElMjUyNTIyYW5zd2VyJTI1MjUyMiUyNTI1MkMlMjUyNTIyc291cmNlSWQlMjUyNTIyJTI1MjUzQTMyNzE1MzM4MjQlMjUyNTdE\" target=\"_blank\">过拟合</a>现象。</p><p style=\"text-align: left; line-height: 2;\">常见的模型微调方法：</p><p style=\"text-align: left; line-height: 2;\"><strong>· </strong>Fine-tuning：这是最常用的微调方法。通过在预训练模型的最后一层添加一个新的分类层，然后根据新的数据集进行微调。</p><p style=\"text-align: left; line-height: 2;\"><strong>· </strong>Feature augmentation：这种方法通过向数据中添加一些人工特征来增强模型的性能。这些特征可以是手工设计的，也可以是通过自动特征生成技术生成的。</p><p style=\"text-align: left; line-height: 2;\"><strong>·</strong> Transfer learning：这种方法是使用在一个任务上训练过的模型作为新任务的起点，然后对模型的参数进行微调，以适应新的任务。</p><p style=\"text-align: left; line-height: 2;\">大模型是未来人工智能发展的重要方向和核心技术，未来，随着 AI 技术的不断进步和应用场景的不断拓展，大模型将在更多领域展现其巨大的潜力，为人类万花筒般的 AI 未来拓展无限可能性。</p><p style=\"text-align: left; line-height: 2;\">本文将继续深入探讨大型语言模型（LLMs）的迷人世界，以及它们理解和生成类似人类语言的不可思议能力。我们将讨论这些模型的历史和演变，涉及到重要的里程碑，如GPT系列及其后继模型。我们还将探索不同类型的LLMs、它们的应用以及支撑许多先进模型的Transformer架构的内部工作原理。此外，我们还将探讨人类引导强化学习等前沿进展以及它如何提升人工智能性能。通过本文的阅读，您将对大型语言模型有一个全面的了解，了解它们的巨大潜力以及这一开创性技术的令人兴奋的未来。</p><h2 style=\"text-align: left;\"><strong>那什么是大型语言模型？</strong></h2><p style=\"text-align: left; line-height: 2;\">当我们谈论大型语言模型时，我们指的是一种能够以类似人类语言的方式“说话”的软件。这些模型非常惊人——它们能够获取上下文并生成不仅连贯而且感觉像是来自真实人类的回复。</p><p style=\"text-align: left; line-height: 2;\">这些语言模型通过分析大量的文本数据并学习语言使用的模式来工作。它们利用这些模式生成的文本几乎无法与人类所说或写的内容区分开来。</p><p style=\"text-align: left; line-height: 2;\">如果您曾与虚拟助手进行聊天或与人工智能客户服务代理进行互动，您可能会在不知不觉中与大型语言模型互动过！这些模型有广泛的应用，从聊天机器人到语言翻译到内容创作等。</p><p style=\"text-align: left; line-height: 2;\">一些最令人印象深刻的大型语言模型由OpenAI开发。例如，它们的GPT-3模型拥有超过1750亿个参数，能够执行摘要生成、问答甚至创作等任务！如果您仍然不确定这样的模型有多好，我建议您自己尝试一下Chat GPT。</p><h2 style=\"text-align: left;\">第一个大型语言模型是什么？</h2><p style=\"text-align: left; line-height: 2;\">正如我们前面提到的，当谈论大型语言模型时，我们基本上是在谈论擅长生成类似人类语言的软件。真正引起人们关注的第一个模型是OpenAI于2018年开发的GPT（Generative Pre-trained Transformer）模型。众所周知，ChatGPT基本上就是GPT-3.5。</p><p style=\"text-align: left; line-height: 2;\">GPT模型之所以如此特殊，是因为它是首批使用Transformer架构的语言模型之一。这是一种能够很好地理解文本数据中的长距离依赖关系的神经网络类型，使得该模型能够生成高度连贯和上下文相关的语言输出。拥有1.17亿个参数的GPT模型对自然语言处理领域产生了重大影响，真正改变了游戏规则。</p><p style=\"text-align: left; line-height: 2;\">此后，我们见证了更大、更令人印象深刻的语言模型的发展，如GPT-2、GPT-3和BERT。这些模型能够生成比GPT模型更复杂、更类似人类的文本。尽管GPT模型可能不再是最大或最好的模型，但它仍然是语言模型发展历程中的重要里程碑，并对自然语言处理领域产生了重大影响。</p><h2 style=\"text-align: left;\">大型语言模型的类型有哪些？</h2><p style=\"text-align: left; line-height: 2;\">有几种不同类型的大型语言模型，每种类型都有其自身的优点和缺点。</p><h3 style=\"text-align: left;\">基于自编码器的模型（Autoencoder-Based Model）</h3><p style=\"text-align: left; line-height: 2;\">一种类型的大型语言模型是基于自编码器的模型，它通过将输入文本编码为较低维度的表示，然后根据该表示生成新的文本。这种类型的模型在文本摘要或内容生成等任务中表现出色。</p><h3 style=\"text-align: left;\">序列到序列模型（Sequence-to-Sequence Model）</h3><p style=\"text-align: left; line-height: 2;\">另一种类型的大型语言模型是序列到序列模型，它接收一个输入序列（比如一个句子）并生成一个输出序列（比如翻译成另一种语言）。这些模型通常用于机器翻译和文本摘要。</p><h3 style=\"text-align: left;\">基于Transformer的模型（Transformer-Based Models）</h3><p style=\"text-align: left; line-height: 2;\">基于Transformer的模型是另一种常见的大型语言模型类型。这些模型使用一种神经网络架构，非常擅长理解文本数据中的长距离依赖关系，使其在生成文本、翻译语言和回答问题等各种语言任务中非常有用。</p><h3 style=\"text-align: left;\">递归神经网络模型（Recursive Neural Network Models）</h3><p style=\"text-align: left; line-height: 2;\">递归神经网络模型被设计用于处理结构化数据，如句子的句法结构表示。这些模型对情感分析和自然语言推理等任务非常有用。</p><h3 style=\"text-align: left;\">分层模型（Hierarchical Models）</h3><p style=\"text-align: left; line-height: 2;\">最后，分层模型被设计用于处理不同粒度级别的文本，例如句子、段落和文档。这些模型用于文档分类和主题建模等任务。</p><h2 style=\"text-align: left;\">大型语言模型是如何工作的？</h2><p style=\"text-align: left; line-height: 2;\">最知名的大型语言模型（LLM）架构是Transformer架构。典型的Transformer模型在处理输入数据时有四个主要步骤，我们将逐一讨论每个步骤：</p><p style=\"text-align: left; line-height: 2;\">首先，模型进行词嵌入，将单词转换为高维向量表示。然后，数据通过多个Transformer层进行传递。在这些层中，自注意机制在理解序列中单词之间的关系方面起着关键作用。最后，在经过Transformer层的处理后，模型通过根据学到的上下文预测序列中最可能的下一个单词或标记来生成文本。</p><p style=\"text-align: left; line-height: 2;\"><img src=\"https://www.aigc.cn/wp-content/uploads/2024/01/v2-69cb718b62b3fff647dda0b00c30474f_720w.webp.jpg\" alt=\"v2-69cb718b62b3fff647dda0b00c30474f_720w.webp\" data-href=\"\" style=\"height: auto;\"></p><h3 style=\"text-align: left;\">词嵌入（Word Embedding）</h3><p style=\"text-align: left; line-height: 2;\">构建大型语言模型时，词嵌入是至关重要的第一步。它将单词表示为高维空间中的向量，使得相似的单词被归为一组。这有助于模型理解单词的含义，并基于此进行预测。</p><p style=\"text-align: left; line-height: 2;\"><img src=\"https://www.aigc.cn/wp-content/uploads/2024/01/v2-5646f07bd0839a932a4212de11962478_720w.webp.jpg\" alt=\"v2-5646f07bd0839a932a4212de11962478_720w.webp\" data-href=\"\" style=\"height: auto;\"></p><p style=\"text-align: left; line-height: 2;\">例如，考虑到单词”猫”和”狗”，这两个词通常会比与之无关的另一对词，如”猫”和”汉堡”更接近。这些单词在它们都是常见的宠物，并且通常与毛茸茸和友好相关联方面具有相似性。在词嵌入中，这些词将被表示为在向量空间中彼此接近的向量。这使得模型能够认识到这两个词具有相似的含义，并可以在类似的语境中使用。有了这些说法，词嵌入的过程是如何执行的呢？</p><p style=\"text-align: left; line-height: 2;\">创建词嵌入涉及对大量文本数据进行神经网络训练，例如新闻文章或书籍。在训练过程中，网络学习根据单词在句子中的前后出现的词来预测其在给定上下文中出现的可能性。通过这个过程学习到的向量捕捉了语料库中不同单词之间的语义关系。类似的方法也适用于”国王”、”皇后”、”男人”和”女人”这样的词。</p><p style=\"text-align: left; line-height: 2;\"><img src=\"https://www.aigc.cn/wp-content/uploads/2024/01/v2-8b5513c61f3e9361ff1ea37a0bb3a234_720w.webp.jpg\" alt=\"v2-8b5513c61f3e9361ff1ea37a0bb3a234_720w.webp\" data-href=\"\" style=\"height: auto;\"></p><p style=\"text-align: left; line-height: 2;\">一旦创建了词嵌入，它们可以作为输入传递给在特定语言任务上进行训练的更大的神经网络，例如文本分类或机器翻译。通过使用词嵌入，模型能够更好地理解单词的含义，并基于这种理解做出更准确的预测。</p><h3 style=\"text-align: left;\">位置编码（Positional Encoding）</h3><p style=\"text-align: left; line-height: 2;\">位置编码是帮助模型确定单词在序列中的位置的技术。它与单词的含义以及它们之间的关系无关，例如”猫”和”狗”之间的相似性。相反，位置编码主要用于跟踪单词的顺序。例如，当将句子”我喜欢猫”输入到模型时，位置编码可以帮助模型区分”我”是在句子的开头，而”猫”是在句子的结尾。这对于模型理解上下文和生成连贯的输出非常重要。</p><p style=\"text-align: left; line-height: 2;\">位置编码使用一系列特定模式的向量来表示单词的位置。这些向量与词嵌入的向量相加，以获得包含位置信息的表示。通过这种方式，模型能够将单词的位置作为输入的一部分，并在生成输出时保持一致。</p><h3 style=\"text-align: left;\">自注意力机制（Self-Attention Mechanism）</h3><p style=\"text-align: left; line-height: 2;\">自注意力机制是Transformer模型的核心组成部分。它允许模型在生成输出时，有效地在输入序列的不同位置进行交互和关注。自注意力机制的关键思想是计算输入序列中每个单词之间的相关性，并将这些相关性用于权衡模型在每个位置的关注程度。</p><p style=\"text-align: left; line-height: 2;\">具体来说，自注意力机制计算每个单词与其他单词之间的相似度，然后将这些相似度转化为注意力权重。这些权重决定了模型在生成输出时对不同位置的输入进行关注的程度。这种自注意力机制使得模型能够根据输入序列中的上下文信息灵活地调整输出的生成。</p><p style=\"text-align: left; line-height: 2;\">自注意力机制的引入是Transformer模型相对于传统递归神经网络（如循环神经网络）的一个重大突破。传统的递归神经网络在处理长序列时容易出现梯度消失或梯度爆炸问题，而自注意力机制使得Transformer模型能够更好地捕捉长距离依赖关系。</p><h3 style=\"text-align: left;\">前馈神经网络（Feed-forward Neural Network）</h3><p style=\"text-align: left; line-height: 2;\">前馈神经网络对每个位置的表示进行进一步的处理。前馈神经网络是由多个全连接层组成的，其中每个层都有一组参数，用于将输入进行非线性变换。这个过程可以帮助模型在生成输出时引入更多的复杂性和灵活性。</p><h3 style=\"text-align: left;\">Transformers</h3><p style=\"text-align: left; line-height: 2;\">高级大型语言模型采用了一种称为Transformer的特定架构。将Transformer层视为传统神经网络层之后的独立层。实际上，Transformer层通常作为附加层添加到传统神经网络架构中，以提高LLM在自然语言文本中建模长距离依赖性的能力。</p><p style=\"text-align: left; line-height: 2;\">Transformer层通过并行处理整个输入序列而不是顺序处理来工作。它由两个基本组件组成：自注意力机制和前馈神经网络。</p><p style=\"text-align: left; line-height: 2;\"><img src=\"https://www.aigc.cn/wp-content/uploads/2024/01/v2-73e93303b7e84350ff5df41aafe67cdd_720w.webp.jpg\" alt=\"v2-73e93303b7e84350ff5df41aafe67cdd_720w.webp\" data-href=\"\" style=\"height: auto;\"></p><p style=\"text-align: left; line-height: 2;\">自注意力机制允许模型为序列中的每个单词分配一个权重，取决于它对预测的重要性。这使得模型能够捕捉单词之间的关系，而不考虑它们之间的距离。</p><p style=\"text-align: left; line-height: 2;\"><img src=\"https://www.aigc.cn/wp-content/uploads/2024/01/v2-f89639eea790b5fd51c1aff15e335ee4_720w.webp.jpg\" alt=\"v2-f89639eea790b5fd51c1aff15e335ee4_720w.webp\" data-href=\"\" style=\"height: auto;\"></p><p style=\"text-align: left; line-height: 2;\">因此，在自注意力层完成序列处理后，位置逐个前馈层接受输入序列中的每个位置并独立处理它。对于每个位置，全连接层接收该位置上的标记（单词或子词）的向量表示。这个向量表示是前面的自注意力层的输出。这个上下文中的全连接层用于将输入向量表示转换为更适合模型学习单词之间复杂模式和关系的新向量表示。</p><p style=\"text-align: left; line-height: 2;\">在训练过程中，Transformer层的权重被重复更新，以减小预测输出与实际输出之间的差异。这是通过反向传播算法完成的，类似于传统神经网络层的训练过程。</p><h3 style=\"text-align: left;\">文本生成</h3><p style=\"text-align: left; line-height: 2;\">通常是由LLM模型执行的最后一步；在LLM经过训练和微调之后，该模型可以用于根据提示或问题生成高度复杂的文本。模型通常通过种子输入进行”预热”，种子输入可以是几个单词、一个句子，甚至是一个完整的段落。然后，LLM利用其学到的模式生成一个连贯且与上下文相关的回答。</p><p style=\"text-align: left; line-height: 2;\">文本生成依赖于一种称为自回归的技术，即模型根据它已生成的先前单词逐个生成输出序列的每个单词或标记。模型利用在训练期间学到的参数来计算下一个单词或标记的概率分布，然后选择最有可能的选择作为下一个输出。</p><p style=\"text-align: left; line-height: 2;\"><img src=\"https://www.aigc.cn/wp-content/uploads/2024/01/v2-152f926f7cb7ef0b4f738292f09b22a4_720w.webp.jpg\" alt=\"v2-152f926f7cb7ef0b4f738292f09b22a4_720w.webp\" data-href=\"\" style=\"height: auto;\"></p><h2 style=\"text-align: left;\">人类引导强化学习提升人工智能性能</h2><p style=\"text-align: left; line-height: 2;\">大型语言模型领域最令人着迷的发展之一是引入了人类反馈的强化学习。这种前沿技术使得LLM能够通过人类的反馈进行学习和改进，使它们在各种应用中成为更加动态和强大的工具。</p><p style=\"text-align: left; line-height: 2;\"><img src=\"https://www.aigc.cn/wp-content/uploads/2024/01/v2-46e7388e6656782b15d41a31c14bb1ba_720w.webp.jpg\" alt=\"v2-46e7388e6656782b15d41a31c14bb1ba_720w.webp\" data-href=\"\" style=\"height: auto;\"></p><p style=\"text-align: left; line-height: 2;\">一般而言，人类引导强化学习意味着由人提供给机器学习模型的一种持续反馈形式。这种反馈可以是明确的或隐含的。对于LLM来说，如果模型返回错误答案，人类用户可以纠正模型，从而提高模型的整体性能。</p><p style=\"text-align: left; line-height: 2;\">例如，如果LLM生成的文本在语法上或语义上不正确，人类可以向LLM提供反馈，指出生成的文本的哪些部分是正确的或不正确的。人类用户甚至可以解释或定义模型不理解的给定单词的含义。然后，LLM可以利用这个反馈调整其参数，并改进在生成更符合期望结果的文本方面的性能。</p><h2 style=\"text-align: left;\">大型语言模型的例子</h2><h3 style=\"text-align: left;\">BERT</h3><p style=\"text-align: left; line-height: 2;\">BERT是谷歌开发的一种预训练深度学习模型，全称为Transformer编码器表示的双向。它旨在理解和生成自然语言。</p><p style=\"text-align: left; line-height: 2;\"><img src=\"https://www.aigc.cn/wp-content/uploads/2024/01/v2-07842c9f21615b7869b0619e599a93b9_720w.webp.jpg\" alt=\"v2-07842c9f21615b7869b0619e599a93b9_720w.webp\" data-href=\"\" style=\"height: auto;\"></p><p style=\"text-align: left; line-height: 2;\">BERT利用双向Transformer架构，这意味着它可以正向和反向处理输入文本，以更好地理解单词之间的上下文和关系。</p><p style=\"text-align: left; line-height: 2;\">BERT在许多任务中被使用，如问答、情感分析、命名实体识别和文本分类。它在多个基准测试中取得了最先进的结果，包括斯坦福问答数据集（SQuAD）和GLUE（通用语言理解评估）基准。</p><p style=\"text-align: left; line-height: 2;\">作为比较措施，BERT base有1.1亿个参数，而更复杂的BERT large有3.45亿个参数。</p><h3 style=\"text-align: left;\">GPT-4</h3><p style=\"text-align: left; line-height: 2;\">OpenAI推出了GPT系列的最新创新：GPT-4，全称为生成式预训练Transformer 4。这个突破性的大型语言模型比其前身GPT-3的1750亿个参数更高，达到了惊人的1万亿个参数。</p><p style=\"text-align: left; line-height: 2;\"><img src=\"https://www.aigc.cn/wp-content/uploads/2024/01/v2-58b5975dc41b1e0f9380ea0a48cd0228_720w.webp.jpg\" alt=\"v2-58b5975dc41b1e0f9380ea0a48cd0228_720w.webp\" data-href=\"\" style=\"height: auto;\"></p><p style=\"text-align: left; line-height: 2;\">GPT-4的关键优势与GPT-3类似，在大量文本数据上进行了广泛的预训练，使其能够学习极其多样的语言特征和关系。因此，可以使用相对较少的示例对GPT-4进行特定自然语言处理任务的微调，使其成为一种非常高效和多功能的工具，适用于各种应用。</p><p style=\"text-align: left; line-height: 2;\">要真正欣赏GPT-4的能力，可以考虑一下它比GPT-3强大500倍的事实，而GPT-3是OpenAI用来开发ChatGPT的语言模型。这种令人印象深刻的AI领域进步承诺带来更接近人类的准确回答，彻底改变我们与人工智能互动和受益的方式。</p><h2 style=\"text-align: left;\">大型语言模型的未来</h2><p style=\"text-align: left; line-height: 2;\">关于大型语言模型的未来，最令人兴奋的是它们将不断变得更加善于理解和回应我们人类。很快，它们将变得非常高效，我们可以在几乎任何设备上使用它们，比如手机甚至小型设备。它们还将成为特定领域的专家，如医学或法律，这非常酷。</p><p style=\"text-align: left; line-height: 2;\">但这还不是全部。这些语言模型将能够处理不仅是文本，还包括图像和声音，并且将使用世界各地的语言。此外，人们正在努力确保这些<a href=\"https://www.aigc.cn/large-models\" target=\"_blank\">AI模型</a>是公平和负责任的，以使其更加开放和减少偏见。</p><p style=\"text-align: left; line-height: 2;\">总之，这些语言模型将成为我们惊人的伙伴，帮助我们完成各种任务，并以无数方式使我们的生活变得更轻松。</p>', 0, 0, 1, '/uploads/img/31cc7ed3-a067-42e1-b7d9-6db1c526d186.jpg', '2025-06-08 12:14:54', 0, '2025-06-08 20:45:07');

-- ----------------------------
-- Table structure for information_collection
-- ----------------------------
DROP TABLE IF EXISTS `information_collection`;
CREATE TABLE `information_collection`  (
  `id` bigint NOT NULL COMMENT '收藏记录ID',
  `stu_id` bigint NOT NULL COMMENT '学生ID',
  `info_id` bigint NOT NULL COMMENT '资讯ID',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '收藏时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` int NOT NULL DEFAULT 0 COMMENT '删除标记(0:未删除,1:已删除)',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_stu_info`(`stu_id` ASC, `info_id` ASC) USING BTREE COMMENT '防止重复收藏'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '资讯收藏记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of information_collection
-- ----------------------------
INSERT INTO `information_collection` VALUES (27001, 1001, 26001, '2023-02-26 09:00:00', '2023-02-26 09:00:00', 0);
INSERT INTO `information_collection` VALUES (27002, 1002, 26002, '2023-02-27 10:00:00', '2023-02-27 10:00:00', 0);

-- ----------------------------
-- Table structure for information_comments
-- ----------------------------
DROP TABLE IF EXISTS `information_comments`;
CREATE TABLE `information_comments`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '评论ID',
  `info_id` bigint NOT NULL COMMENT '资讯ID',
  `user_id` bigint NOT NULL COMMENT '评论用户ID',
  `content` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '评论内容',
  `info_like_num` bigint NOT NULL DEFAULT 0 COMMENT '点赞数',
  `at_id` bigint NOT NULL DEFAULT 0 COMMENT '被@用户ID(0表示未@)',
  `parent_comments_id` bigint NOT NULL DEFAULT 0 COMMENT '父评论ID(0表示一级评论)',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '评论时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  `deleted` int NOT NULL DEFAULT 0 COMMENT '删除标记(0:未删除,1:已删除)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 28020 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '资讯评论表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of information_comments
-- ----------------------------
INSERT INTO `information_comments` VALUES (28001, 26001, 1001, '这篇文章很有帮助，谢谢分享！', 5, 0, 0, '2023-02-28 09:00:00', NULL, 0);
INSERT INTO `information_comments` VALUES (28002, 26001, 1002, '我也觉得很有用，特别是性能改进部分', 3, 1001, 28001, '2023-03-01 10:00:00', NULL, 0);
INSERT INTO `information_comments` VALUES (28003, 26002, 1001, '这些研究进展对实际应用有帮助吗？', 2, 0, 0, '2023-03-02 09:00:00', NULL, 0);
INSERT INTO `information_comments` VALUES (28004, 26002, 2002, '12', 0, 0, 0, '2025-06-07 14:30:37', NULL, 1);
INSERT INTO `information_comments` VALUES (28005, 26002, 2002, '213213', 0, 0, 0, '2025-06-07 14:30:44', NULL, 0);
INSERT INTO `information_comments` VALUES (28006, 26003, 2002, '123', 0, 0, 0, '2025-06-07 15:22:36', NULL, 1);
INSERT INTO `information_comments` VALUES (28007, 26003, 2002, '123', 0, 0, 0, '2025-06-07 15:22:45', NULL, 0);
INSERT INTO `information_comments` VALUES (28008, 26003, 2002, '@匿名用户 21312', 0, 0, 0, '2025-06-07 15:22:48', NULL, 1);
INSERT INTO `information_comments` VALUES (28009, 26003, 2002, '412321', 0, 0, 0, '2025-06-07 15:45:35', NULL, 0);
INSERT INTO `information_comments` VALUES (28010, 26003, 2002, '213123123', 0, 0, 0, '2025-06-07 17:01:21', NULL, 0);
INSERT INTO `information_comments` VALUES (28011, 26001, 2001, '666', 0, 0, 0, '2025-06-07 20:00:03', NULL, 1);
INSERT INTO `information_comments` VALUES (28012, 26004, 2001, '213213', 0, 0, 0, '2025-06-08 10:41:59', NULL, 1);
INSERT INTO `information_comments` VALUES (28013, 26004, 2001, '@匿名用户 1123213', 0, 0, 0, '2025-06-08 12:05:40', NULL, 1);
INSERT INTO `information_comments` VALUES (28014, 26007, 2001, '123123', 0, 0, 0, '2025-06-08 12:17:32', NULL, 0);
INSERT INTO `information_comments` VALUES (28015, 26008, 2002, 'SADSAD', 0, 0, 0, '2025-06-08 12:28:48', NULL, 0);
INSERT INTO `information_comments` VALUES (28016, 26008, 2002, '@匿名用户 21321312', 0, 0, 0, '2025-06-08 12:28:58', NULL, 1);
INSERT INTO `information_comments` VALUES (28017, 26007, 2002, '213123', 0, 0, 0, '2025-06-08 12:37:36', NULL, 0);
INSERT INTO `information_comments` VALUES (28018, 26007, 2002, '213213', 0, 0, 0, '2025-06-08 12:43:33', NULL, 0);
INSERT INTO `information_comments` VALUES (28019, 26008, 2002, '123123', 0, 0, 0, '2025-06-08 12:45:06', NULL, 1);

-- ----------------------------
-- Table structure for information_comments_like
-- ----------------------------
DROP TABLE IF EXISTS `information_comments_like`;
CREATE TABLE `information_comments_like`  (
  `id` bigint NOT NULL COMMENT '点赞记录ID',
  `stu_id` bigint NOT NULL COMMENT '学生ID',
  `info_com_id` bigint NOT NULL COMMENT '资讯评论ID',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '点赞时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` int NOT NULL DEFAULT 0 COMMENT '删除标记(0:未删除,1:已删除)',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_stu_comment`(`stu_id` ASC, `info_com_id` ASC) USING BTREE COMMENT '防止重复点赞'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '资讯评论点赞记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of information_comments_like
-- ----------------------------
INSERT INTO `information_comments_like` VALUES (29001, 1001, 28001, '2023-03-03 09:00:00', '2023-03-03 09:00:00', 0);
INSERT INTO `information_comments_like` VALUES (29002, 1002, 28001, '2023-03-04 10:00:00', '2023-03-04 10:00:00', 0);

-- ----------------------------
-- Table structure for information_like
-- ----------------------------
DROP TABLE IF EXISTS `information_like`;
CREATE TABLE `information_like`  (
  `id` bigint NOT NULL COMMENT '点赞记录ID',
  `stu_id` bigint NOT NULL COMMENT '学生ID',
  `info_id` bigint NOT NULL COMMENT '资讯ID',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '点赞时间',
  `deleted` int NOT NULL DEFAULT 0 COMMENT '删除标记(0:未删除,1:已删除)',
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_stu_info`(`stu_id` ASC, `info_id` ASC) USING BTREE COMMENT '防止重复点赞'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '资讯点赞记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of information_like
-- ----------------------------
INSERT INTO `information_like` VALUES (30001, 1001, 26001, '2023-03-05 09:00:00', 0, '2023-03-05 09:00:00');
INSERT INTO `information_like` VALUES (30002, 1002, 26002, '2023-03-06 10:00:00', 0, '2023-03-06 10:00:00');

-- ----------------------------
-- Table structure for learning_progress
-- ----------------------------
DROP TABLE IF EXISTS `learning_progress`;
CREATE TABLE `learning_progress`  (
  `id` int NOT NULL COMMENT '进度记录ID',
  `stu_id` bigint NOT NULL COMMENT '学生ID',
  `cou_id` bigint NOT NULL COMMENT '课程ID',
  `recording` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '学习记录描述',
  `time` bigint NOT NULL DEFAULT 0 COMMENT '学习时长(单位：秒)',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` int NOT NULL DEFAULT 0 COMMENT '删除标记(0:未删除,1:已删除)',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_stu_cou`(`stu_id` ASC, `cou_id` ASC) USING BTREE COMMENT '学生课程学习记录唯一约束'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '学生学习进度记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of learning_progress
-- ----------------------------
INSERT INTO `learning_progress` VALUES (12001, 1001, 7001, '已完成第一章学习', 1800, '2023-01-29 09:00:00', '2023-01-29 09:30:00', 0);

-- ----------------------------
-- Table structure for message_comments
-- ----------------------------
DROP TABLE IF EXISTS `message_comments`;
CREATE TABLE `message_comments`  (
  `id` bigint NOT NULL COMMENT '评论ID',
  `role` int NOT NULL COMMENT '评论类型(1:问题评论,2:资讯评论的评论,3:问题评论的评论,4:资讯评论)',
  `relevancy_id` bigint NULL DEFAULT NULL COMMENT '关联业务ID',
  `stu_id` bigint NULL DEFAULT NULL COMMENT '学生ID',
  `tea_id` bigint NULL DEFAULT NULL COMMENT '教师ID',
  `content` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '评论内容',
  `issuer_id` bigint NULL DEFAULT NULL COMMENT '发布者ID(学生)',
  `issuer_tea_id` bigint NULL DEFAULT NULL COMMENT '发布者ID(教师)',
  `status` int NOT NULL DEFAULT 0 COMMENT '状态(0:正常)',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` int NOT NULL DEFAULT 0 COMMENT '删除标记(0:未删除,1:已删除)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '消息评论表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of message_comments
-- ----------------------------
INSERT INTO `message_comments` VALUES (37001, 4, 26001, 1001, NULL, '这篇文章很有帮助，谢谢分享！', 1001, NULL, 0, '2023-03-20 09:00:00', '2023-03-20 09:00:00', 0);
INSERT INTO `message_comments` VALUES (37002, 1, 31001, NULL, 2001, '装饰器是Python中一个强大的功能...', NULL, 2001, 0, '2023-03-21 10:00:00', '2023-03-21 10:00:00', 0);

-- ----------------------------
-- Table structure for message_like
-- ----------------------------
DROP TABLE IF EXISTS `message_like`;
CREATE TABLE `message_like`  (
  `id` bigint NOT NULL COMMENT '点赞记录ID',
  `role` int NOT NULL COMMENT '点赞类型(1:问题点赞,2:资讯评论点赞,3:问题评论点赞)',
  `relevancy_id` bigint NULL DEFAULT NULL COMMENT '关联业务ID(问题ID/评论ID)',
  `stu_id` bigint NOT NULL COMMENT '点赞学生ID',
  `content` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '点赞内容描述',
  `issuer_id` bigint NOT NULL COMMENT '被点赞对象发布者ID',
  `status` int NOT NULL DEFAULT 0 COMMENT '状态(0:正常)',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '点赞时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` int NOT NULL DEFAULT 0 COMMENT '删除标记(0:未删除,1:已删除)',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_role_stu_relevancy`(`role` ASC, `stu_id` ASC, `relevancy_id` ASC) USING BTREE COMMENT '防止重复点赞'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '消息点赞记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of message_like
-- ----------------------------
INSERT INTO `message_like` VALUES (38001, 2, 28001, 1001, '点赞了你的评论', 1001, 0, '2023-03-22 09:00:00', NULL, 0);
INSERT INTO `message_like` VALUES (38002, 1, 31001, 1002, '点赞了你的问题', 1001, 0, '2023-03-23 10:00:00', NULL, 0);

-- ----------------------------
-- Table structure for message_system
-- ----------------------------
DROP TABLE IF EXISTS `message_system`;
CREATE TABLE `message_system`  (
  `id` bigint NOT NULL COMMENT '消息ID',
  `role` int NULL DEFAULT NULL COMMENT '消息类型(1:系统通知,2:订单通知,3:采纳通知,4-11:各类违规通知)',
  `relevancy_id` bigint NOT NULL COMMENT '关联业务ID',
  `stu_id` bigint NULL DEFAULT NULL COMMENT '接收学生ID',
  `tea_id` bigint NULL DEFAULT NULL COMMENT '接收教师ID',
  `content` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '消息内容',
  `status` int NOT NULL DEFAULT 0 COMMENT '状态(0:未读,1:已读)',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` int NOT NULL DEFAULT 0 COMMENT '删除标记(0:未删除,1:已删除)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '系统消息通知表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of message_system
-- ----------------------------
INSERT INTO `message_system` VALUES (39001, 2, 21001, 1001, NULL, '您的订单已支付成功', 1, '2023-03-24 09:00:00', '2023-03-24 09:30:00', 0);
INSERT INTO `message_system` VALUES (39002, 4, 33003, NULL, 2002, '您的回答被采纳', 0, '2023-03-25 10:00:00', '2023-03-25 10:00:00', 0);

-- ----------------------------
-- Table structure for practice
-- ----------------------------
DROP TABLE IF EXISTS `practice`;
CREATE TABLE `practice`  (
  `id` bigint NOT NULL COMMENT '实践活动ID',
  `tea_id` bigint NOT NULL COMMENT '教师ID',
  `cou_id` bigint NOT NULL COMMENT '关联课程ID',
  `pra_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '实践活动名称',
  `pra_site` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '实践地点',
  `pra_main` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '实践内容描述',
  `start_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '开始时间',
  `end_time` timestamp NULL DEFAULT NULL COMMENT '结束时间',
  `status` int NOT NULL DEFAULT 0 COMMENT '状态(0:未开始,1:进行中,2:已结束)',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` int NOT NULL DEFAULT 0 COMMENT '删除标记(0:未删除,1:已删除)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '课程实践活动表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of practice
-- ----------------------------
INSERT INTO `practice` VALUES (24001, 2001, 7001, 'Python项目实践', '计算机实验室A', '完成一个简单的Python项目', '2023-02-20 09:00:00', '2023-02-20 12:00:00', 2, '2023-02-15 09:00:00', '2023-02-20 12:30:00', 0);
INSERT INTO `practice` VALUES (24002, 2002, 7002, '机器学习实验', '人工智能实验室', '完成一个简单的分类实验', '2023-02-25 14:00:00', '2023-02-25 17:00:00', 1, '2023-02-16 10:00:00', '2023-02-25 14:30:00', 0);

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` bigint NOT NULL COMMENT '学生ID',
  `user_id` bigint NOT NULL COMMENT '用户ID(逻辑外键)',
  `stu_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '学生姓名(默认用户名)',
  `stu_study_time` bigint NOT NULL DEFAULT 0 COMMENT '总学习时长(单位:分钟)',
  `stu_score` bigint NULL DEFAULT 100 COMMENT '学生积分',
  `clock` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '0000000' COMMENT '打卡记录(7位字符串)',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `deleted` int NOT NULL DEFAULT 0 COMMENT '删除标记(0:未删除,1:已删除)',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_user_id`(`user_id` ASC) USING BTREE COMMENT '用户ID索引'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '学生信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (1001, 1001, '张三', 3600, 400, '1010101', '2023-01-01 10:05:00', 0, '2025-06-10 16:21:55');
INSERT INTO `student` VALUES (1002, 1002, '李四', 1800, 300, '0101010', '2023-01-02 11:05:00', 0, '2023-01-16 09:45:00');

-- ----------------------------
-- Table structure for student_class
-- ----------------------------
DROP TABLE IF EXISTS `student_class`;
CREATE TABLE `student_class`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `stu_id` bigint NOT NULL COMMENT '学生ID',
  `class_id` bigint NOT NULL COMMENT '班级ID',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_stu_class`(`stu_id` ASC, `class_id` ASC) USING BTREE COMMENT '学生班级唯一关联约束'
) ENGINE = InnoDB AUTO_INCREMENT = 4065 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '学生班级关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student_class
-- ----------------------------

-- ----------------------------
-- Table structure for student_clock
-- ----------------------------
DROP TABLE IF EXISTS `student_clock`;
CREATE TABLE `student_clock`  (
  `id` bigint NOT NULL COMMENT '打卡记录ID',
  `stu_id` bigint NOT NULL COMMENT '学生ID',
  `time` int NOT NULL COMMENT '打卡时间(时间戳)',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录创建时间',
  `deleted` int NOT NULL DEFAULT 0 COMMENT '删除标记(0:未删除,1:已删除)',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_stu_id`(`stu_id` ASC) USING BTREE COMMENT '学生ID索引',
  INDEX `idx_time`(`time` ASC) USING BTREE COMMENT '打卡时间索引'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '学生打卡记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student_clock
-- ----------------------------
INSERT INTO `student_clock` VALUES (13001, 1001, 1675209600, '2023-02-01 08:00:00', 0, '2023-02-01 08:00:00');
INSERT INTO `student_clock` VALUES (13002, 1001, 1675297800, '2023-02-02 08:30:00', 0, '2023-02-02 08:30:00');
INSERT INTO `student_clock` VALUES (13003, 1002, 1675213200, '2023-02-01 09:00:00', 0, '2023-02-01 09:00:00');

-- ----------------------------
-- Table structure for student_course
-- ----------------------------
DROP TABLE IF EXISTS `student_course`;
CREATE TABLE `student_course`  (
  `id` bigint NOT NULL COMMENT '关联记录ID',
  `stu_id` bigint NOT NULL COMMENT '学生ID',
  `cou_id` bigint NOT NULL COMMENT '课程ID',
  `cou_type` int NOT NULL DEFAULT 0 COMMENT '课程类型(0:自选课,1:班级课)',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_stu_cou`(`stu_id` ASC, `cou_id` ASC) USING BTREE COMMENT '学生课程唯一关联约束',
  INDEX `idx_cou_type`(`cou_type` ASC) USING BTREE COMMENT '课程类型索引'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '学生课程关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student_course
-- ----------------------------
INSERT INTO `student_course` VALUES (10001, 1001, 7001, 1, '2023-01-23 09:00:00', '2023-01-23 09:00:00');
INSERT INTO `student_course` VALUES (10002, 1002, 7001, 1, '2023-01-24 10:00:00', '2023-01-24 10:00:00');
INSERT INTO `student_course` VALUES (10003, 1001, 7002, 0, '2023-01-25 09:00:00', '2023-01-25 09:00:00');

-- ----------------------------
-- Table structure for student_course_appraise
-- ----------------------------
DROP TABLE IF EXISTS `student_course_appraise`;
CREATE TABLE `student_course_appraise`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `stu_id` bigint NOT NULL COMMENT '学生ID',
  `cou_id` bigint NOT NULL COMMENT '课程ID',
  `cou_appraise` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '课程评价内容',
  `evaluate_score` int NULL DEFAULT NULL COMMENT '评分(0-5分)',
  `deleted` int NOT NULL DEFAULT 0 COMMENT '删除标记(0:未删除,1:已删除)',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '评价时间',
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_stu_cou`(`stu_id` ASC, `cou_id` ASC) USING BTREE COMMENT '防止重复评价'
) ENGINE = InnoDB AUTO_INCREMENT = 18003 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '学生课程评价表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student_course_appraise
-- ----------------------------
INSERT INTO `student_course_appraise` VALUES (18001, 1001, 7001, '课程内容很丰富，讲解清晰', 5, 0, '2023-02-08 09:00:00', '2023-02-08 09:00:00');
INSERT INTO `student_course_appraise` VALUES (18002, 1002, 7001, '课程难度适中，适合初学者', 4, 0, '2023-02-09 10:00:00', '2023-02-09 10:00:00');

-- ----------------------------
-- Table structure for student_course_cart
-- ----------------------------
DROP TABLE IF EXISTS `student_course_cart`;
CREATE TABLE `student_course_cart`  (
  `id` bigint NOT NULL COMMENT '购物车记录ID',
  `stu_id` bigint NOT NULL COMMENT '学生ID',
  `cou_id` bigint NOT NULL COMMENT '课程ID',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '加入时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` int NOT NULL DEFAULT 0 COMMENT '删除标记(0:未删除,1:已删除)',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_stu_cou`(`stu_id` ASC, `cou_id` ASC) USING BTREE COMMENT '防止重复加入购物车'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '学生课程购物车表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student_course_cart
-- ----------------------------
INSERT INTO `student_course_cart` VALUES (15001, 1001, 7002, '2023-02-03 09:00:00', '2023-02-03 09:00:00', 0);

-- ----------------------------
-- Table structure for student_course_collection
-- ----------------------------
DROP TABLE IF EXISTS `student_course_collection`;
CREATE TABLE `student_course_collection`  (
  `id` bigint NOT NULL COMMENT '收藏记录ID',
  `stu_id` bigint NOT NULL COMMENT '学生ID',
  `cou_id` bigint NOT NULL COMMENT '课程ID',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '收藏时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` int NOT NULL DEFAULT 0 COMMENT '删除标记(0:未删除,1:已删除)',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_stu_cou`(`stu_id` ASC, `cou_id` ASC) USING BTREE COMMENT '防止重复收藏'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '学生课程收藏关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student_course_collection
-- ----------------------------
INSERT INTO `student_course_collection` VALUES (16001, 1001, 7001, '2023-02-04 10:00:00', '2023-02-04 10:00:00', 0);
INSERT INTO `student_course_collection` VALUES (16002, 1002, 7002, '2023-02-05 11:00:00', '2023-02-05 11:00:00', 0);

-- ----------------------------
-- Table structure for student_course_fancy
-- ----------------------------
DROP TABLE IF EXISTS `student_course_fancy`;
CREATE TABLE `student_course_fancy`  (
  `id` bigint NOT NULL COMMENT '点赞记录ID',
  `stu_id` bigint NOT NULL COMMENT '学生ID',
  `cou_id` bigint NOT NULL COMMENT '课程ID',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '点赞时间',
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` int NOT NULL DEFAULT 0 COMMENT '删除标记(0:未删除,1:已删除)',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_stu_cou`(`stu_id` ASC, `cou_id` ASC) USING BTREE COMMENT '防止重复点赞'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '学生课程点赞表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student_course_fancy
-- ----------------------------
INSERT INTO `student_course_fancy` VALUES (17001, 1001, 7001, '2023-02-06 09:00:00', '2023-02-06 09:00:00', 0);
INSERT INTO `student_course_fancy` VALUES (17002, 1002, 7001, '2023-02-07 10:00:00', '2023-02-07 10:00:00', 0);

-- ----------------------------
-- Table structure for student_course_progress
-- ----------------------------
DROP TABLE IF EXISTS `student_course_progress`;
CREATE TABLE `student_course_progress`  (
  `id` bigint NOT NULL COMMENT '进度记录ID',
  `stu_id` bigint NOT NULL COMMENT '学生ID',
  `cou_id` bigint NOT NULL COMMENT '课程ID',
  `cha_id` bigint NOT NULL COMMENT '章节ID',
  `learned_duration` bigint NOT NULL DEFAULT 0 COMMENT '已学习时长(单位:秒)',
  `media_progress` bigint NULL DEFAULT 0 COMMENT '媒体进度(单位:秒)',
  `media_duration` bigint NOT NULL COMMENT '媒体总时长(单位:秒)',
  `learned_status` int NOT NULL DEFAULT 0 COMMENT '学习状态(0:学习中,1:已完成)',
  `positioning` bigint NULL DEFAULT NULL COMMENT '上一次播放位置(单位:秒)',
  `point` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '学习进度标记点',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` int NOT NULL DEFAULT 0 COMMENT '删除标记(0:未删除,1:已删除)',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_stu_cou_cha`(`stu_id` ASC, `cou_id` ASC, `cha_id` ASC) USING BTREE COMMENT '学生课程章节唯一进度记录',
  INDEX `idx_stu_cou`(`stu_id` ASC, `cou_id` ASC) USING BTREE COMMENT '学生课程索引',
  INDEX `idx_cha_id`(`cha_id` ASC) USING BTREE COMMENT '章节索引'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '学生课程学习进度表(自选课程)' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student_course_progress
-- ----------------------------
INSERT INTO `student_course_progress` VALUES (11001, 1001, 7001, 9001, 1800, 1200, 1800, 1, 1200, '{\"lastPosition\":1200}', '2023-01-26 09:00:00', '2023-01-26 10:30:00', 0);
INSERT INTO `student_course_progress` VALUES (11002, 1001, 7001, 9002, 900, 600, 1200, 0, 600, '{\"lastPosition\":600}', '2023-01-27 10:00:00', '2023-01-27 11:00:00', 0);
INSERT INTO `student_course_progress` VALUES (11003, 1002, 7001, 9001, 2400, 1800, 1800, 1, 1800, '{\"lastPosition\":1800}', '2023-01-28 09:00:00', '2023-01-28 11:00:00', 0);

-- ----------------------------
-- Table structure for student_order
-- ----------------------------
DROP TABLE IF EXISTS `student_order`;
CREATE TABLE `student_order`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `code` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '订单流水号',
  `stu_id` bigint NOT NULL COMMENT '学生ID',
  `amount` bigint NULL DEFAULT NULL COMMENT '订单金额(单位：分)',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` int NOT NULL DEFAULT 0 COMMENT '删除标记(0:未删除,1:已删除)',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_code`(`code` ASC) USING BTREE COMMENT '订单流水号唯一约束',
  INDEX `idx_stu_id`(`stu_id` ASC) USING BTREE COMMENT '学生ID索引'
) ENGINE = InnoDB AUTO_INCREMENT = 21005 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '学生订单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student_order
-- ----------------------------
INSERT INTO `student_order` VALUES (21001, 'ORD202302150001', 1001, 9900, '2023-02-15 09:00:00', '2023-02-15 09:00:00', 0);
INSERT INTO `student_order` VALUES (21002, 'ORD202302160001', 1002, 9900, '2023-02-16 10:00:00', '2023-02-16 10:00:00', 0);
INSERT INTO `student_order` VALUES (21003, 'ORDER_1749543500457_bfa25cdf', 1001, 10, '2025-06-10 16:18:20', '2025-06-10 16:18:20', 0);
INSERT INTO `student_order` VALUES (21004, 'ORDER_1749543715833_d146e7b0', 1001, 10, '2025-06-10 16:21:55', '2025-06-10 16:21:55', 0);

-- ----------------------------
-- Table structure for student_order_detail
-- ----------------------------
DROP TABLE IF EXISTS `student_order_detail`;
CREATE TABLE `student_order_detail`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `order_id` bigint NULL DEFAULT NULL COMMENT '关联订单ID',
  `cou_id` bigint NOT NULL COMMENT '课程ID',
  `cou_price` bigint NOT NULL COMMENT '课程价格(单位：分)',
  `cou_pic` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '课程封面URL',
  `tea_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '教师姓名',
  `cou_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '课程名称',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` int NOT NULL DEFAULT 0 COMMENT '删除标记(0:未删除,1:已删除)',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_order_id`(`order_id` ASC) USING BTREE COMMENT '订单ID索引',
  INDEX `idx_cou_id`(`cou_id` ASC) USING BTREE COMMENT '课程ID索引'
) ENGINE = InnoDB AUTO_INCREMENT = 22005 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '学生订单明细表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student_order_detail
-- ----------------------------
INSERT INTO `student_order_detail` VALUES (22001, 21001, 7001, 9900, 'https://example.com/courses/python.jpg', '王教授', 'Python编程基础', '2023-02-15 09:05:00', '2023-02-15 09:05:00', 0);
INSERT INTO `student_order_detail` VALUES (22002, 21002, 7001, 9900, 'https://example.com/courses/python.jpg', '王教授', 'Python编程基础', '2023-02-16 10:05:00', '2023-02-16 10:05:00', 0);
INSERT INTO `student_order_detail` VALUES (22003, 21003, 7005, 10, '/uploads/img/f8bab475-25d8-44f8-9905-8a49616f636d.png', '陈海涛', 'SpringBoot实战项目开发', '2025-06-10 16:18:20', '2025-06-10 16:18:20', 0);
INSERT INTO `student_order_detail` VALUES (22004, 21004, 7002, 10, '/uploads/img/c24237b3-da35-44cd-8a4c-cfa1389e5138.png', '李教授', '机器学习入门', '2025-06-10 16:21:55', '2025-06-10 16:21:55', 0);

-- ----------------------------
-- Table structure for student_practice
-- ----------------------------
DROP TABLE IF EXISTS `student_practice`;
CREATE TABLE `student_practice`  (
  `id` bigint NOT NULL COMMENT '关联记录ID',
  `stu_id` bigint NOT NULL COMMENT '学生ID',
  `pra_id` bigint NOT NULL COMMENT '实践活动ID',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` int NOT NULL DEFAULT 0 COMMENT '删除标记(0:未删除,1:已删除)',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_stu_pra`(`stu_id` ASC, `pra_id` ASC) USING BTREE COMMENT '防止重复关联'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '学生实践活动关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student_practice
-- ----------------------------
INSERT INTO `student_practice` VALUES (25001, 1001, 24001, '2023-02-21 09:00:00', '2023-02-21 09:00:00', 0);
INSERT INTO `student_practice` VALUES (25002, 1002, 24001, '2023-02-22 10:00:00', '2023-02-22 10:00:00', 0);
INSERT INTO `student_practice` VALUES (25003, 1001, 24002, '2023-02-23 09:00:00', '2023-02-23 09:00:00', 0);

-- ----------------------------
-- Table structure for student_score_detail
-- ----------------------------
DROP TABLE IF EXISTS `student_score_detail`;
CREATE TABLE `student_score_detail`  (
  `id` bigint NOT NULL COMMENT '积分明细ID',
  `stu_id` bigint NOT NULL COMMENT '学生ID',
  `way` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '积分获取/消耗途径',
  `detail` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '积分变动详情',
  `deleted` int NOT NULL DEFAULT 0 COMMENT '删除标记(0:未删除,1:已删除)',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_stu_id`(`stu_id` ASC) USING BTREE COMMENT '学生ID索引',
  INDEX `idx_create_time`(`create_time` ASC) USING BTREE COMMENT '创建时间索引'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '学生积分变动明细表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student_score_detail
-- ----------------------------
INSERT INTO `student_score_detail` VALUES (23001, 1001, '学习', '完成Python编程基础第一章学习', 0, '2023-02-17 09:00:00', '2023-02-17 09:00:00');
INSERT INTO `student_score_detail` VALUES (23002, 1001, '打卡', '连续打卡3天', 0, '2023-02-18 10:00:00', '2023-02-18 10:00:00');
INSERT INTO `student_score_detail` VALUES (23003, 1002, '学习', '完成Python编程基础第一章学习', 0, '2023-02-19 09:00:00', '2023-02-19 09:00:00');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `id` bigint NOT NULL COMMENT '教师ID',
  `user_id` bigint NOT NULL COMMENT '用户ID(逻辑外键)',
  `tea_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '教师姓名(默认用户名)',
  `cours_num` int NOT NULL DEFAULT 0 COMMENT '课程数量',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `deleted` int NOT NULL DEFAULT 0 COMMENT '删除标记(0:未删除,1:已删除)',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_user_id`(`user_id` ASC) USING BTREE COMMENT '确保用户唯一性'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '教师信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES (2001, 2001, '陈海涛', 5, '2023-01-03 09:05:00', 0, '2025-06-08 19:37:06');
INSERT INTO `teacher` VALUES (2002, 2002, '李教授', 3, '2023-01-04 14:05:00', 0, '2025-06-08 20:20:53');

-- ----------------------------
-- Table structure for teacher_class
-- ----------------------------
DROP TABLE IF EXISTS `teacher_class`;
CREATE TABLE `teacher_class`  (
  `id` bigint NOT NULL COMMENT '关联记录ID',
  `class_id` bigint NOT NULL COMMENT '班级ID',
  `tea_id` bigint NOT NULL COMMENT '教师ID',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` int NOT NULL DEFAULT 0 COMMENT '删除标记(0:未删除,1:已删除)',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_tea_class`(`tea_id` ASC, `class_id` ASC) USING BTREE COMMENT '防止教师重复关联班级'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '教师班级关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher_class
-- ----------------------------
INSERT INTO `teacher_class` VALUES (5001, 3001, 2001, '2023-01-09 09:00:00', '2023-01-09 09:00:00', 0);
INSERT INTO `teacher_class` VALUES (5002, 3002, 2002, '2023-01-10 10:00:00', '2023-01-10 10:00:00', 0);

-- ----------------------------
-- Table structure for today_situation
-- ----------------------------
DROP TABLE IF EXISTS `today_situation`;
CREATE TABLE `today_situation`  (
  `id` bigint NOT NULL COMMENT '记录ID',
  `stu_id` bigint NOT NULL COMMENT '学生ID',
  `time` bigint NOT NULL COMMENT '时间戳(记录日期)',
  `score` bigint NOT NULL DEFAULT 0 COMMENT '当日积分',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_stu_time`(`stu_id` ASC, `time` ASC) USING BTREE COMMENT '学生每日记录唯一约束',
  INDEX `idx_stu_id`(`stu_id` ASC) USING BTREE COMMENT '学生ID索引',
  INDEX `idx_time`(`time` ASC) USING BTREE COMMENT '时间戳索引'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '学生每日情况记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of today_situation
-- ----------------------------
INSERT INTO `today_situation` VALUES (14001, 1001, 1675180800, 10);
INSERT INTO `today_situation` VALUES (14002, 1001, 1675267200, 15);
INSERT INTO `today_situation` VALUES (14003, 1002, 1675180800, 8);

-- ----------------------------
-- Table structure for topic_question
-- ----------------------------
DROP TABLE IF EXISTS `topic_question`;
CREATE TABLE `topic_question`  (
  `id` bigint NOT NULL COMMENT '问题ID',
  `stu_id` bigint NULL DEFAULT NULL COMMENT '提问学生ID(逻辑外键)',
  `tea_id` bigint NULL DEFAULT NULL COMMENT '回答教师ID(逻辑外键)',
  `has_adopt` int NOT NULL DEFAULT 0 COMMENT '采纳状态(0:未采纳,>0:采纳的回答ID)',
  `content` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '问题内容',
  `like_num` int NULL DEFAULT 0 COMMENT '点赞数',
  `question_type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '问题类型',
  `collection_num` int NULL DEFAULT 0 COMMENT '收藏数',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `deleted` int NOT NULL DEFAULT 0 COMMENT '删除标记(0:未删除,1:已删除)',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `class_id` bigint NULL DEFAULT NULL COMMENT '关联班级ID(逻辑外键)',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_stu_id`(`stu_id` ASC) USING BTREE COMMENT '学生ID索引',
  INDEX `idx_tea_id`(`tea_id` ASC) USING BTREE COMMENT '教师ID索引',
  INDEX `idx_class_id`(`class_id` ASC) USING BTREE COMMENT '班级ID索引',
  INDEX `idx_has_adopt`(`has_adopt` ASC) USING BTREE COMMENT '采纳状态索引',
  FULLTEXT INDEX `ft_content`(`content`) COMMENT '内容全文索引'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '话题/问题表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of topic_question
-- ----------------------------
INSERT INTO `topic_question` VALUES (31001, 1001, NULL, 0, 'Python中的装饰器如何使用？', 5, '编程问题', 3, '2023-03-07 09:00:00', 0, '2023-03-07 09:00:00', 3001);
INSERT INTO `topic_question` VALUES (31002, 1002, 2002, 32001, '机器学习中如何选择正确的算法？', 8, '机器学习', 5, '2023-03-08 10:00:00', 0, '2023-03-10 11:00:00', 3002);

-- ----------------------------
-- Table structure for topic_question_collection
-- ----------------------------
DROP TABLE IF EXISTS `topic_question_collection`;
CREATE TABLE `topic_question_collection`  (
  `id` bigint NOT NULL COMMENT '收藏记录ID',
  `stu_id` bigint NOT NULL COMMENT '学生ID',
  `q_id` bigint NOT NULL COMMENT '问题ID',
  `collection` int NOT NULL COMMENT '收藏状态(1:收藏,0:取消)',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '收藏时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_stu_question`(`stu_id` ASC, `q_id` ASC) USING BTREE COMMENT '防止重复收藏',
  INDEX `idx_q_id`(`q_id` ASC) USING BTREE COMMENT '问题ID索引'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '问题收藏记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of topic_question_collection
-- ----------------------------
INSERT INTO `topic_question_collection` VALUES (32001, 1001, 31001, 1, '2023-03-09 09:00:00', '2023-03-09 09:00:00');
INSERT INTO `topic_question_collection` VALUES (32002, 1002, 31002, 1, '2023-03-10 10:00:00', '2023-03-10 10:00:00');

-- ----------------------------
-- Table structure for topic_question_comment
-- ----------------------------
DROP TABLE IF EXISTS `topic_question_comment`;
CREATE TABLE `topic_question_comment`  (
  `id` bigint NOT NULL COMMENT '评论ID',
  `q_id` bigint NOT NULL COMMENT '关联问题ID',
  `stu_id` bigint NULL DEFAULT NULL COMMENT '评论学生ID',
  `tea_id` int NULL DEFAULT NULL COMMENT '评论教师ID',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '评论内容',
  `has_adopt` int NULL DEFAULT 0 COMMENT '采纳状态(0:未采纳,1:已采纳)',
  `like_num` int NULL DEFAULT 0 COMMENT '点赞数',
  `reply_id` bigint NULL DEFAULT NULL COMMENT '回复的评论ID',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` int NULL DEFAULT 0 COMMENT '删除标记(0:未删除,1:已删除)',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_q_id`(`q_id` ASC) USING BTREE COMMENT '问题ID索引',
  INDEX `idx_stu_id`(`stu_id` ASC) USING BTREE COMMENT '学生ID索引',
  INDEX `idx_tea_id`(`tea_id` ASC) USING BTREE COMMENT '教师ID索引',
  INDEX `idx_reply_id`(`reply_id` ASC) USING BTREE COMMENT '回复评论索引',
  FULLTEXT INDEX `ft_content`(`content`) COMMENT '内容全文索引'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '问题评论表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of topic_question_comment
-- ----------------------------
INSERT INTO `topic_question_comment` VALUES (33001, 31001, NULL, 2001, '装饰器是Python中一个强大的功能，可以用来修改或增强函数的行为...', 0, 3, 0, '2023-03-11 09:00:00', NULL, 0);
INSERT INTO `topic_question_comment` VALUES (33002, 31001, 1002, NULL, '能举个具体的例子吗？', 0, 1, 33001, '2023-03-12 10:00:00', NULL, 0);
INSERT INTO `topic_question_comment` VALUES (33003, 31002, NULL, 2002, '选择算法需要考虑数据类型、问题类型和计算资源等因素...', 1, 5, 0, '2023-03-13 09:00:00', NULL, 0);

-- ----------------------------
-- Table structure for topic_question_comment_like
-- ----------------------------
DROP TABLE IF EXISTS `topic_question_comment_like`;
CREATE TABLE `topic_question_comment_like`  (
  `id` bigint NOT NULL COMMENT '点赞记录ID',
  `stu_id` bigint NOT NULL COMMENT '学生ID',
  `c_id` bigint NOT NULL COMMENT '评论ID',
  `like` int NOT NULL COMMENT '点赞状态(1:点赞,0:取消)',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_stu_comment`(`stu_id` ASC, `c_id` ASC) USING BTREE COMMENT '防止重复点赞',
  INDEX `idx_c_id`(`c_id` ASC) USING BTREE COMMENT '评论ID索引'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '问题评论点赞表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of topic_question_comment_like
-- ----------------------------
INSERT INTO `topic_question_comment_like` VALUES (34001, 1001, 33001, 1, '2023-03-14 09:00:00', '2023-03-14 09:00:00');
INSERT INTO `topic_question_comment_like` VALUES (34002, 1002, 33003, 1, '2023-03-15 10:00:00', '2023-03-15 10:00:00');

-- ----------------------------
-- Table structure for topic_question_img
-- ----------------------------
DROP TABLE IF EXISTS `topic_question_img`;
CREATE TABLE `topic_question_img`  (
  `id` bigint NOT NULL COMMENT '图片ID',
  `q_id` bigint NULL DEFAULT NULL COMMENT '关联问题ID',
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '图片URL地址',
  `deleted` int NULL DEFAULT 0 COMMENT '删除标记(0:未删除,1:已删除)',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_q_id`(`q_id` ASC) USING BTREE COMMENT '问题ID索引'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '问题图片表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of topic_question_img
-- ----------------------------
INSERT INTO `topic_question_img` VALUES (35001, 31001, 'https://example.com/questions/decorator-example.jpg', 0, '2023-03-16 09:00:00', '2023-03-16 09:00:00');
INSERT INTO `topic_question_img` VALUES (35002, 31002, 'https://example.com/questions/ml-algorithm.jpg', 0, '2023-03-17 10:00:00', '2023-03-17 10:00:00');

-- ----------------------------
-- Table structure for topic_question_like
-- ----------------------------
DROP TABLE IF EXISTS `topic_question_like`;
CREATE TABLE `topic_question_like`  (
  `id` bigint NOT NULL COMMENT '点赞记录ID',
  `stu_id` bigint NOT NULL COMMENT '学生ID',
  `q_id` bigint NULL DEFAULT NULL COMMENT '关联问题ID',
  `like` int NULL DEFAULT NULL COMMENT '点赞状态(1:点赞,0:取消)',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_stu_question`(`stu_id` ASC, `q_id` ASC) USING BTREE COMMENT '防止重复点赞',
  INDEX `idx_q_id`(`q_id` ASC) USING BTREE COMMENT '问题ID索引'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '问题点赞记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of topic_question_like
-- ----------------------------
INSERT INTO `topic_question_like` VALUES (36001, 1001, 31001, 1, '2023-03-18 09:00:00', '2023-03-18 09:00:00');
INSERT INTO `topic_question_like` VALUES (36002, 1002, 31002, 1, '2023-03-19 10:00:00', '2023-03-19 10:00:00');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint NOT NULL COMMENT '用户ID',
  `role` int NOT NULL COMMENT '用户角色(0:教师,1:学生)',
  `username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名',
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `pic` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '头像URL',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `deleted` int NOT NULL DEFAULT 0 COMMENT '删除标记(0:未删除,1:已删除)',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_username`(`username` ASC) USING BTREE COMMENT '用户名唯一约束'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户基础信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1001, 1, 'student1', '$2a$10$wHhPVD/35z08O3Zh5IXsSu1O9cqUXpY8Ikv2Ie6bKPJYxUScKmcja', 'https://example.com/avatars/student1.jpg', '2023-01-01 10:00:00', 0, '2025-06-10 17:02:37');
INSERT INTO `user` VALUES (1002, 1, 'student2', '$2a$10$hJhlg9uddcZjVQSPMC2KMO4y1vaqQxE8W3lOv1x4mm1l0J4TdQqBK', 'https://example.com/avatars/student2.jpg', '2023-01-02 11:00:00', 0, '2025-05-26 16:23:43');
INSERT INTO `user` VALUES (2001, 0, 'teacher1', '$2a$05$DWGinMmO00tRkGb.2IVwguvI/ZIKiwfYoKp2MMNKaSx7PnSlJMI9y', '/uploads/avatar/avatar_92ff9159-1ffb-4d2e-8dc2-54db149932e3.png', '2023-01-03 09:00:00', 0, '2025-06-10 17:01:54');
INSERT INTO `user` VALUES (2002, 0, 'teacher2', '$2a$05$EDmIfTlEbJJd6YGTFGGn.eFazMB89bZJynTXTxKOiIdhg/IwBrpxa', '/uploads/avatar/avatar_66c9cd4a-fb0a-4e74-adc4-03329e087969.png', '2023-01-04 14:00:00', 0, '2025-06-08 20:20:53');

-- ----------------------------
-- Table structure for user_violations
-- ----------------------------
DROP TABLE IF EXISTS `user_violations`;
CREATE TABLE `user_violations`  (
  `id` bigint NOT NULL COMMENT '记录ID',
  `uid` bigint NOT NULL COMMENT '用户ID',
  `violations` int NOT NULL DEFAULT 0 COMMENT '违规次数',
  `mushin` int NOT NULL DEFAULT 0 COMMENT '禁言状态(0:正常,1:禁言)',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` int NOT NULL DEFAULT 0 COMMENT '删除标记(0:未删除,1:已删除)',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_uid`(`uid` ASC) USING BTREE COMMENT '用户ID索引',
  INDEX `idx_mushin`(`mushin` ASC) USING BTREE COMMENT '禁言状态索引'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户违规记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_violations
-- ----------------------------
INSERT INTO `user_violations` VALUES (44001, 1001, 1, 0, '2023-04-05 09:00:00', '2023-04-05 09:00:00', 0);
INSERT INTO `user_violations` VALUES (44002, 1002, 2, 1, '2023-04-06 10:00:00', '2023-04-06 10:00:00', 0);

SET FOREIGN_KEY_CHECKS = 1;
