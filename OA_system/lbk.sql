/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.1.51-community : Database - oa_system
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`oa_system` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `oa_system`;

/*Table structure for table `holiday` */

DROP TABLE IF EXISTS `holiday`;

CREATE TABLE `holiday` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `reply_uid` int(11) DEFAULT NULL,
  `begin_time` date DEFAULT NULL,
  `end_time` date DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `reason` varchar(100) DEFAULT NULL,
  `audit_uid` int(11) DEFAULT NULL,
  `replyName` varchar(20) DEFAULT NULL,
  `days` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `holiday` */

insert  into `holiday`(`id`,`reply_uid`,`begin_time`,`end_time`,`status`,`reason`,`audit_uid`,`replyName`,`days`) values (1,2,'2014-06-08','2014-06-17',3,'事假',1,'李小小',9),(2,3,'2014-06-11','2014-06-20',0,'婚假',1,'张三',9),(3,2,'2014-06-10','2014-06-12',1,'事假',1,'李小小',3),(4,1,'2014-06-10','2014-06-20',1,'事假',1,'倪明亮',10),(5,2,'2014-06-11','2014-06-12',1,'事假',1,'李小小',1),(6,4,'2014-06-12','2014-06-22',0,'婚假',1,'王五',10),(7,1,'2014-06-17','2014-06-18',1,'事假',1,'倪明亮',1),(8,2,'2014-06-09','2014-06-11',0,'事假',6,'李小小',2),(9,4,'2014-06-09','2014-06-11',3,'',6,'王五',2);

/*Table structure for table `mail` */

DROP TABLE IF EXISTS `mail`;

CREATE TABLE `mail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) DEFAULT NULL,
  `content` varchar(500) DEFAULT NULL,
  `isread` int(11) DEFAULT NULL,
  `sendtime` date DEFAULT NULL,
  `adjunctpath` varchar(300) DEFAULT NULL,
  `from_uid` int(11) DEFAULT NULL,
  `to_uid` int(11) DEFAULT NULL,
  `to_statu` int(11) DEFAULT NULL,
  `from_statu` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_3` (`from_uid`),
  KEY `fk_4` (`to_uid`),
  CONSTRAINT `fk_3` FOREIGN KEY (`from_uid`) REFERENCES `users` (`id`) ON DELETE SET NULL,
  CONSTRAINT `fk_4` FOREIGN KEY (`to_uid`) REFERENCES `users` (`id`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

/*Data for the table `mail` */

/*insert  into `mail`(`id`,`title`,`content`,`isread`,`sendtime`,`adjunctpath`,`from_uid`,`to_uid`,`to_statu`,`from_statu`) values (1,'饮食文化','饮食文化的快立 海风还是覅和司法【表情】【表情】hi死花',1,'2014-06-07','E:\\Workspaces\\MyEclipse 10\\.metadata\\.me_tcat\\webapps\\OA_system\\upload\\11.png',2,3,1,1),(2,'1231','123123',1,'2014-06-07','E:\\Workspaces\\MyEclipse 10\\.metadata\\.me_tcat\\webapps\\OA_system\\upload\\3.jpg',2,3,0,1),(3,'请问去恶趣味 ','企鹅请问请问请问',1,'2014-06-07','E:\\Workspaces\\MyEclipse 10\\.metadata\\.me_tcat\\webapps\\OA_system\\upload\\1.jpg',1,3,1,1),(4,'123123123123','1312312312312312',0,'2014-06-07','E:\\Workspaces\\MyEclipse 10\\.metadata\\.me_tcat\\webapps\\OA_system\\upload\\22.png',1,3,1,1),(5,'2厄齐尔','恶趣味请问',0,'2014-06-07','E:\\Workspaces\\MyEclipse 10\\.metadata\\.me_tcat\\webapps\\OA_system\\upload\\22.png',1,3,1,1),(8,'12312','13123123',1,'2014-06-07','E:\\Workspaces\\MyEclipse 10\\.metadata\\.me_tcat\\webapps\\OA_system\\upload\\22.png',3,2,1,1),(9,'131','131231',1,'2014-06-07','E:\\Workspaces\\MyEclipse 10\\.metadata\\.me_tcat\\webapps\\OA_system\\upload\\22.png',1,1,1,1),(10,'1312','12312312312312312',0,'2014-06-07','E:\\Workspaces\\MyEclipse 10\\.metadata\\.me_tcat\\webapps\\OA_system\\upload\\3.jpg',2,3,1,1),(11,'jkj ','uguhjk',1,'2014-06-07','E:\\Workspaces\\MyEclipse 10\\.metadata\\.me_tcat\\webapps\\OA_system\\upload\\3.jpg',2,1,1,1),(13,'123','123123',0,'2014-06-08','E:\\Workspaces\\MyEclipse 10\\.metadata\\.me_tcat\\webapps\\OA_system\\upload\\11.png',2,4,1,1),(14,'赫赫','你好',0,'2014-06-09','E:\\Workspaces\\MyEclipse 10\\.metadata\\.me_tcat\\webapps\\OA_system\\upload\\2.png',6,1,1,1),(16,'中文','中文附件邮件',1,'2014-06-09','E:\\Workspaces\\MyEclipse 10\\.metadata\\.me_tcat\\webapps\\OA_system\\upload\\1402311469089.png',6,2,0,1);*/

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uname` varchar(20) NOT NULL,
  `upwd` varchar(20) NOT NULL,
  `age` int(11) DEFAULT NULL,
  `sex` varchar(2) DEFAULT NULL,
  `nickname` varchar(30) NOT NULL,
  `mobile` varchar(11) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `realname` varchar(20) DEFAULT NULL,
  `role` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uname` (`uname`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `users` */

insert  into `users`(`id`,`uname`,`upwd`,`age`,`sex`,`nickname`,`mobile`,`address`,`realname`,`role`) values (1,'admin','admin',22,'男','龙城飞将','18226605301','中国-阜阳','倪明亮',1),(2,'123','123',21,'男','李四1','18226605303','中国-合肥','李小小',2),(3,'test','test',25,'女','小山','18226605356','中国-南京','张三',2),(4,'111','111',22,'男','乖乖','18767678989','中国-杭州','王五',2),(5,'222','222',20,'女','哈哈','18767678987','中国-北京','麻子',2),(6,'root','root',30,'男','老刘','18767678888','中国-池州','刘帅',1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
