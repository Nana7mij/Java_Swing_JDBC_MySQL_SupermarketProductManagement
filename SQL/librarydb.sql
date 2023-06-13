/*
 Navicat Premium Data Transfer

 Source Server         : NAN
 Source Server Type    : MySQL
 Source Server Version : 80023
 Source Host           : localhost:3306
 Source Schema         : librarydb

 Target Server Type    : MySQL
 Target Server Version : 80023
 File Encoding         : 65001

 Date: 02/07/2021 09:33:22
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `admin_id` int(0) NOT NULL AUTO_INCREMENT,
  `admin_pwd` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`admin_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1021 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (13, '2346');
INSERT INTO `admin` VALUES (1001, '12345');
INSERT INTO `admin` VALUES (1002, '5656');
INSERT INTO `admin` VALUES (1003, '1234');
INSERT INTO `admin` VALUES (1004, '456');
INSERT INTO `admin` VALUES (1006, '45127');
INSERT INTO `admin` VALUES (1007, '4545');
INSERT INTO `admin` VALUES (1014, '9878');
INSERT INTO `admin` VALUES (1015, '98754');
INSERT INTO `admin` VALUES (1016, '5678');
INSERT INTO `admin` VALUES (1017, '5656');
INSERT INTO `admin` VALUES (1018, '123456');
INSERT INTO `admin` VALUES (1019, '12345');
INSERT INTO `admin` VALUES (1020, '123456');
INSERT INTO `admin` VALUES (1021, '7878');
INSERT INTO `admin` VALUES (1022, '9898');
INSERT INTO `admin` VALUES (1023, '9898');
INSERT INTO `admin` VALUES (1024, '1234');

-- ----------------------------
-- Table structure for books
-- ----------------------------
DROP TABLE IF EXISTS `books`;
CREATE TABLE `books`  (
  `books_id` int(0) NOT NULL AUTO_INCREMENT,
  `books_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `books_author` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `books_press` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `books_isbn` int(0) NOT NULL,
  `category_id` int(0) NULL DEFAULT NULL,
  `books_state` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `books_price` int(0) NOT NULL,
  `stock_Date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`books_id`) USING BTREE,
  UNIQUE INDEX `un_books`(`books_isbn`) USING BTREE,
  INDEX `category_id`(`category_id`) USING BTREE,
  CONSTRAINT `books_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 33 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of books
-- ----------------------------
INSERT INTO `books` VALUES (31, '张三', '李四', '王五', 98563, 1, '借出', 20, '2021-06-29 15:43:33');
INSERT INTO `books` VALUES (32, '西游记', '吴承恩', '张三', 7998, 1, '可借', 10, '2021-06-29 15:54:59');
INSERT INTO `books` VALUES (33, '水浒传', '施耐庵', '赵六', 9898, 2, '可借', 25, '2021-07-01 22:33:44');

-- ----------------------------
-- Table structure for borrower_item
-- ----------------------------
DROP TABLE IF EXISTS `borrower_item`;
CREATE TABLE `borrower_item`  (
  `reader_id` int(0) NOT NULL,
  `book_id` int(0) NOT NULL,
  `borrowing_time` datetime(0) NULL,
  `return_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`reader_id`, `book_id`, `borrowing_time`) USING BTREE,
  INDEX `reader_id`(`reader_id`) USING BTREE,
  CONSTRAINT `borrower_item_ibfk_1` FOREIGN KEY (`reader_id`) REFERENCES `reader` (`reader_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `category_id` int(0) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`category_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES (1, '张三类');
INSERT INTO `category` VALUES (2, '李四类');
INSERT INTO `category` VALUES (3, '王五类');

-- ----------------------------
-- Table structure for plan_order
-- ----------------------------
DROP TABLE IF EXISTS `plan_order`;
CREATE TABLE `plan_order`  (
  `order_id` int(0) NOT NULL,
  `order_date` date NULL DEFAULT NULL,
  `book_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `book_price` double(11, 2) NOT NULL,
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for reader
-- ----------------------------
DROP TABLE IF EXISTS `reader`;
CREATE TABLE `reader`  (
  `reader_id` int(0) NOT NULL,
  `reader_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `birthday` date NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `reader_pwd` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `news` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`reader_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of reader
-- ----------------------------
INSERT INTO `reader` VALUES (209, '王瑾', '2021-06-29', '湖南', '男', '1314', '好烦呀');
INSERT INTO `reader` VALUES (210, '李四', '2021-07-01', '湖南', '男', '520', '讨厌');

-- ----------------------------
-- Table structure for record_item
-- ----------------------------
DROP TABLE IF EXISTS `record_item`;
CREATE TABLE `record_item`  (
  `books_id` int(0) NOT NULL,
  `reader_id` int(0) NOT NULL,
  `borrowing_time` datetime(0) NULL,
  `return_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`books_id`, `reader_id`, `borrowing_time`) USING BTREE,
  INDEX `reader_id`(`reader_id`) USING BTREE,
  CONSTRAINT `record_item_ibfk_1` FOREIGN KEY (`books_id`) REFERENCES `books` (`books_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `record_item_ibfk_2` FOREIGN KEY (`reader_id`) REFERENCES `reader` (`reader_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of record_item
-- ----------------------------
INSERT INTO `record_item` VALUES (31, 209, '2021-07-24 22:18:18', '2021-07-16 22:18:23');
INSERT INTO `record_item` VALUES (33, 209, '2021-07-01 22:34:27', '2021-07-01 22:34:30');

SET FOREIGN_KEY_CHECKS = 1;
