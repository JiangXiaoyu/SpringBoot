DROP TABLE IF EXISTS `t_bwoil_pay_account`;
CREATE TABLE `t_bwoil_pay_account` (
  `id` int(19) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` varchar(32) NOT NULL COMMENT '云油用户标识',
  `acount_name` varchar(64) NOT NULL COMMENT '账户姓名',
  `mobile_phone` varchar(11) NOT NULL COMMENT '用户手机号码',
  `id_card_no` varchar(18) NOT NULL COMMENT '身份证号码',
  `bank_card_no` varchar(32) NOT NULL COMMENT '绑定一类卡账号',
  `first_card_bank` varchar(50) COMMENT '一类卡开户银行',
  `e_card_no` varchar(32) NOT NULL COMMENT '电子账户',
  `e_card_bank` varchar(5) COMMENT '电子账户开户行',
  `open_date` varchar(8) NOT NULL COMMENT '电子账户开户日期',
  `e_protocol_ac_no` varchar(18) NOT NULL COMMENT '电子账户协议编号',
  `e_ac_no_status` varchar(4) COMMENT '银行处理状态',
  `balance` decimal(50,6) COMMENT '账户余额',
  `nopassword_littlemoney` varchar(4) COMMENT '是否开通小额免密,0-开通 1-未开通',
  `status` varchar(4) NOT NULL COMMENT '账户户状态(0-可用 1-不可用)',
  `create_time` datetime COMMENT '创建时间',
  `update_time` datetime COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COMMENT='账户信息表';

DROP TABLE IF EXISTS `t_bwoil_balance_change_log`;
CREATE TABLE `t_bwoil_balance_change_log` (
  `id` int(19) NOT NULL AUTO_INCREMENT COMMENT '主键',
-- `account_id` int(20) NOT NULL COMMENT '账户Id，关联账户主键',
--  `mobile_phone` varchar(11) NOT NULL COMMENT '用户手机号码',
  `amount` varchar(32) NOT NULL COMMENT '交易金额',
  `remark` varchar(255) COMMENT '转账用途',
  `code` varchar(500) COMMENT '民行返回码',
  `message` varchar(64) COMMENT '民行返回信息',
  `e_protocol_ac_no` varchar(18) COMMENT '电子账户协议编号',
  `trade_type` varchar(1) COMMENT '交易类型(0-出金|1-入金）',
  `pay_path` varchar(10) COMMENT '汇款方式(用于出金交易)',
  `create_time` datetime COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='民生出入金记录表';

DROP TABLE IF EXISTS `t_bwoil_open_account_log`;
CREATE TABLE `t_bwoil_open_account_log` (
  `id` int(19) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` varchar(32) NOT NULL COMMENT '云油用户标识',
  `acount_name` varchar(64) NOT NULL COMMENT '账户姓名',
  `mobile_phone` varchar(11) NOT NULL COMMENT '用户手机号码',
  `id_card_no` varchar(18) NOT NULL COMMENT '身份证号码',
  `bank_card_No` varchar(32) NOT NULL COMMENT '绑定银行卡账号',
  `open_bank` varchar(50) DEFAULT NULL COMMENT '开户银行',
  `code` varchar(16) NOT NULL COMMENT '民行返回码',
  `message` varchar(500) NOT NULL COMMENT '民行返回信息',
  `channel_jnl_no` varchar(32) COMMENT '渠道请求流水号',
  `e_account_open_jnl_no` varchar(32) COMMENT '预开户号',
  `e_ac_no_status` varchar(4) COMMENT '银行处理状态',
  `e_protocol_ac_no` varchar(18) COMMENT '电子账户协议编号',
  `e_card_no` varchar(18) COMMENT '电子账户',
  `open_date` varchar(8) COMMENT '电子账户开户日期',
  `bank_inner_flag` varchar(4) COMMENT '绑定卡行内行外标识',
  `create_time` datetime COMMENT '创建时间',
  `update_time` datetime COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8 COMMENT='开户日志表';

DROP TABLE IF EXISTS `t_bwoil_upload_bankcard_log`;
CREATE TABLE `t_bwoil_upload_bankcard_log` (
  `id` int(19) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `bank_card_no` varchar(32) NOT NULL COMMENT '银行卡号码',
  `e_protocol_ac_no` varchar(32) COMMENT '电子账户协议编码',
  `code` varchar(32) NOT NULL COMMENT '民生返回码',
  `message` varchar(512) NOT NULL COMMENT '民生返回信息',
  `image_seq` varchar(128) COMMENT '银行卡照片序号',
  `create_time` datetime COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='银行卡照片上传日志';

DROP TABLE IF EXISTS `t_bwoil_upload_idcard_log`;
CREATE TABLE `t_bwoil_upload_idcard_log` (
  `id` int(19) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `id_card_no` int(32) NOT NULL COMMENT '身份证号码',
  `name` varchar(50) NOT NULL COMMENT '身份证姓名',
  `code` varchar(16) NOT NULL COMMENT '民行返回码',
  `message` varchar(256) NOT NULL COMMENT '民行返回信息',
  `channel_jnl_no` varchar(32) NOT NULL COMMENT '渠道请求流水号',
  `status` varchar(2) NOT NULL COMMENT '流水状态,00-照片上传成功 01-照片需人工审核 02-照片上传失败',
  `reason` varchar(2) NOT NULL COMMENT '民行返回失败原因',
  `idpno` varchar(32) COMMENT '身份证照片验证凭证号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='身份证照片上传日志';