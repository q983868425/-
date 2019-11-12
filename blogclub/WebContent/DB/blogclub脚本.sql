/*
SQLyog Ultimate v9.10 
MySQL - 5.1.44-community : Database - blogclub
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`blogclub` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `blogclub`;

/*Table structure for table `area` */

DROP TABLE IF EXISTS `area`;

CREATE TABLE `area` (
  `id` int(11) DEFAULT NULL,
  `areaID` varchar(6) NOT NULL,
  `areas` varchar(40) DEFAULT NULL COMMENT '区县名称',
  `cityID` varchar(6) DEFAULT NULL COMMENT '城市ID',
  PRIMARY KEY (`areaID`),
  KEY `FK_area` (`cityID`),
  CONSTRAINT `FK_area` FOREIGN KEY (`cityID`) REFERENCES `city` (`cityID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `area` */

/*Table structure for table `blog` */

DROP TABLE IF EXISTS `blog`;

CREATE TABLE `blog` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '博客编号（博客条码）',
  `kid` int(11) DEFAULT NULL COMMENT 'blogKind(kid)',
  `uid` int(11) DEFAULT NULL COMMENT 'user(uid)',
  `title` varchar(200) NOT NULL COMMENT '名称',
  `schema` varchar(500) NOT NULL COMMENT '概要',
  `content` text NOT NULL COMMENT '详情',
  `clicks` int(11) NOT NULL COMMENT '点击量',
  `datetime` datetime NOT NULL COMMENT '博客发表时间',
  PRIMARY KEY (`id`),
  KEY `FK_blog_1` (`kid`),
  KEY `FK_blog_2` (`uid`),
  CONSTRAINT `FK_blog_1` FOREIGN KEY (`kid`) REFERENCES `blogkind` (`id`),
  CONSTRAINT `FK_blog_2` FOREIGN KEY (`uid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `blog` */

insert  into `blog`(`id`,`kid`,`uid`,`title`,`schema`,`content`,`clicks`,`datetime`) values (1,1,3,'1111','2222','11111',3,'2019-10-04 00:00:00'),(2,1,3,'aaaa','aaa','aaaa',2,'2019-10-04 00:00:00'),(3,1,3,'aaaa','aaa','aaaa',1,'2019-10-04 16:17:18'),(4,1,3,'1111','2222','11111',6,'2019-10-04 16:17:18'),(5,2,1,'sdfsda','asdfsad','dfsdafsdfsdafsd',213,'2019-02-12 00:00:00'),(6,3,4,'asdasd','asdasdsda','asdasdasdasdasdasdddddddddddddddddddddddddd',55,'2019-02-12 00:00:00'),(7,3,4,'12321',' 2123','2132132133333333333333',11,'2019-02-12 00:00:00');

/*Table structure for table `blogkind` */

DROP TABLE IF EXISTS `blogkind`;

CREATE TABLE `blogkind` (
  `id` int(11) NOT NULL COMMENT '博客类别编号',
  `name` varchar(20) NOT NULL COMMENT '博客类型名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `blogkind` */

insert  into `blogkind`(`id`,`name`) values (1,'原创'),(2,'经典'),(3,'转载');

/*Table structure for table `city` */

DROP TABLE IF EXISTS `city`;

CREATE TABLE `city` (
  `id` int(11) DEFAULT NULL,
  `cityID` varchar(6) NOT NULL,
  `city` varchar(40) DEFAULT NULL COMMENT '城市名称',
  `provinceID` varchar(6) DEFAULT NULL COMMENT '省份ID',
  PRIMARY KEY (`cityID`),
  KEY `FK_city` (`provinceID`),
  CONSTRAINT `FK_city` FOREIGN KEY (`provinceID`) REFERENCES `province` (`provinceID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `city` */

/*Table structure for table `comment` */

DROP TABLE IF EXISTS `comment`;

CREATE TABLE `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL COMMENT '评论人',
  `bid` int(11) NOT NULL COMMENT '博客编号',
  `ip` varchar(100) NOT NULL COMMENT '评论时机器ip',
  `datetime` datetime NOT NULL COMMENT '日期',
  `content` varchar(1000) DEFAULT NULL COMMENT '评论内容',
  PRIMARY KEY (`id`),
  KEY `FK_comment_1` (`uid`),
  KEY `FK_comment_2` (`bid`),
  CONSTRAINT `FK_comment_1` FOREIGN KEY (`uid`) REFERENCES `user` (`id`),
  CONSTRAINT `FK_comment_2` FOREIGN KEY (`bid`) REFERENCES `blog` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `comment` */

insert  into `comment`(`id`,`uid`,`bid`,`ip`,`datetime`,`content`) values (4,3,3,'111','2019-10-05 15:40:11','aaaaaaa'),(5,3,3,'111','2019-10-05 15:40:14','aaaaaaa'),(6,4,4,'sadf','2019-10-05 21:16:41','asdf');

/*Table structure for table `province` */

DROP TABLE IF EXISTS `province`;

CREATE TABLE `province` (
  `id` int(11) DEFAULT NULL,
  `provinceID` varchar(6) NOT NULL,
  `province` varchar(40) DEFAULT NULL COMMENT '省份名称',
  PRIMARY KEY (`provinceID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `province` */

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(20) NOT NULL COMMENT '姓名',
  `pass` varchar(50) NOT NULL COMMENT '密码',
  `sex` char(1) NOT NULL DEFAULT 'f' COMMENT '性别',
  `age` int(11) NOT NULL COMMENT '年龄',
  `tel` varchar(15) NOT NULL COMMENT '电话',
  `provinceId` varchar(6) DEFAULT NULL COMMENT '省(直辖市)代码',
  `cityId` varchar(6) DEFAULT NULL COMMENT '市(自治区)代码',
  `areaId` varchar(6) DEFAULT NULL COMMENT '区(县)代码',
  `inputdate` datetime NOT NULL COMMENT '注册时间',
  `ip` varchar(100) NOT NULL COMMENT '注册时机器IP',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`name`,`pass`,`sex`,`age`,`tel`,`provinceId`,`cityId`,`areaId`,`inputdate`,`ip`) values (1,'admin','111','m',22,'1232145','陕西','西安市','高新区','2019-10-05 11:29:03','123.123.123.123'),(3,'aa','111','m',22,'1232145','陕西','西安市','高新区','2019-10-05 11:28:27','123.123.123.123'),(4,'bb','111','m',22,'1232145','陕西','西安市','高新区','2019-10-05 11:09:33','123.123.123.123'),(5,'curry','123','f',22,'12312321','0','0','0','2019-10-06 10:55:55','0:0:0:0:0:0:0:1'),(6,'baihu','123','f',22,'123213213','0','0','0','2019-10-06 11:04:20','0:0:0:0:0:0:0:1');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
