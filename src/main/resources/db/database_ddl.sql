CREATE DATABASE `ailedger` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;

-- ailedger.admin_t definition

CREATE TABLE `admin_t`
(
    `adminNo`     varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '管理员id',
    `adminName`   varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '管理员名',
    `adminPasswd` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '管理员密码',
    `adminStatus` tinyint                                                NOT NULL COMMENT '帐号状态',
    PRIMARY KEY (`adminNo`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


-- ailedger.announce_t definition

CREATE TABLE `announce_t`
(
    `annoNo`      varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci   NOT NULL COMMENT '公告id',
    `annoTitle`   varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NOT NULL COMMENT '公告标题',
    `annoType`    varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci   NOT NULL COMMENT '公告类型',
    `annoContent` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '公告内容',
    `annoDate`    varchar(24) CHARACTER SET utf8 COLLATE utf8_general_ci  NOT NULL COMMENT '公告日期',
    `adminNo`     varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci  NOT NULL COMMENT '管理员id',
    PRIMARY KEY (`annoNo`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


-- ailedger.cost_t definition

CREATE TABLE `cost_t`
(
    `costNo`       varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci  NOT NULL COMMENT '支出id',
    `costEvent`    varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci  NOT NULL COMMENT '支出事件',
    `costType`     varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci  NOT NULL COMMENT '支出类型',
    `costAmount`   double                                                 NOT NULL COMMENT '支出金额',
    `costRemark`   varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '支出备注',
    `costDatetime` varchar(24) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '日期时间',
    `userNo`       varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户id',
    PRIMARY KEY (`costNo`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


-- ailedger.counter_t definition

CREATE TABLE `counter_t`
(
    `id`            int NOT NULL DEFAULT '1' COMMENT '计数器id',
    `annoCounter`   int          DEFAULT '0' COMMENT '公告计数器',
    `costCounter`   int          DEFAULT '0' COMMENT '花销计数器',
    `fbCounter`     int          DEFAULT '0' COMMENT '反馈计数器',
    `incomeCounter` int          DEFAULT '0' COMMENT '收入计数器',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


-- ailedger.feedback_t definition

CREATE TABLE `feedback_t`
(
    `fbNo`      varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci   NOT NULL COMMENT '反馈id',
    `fbTitle`   varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NOT NULL COMMENT '反馈标题',
    `fbType`    varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci   NOT NULL COMMENT '反馈类型',
    `fbContent` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '内容',
    `fbRead`    tinyint DEFAULT '0' COMMENT '是否已读',
    `fbDate`    varchar(24) CHARACTER SET utf8 COLLATE utf8_general_ci  NOT NULL COMMENT '日期',
    `userNo`    varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NOT NULL COMMENT '用户id',
    PRIMARY KEY (`fbNo`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


-- ailedger.history_t definition

CREATE TABLE `history_t`
(
    `userNo`     varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NOT NULL COMMENT '用户id',
    `hisDate`    varchar(24) CHARACTER SET utf8 COLLATE utf8_general_ci  NOT NULL COMMENT '发送时间',
    `hisContent` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '发送内容',
    `isMeSend`   tinyint(1)                                              NOT NULL COMMENT '发送方 0-服务器，1-用户',
    PRIMARY KEY (`userNo`, `hisDate`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


-- ailedger.income_t definition

CREATE TABLE `income_t`
(
    `incNo`       varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci  NOT NULL COMMENT '收入id',
    `incEvent`    varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci  NOT NULL COMMENT '收入事件',
    `incType`     varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci  NOT NULL COMMENT '收入类型',
    `incAmount`   double                                                 NOT NULL COMMENT '收入金额',
    `incRemark`   varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '收入备注',
    `incDatetime` varchar(24) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '日期时间',
    `userNo`      varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户id',
    PRIMARY KEY (`incNo`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


-- ailedger.products_t definition

CREATE TABLE `products_t`
(
    `proNo`    varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品id',
    `proName`  varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '品名',
    `proPrice` int DEFAULT '10' COMMENT '价格',
    PRIMARY KEY (`proNo`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


-- ailedger.sentence_t definition

CREATE TABLE `sentence_t`
(
    `SenId`   tinyint                                                 NOT NULL AUTO_INCREMENT COMMENT 'id',
    `Content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '回复内容',
    PRIMARY KEY (`SenId`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 5
  DEFAULT CHARSET = utf8;


-- ailedger.user_t definition

CREATE TABLE `user_t`
(
    `userNo`      varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户id',
    `userName`    varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
    `userPasswd`  varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户密码',
    `userCredits` int                                                     DEFAULT '0' COMMENT '用户积分',
    `userStorage` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '库存，以","分隔',
    `userStatus`  tinyint                                                 DEFAULT '1' COMMENT '账号状态',
    `userBudget`  double                                                  DEFAULT '0' COMMENT '用户设置的月度预算',
    PRIMARY KEY (`userNo`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;