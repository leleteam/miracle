create table a_users (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `phone` varchar(20) DEFAULT '' COMMENT '登陆手机号',
  `password` varchar(100) NOT NULL COMMENT '密码',
  `name` varchar(20) NOT NULL COMMENT '姓名',
  `job_number` varchar(30) NOT NULL COMMENT '工号',
  `active` tinyint(1) NOT NULL DEFAULT '0' comment '是否激活',
  `status` INT(2) NOT NULL DEFAULT '1' COMMENT '状态, 0: 离职, 1: 正常, 3:锁定等',
  PRIMARY KEY (`id`),
  UNIQUE KEY `job_num` (`job_number`),
  UNIQUE KEY `phone` (`phone`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8 COMMENT='管理员用户表';