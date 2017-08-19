/*
SQLyog Ultimate v11.13 (64 bit)
MySQL - 5.5.47 : Database - coffee
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`coffee` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `coffee`;

/*Table structure for table `coffee` */

DROP TABLE IF EXISTS `coffee`;

CREATE TABLE `coffee` (
  `coffeeNo` int(20) NOT NULL AUTO_INCREMENT,
  `coffeeName` varchar(20) DEFAULT NULL,
  `coffeePrice` varchar(20) DEFAULT NULL,
  `coffeeType` varchar(20) DEFAULT NULL,
  `picPath` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`coffeeNo`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8;

/*Data for the table `coffee` */

insert  into `coffee`(`coffeeNo`,`coffeeName`,`coffeePrice`,`coffeeType`,`picPath`) values (45,'11','99','午咖啡',NULL);

/*Table structure for table `gossip` */

DROP TABLE IF EXISTS `gossip`;

CREATE TABLE `gossip` (
  `gossipNo` int(20) NOT NULL AUTO_INCREMENT,
  `gossipTime` varchar(20) DEFAULT NULL,
  `gossipContent` varchar(100) DEFAULT NULL,
  `goods` int(11) DEFAULT '0',
  `bads` int(11) DEFAULT '0',
  `reply` varchar(50) DEFAULT NULL,
  `replyTime` varchar(20) DEFAULT NULL,
  `gossipTitle` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`gossipNo`)
) ENGINE=InnoDB AUTO_INCREMENT=139 DEFAULT CHARSET=utf8;

/*Data for the table `gossip` */

insert  into `gossip`(`gossipNo`,`gossipTime`,`gossipContent`,`goods`,`bads`,`reply`,`replyTime`,`gossipTitle`) values (135,'17-7-4 下午1:38','aaa',0,1,'haohao','17-7-4 下午1:42','fhh'),(137,'17-7-4 下午1:29','ooo',1,1,'hhh','hhh','ooo');

/*Table structure for table `menu` */

DROP TABLE IF EXISTS `menu`;

CREATE TABLE `menu` (
  `menuNo` int(20) NOT NULL AUTO_INCREMENT,
  `userName` varchar(20) DEFAULT NULL,
  `proName` varchar(20) DEFAULT NULL,
  `proPrice` varchar(20) DEFAULT NULL,
  `userPhone` varchar(20) DEFAULT NULL,
  `userAddress` varchar(50) DEFAULT NULL,
  `menuStatu` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`menuNo`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

/*Data for the table `menu` */

insert  into `menu`(`menuNo`,`userName`,`proName`,`proPrice`,`userPhone`,`userAddress`,`menuStatu`) values (11,'11','卡布奇','5','13091261752','ad','已完成'),(12,'admin','11','99','13091261752','aaaa','已支付'),(13,'admin','11','99','13091261752','sadsa','已支付');

/*Table structure for table `news` */

DROP TABLE IF EXISTS `news`;

CREATE TABLE `news` (
  `newsNo` int(20) NOT NULL AUTO_INCREMENT,
  `newsTitle` varchar(40) DEFAULT NULL,
  `newsContent` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`newsNo`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `news` */

insert  into `news`(`newsNo`,`newsTitle`,`newsContent`) values (1,'城市特色咖啡厅 不一样的装潢主题带来不一样的惊喜','TheBank咖啡厅式样仿照阿姆斯特丹银行建造，天花板布满了凹凸有致的木方块，显得古色古香。。'),(2,'双11 遇见主题咖啡厅','你13，我14，我们一生一世！11月11日，由遇见主题咖啡厅主办“相亲派对”——遇见主题咖啡厅，寻找自己的另一半。'),(3,'游戏咖啡馆 带你穿越回童年！','英国一男子开办了一家以老式游戏机为主题的咖啡馆，取名“游戏结束”。走进这间咖啡馆，仿佛回到了童年的世界。'),(4,'小小的咖啡店，却有大大的梦想','柯布咖啡，位于厦门金榜路，致力于寻觅世界上最好的咖啡豆、茶叶，并将其呈现于大众，让每一位顾客享受最本真的精致料理。');

/*Table structure for table `order` */

DROP TABLE IF EXISTS `order`;

CREATE TABLE `order` (
  `orderNo` int(20) NOT NULL AUTO_INCREMENT,
  `orderName` varchar(20) DEFAULT NULL,
  `orderPhone` varchar(50) DEFAULT NULL,
  `orderTime` varchar(20) DEFAULT NULL,
  `orderNum` int(20) DEFAULT NULL,
  PRIMARY KEY (`orderNo`)
) ENGINE=InnoDB AUTO_INCREMENT=131489134 DEFAULT CHARSET=utf8;

/*Data for the table `order` */

insert  into `order`(`orderNo`,`orderName`,`orderPhone`,`orderTime`,`orderNum`) values (131489126,'王文峰','13112345678','2017-07-13',4),(131489133,'王文','111111','2017-07-20',19);

/*Table structure for table `shopping` */

DROP TABLE IF EXISTS `shopping`;

CREATE TABLE `shopping` (
  `menuNo` int(20) NOT NULL AUTO_INCREMENT,
  `userName` varchar(20) DEFAULT NULL,
  `proName` varchar(20) DEFAULT NULL,
  `proPrice` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`menuNo`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

/*Data for the table `shopping` */

insert  into `shopping`(`menuNo`,`userName`,`proName`,`proPrice`) values (7,'admin','卡布奇诺','35'),(8,'admin','卡布奇诺','35'),(9,'admin','卡布奇诺','35'),(11,'admin','卡布奇诺','35'),(13,'admin','早咖啡','卡布奇诺'),(14,'admin','早咖啡','卡布奇诺'),(15,'admin','早咖啡','卡布奇诺');

/*Table structure for table `snack` */

DROP TABLE IF EXISTS `snack`;

CREATE TABLE `snack` (
  `snackNo` int(10) NOT NULL AUTO_INCREMENT,
  `snackName` varchar(20) DEFAULT NULL,
  `snackPrice` varchar(10) DEFAULT NULL,
  `snackPic` varchar(50) DEFAULT NULL,
  `snackStatu` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`snackNo`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `snack` */

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `userName` varchar(20) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `realName` varchar(10) DEFAULT NULL,
  `idCard` varchar(50) DEFAULT NULL,
  `statu` int(2) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`userName`,`phone`,`password`,`realName`,`idCard`,`statu`) values (16,'班主任','18810889999','999999','何涛','110110199006062587',0),(17,'任课老师','18810776666','666666','蔡珊珊','110119199301203522',0),(18,'班长','15133265789','555555','孙福','110118199603215858',1),(19,'学委','13678523631','111111','史嘉琪','110114199205283636',0),(20,'admin','13091261752','1234','王文','130604199110121216',1),(21,'meilin','15012329715','123456#','啊啊','130604199110121216',0),(22,'史嘉麒','13091261752','xinyuanru1','史嘉麒','130604199110121216',0),(23,'福大人','13233333333','sunfu820sunfu820','孙福','220181199608077765',0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
